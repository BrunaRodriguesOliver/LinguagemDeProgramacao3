package Ex3;

import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		
		Scanner e = new Scanner(System.in);

		System.out.println("informe um número inteiro");
		Integer valor = e.nextInt();

		System.out.println("Fatorial: "
				+ Stream.iterate(valor, n -> n >= 2, n -> n - 1).reduce((acc, numAtual) -> acc * numAtual).get());

		e.close();

	}

}
