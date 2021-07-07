package Ex3;

import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		
		Boolean result = Stream.of("Paulo", "Camila", "Ana Maria", "Patrick", "Ana Clara", "Pedro", "Alfredo")
				.filter(n -> n.startsWith("W")).findAny().isPresent();

		if (!result) {
			System.out.println("Nomes com esta letra não consta na lista");
		}
	}

}
