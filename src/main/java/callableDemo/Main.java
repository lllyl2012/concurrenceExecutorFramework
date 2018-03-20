package callableDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) {
		Random rand = new Random();
		List<Future<Integer>> list = new ArrayList<Future<Integer>>();
		for(int a=0;a<10;a++) {
			int b = rand.nextInt(20);
			System.out.println("y:"+b);
			FactorialCalculator calculator = new FactorialCalculator(b);
			ExecutorService pool = Executors.newCachedThreadPool();
			Future<Integer> result= pool.submit(calculator);
			list.add(result);
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int a=0;a<10;a++) {
			try {
				Future<Integer> i = list.get(a);
				System.out.println(a+":"+i.get());
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
