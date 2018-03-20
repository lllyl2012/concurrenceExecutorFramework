package FutureCancelDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
/**
 * 执行器中中断线程，（经实验）如果线程实现的是Runnable会报错，并无法中断,经推断，由于trycatch机制，保护了该线程；
 * 如果实现的是Callable则不会报错；
 * @author soft01
 *
 */
public class Main {

	public static void main(String[] args) {

		ExecutorService pool = Executors.newCachedThreadPool();
		Task t = new Task();
		Future f = pool.submit(t);
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		f.cancel(true);//如果参数为true并且线程正在运行，则关闭线程；false并且线程正好运行，则不关闭线程
		System.out.println("end");
	}

}
