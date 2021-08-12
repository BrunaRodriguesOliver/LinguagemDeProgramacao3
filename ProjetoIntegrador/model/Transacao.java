package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import model.Enum.FormaTransacao;
import model.Enum.TipoTransacao;

public class Transacao {

	private long id;
	private double valor;
	private String descricao;
	private Date dataTransacao;
	private Categoria categoria;
	private TipoTransacao tipoTransacao;
	private FormaTransacao formaTransacao;

	public long getId() {
		return id;
	}
	
	public double getValor() {
		return valor;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public TipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}
	
	public FormaTransacao getFormaTransacao() {
		return formaTransacao;
	}
	
	public Date getDataTransacao() {
		return dataTransacao;
	}
	
	public String getDataTransacaoFormatted() {
		SimpleDateFormat spdf = new SimpleDateFormat("dd/MM/YYYY");
		return spdf.format(this.dataTransacao);
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void setTipoTransacao(TipoTransacao tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}

	public void setFormaTransacao(FormaTransacao formaTransacao) {
		this.formaTransacao = formaTransacao;
	}

	public void setDataTransacao(Date dataTransacao) {
		this.dataTransacao = dataTransacao;
	}

}
