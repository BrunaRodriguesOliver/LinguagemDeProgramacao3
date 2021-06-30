package ex2;

import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		
		Stream.iterate(0, n -> n <= 9, n -> n + 1) 
			.filter(n -> n % 2 == 0) //numeros pares
			.skip(2) //ignora dois primeiros numeros
			.limit(2) // limite dois primeiro numeros
			.map(x -> x * 2) //multiplica por 2
			.forEach(System.out::println); //resultado

	}

}
