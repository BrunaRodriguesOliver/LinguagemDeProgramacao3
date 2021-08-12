package Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.Transacao;
import model.Enum.TipoTransacao;



public class RepositoryTransacoes implements Repository<Transacao> {
	
	public static long sequencia = 0L;
	private static List<Transacao> transacoes = new ArrayList<Transacao>();

	@Override
	public void add(Transacao objeto) {
		objeto.setId(sequencia);
		transacoes.add(objeto);

		if (objeto.getTipoTransacao() == TipoTransacao.GASTO && objeto.getValor() > 0
				|| objeto.getTipoTransacao() == TipoTransacao.RECEITA && objeto.getValor() < 0) {
					objeto.setValor(-objeto.getValor());
		}

		sequencia += 1;
	}

	@Override
	public void remove(Transacao objeto) {
		
	}

	@Override
	public List<Transacao> getAll() {
		return transacoes;
	}

	@Override
	public Optional<Transacao> findOne(long id) {
		return null;
	}


}
