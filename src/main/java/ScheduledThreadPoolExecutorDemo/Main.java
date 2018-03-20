package ScheduledThreadPoolExecutorDemo;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * 在执行器中延迟执行任务
 * 被执行任务可以继承Runnable或者Callable其中之一
 * @author soft01
 *
 */
public class Main {
	public static void main(String[] args) {
		ScheduledThreadPoolExecutor pool = (ScheduledThreadPoolExecutor)Executors.newScheduledThreadPool(1);
		System.out.println("开始了");
		for(int a=0;a<5;a++) {
			Task t = new Task("dog"+a);
			pool.schedule(t, a+1, TimeUnit.SECONDS);
		}
		pool.shutdown();
		try {
			pool.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("全部结束了");
	}
}
