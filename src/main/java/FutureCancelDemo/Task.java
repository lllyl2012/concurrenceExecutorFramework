package FutureCancelDemo;

import java.util.concurrent.Callable;

public class Task implements Callable<String>{

	public String call() throws InterruptedException {
		while(true){
			System.out.println("hello world");
				
					Thread.sleep(500);
			
		
		}
	}

}
