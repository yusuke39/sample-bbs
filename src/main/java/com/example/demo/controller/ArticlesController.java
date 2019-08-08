package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Articles;
import com.example.demo.service.ArticlesService;

/**
 * 掲示板の投稿と表示用のコントローラー
 * 
 * @author hiranoyuusuke
 *
 */
@Controller
@RequestMapping("")
public class ArticlesController {
	
	@Autowired
	private ArticlesService service;
	
	@RequestMapping("")
	public String index(Model model) {
	  List<Articles> bbsList =  service.findAllArticles();
	  model.addAttribute("bbsList", bbsList);
	  return "bbs";
	}
	
	
	


}
