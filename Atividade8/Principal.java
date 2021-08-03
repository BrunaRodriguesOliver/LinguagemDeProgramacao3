
public class Principal {

	public static void main(String[] args) {
		
		Cliente cliente = new Cliente("Bruna", "12345665433", "97656-7765");
		Reflection reflection = new Reflection(cliente);
		
		reflection.doAnalise();
		
		reflection.createNewObject("Cliente");
	}

}
