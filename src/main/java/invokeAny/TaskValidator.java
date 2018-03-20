package invokeAny;

import java.util.concurrent.Callable;

public class TaskValidator implements Callable<String>{
	private UserValidator userValidator;
	private String name;
	private String pwd;
	public TaskValidator(UserValidator uv,String name,String pwd) {
		this.name = name;
		this.pwd = pwd;
		this.userValidator = uv;
	}
	public String call() {
		if(!userValidator.validate(name, pwd)) {
			System.out.println("未通过");
		}
		System.out.println("user have found");
		return userValidator.getName();
	}
}
