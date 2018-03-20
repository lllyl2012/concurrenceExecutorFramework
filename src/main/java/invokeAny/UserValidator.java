package invokeAny;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class UserValidator {
	private String name;
	private String password;
	public UserValidator(String name,String password) {
		this.name = name;
		this.password = password;
	}
	public boolean validate(String name,String password) {
		Random random = new Random();
		long time = (long)(Math.random()*10);
		try {
			System.out.println(Thread.currentThread().getName()+"正在等待");
			TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			return false;
		}
		return random.nextBoolean();
	}
	public String getName() {
		return name;
	}
}
