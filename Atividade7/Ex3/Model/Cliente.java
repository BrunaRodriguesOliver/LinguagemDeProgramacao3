package Model;

import java.util.UUID;

public class Cliente {

	private UUID id;
	private String nome;
	private String cpf;

	public Cliente(String nome, String cpf) {
		this.id = UUID.randomUUID();
		this.nome = nome;
		this.setCpf(cpf);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {

		if (cpf.length() == 11) {
			this.cpf = cpf;
		} else {
			throw new IllegalArgumentException("CPF INVÁLIDO: O CPF	deve possuir 11 dígitos");
		}

	}
}