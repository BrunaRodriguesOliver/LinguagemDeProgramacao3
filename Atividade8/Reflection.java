import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {

	private Object objeto;

	private Class<?> specificClass;

	public Reflection(Object objeto) {
		this.objeto = objeto;
	}

	public void createNewObject(String nomeClasse) {
		try {
			Class<?> cl = Class.forName(nomeClasse);

			System.out.println("\nCriando instância de " + cl.getSimpleName());
			Object instance = cl.getDeclaredConstructor().newInstance();

			Field[] fields = cl.getDeclaredFields();

			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];

				System.out.println("Setando valor em: " + field.getName());

				boolean isAcessivel = field.canAccess(this.objeto);
				field.setAccessible(true);

				Object valor = field.getType().equals(String.class) ? "Cliente novo" : 0.0;
				field.set(instance, valor);

				field.setAccessible(isAcessivel);
			}

			System.out.println(instance.toString());

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}

	public void doAnalise() {

		this.specificClass = this.objeto.getClass();

		System.out.println("Nome da classe: " + this.specificClass.getName());
		System.out.println("Localizada em: " + this.specificClass.getCanonicalName());
		System.out.println("Tipo da classe: " + this.specificClass.getTypeName());

		System.out.println("\n");

		try {
			this.doAnaliseAtributos();
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		System.out.println("\n");

		doAnaliseMetodos();
	}

	private void doAnaliseAtributos() throws IllegalArgumentException, IllegalAccessException {
		Field[] fields = this.specificClass.getDeclaredFields();

		for (int i = 0; i < fields.length; i++) {

			Field field = fields[i];

			boolean isAcessivel = field.canAccess(this.objeto);

			field.setAccessible(true);

			System.out.println("Nome do atributo: " + field.getName());
			System.out.println("Tipo do atributo: " + field.getType().getName());
			System.out.println("Valor do atributo: " + field.get(this.objeto).toString());
			System.out.println("\n");

			field.setAccessible(isAcessivel);
		}

		System.out.println("Modificando atributo: " + fields[0].getName());

		boolean isAcessivel = fields[0].canAccess(this.objeto);
		fields[0].setAccessible(true);

		System.out.println("Valor atual: " + fields[0].get(this.objeto));

		Object valor = fields[0].getType().equals(String.class) ? "Ola" : 0;

		fields[0].set(this.objeto, valor);

		System.out.println("Novo valor: " + fields[0].get(this.objeto));

		fields[0].setAccessible(isAcessivel);

		System.out.println("\nMudando visibilidade do atributo: " + fields[0].getName());

		fields[0].setAccessible(!isAcessivel);

		System.out.println("Novo valor: " + fields[0].canAccess(this.objeto));
	}

	private void doAnaliseMetodos() {
		Method metodos[] = specificClass.getDeclaredMethods();

		for (int i = 0; i < metodos.length; i++) {
			Method method = metodos[i];

			System.out
					.println("Método: " + method.getName() + " - Retorno: " + method.getGenericReturnType().toString());
		}
	}
}
