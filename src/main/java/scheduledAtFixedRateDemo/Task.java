package scheduledAtFixedRateDemo;

import java.util.concurrent.Callable;

public class Task implements Runnable{
	private String name;
	public Task(String name) {
		this.name = name;
	}
	public void run()  {
		System.out.println("开始工作了");
		System.out.println("hello world");
	}
}
