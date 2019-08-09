package com.example.demo.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


/**
 * コメントのリクエストパラメーターを受け取るフォーム.
 * 
 * @author hiranoyuusuke
 *
 */
public class CommentForm {

	/**名前*/
	@NotBlank(message="名前は必須です")
	@Size(min=1, max=50, message="名前は５０文字以内で入力してください")
	private String name;
	/**コメント内容*/
	@NotBlank(message="コメントは必須です")
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
