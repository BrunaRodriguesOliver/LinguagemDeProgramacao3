package Questao13;

public class Inicio {

	public static void main(String[] args) {
		
		Cliente joao = new Cliente("Jo�o");
		Cliente alice = new Cliente("Alice");
		
		// opera��es de saque e transferencia
		joao.fazerOperacao(true, true);
		alice.fazerOperacao(true, true);

	}

}
