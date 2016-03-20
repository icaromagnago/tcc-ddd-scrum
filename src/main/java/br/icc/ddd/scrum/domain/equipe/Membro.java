package br.icc.ddd.scrum.domain.equipe;

import javax.persistence.Entity;

import br.icc.ddd.scrum.domain.Entidade;

@Entity
public class Membro extends Entidade {

	private String nome;
	private String email;
	private String nomeDeUsuario;
	private boolean ativo;

	public Membro() {
		super();
	}

	public Membro(String nome, String email, String nomeDeUsuario, boolean ativo) {
		this.nome = nome;
		this.email = email;
		this.nomeDeUsuario = nomeDeUsuario;
		this.ativo = ativo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeDeUsuario() {
		return nomeDeUsuario;
	}

	public void setNomeDeUsuario(String nomeDeUsuario) {
		this.nomeDeUsuario = nomeDeUsuario;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
