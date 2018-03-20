package invokeAny;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 运行多个任务并处理第一个结果
 * invokeAny();
 * @author soft01
 *
 */
public class Main {

	public static void main(String[] args) {

		String username = "test";
		String password="test";
		UserValidator userV1 = new UserValidator("ldap","1234556");
		UserValidator userV2 = new UserValidator("gogoing","666666");
		TaskValidator ldap = new TaskValidator(userV1,username,password);
		TaskValidator dbTask = new TaskValidator(userV2,username,password);
		List<TaskValidator> taskList = new ArrayList<TaskValidator>();
		taskList.add(ldap);
		taskList.add(dbTask);
		ExecutorService executor = Executors.newCachedThreadPool();
		String result;
		try {
			result = executor.invokeAny(taskList);
			System.out.println("result:"+result);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executor.shutdown();
		System.out.println("end");
	}

}
