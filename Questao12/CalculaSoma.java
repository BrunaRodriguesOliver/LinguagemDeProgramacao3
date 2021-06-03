package Questao12;

import java.util.Scanner;

public class CalculaSoma {

	public static void main(String[] args) {
		Scanner e = new Scanner(System.in);
		
		Integer a;
		Integer b;
	
		System.out.print("Informe o numero: ");
		a = Integer.parseInt( e.nextLine() );
		
		System.out.print("Informe um numero maior que o anterior: ");
		b = Integer.parseInt( e.nextLine() );
		
		while( a < b ) {
			System.out.print("\n\nO valor digitado nao e maior que "+
					a+", digite um novo valor: ");
			b = Integer.parseInt( e.nextLine() );
		}
		
		Soma s = new Soma(a, b);
		s.calcular();
		
		e.close();
	}

}
