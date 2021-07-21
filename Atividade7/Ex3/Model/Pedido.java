package Model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Pedido {

	private UUID id;
	private List<Produto> produtosDaCompra;
	private Cliente comprador;
	private Date dataPedido;

	public Pedido(List<Produto> produtos, Cliente comprador) {
		this.produtosDaCompra = produtos;
		this.comprador = comprador;

		this.dataPedido = new Date();
		this.id = UUID.randomUUID();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public List<Produto> getProdutosDaCompra() {
		return produtosDaCompra;
	}

	public void setProdutosDaCompra(List<Produto> produtosDaCompra) {
		this.produtosDaCompra = produtosDaCompra;
	}

	public Cliente getComprador() {
		return comprador;
	}

	public void setComprador(Cliente comprador) {
		this.comprador = comprador;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}
}