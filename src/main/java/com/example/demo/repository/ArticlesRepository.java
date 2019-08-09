package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Articles;
import com.example.demo.domain.Comment;


/**
 * 投稿記事を操作するコントローラー.
 * 
 * @author hiranoyuusuke
 *
 */
@Repository
public class ArticlesRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final ResultSetExtractor<List<Articles>> RESULT = (rs) -> {
		List<Articles> articleList = new ArrayList<>();
		int preId = 0;
		List<Comment> commentList = null;
		
		while(rs.next()) {
		   int id = rs.getInt("id");
			if(id != preId) {
				Articles articles = new Articles();
				articles.setId(rs.getInt("id"));
				articles.setName(rs.getString("name"));
				articles.setContent(rs.getString("content"));
				commentList = new ArrayList<>();
				articles.setCommentList(commentList);
				articleList.add(articles);
				preId = rs.getInt("id");
			}
			Comment comment = new Comment();
			comment.setId(rs.getInt("comment_id"));
			comment.setName(rs.getString("comment_name"));
			comment.setContent(rs.getString("comment_content"));		
			comment.setArticleId(rs.getInt("comment_article_id"));
			commentList.add(comment);
		}
		
	
		return articleList;
		
	};
	
	
	/**
	 * 投稿した記事を全て検索する.
	 * 
	 * @return 投稿した記事を返す.
	 */
	public List<Articles> findAll(){
		String sql = "SELECT a.id,a.name,a.content,c.id comment_id,c.name comment_name,c.content comment_content,c.article_id comment_article_id "
					+ "FROM articles a LEFT OUTER JOIN comments c ON a.id = c.article_id ORDER BY id DESC;";
		
		List<Articles> articleList =  template.query(sql, RESULT);
		
		return articleList;
		
	}
	
	/**
	 * 記事をDBへ保存する.
	 * 
	 * @param article
	 */
	public void insert(Articles article) {
		String sql = "INSERT INTO articles(name, content) VALUES(:name,:content)";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("name", article.getName()).addValue("content", article.getContent());
		
		template.update(sql, param);
	}
	
	
	public void deleteById() {
		String sql = "DELETE FROM ";
	}
	

}
