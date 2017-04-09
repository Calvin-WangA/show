package com.wch.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.aspectj.lang.JoinPoint;

/**
 * Created by SL131 on 2017/4/3.
 */
public class RequestLogAop {

    private static final Logger logger = (Logger) LogManager.getLogger(RequestLogAop.class);

    public void before(JoinPoint point) {

        logger.debug("执行之前");
    }

    public void around(JoinPoint point) {
        logger.debug("执行中");
    }

    public void after(JoinPoint point) {
        logger.debug("执行之后");
    }

    public void afterReturn(JoinPoint point) {
        logger.debug("返回");
    }

    public void afterException(JoinPoint point) {
        logger.debug("异常");
    }
}
