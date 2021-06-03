package Questao13;

public class Cliente implements Runnable {
	
	private String nome;
	private Boolean saque;
	private Boolean transferencia;
	
	private static Caixa cx = new Caixa();
	
	public Cliente(String nome) {
		super();
		this.nome = nome;
	}
	public void fazerOperacao(Boolean saque, Boolean transferencia) {
		this.saque = saque;
		this.transferencia = transferencia;
		new Thread(this, nome).start();
	}
	
	@Override
	public void run() {

		System.out.println("Cliente " + nome + " solicitou uso do caixa.");
		
		cx.operacoes(nome, saque, transferencia);
		
		System.out.println("Cliente " + nome + " finalizou o uso do caixa.");
	}
}