package RejectedExecutionHandlerDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
/**
 * 处理在执行器中被拒绝的任务
 * @author soft01
 *
 */
public class Main {

	public static void main(String[] args) {

		RejectedTaskController controller = new RejectedTaskController();
		ThreadPoolExecutor service = (ThreadPoolExecutor)Executors.newCachedThreadPool();
		service.setRejectedExecutionHandler(controller);
		for(int a=0;a<3;a++) {
			Task t = new Task("gaga"+a);
			service.submit(t);
		}
		System.out.println("close executor");
		service.shutdown();
		
		System.out.println("send another task");
		service.submit(new Task("另外的"));
		System.out.println("end");
	}

}
