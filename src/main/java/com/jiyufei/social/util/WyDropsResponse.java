package com.jiyufei.social.util;

import java.text.SimpleDateFormat;

import com.jiyufei.social.bean.WyDrops;


/*
 *Created by jiyufei on 2016年11月3日 下午5:42:39 .
 */
public class WyDropsResponse {

	private Integer id;

    private String title;

    private String author;

    private String createTime;

    private Integer type;

    private String tag;

    private Integer num;

    public WyDropsResponse(){
    	
    }
    
    public WyDropsResponse(WyDrops drops){
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	this.id = drops.getId();
    	this.title = drops.getTitle();
    	this.author = drops.getAuthor();
    	this.createTime = df.format(drops.getCreateTime());
    	this.type = drops.getType();
    	this.tag = drops.getTag();
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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
    
    
    
}
