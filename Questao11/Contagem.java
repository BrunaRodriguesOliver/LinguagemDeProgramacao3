package Questao11;

import java.util.Scanner;

public class Contagem {

	public static void main(String[] args) {
		Scanner e = new Scanner(System.in);
		String palavra;
	
		System.out.println("Informe uma palavra: ");
		palavra = e.nextLine();
		
		QtdConsoantesVogais  consoante = new QtdConsoantesVogais(palavra, false);
		QtdConsoantesVogais  vogal = new QtdConsoantesVogais(palavra, true);
		
		consoante.qtd();
		vogal.qtd();
	}

}
