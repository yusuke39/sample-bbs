package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Articles;
import com.example.demo.repository.ArticlesRepository;

/**
 * コントローラーからの操作をリポジトリーに渡す.
 * 
 * @author hiranoyuusuke
 *
 */
@Service
@Transactional
public class ArticlesService {
	
	@Autowired
	private ArticlesRepository repository;
	
	/**
	 * 投稿記事を検索する.
	 * 
	 * @return
	 */
	public List<Articles> findAllArticles(){
		return repository.findAll();
	}
	
	/**
	 * 投稿記事をDBへ保存する.
	 * 
	 * @param articles
	 */
	public void insertArticle(Articles articles) {
		repository.insert(articles);
	}

}
