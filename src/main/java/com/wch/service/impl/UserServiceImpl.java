package com.wch.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wch.dao.UserMapper;
import com.wch.entity.User;
import com.wch.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService
{

    private UserMapper userMapper;
    
    @Autowired
	public void setUserMapper(UserMapper userMapper)
	{
		this.userMapper = userMapper;
	}
    
	@Override
	public User getUser(String id)
	{
		User user = userMapper.selectUser(id);
		return user;
	}

    

}