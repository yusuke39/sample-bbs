package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Articles;
import com.example.demo.domain.Comment;
import com.example.demo.form.ArticleForm;
import com.example.demo.form.CommentForm;
import com.example.demo.service.ArticlesService;
import com.example.demo.service.CommentService;

/**
 * 掲示板の投稿と表示用のコントローラー.
 * 
 * @author hiranoyuusuke
 *
 */
@Controller
@RequestMapping("")
public class ArticlesController {
	
	@ModelAttribute
	public ArticleForm  setUpArticleForm() {
		return new ArticleForm();
	}
	
	@ModelAttribute
	public CommentForm setUpCommentForm() {
		return new CommentForm();
	}
	
	@Autowired
	private ArticlesService articleService;
	
	@Autowired
	private CommentService commentService;	
	
	
	/**
	 * 掲示板表示、投稿内容表示のメソッド.
	 * 
	 * @param model リクエストスコープ
	 * @return　掲示板表示
	 */
	@RequestMapping("")
	public String index(Model model) {
	  List<Articles> bbsList =  articleService.findAllArticles();
	  model.addAttribute("bbsList", bbsList);
	  return "bbs";
	}
	
	/**
	 * 投稿をDBへ保存する.
	 * 
	 * @param form 投稿のリクエストパラメーターを受け取る
	 * @param model　リクエストスコープ
	 * @return　indexメソッドを呼び出し、掲示板画面へ最新の投稿を表示する
	 */
	@RequestMapping("/postArticle")
	public String postArticle(ArticleForm form, Model model) {
		Articles articles = new Articles();
		articles.setName(form.getName());
		articles.setContent(form.getContent());
		articleService.insertArticle(articles);
		return "redirect:/";
	}
	
	
	/**
	 * コメントをDBへ保存する.
	 * 
	 * @param form コメント内容のリクエストパラメーターを受け取る
	 * @param model　リクエストスコープ
	 * @return　indexメソッドを呼び出し、掲示板画面へ最新のコメントを表示する
	 */
	@RequestMapping("/postComment")
	public String postComment(CommentForm form, Model model) {
		Comment comment = new Comment();
		comment.setName(form.getName());
		comment.setContent(form.getContent());
		comment.setArticleId(Integer.parseInt(form.getArticleId()));
		commentService.insertComment(comment);
		return "redirect:/";
	}
	
	
	/**
	 * 記事とコメント一括削除する.
	 * 
	 * @return indexメソッドに戻る
	 */
//	@RequestMapping("/delete")
//	public String deleteArticles() {
//		
//	}

}
