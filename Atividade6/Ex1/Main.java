package Ex1;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Gerar 100 números aleatórios");
		List<Integer> numAleatorios = Stream.generate(() -> new Random().nextInt(10))
				.limit(100)
				.filter(n -> n != 0)
				.collect(Collectors.toList());

		System.out.println(numAleatorios.toString());

		Integer soma = numAleatorios.stream().reduce(0, (acc, elementoAtual) -> acc + elementoAtual);
		System.out.println("Soma dos números gerados: " + soma);

		Integer multiplicacao = numAleatorios.stream().reduce(1, (acc, elementoAtual) -> acc * elementoAtual);
		System.out.println("Multiplicação dos números gerados: " + multiplicacao);

		Integer menorNumero = numAleatorios.stream().reduce(Integer.MAX_VALUE,
				(acc, elementoAtual) -> Math.min(acc, elementoAtual));
		System.out.println("Menor número da lista: " + menorNumero);

		Integer maiorNumero = numAleatorios.stream().reduce(0,
				(acc, elementoAtual) -> Math.max(acc, elementoAtual));
		System.out.println("Maior número da lista: " + maiorNumero);

	}

}
