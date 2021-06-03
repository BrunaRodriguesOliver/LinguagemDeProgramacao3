
public class Calculator implements Runnable {
	private Integer n1;
	private Integer n2;
	private String operacao;
	
	public Calculator(Integer n1, Integer n2, String operacao) {
		this.n1 = n1;
		this.n2 = n2;
		this.operacao = operacao;
		
		Thread td = new Thread(this);
		td.start();
	}
	
	@Override
	public void run() {
		switch(operacao) {
		case "-":
			System.out.println(n1 + " - " + n2 + " = " + (n1-n2));
			break;
		case "+":
			System.out.println(n1 + " + " + n2 + " = " + (n1+n2));
			break;
		case "*":
			System.out.println(n1 + " x " + n2 + " = " + (n1*n2));
			break;
		case "/":
			System.out.println(n1 + " / " + n2 + " = " + (n1/n2));
			break;
		
		default:
			System.out.println("Houve um erro na resolução do problema,"
					+ "os valores informados");
			break;
		
		}
	}
	
	
	

}
