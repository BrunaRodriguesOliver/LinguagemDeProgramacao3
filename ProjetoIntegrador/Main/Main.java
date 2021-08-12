package Main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import Repository.RepositoryCategoria;
import Repository.RepositoryTransacoes;
import exceptions.ExceptionDuplicado;
import exceptions.ExpectionEntidadeNaoEncontrada;
import model.Categoria;
import model.Transacao;
import model.Enum.FormaTransacao;
import model.Enum.TipoTransacao;
import view.CategoriaView;

public class Main {

	public static void main(String[] args) {
		
			Scanner ent = new Scanner(System.in);
			Integer opc;

			RepositoryTransacoes rt = null;
			RepositoryCategoria rc = null;

			try {
				rt = new RepositoryTransacoes();
				rc = new RepositoryCategoria();
			} catch (ExceptionDuplicado e) {
				e.printStackTrace();
			}

			do {

				System.out.println("\nEscolha uma opção: ");
				System.out.println("1 - Ver Extrato");
				System.out.println("2 - Registrar transação");
				System.out.println("3 - Listagem de categorias de transação");
				System.out.println("4 - Cadastrar nova categoria de transação");
				System.out.println("0 - Sair");

				opc = ent.nextInt();

				switch (opc) {
				case 1:
					System.out.println("Visualizando transações");

					List<Transacao> transacoes = new ArrayList<Transacao>();
					transacoes = rt.getAll();

					transacoes.forEach(t -> {
						System.out.println("#" + t.getId() + " - " + t.getDescricao() + " " + t.getTipoTransacao());
						System.out.println(t.getCategoria().getNome());
						System.out.println("Realizada em: " + t.getDataTransacaoFormatted());
						System.out.println("Forma de transação: " + t.getFormaTransacao());
						System.out.println("Valor: " + t.getValor());
					});

					Double saldo = transacoes.stream().map(t -> t.getValor()).reduce(0.0,
							(acc, elementoAtual) -> acc + elementoAtual);

					System.out.println("Seu saldo atual é: R$" + saldo);

					break;

				case 2:

					System.out.println("Registrar transação: ");

					System.out.println("Informe o código da categoria de transação: ");
					rc.getAll().forEach(c -> {
						System.out.println(" Cód: " + c.getId() + " " + c.getNome());
					});

					Optional<Categoria> categoriaEscolhida = rc.findOne(ent.nextInt());

					Transacao transacao = new Transacao();
					try {
						categoriaEscolhida.ifPresentOrElse((c) -> {
							transacao.setCategoria(c);
						}, () -> {
							throw new ExpectionEntidadeNaoEncontrada("A categoria selecionada não existe");
						});

						System.out.println("Informe a baixo o tipo de transação:");
						for (int i = 0; i < TipoTransacao.values().length; i++) {
							System.out.println(i + " - " + TipoTransacao.values()[i]);
						}

						int opcaoTipoTransacao = ent.nextInt();
						if (opcaoTipoTransacao > TipoTransacao.values().length || opcaoTipoTransacao < 0) {
							throw new IllegalArgumentException("Esse tipo de trnasação não existe na lista");
						}

						transacao.setTipoTransacao(TipoTransacao.values()[opcaoTipoTransacao]);

						System.out.println("Informe o valor da transação");
						transacao.setValor(ent.nextDouble());

						System.out.println("Escolha abaixo a forma de transação:");

						for (int i = 0; i < FormaTransacao.values().length; i++) {
							System.out.println(i + " - " + FormaTransacao.values()[i]);
						}

						int opcaoFormaTransacao = ent.nextInt();

						if (opcaoFormaTransacao < 0 || opcaoFormaTransacao > FormaTransacao.values().length) {
							throw new IllegalArgumentException("A forma informada não existe na lista");
						}
						transacao.setFormaTransacao(FormaTransacao.values()[opcaoFormaTransacao]);
						ent.nextLine();

						System.out.println("Descrição do gasto:");
						Optional<String> descricao = Optional.ofNullable(ent.nextLine());

						if (descricao.isPresent() && !descricao.get().isBlank()) {
							transacao.setDescricao(descricao.get());
						} else {
							transacao.setDescricao(transacao.getTipoTransacao().toString());
						}

						transacao.setDataTransacao(new Date());

						rt.add(transacao);
					} catch (Exception e) {
						System.out.println(e.getMessage());
						System.out.println("Não foi possível seguir com seu cadastro");
					}

					break;

				case 3:
					CategoriaView.exibirLista(rc);
					break;

				case 4:
					CategoriaView.cadastrarCategoriaNova(ent, rc);

					break;

				default:
					break;
				}

			} while (opc != 0);

			ent.close();
		}

		public static void inicializarRepositories() {

		

	}

}
