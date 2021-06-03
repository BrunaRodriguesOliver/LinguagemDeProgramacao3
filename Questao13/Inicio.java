package Questao13;

public class Inicio {

	public static void main(String[] args) {
		
		Cliente joao = new Cliente("João");
		Cliente alice = new Cliente("Alice");
		
		// operações de saque e transferencia
		joao.fazerOperacao(true, true);
		alice.fazerOperacao(true, true);

	}

}
