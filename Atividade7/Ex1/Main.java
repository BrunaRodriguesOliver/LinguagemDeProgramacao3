package Ex1;

import java.util.Scanner;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {

			System.out.println("Digite um número");
			Integer primeiroNumero = sc.nextInt();

			System.out.println("Digite um novo número");
			Integer segundoNumero = sc.nextInt();

			if (primeiroNumero < 0 || segundoNumero < 0) {
				throw new IllegalArgumentException("Erro: argumento negativo");
			}

			if (primeiroNumero > 1000 || segundoNumero > 1000) {
				throw new IllegalArgumentException("Erro: Digite um valor menor que 1000");
			}

			float result = primeiroNumero / segundoNumero;
			System.out.println("Resultado: " + result);
		}

		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (ArithmeticException e) {
			System.out.println("Não é possível dividir o valor por 0");
		} catch (Exception e) {
			System.out.println("Houve um ocorreu: ");
			e.printStackTrace();
		} finally {
			System.out.println("Finalizada e execução");
		}
		sc.close();
	}


}
