package RejectedExecutionHandlerDemo;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable{
	private String name;
	public Task(String n) {
		this.name  =  n;
	}
	public String toString() {
		return name;
	}
	public void run() {
		System.out.println("task:"+name+"is start");
		Random rand = new Random();
		int time = rand.nextInt(5);
		try {
			TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("执行结束了");
	}

}
