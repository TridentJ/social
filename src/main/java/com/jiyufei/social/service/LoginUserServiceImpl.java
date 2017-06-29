package com.jiyufei.social.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiyufei.social.bean.LoginUser;
import com.jiyufei.social.bean.LoginUserExample;
import com.jiyufei.social.dao.LoginUserMapper;

/*
 *Created by jiyufei on 2016年10月27日 上午10:52:10 .
 */
@Service("loginUserService")
public class LoginUserServiceImpl implements LoginUserService {

	@Autowired
	private LoginUserMapper loginUserMapper;
	
	
	@Override
	public LoginUser getUserById(Integer id) throws Exception {
		LoginUser loginUser = loginUserMapper.selectByPrimaryKey(id);
		return loginUser;
	}

	@Override
	public LoginUser getUserByMail(String mail) throws Exception {
		LoginUserExample example = new LoginUserExample();
		example.createCriteria().andMailEqualTo(mail);
		List<LoginUser> loginUserList = loginUserMapper.selectByExample(example);
		return loginUserList.get(0);
	}

	@Override
	public int addUser(LoginUser user) throws Exception {
		int result = loginUserMapper.insertSelective(user);
		return result;
	}

	@Override
	public int frozeUserById(Integer id) throws Exception {
		LoginUser loginUser = new LoginUser();
		loginUser.setId(id);
		loginUser.setStatus(0);
		int result = loginUserMapper.updateByPrimaryKeySelective(loginUser);
		return result;
	}

	@Override
	public int updateUserById(LoginUser user) throws Exception {
		int result = loginUserMapper.updateByPrimaryKeySelective(user);
		return result;
	}

}
