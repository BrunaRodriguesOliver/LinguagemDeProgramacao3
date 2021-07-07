package Ex4;

import java.util.stream.Stream;
import javax.naming.NameNotFoundException;

public class Main {

	public static void main(String[] args) throws NameNotFoundException {
		
		Stream.of("Paulo", "Camila", "Ana Maria", "Patrick", "Ana Clara", "Pedro", "Alfredo")
		.filter(n -> n.startsWith("W")).findAny().orElseThrow(()-> new NameNotFoundException());

	}

}
