package Repository;

import java.util.List;
import java.util.Optional;

import exceptions.ExceptionDuplicado;

public interface Repository<T> {
	
	public void add(T objeto) throws ExceptionDuplicado;
	public void remove(T objeto);
	public List<T> getAll();
	public Optional<T> findOne(long id);

}
