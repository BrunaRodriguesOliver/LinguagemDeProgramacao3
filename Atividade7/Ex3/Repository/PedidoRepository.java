package Repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Exception.EstoqueException;
import Model.Pedido;
import Model.Produto;

public class PedidoRepository {

	private static List<Pedido> compras = new ArrayList<Pedido>();

	public static void savePedido(Pedido pedido) {

		System.out.println("Verificando pedido");

		List<Produto> produtos = pedido.getProdutosDaCompra();

		produtos.forEach(prod -> {

			// Valida a compra
			if (ProdutoRepository.estoque.containsKey(prod.getId())) {

				Integer quantidadeDisponivel = ProdutoRepository.estoque.get(prod.getId());

				if (quantidadeDisponivel == 0) {
					throw new EstoqueException("O produto: " + prod.getNome() + " não está disponível e estoque");
				} else {
					ProdutoRepository.darBaixaEmProduto(prod.getId());
				}

			} else {
				throw new IllegalArgumentException("Desculpe, o produto solicitado não existe.");
			}
		});

		compras.add(pedido);
		System.out.println("Pedido finalizado com sucesso");
	}

	public static void getCompras() {
		compras.forEach(c -> {
			System.out.println("\nCompra: " + c.getId());

			System.out.println("Cliente: " + c.getComprador().getNome() + " - " + c.getComprador().getCpf());

			SimpleDateFormat spdf = new SimpleDateFormat("dd-MM-YYYY");

			System.out.println("Comprado em: " + spdf.format(c.getDataPedido()));
			c.getProdutosDaCompra().forEach(pc -> {
				System.out.println("Produto: " + pc.getNome() + " - R$:" + pc.getPreco());
			});
		});
	}

}
