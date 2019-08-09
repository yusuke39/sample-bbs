package com.example.demo.domain;

/**
 * コメントのドメイイン.
 * 
 * @author hiranoyuusuke
 *
 */
public class Comment {

	/**ID*/
	private Integer id;
	/**名前*/
	private String name;
	/**コメント内容*/
	private String content;
	/**ArticlesIdの外部キー*/
	private Integer articleId;

	public Comment() {}

	public Comment(Integer id, String name, String content, Integer articleId) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
		this.articleId = articleId;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", name=" + name + ", content=" + content + ", articleId=" + articleId + "]";
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

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	
	

}
