package ex1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		System.out.println("Insira um número limite: ");
		Scanner e = new Scanner(System.in);

		Integer numLimite = e.nextInt();
		e.close();

		System.out.println("Gerando lista de números duplicados...");

		List<Integer> numDuplicados = new ArrayList<Integer>();

		Stream.iterate(1, n -> n <= numLimite, n -> n + 1)
				.forEach(x -> numDuplicados.addAll(Arrays.asList(x, x)));

		System.out.println("Imprimindo lista....");
		numDuplicados.stream().forEach(n -> System.out.println(n));

		System.out.println("Imprimindo lista sem repetição....");
		numDuplicados.stream().distinct().forEach(n -> System.out.println(n));

		System.out.println("Imprimindo ímpares sem repetição....");
		numDuplicados.stream().distinct().filter(n -> n % 2 != 0).forEach(n -> System.out.println(n));

		System.out.println("Imprimindo pares sem repetição....");
		numDuplicados.stream().distinct().filter(n -> n % 2 == 0).forEach(n -> System.out.println(n));

		if (numDuplicados.stream().distinct().count() > 5) {
			System.out.println("Imprimindo a partir do 5º elemento sem repetição....");
			numDuplicados.stream().distinct().skip(5).forEach(n -> System.out.println(n));
		}

		System.out.println("Imprimindo todos multiplicados por 4....");
		numDuplicados.stream().map(n -> n * 4).forEach(n -> System.out.println(n));
	

	}

}
