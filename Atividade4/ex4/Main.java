package ex4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<String> nomes = Arrays.asList("Paulo", "Camila", "Ana Maria", "Patrick", "Ana Clara", "Pedro", "Alfredo");

		System.out.println("\nNomes que começam com P");
		nomes.stream().filter(nome -> nome.startsWith("P")).forEach(System.out::println);

		System.out.println("\nNomes por tamanho");
		nomes.stream().sorted((a, b) -> a.length() - b.length())
				.forEach(nome -> System.out.println("Nome: " + nome + " Tamanho: " + nome.length()));

		System.out.println("\nNomes com A");
		nomes.stream().map(nome -> nome + " - " + nome.startsWith("A")).forEach(System.out::println);

		System.out.println("\nNomes por tamanho, em caixa alta e com vírgula");
		System.out.println(nomes.stream().sorted((a, b) -> a.length() - b.length()).map(nome -> nome.toUpperCase())
				.collect(Collectors.joining(", ")));

	}

}
