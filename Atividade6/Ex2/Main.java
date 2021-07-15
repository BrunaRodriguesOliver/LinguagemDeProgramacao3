package Ex2;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<String> nomes = Arrays.asList("Paulo", "Camila", "Ana Maria", "Patrick", "Ana Clara", "Pedro", "Alfredo");
		
		System.out.println(nomes.stream().filter(n -> n.startsWith("P")).reduce((acc, nomeAtual) -> acc.concat(", " + nomeAtual)).get());

		System.out.println(nomes.stream().filter(n -> n.startsWith("A")).reduce((acc, nomeAtual) -> acc.concat(", " + nomeAtual)).get());
		
		System.out.println(nomes.stream().reduce((acc, nomeAtual) -> acc.concat(", " + nomeAtual)).get());

	}

}
