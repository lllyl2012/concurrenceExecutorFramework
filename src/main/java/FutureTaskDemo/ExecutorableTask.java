package FutureTaskDemo;

import java.util.concurrent.Callable;

public class ExecutorableTask implements Callable<String>{
	private String name;
	public ExecutorableTask(String a) {
		this.name = a;
	}
	public String getName(){
		return name;
	}
	public String call() throws Exception {
		int time = (int)(Math.random()*10000);
		System.out.println(name+":time:"+time);
		Thread.sleep(time);
	
		return "ok:"+Thread.currentThread().getName();
	}

}
