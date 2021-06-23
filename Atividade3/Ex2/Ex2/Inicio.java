package Ex2;

public class Inicio {

	public static void main(String[] args) {
		InterfaceFuncional func = (msg) -> {
			System.out.println(msg);
		};
		
		func.show("The corousel never stops turning");

	}

}
