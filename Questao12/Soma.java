package Questao12;

public class Soma implements Runnable {
	private Integer a;
	private Integer b;
	private Integer soma = 0;
	
	public Soma(Integer a, Integer b) {
		this.a = a;
		this.b = b;
	}
	
	public void calcular() {
		Thread td = new Thread(this);
		td.start();
	}
	
	public void run() {
		Integer qtd = 1;
		Integer vlrInicio = a;
		soma = vlrInicio;
		
		while(soma < b){
			vlrInicio++;
			soma = soma + vlrInicio;
			qtd++;
		}
		
		System.out.println("\nA\tB\tResposta\n " +a+"\t"+ b + "\t" + qtd + "( " + a);
		
		for(int i=(a+1); i <= vlrInicio; i++ ){
			System.out.println("+");
			System.out.println(i);
		}
		System.out.println(" = " + soma + ")\n");
		
	}
}
