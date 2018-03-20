package FutureTaskDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ResultTask extends FutureTask<String>{
	private String name;
	public ResultTask(Callable<String> callable) {
		super(callable);
		this.name = ((ExecutorableTask)callable).getName();
	}
	protected void done() {
		if(isCancelled()) {
			System.out.println("cancelled:"+name);
		}else {
			System.out.println("finished:"+name);
		}
	}
}
