package com.wch.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wch.dao.UserMapper;
import com.wch.entity.User;
import com.wch.service.iface.UserService;

@Service("userService")
public class UserServiceImpl implements UserService
{

	@Autowired
    private UserMapper userMapper;

	public User getUser(String id)
	{
		User user = userMapper.selectUser(id);
		return user;
	}

    

}