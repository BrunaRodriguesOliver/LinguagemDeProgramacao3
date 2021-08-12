  
package Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import exceptions.ExceptionDuplicado;
import model.Categoria;

public class RepositoryCategoria implements Repository<Categoria> {

	public static long sequencia = 0L;

	private static List<Categoria> categorias = new ArrayList<Categoria>();

	public RepositoryCategoria() throws ExceptionDuplicado {
		add(new Categoria("Moradia", sequencia));
		add(new Categoria("Transporte", sequencia));
		add(new Categoria("Lazer", sequencia));
		add(new Categoria("Salário", sequencia));
		add(new Categoria("Alimentação", sequencia));
		
	}

	@Override
	public void add(Categoria objeto) throws ExceptionDuplicado {
		boolean isCategoriaUnica = categorias.stream().noneMatch(cat -> cat.getNome().equals(objeto.getNome()));

		if (isCategoriaUnica) {
			Categoria categoria = new Categoria();
			categoria.setNome(objeto.getNome());
			categoria.setId(sequencia);
			categorias.add(categoria);
			
			sequencia += 1;
		} else {
			throw new ExceptionDuplicado("A categoria '" + objeto.getNome() + "' já foi cadastrada");
		}

	}

	@Override
	public void remove(Categoria objeto) {
		categorias.removeIf(categoria -> categoria.getId() == objeto.getId());
	}

	@Override
	public List<Categoria> getAll() {
		return categorias;
	}

	@Override
	public Optional<Categoria> findOne(long id) {
		Optional<Categoria> categoria = categorias.stream().filter(c -> c.getId() == id).findFirst();
		return categoria;
	}

}