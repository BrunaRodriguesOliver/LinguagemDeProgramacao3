package view;

import java.util.Scanner;

import Repository.RepositoryCategoria;
import exceptions.ExceptionDuplicado;
import exceptions.ExceptionVazio;
import model.Categoria;

public class CategoriaView {
	
	public static void exibirLista(RepositoryCategoria categoriaRepository) {
		System.out.println("Litagem de categorias de transaçăo\n");

		categoriaRepository.getAll().stream().forEach(c -> {
			System.out.println("#Cód: " + c.getId() + " - " + c.getNome());
		});
	}

	public static void cadastrarCategoriaNova(Scanner scan, RepositoryCategoria categoriaRepository) {
		System.out.println("Cadastrar categoria de transaçăo\n");

		System.out.println("Digite um nome para a categoria: ");
		String nome = scan.nextLine();

		try {

			Categoria categoria = new Categoria();
			categoria.setNome(nome);

			categoriaRepository.add(categoria);
			System.out.println("Categoria cadastrada!");
			
			if (nome.isBlank()) {
				throw new ExceptionVazio("O nome está vazio");
			}
			
		} catch (ExceptionDuplicado | ExceptionVazio e) {
			System.out.println(e.getMessage());
			System.out.println("Năo foi possível realizar o registro da categoria");
		}
	}


}
