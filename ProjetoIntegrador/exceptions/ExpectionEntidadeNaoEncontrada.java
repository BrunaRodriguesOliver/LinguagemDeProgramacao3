package exceptions;

public class ExpectionEntidadeNaoEncontrada extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ExpectionEntidadeNaoEncontrada(String mensagem) {
		super(mensagem);
	}
}
