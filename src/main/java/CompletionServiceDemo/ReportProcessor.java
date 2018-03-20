package CompletionServiceDemo;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ReportProcessor implements Runnable{
	private CompletionService<String> service;
	private boolean end;
	public ReportProcessor(CompletionService<String> service) {
		this.service = service;
		end = false;
	}
	public void run() {
		while(!end) {
			try {
				Future<String> result = service.poll(20,TimeUnit.SECONDS);//无参数情况下若没有内容则直接返回null，也可以用take()等待队列中出现元素.
				if(result!=null) {
					try {
						String report = result.get();
						System.out.println("report:"+report);
					} catch (ExecutionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void setEnd(boolean end) {
		this.end =end;
	}
}
