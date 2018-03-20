package FutureTaskDemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * FutureTask类提供了名为Done()的方法，允许
 * 执行器在任务执行结束后，再执行一段代码。可以用来执行一些
 * 后期操作：比如产生报表，发送邮件或者释放资源。
 * @author soft01
 *
 */
public class Main {

	public static void main(String[] args) {
		ExecutorService pool = Executors.newCachedThreadPool();
		
		ResultTask[] taskList = new ResultTask[5];
		
		for(int a=0;a<taskList.length;a++) {
			ExecutorableTask t = new ExecutorableTask("work"+a);
			taskList[a] = new ResultTask(t);
			pool.submit(taskList[a]);
			
		}
		
		try {
			System.out.println("主线程休眠5庙");
			Thread.sleep(5000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int a=0;a<taskList.length;a++) {
			taskList[a].cancel(true);
			System.out.println(1);
		}
		System.out.println("任务取消");
		for(int a=0;a<taskList.length;a++) {
			if(!taskList[a].isCancelled()) {
				try {
					System.out.println("taskList:"+taskList[a].get());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("打印输出还没有被取消任务的结果");
		pool.shutdown();
	}

}
