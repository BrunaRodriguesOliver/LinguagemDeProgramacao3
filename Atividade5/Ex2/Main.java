package Ex2;

import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		
		Optional<String> optVazio = Optional.empty();
		Optional<String> optComValor = Optional.of("Possui valor!");
		
		System.out.println(optComValor.orElseThrow(()-> 
							new NullPointerException("Está vazio")));
		
		optVazio.orElseThrow(()-> new NullPointerException("Está vazio"));

	}

}
