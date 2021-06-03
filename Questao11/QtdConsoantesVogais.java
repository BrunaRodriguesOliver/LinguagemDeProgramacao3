package Questao11;

class QtdConsoantesVogais implements Runnable{
	
	private String palavra;
	private Integer qtdVogais = 0;
	private Integer qtdConso = 0;
	private Integer result = 0;
	private boolean vogal = false;
	private char c;
	
	public QtdConsoantesVogais(String palavra, boolean vogal) {
		this.vogal = vogal;
		this.palavra = palavra.toLowerCase();
	}
	
	@Override
	public void run() {
		for(int i = 0; i < palavra.length(); i++) {
			c = palavra.charAt(i);
			if(c == 97 || c == 101 || c == 105 || c == 111 || c == 117) {
				qtdVogais++;
			} else if((c >= 97) && (c <= 122)) {
				qtdConso++;
			}
		}
		
		result = (vogal ? qtdVogais : qtdConso);
		if(vogal) {
			System.out.println("Na palavra " + palavra + " contém " + result + " vogais");
		} else {
			System.out.println("Na palvra " + palavra + " contém " + result + " consoantes");
		}
	}
	
	public void qtd() {
		Thread td = new Thread(this);
		td.start();
	}
	
	
	
}
