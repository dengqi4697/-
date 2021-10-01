package com.cusm.common;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WebContextListener implements ServletContextListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContext ctx = servletContextEvent.getServletContext();
		Constant.initSysConfig(ctx.getRealPath("/WEB-INF/classes/sysconfig.properties"));
		
	}

}
