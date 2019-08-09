package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Comment;

/**
 * コメント内容をDBとやりとりする.
 * 
 * @author hiranoyuusuke
 *
 */
@Repository
public class CommentRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * コメントをDBへ保存する.
	 * 
	 * @param comment
	 */
	public void insert(Comment comment) {
		String sql = "INSERT INTO comments(name,content,article_id) VALUES(:name,:content,:articleId)";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("name", comment.getName())
											.addValue("content", comment.getContent()).addValue("articleId", comment.getArticleId());
		template.update(sql, param);	
	}

}
