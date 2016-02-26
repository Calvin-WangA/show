package com.wch.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("manager/seat")
public class SeatController
{

	private static final Logger logger = (Logger) LogManager.getLogger(SeatController.class);
	@RequestMapping("/setSeat.action")
	public String receiveSeat(HttpServletRequest request)
	{
		String seats = request.getParameter("seats");
		logger.debug(seats);
		return "manager/seats";
	}
}
