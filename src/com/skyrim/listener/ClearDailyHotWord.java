package com.skyrim.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ClearDailyHotWord implements ServletContextListener{
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
	System.out.println("Hello World!!");
	}
	

}
