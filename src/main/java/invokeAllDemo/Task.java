package invokeAllDemo;

import java.util.concurrent.Callable;

public class Task implements Callable<Result>{
	private String name;
	public Task(String name) {
		this.name = name;
	}
	public Result call() throws Exception {
		System.out.println(Thread.currentThread().getName()+"正在计算结果");
		Thread.sleep((int)(Math.random()*10)*1000);
		int value = (int)(Math.random()*100);
		Result result = new Result();
		result.setName(name);
		result.setValue(value);
		System.out.println("任务执行结束"+this.name);
		return result;
	}

}
