package com.jiyufei.social.util;

import com.jiyufei.social.bean.WyDrops;

/*
 *Created by jiyufei on 2016年11月4日 上午11:47:54 .
 */
public class DropsHistory {

	private Integer id;
	private String title;
	private String author;
	private Integer num;
	
	public DropsHistory(){
		
	}
	
	public DropsHistory(WyDrops drops){
		this.id = drops.getId();
		this.title = drops.getTitle();
		this.author = drops.getAuthor();
		this.num = drops.getNum();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
	
	
	
}
