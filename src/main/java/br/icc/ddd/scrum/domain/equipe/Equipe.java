package br.icc.ddd.scrum.domain.equipe;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.icc.ddd.scrum.domain.Entidade;
import br.icc.ddd.scrum.domain.ValidacaoException;

@Entity
public class Equipe extends Entidade {

	private static final long serialVersionUID = 1L;

	@NotNull(message="O nome é obrigatório")
	@Size(max=255, message="O nome da equipe deve possuir no máximo 255 caracteres")
	private String nome;

	@Size(max=2000, message="A descrição deve possuir no máximo 2000 caracteres")
	private String descricao;

	@OneToOne(optional=true)
	private Membro scrumMaster;

	@OneToMany(mappedBy = "equipe")
	private Set<Membro> membros;

	public Equipe() {
		super();
		this.membros = new HashSet<Membro>();
	}

	public boolean adicionarMembro(Membro membro) {
		return this.membros.add(membro);
	}

	public boolean removerMembro(Membro membro) {
		return this.membros.remove(membro);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;

		violacoes = obterValidador().validateProperty(this, "nome");
		if(!violacoes.isEmpty()) {
			throw new ValidacaoException(getClass(), violacoes);
		}
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;

		violacoes = obterValidador().validateProperty(this, "descricao");
		if(!violacoes.isEmpty()) {
			throw new ValidacaoException(getClass(), violacoes);
		}
	}

	public Membro getScrumMaster() {
		return scrumMaster;
	}

	public void setScrumMaster(Membro scrumMaster) {
		this.scrumMaster = scrumMaster;
	}

	public Set<Membro> getMembros() {
		return membros;
	}

	public void setMembros(Set<Membro> membros) {
		this.membros = membros;
	}
}
