package Ex1;

import java.util.Optional;

public class ExB {

	public static void main(String[] args) {
		
		Optional<String> vazio = Optional.empty();
		Optional<String> comValor = Optional.of("Possui valor");

		System.out.println(vazio.orElse("Optional não tinha valor"));
		System.out.println(comValor.orElse("Isso não será mostrado"));

		System.out.println(vazio.orElseGet(() -> "Optional não tinha valor"));
		System.out.println(comValor.orElseGet(() -> "Isso não será mostrado"));
	}

}
