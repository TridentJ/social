package com.jiyufei.social.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.jiyufei.social.bean.WyDrops;
import com.jiyufei.social.bean.WyDropsExample;
import com.jiyufei.social.dao.WyDropsMapper;

/*
 *Created by jiyufei on 2016年11月3日 上午11:32:50 .
 */
@Service("wyDropsService")
public class WyDropsServiceImpl implements WyDropsService{

	@Autowired
	private WyDropsMapper wyDropsMapper;
	
	@Override
	public WyDrops getDropsById(Integer id) throws Exception {
		WyDrops wyDrops = wyDropsMapper.selectByPrimaryKey(id);
		return wyDrops;
	}

	@Override
	public List<WyDrops> getDropsByTitle(String title) throws Exception {
		WyDropsExample example = new WyDropsExample();
		example.createCriteria().andTitleLike("%" + title + "%");
		List<WyDrops> wyDropsList = wyDropsMapper.selectByExample(example);
		return wyDropsList;
	}

	@Override
	public List<WyDrops> getDropsByAuthor(String author) throws Exception {
		WyDropsExample example = new WyDropsExample();
		example.createCriteria().andAuthorLike("%" + author + "%");
		List<WyDrops> wyDropsList = wyDropsMapper.selectByExample(example);
		return wyDropsList;
	}

	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
	public Integer addReadNumById(Integer id) throws Exception {
		WyDrops wyDrops = wyDropsMapper.selectByPrimaryKey(id);
		int newNum = wyDrops.getNum() + 1;
		WyDrops drops = new WyDrops();
		drops.setId(wyDrops.getId());
		drops.setNum(newNum);
		int result = wyDropsMapper.updateByPrimaryKeySelective(drops);
		return result;
	}

	@Override
	public Integer getDropsNum() throws Exception {
		
		return null;
	}

	@Override
	public List<WyDrops> getAllDrops(Integer pageNum,Integer pageSize) throws Exception {
		WyDropsExample example = new WyDropsExample();
		example.createCriteria().andStatusEqualTo(new Integer(1));
		PageHelper.startPage(pageNum, pageSize);
		List<WyDrops> wyDropsList = wyDropsMapper.selectByExample(example);
		return wyDropsList;
	}

	@Override
	public List<WyDrops> getDropsTop10() throws Exception {
		WyDropsExample example = new WyDropsExample();
		example.createCriteria().andStatusEqualTo(new Integer(1));
		example.setOrderByClause("num desc");
		PageHelper.startPage(1, 10);
		List<WyDrops> wyDropsList = wyDropsMapper.selectByExample(example);
		return wyDropsList;
	}

	@Override
	public List<WyDrops> searchDrops(WyDrops wyDrops,Integer pageNum,Integer pageSize) throws Exception {
		WyDropsExample example = new WyDropsExample();
		WyDropsExample.Criteria criteria = example.createCriteria();
		if((wyDrops.getTitle() != "") && (wyDrops.getTitle() != null)){
			criteria.andTitleLike("%" + wyDrops.getTitle() + "%");
		}
		if((wyDrops.getAuthor() != "") && (wyDrops.getAuthor() != null)){
			criteria.andAuthorLike("%" + wyDrops.getAuthor() + "%");
		}
		PageHelper.startPage(pageNum, pageSize);
		List<WyDrops> wyDropsList = wyDropsMapper.selectByExample(example);
		return wyDropsList;
	}

	
	
}
