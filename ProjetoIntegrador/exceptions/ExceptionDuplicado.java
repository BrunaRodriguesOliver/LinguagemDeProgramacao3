package exceptions;

public class ExceptionDuplicado extends RuntimeException  {
	
	private static final long serialVersionUID = 1L;

	public ExceptionDuplicado(String mensagem) {
		super(mensagem);
	}

}
