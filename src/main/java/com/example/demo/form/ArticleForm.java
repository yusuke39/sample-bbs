package com.example.demo.form;

/**
 * 記事投稿のリクエストパラメーターを受け取る.
 * 
 * @author hiranoyuusuke
 *
 */
public class ArticleForm {

	/**名前*/
	private String name;
	/**投稿内容*/
	private String content;


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
