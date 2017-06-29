package com.jiyufei.social.service;

import java.util.List;

import com.jiyufei.social.bean.WyDrops;
/*
 *Created by jiyufei on 2016年11月3日 上午11:25:40 .
 */

public interface WyDropsService {

	public List<WyDrops> getAllDrops(Integer pageNum,Integer pageSize) throws Exception;
	
	public WyDrops getDropsById(Integer id) throws Exception;
	
	public List<WyDrops> searchDrops(WyDrops wyDrops,Integer pageNum,Integer pageSize) throws Exception;
	
	public List<WyDrops> getDropsByTitle(String title) throws Exception;

	public List<WyDrops> getDropsByAuthor(String author) throws Exception;
	
	public Integer addReadNumById(Integer id) throws Exception;
	
	public Integer getDropsNum() throws Exception;
	
	public List<WyDrops> getDropsTop10() throws Exception;
	
}
