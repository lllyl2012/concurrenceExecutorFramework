package invokeAllDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) {

		ExecutorService pool = Executors.newCachedThreadPool();
		List<Task> taskList = new ArrayList<Task>();
		for (int a = 0; a < 10; a++) {
			taskList.add(new Task("gaga" + a));
		}
		List<Future<Result>> resultList = new ArrayList<Future<Result>>();
		try {
			resultList = pool.invokeAll(taskList);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pool.shutdown();
		for (int a = 0; a < resultList.size(); a++) {
			Future<Result> future = resultList.get(a);
			try {
				Result result = future.get();//可以用future的isDone()来检查future是否完成
				System.out.println(result.getName()+":"+result.getValue());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
