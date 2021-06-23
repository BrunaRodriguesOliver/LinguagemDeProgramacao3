package Ex4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;



public class Inicio {

	public static void main(String[] args) {

		List<Avaliacao> av = new ArrayList<Avaliacao>();
		
		new Thread(() -> {
			av.add(new Avaliacao("Portugu�s", "Julia Castro", 8.0));
			av.add(new Avaliacao("Portugu�s", "Pedro Barros", 6.9));
			av.add(new Avaliacao("Portugu�s", "Let�cia Cardoso", 5.4));
			av.add(new Avaliacao("Portugu�s", "Arthur Leal", 4.7));
			
			desempenho(av, (avaliacao) -> avaliacao.getNota() > 6);
		}).start();
	}
	
	static void desempenho(List<Avaliacao> av, Predicate<Avaliacao> predicate) {
		Collections.sort(av,
				(Avaliacao av1, Avaliacao av2) -> av1.getAluno().compareTo(av2.getAluno()));
		
		System.out.println("Lista de Alunos Aprovados na Mat�ria: ");
		
		av.forEach(aprovados -> {
			if(predicate.test(aprovados)) {
				System.out.println("\n"+aprovados.getAluno());
				System.out.println("Nota: " + aprovados.getNota());
			}
		});
	}

}
