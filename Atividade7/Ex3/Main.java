package Ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Exception.EstoqueException;
import Model.Cliente;
import Model.Pedido;
import Repository.PedidoRepository;
import Repository.ProdutoRepository;

public class Main {

	public static void main(String[] args) {
		ProdutoRepository.criarProdutos();

		List<Cliente> clientes = new ArrayList<Cliente>();

		// Cadastra um cliente com CPF errado
		Optional<Cliente> cliente1 = Optional.ofNullable(cadastrarCliente("João", "65784394"));
		cliente1.ifPresent(c -> clientes.add(c));

		// Cadastra um cliente com CPF correto
		Optional<Cliente> cliente2 = Optional.ofNullable(cadastrarCliente("Maria", "23456457699"));
		cliente1.ifPresent(c -> clientes.add(c));

		fazerPedido(cliente2.get());
		fazerPedido(cliente2.get());
		fazerPedido(cliente2.get());
			
		//Aqui da erro, pois existem domente 3 produos no estoque
		fazerPedido(cliente2.get());
	
		// Vizualiza as compras que foram feitas
		PedidoRepository.getCompras();
	}

	public static void fazerPedido(Cliente cliente) {
		System.out.println("\n" + cliente.getNome() + " fazendo pedido");

		// Simula compra com todos os produtos disponiveis
		Pedido pedido = new Pedido(ProdutoRepository.produtosDisponiveis, cliente);

		try {
			PedidoRepository.savePedido(pedido);
		} catch (EstoqueException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Desculpe. Um erro inesperado ocorreu");
			e.printStackTrace();
		}

	}

	public static Cliente cadastrarCliente(String nome, String cpf) {
		System.out.println("\nCadastrando cliente: " + nome);

		try {
			Cliente clienteComCpfErrado = new Cliente(nome, cpf);
			System.out.println("Criado com sucesso");
			return clienteComCpfErrado;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	
	}

}
