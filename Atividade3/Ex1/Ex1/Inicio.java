package Ex1;

import java.util.List;
import java.util.Arrays;
import java.util.function.Predicate;

public class Inicio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> numero = Arrays.asList(2, 8, 6, 7, 5);
		
		operacoes(numero, (n) -> true);
		

	}
	
	public static void operacoes(List<Integer> numero, Predicate<Integer> predicate) {
		numero.forEach(n -> {
			System.out.println("Número: " + n);
			System.out.println("Número ao quadrado: " + n*n);
			System.out.println("Dobro do número:" + n*2);
			System.out.println("Número + 3: " + n+3 );
		});
	}

}
