package com.example.demo.form;

/**
 * コメントのリクエストパラメーターを受け取るフォーム.
 * 
 * @author hiranoyuusuke
 *
 */
public class CommentForm {

	/**名前*/
	private String name;
	/**コメント内容*/
	private String content;
	/**ArticlesIdの外部キー*/
	private String articleId;
	
	
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
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

}
