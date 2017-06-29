package com.jiyufei.social.util;

import com.fasterxml.jackson.annotation.JsonInclude;

/*
 *Created by jiyufei on 2016年11月1日 下午11:22:54 .
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AjaxSocial {

	private Integer code;
	private String msg;
	private Integer column;
	private Object content;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getColumn() {
		return column;
	}
	public void setColumn(Integer column) {
		this.column = column;
	}
	public Object getContent() {
		return content;
	}
	public void setContent(Object content) {
		this.content = content;
	}
	
	
}
