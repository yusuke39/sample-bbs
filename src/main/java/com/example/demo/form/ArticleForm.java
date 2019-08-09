package com.example.demo.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 記事投稿のリクエストパラメーターを受け取る.
 * 
 * @author hiranoyuusuke
 *
 */
public class ArticleForm {

	/** ID */
	private String id;
	/** 名前 */
	@NotBlank(message = "名前は必須です")
	@Size(min = 1, max = 50, message = "名前は５０文字以内で入力してください")
	private String name;
	/** 投稿内容 */
	@NotBlank(message = "コメントは必須です")
	private String content;
	
	
	public Integer getIntegerId() {
		return Integer.parseInt(id);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

}
