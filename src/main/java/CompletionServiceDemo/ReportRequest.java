package CompletionServiceDemo;

import java.util.concurrent.CompletionService;

public class ReportRequest implements Runnable{
	private CompletionService<String> service;
	private String name;
	public ReportRequest(String name,CompletionService<String> service) {
		this.service  = service;
		this.name = name;
	}
	public void run() {
		ReportGenerator generator = new ReportGenerator(name,"gaga");
		service.submit(generator);
	}
}
