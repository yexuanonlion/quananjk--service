package com.zxf.jpush;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class JPushToAndroid implements ServletContextListener{
	private ScheduledExecutorService service = null;
	
	JPushSigletonUtil jpUtil = JPushSigletonUtil.getInstancei();
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		if(service!=null){
			service.shutdown();
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
		service = Executors.newScheduledThreadPool(1);
		service.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				jpUtil.pushMesssage();
			}
		},  5, 30, TimeUnit.SECONDS);//5秒后执行，每隔10秒执行一次，以秒为单位。
		
		
	}
	

}
