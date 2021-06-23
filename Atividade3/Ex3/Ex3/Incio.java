package Ex3;

import java.util.function.Function;

public class Incio {
	
	public static class Fatorial{
		Function<Integer, Integer> func;
	}

	public static void main(String[] args) {
		Fatorial f = new Fatorial();
		
		f.func = (n) -> {
			if(n == 0) {
				return 1;
			} else {
				return n * f.func.apply(n -1);
			}
		};
		
		System.out.println(f.func.apply(8));
	}

}
