package com.jiyufei.social.util;

import com.fasterxml.jackson.annotation.JsonInclude;

/*
 *Created by jiyufei on 2016年8月27日 下午2:25:40 .
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AjaxResponse {
	private Integer code;
	private String msg;
	private Object content;
	
	public AjaxResponse(){
		
	}
	
	public AjaxResponse(Integer code,String msg,String content){
		this.code = code;
		this.msg = msg;
		this.content = content;
	}

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

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}
	
	
}
