package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Comment;
import com.example.demo.repository.CommentRepository;

/**
 * コントローラーからリポジトリーへコメントの操作を渡す.
 * 
 * @author hiranoyuusuke
 *
 */
@Service
@Transactional
public class CommentService {
	
	
	@Autowired
	private CommentRepository repository;
	
	/**
	 * コメントをDBへ保存するリポジトリーの処理を呼び出す.
	 * 
	 * @param comment
	 */
	public void insertComment(Comment comment) {
		repository.insert(comment);
	}

}
