package Questao14;

public class Inicio {
	
	public static void main(String[] args) {
		Cliente joao = new Cliente("Joao");
		Cliente alice = new Cliente("Alice");
		
		// operacoes de saque e transferencia
		joao.realizarOperacao(true, true);
		alice.realizarOperacao(true, true);
		}

}
