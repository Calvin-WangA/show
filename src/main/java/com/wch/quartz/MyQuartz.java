package com.wch.quartz;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.wch.controller.UserController;

public class MyQuartz implements Job
{

	public static final Logger logger = (Logger) LogManager.getLogger(UserController.class);
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException
	{
		logger.trace("I am enter!");
	}

}
