package Ex1;

import java.util.Optional;

public class ExA {

	public static void main(String[] args) {
		
		Optional<String> result = Optional.empty();

		System.out.println(result.orElse("Valor diferente"));

		System.out.println(result.orElseGet(() -> "Valor novo"));

	}

}
