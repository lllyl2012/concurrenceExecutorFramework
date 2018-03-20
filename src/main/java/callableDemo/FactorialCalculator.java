package callableDemo;

import java.util.concurrent.Callable;

public class FactorialCalculator implements Callable<Integer>{
	private Integer number;
	public FactorialCalculator(int number) {
		this.number = number;
	}
	public Integer call() throws Exception {
		int result = 1;
		if(number==0||number==1) {
			return 1;
		}
		for(int a=2;a<number;a++) {
			result *= a;
		}
		return result;
	}
	
}
