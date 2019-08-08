package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Articles;
import com.example.demo.repository.ArticlesRepository;

@Service
@Transactional
public class ArticlesService {
	
	@Autowired
	private ArticlesRepository repository;
	
	public List<Articles> findAllArticles(){
		return repository.findAll();
	}

}
