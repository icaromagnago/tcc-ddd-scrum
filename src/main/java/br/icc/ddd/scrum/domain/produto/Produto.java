package br.icc.ddd.scrum.domain.produto;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.icc.ddd.scrum.domain.Entidade;

@Entity
public class Produto extends Entidade {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message="O nome é obrigatório")
	@Size(max=50, message="O nome deve possuir no máximo 50 caracteres")
	private String nome;
	
	@Size(max=255, message="A descrição deve possuir no máximo 255 caracteres")
	private String descricao;
	
	public Produto() {}
	
	public Produto(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
