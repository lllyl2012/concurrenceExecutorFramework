package CompletionServiceDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ReportGenerator implements Callable<String>{
	private String sender;
	private String title;
	public ReportGenerator(String sender,String title) {
		this.sender = sender;
		this.title = title;
	}
	public String call() throws Exception {
		System.out.println(Thread.currentThread().getName()+"正在处理");
		int time = (int)(Math.random()*10);
		TimeUnit.SECONDS.sleep(time);
		return sender+":"+title;
	}

}
