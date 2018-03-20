package RejectedExecutionHandlerDemo;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class RejectedTaskController implements RejectedExecutionHandler{

	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println("被拒绝的线程是:"+r.toString());
		System.out.println("执行器的名字是:"+executor.toString());
		System.out.println("isTerminating:"+executor.isTerminating());
		System.out.println("isTerminated:"+executor.isTerminated());
	}

}
