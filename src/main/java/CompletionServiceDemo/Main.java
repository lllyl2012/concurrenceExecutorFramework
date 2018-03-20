package CompletionServiceDemo;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 在执行器中分离任务的启动和结果的处理；
 * CompletionService类，参数为执行器，
 * 要执行的线程，必须拥有一个CompletionService类的成员变量，
 * 并通过构造函数传递；
 * @author soft01
 *
 */
public class Main {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		CompletionService<String> service = new ExecutorCompletionService<String>(executor);
		ReportRequest face = new ReportRequest("face",service);
		ReportRequest online = new ReportRequest("online",service);
		Thread t = new Thread(face);
		Thread t2 = new Thread(online);
		t.start();
		t2.start();
		
		ReportProcessor processor = new ReportProcessor(service);
		Thread p = new Thread(processor);
		p.start();
		
		System.out.println("等待任务完成");
		
		try {
			t.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("关闭执行器");
		executor.shutdown();
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		processor.setEnd(true);
		System.out.println("全部结束");
	}

}
