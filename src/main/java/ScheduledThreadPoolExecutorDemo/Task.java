package ScheduledThreadPoolExecutorDemo;

import java.util.Date;
import java.util.concurrent.Callable;

public class Task implements Callable<String>{

	private String name;
	public Task(String name) {
		this.name = name;
	}
	public String call() throws Exception {
		System.out.println(name+":"+new Date());
		return "hello world";
	}

}
