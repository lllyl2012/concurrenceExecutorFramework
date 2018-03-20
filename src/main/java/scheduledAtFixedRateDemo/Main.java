package scheduledAtFixedRateDemo;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/**
 *执行器周期执行任务
 * @author soft01
 *
 */
public class Main {

	public static void main(String[] args) {

		ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
		Task task = new Task("全部");
		ScheduledFuture<?> result = pool.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);//第一次执行的时间，和之后执行的周期
		for(int a=0;a<10;a++) {
			System.out.println("线程还要休眠:"+result.getDelay(TimeUnit.SECONDS));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		pool.shutdown();//执行器关闭后，周期任务也会结束
		try {
			TimeUnit.SECONDS.sleep(20);
			System.out.println("all over");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
