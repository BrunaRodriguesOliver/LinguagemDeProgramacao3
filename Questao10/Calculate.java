import java.util.Scanner;

public class Calculate {

	public static void main(String[] args) {
		Scanner e = new Scanner(System.in);
		
		Integer n1;
		Integer n2;
		String operacao;
		
		System.out.println("Informe o primeiro numero: ");
		n1 = Integer.valueOf(e.nextLine());
		
		System.out.println("Informe o segundo numero: ");
		n2 = Integer.valueOf(e.nextLine());
		
		System.out.println("Qual a operação que deja fazer? (+, -, *, /) ");
		operacao = e.nextLine();
		
		Calculator c = new Calculator(n1, n2, operacao);
		
		e.close();
		
		
	}
	
}
