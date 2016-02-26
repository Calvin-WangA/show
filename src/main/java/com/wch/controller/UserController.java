package com.wch.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wch.entity.User;
import com.wch.service.UserService;

@Controller
@RequestMapping("userController")
public class UserController
{

	private static final Logger logger = (Logger) LogManager.getLogger(UserController.class);
	
	private UserService userService;
	
	public UserService getUserService()
	{
		return userService;
	}

	@Autowired
	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}

	@RequestMapping("/user.action")
	public String showPeople(HttpServletRequest request)
	{
		logger.info("Entering application.");
		String id = request.getParameter("id");
		User user = userService.getUser(id);
		request.setAttribute("user",user);
		logger.info("Exiting application.");
		return "/manager/showPeople";
	}
	
}
