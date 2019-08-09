package com.example.demo.domain;

import java.util.List;


/**
 * 記事のドメイン.
 * 
 * @author hiranoyuusuke
 *
 */
public class Articles {

	/**ID*/
	private Integer id;
	/**名前*/
	private String name;
	/**投稿内容*/
	private String content;
	/**コメントを格納するリスト*/
	private List<Comment> commentList;

	public Articles() {}

	public Articles(Integer id, String name, String content, List<Comment> commentList) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
		this.commentList = commentList;
	}

	@Override
	public String toString() {
		return "Articles [id=" + id + ", name=" + name + ", content=" + content + ", commentList=" + commentList + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	
}
