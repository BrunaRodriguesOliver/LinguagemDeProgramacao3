package exceptions;

public class ExceptionVazio extends RuntimeException{
	

	private static final long serialVersionUID = 1L;

	public ExceptionVazio(String mensagem) {
		super(mensagem);
		
	}
}
