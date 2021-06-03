package Questao13;

public class Caixa {
	public synchronized void operacoes(String cliente, Boolean saque, Boolean
			transferencia) {
		
			if(saque) {
				System.out.println("O cliente " + cliente +
						" iniciou operacao de saque!");
				try {
					Thread.sleep(8000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			if(transferencia) {
				System.out.println("o Cliente " + cliente +
						" iniciou operacao de transferencia!");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}


}
