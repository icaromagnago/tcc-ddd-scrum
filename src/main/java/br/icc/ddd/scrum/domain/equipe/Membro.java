package br.icc.ddd.scrum.domain.equipe;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.icc.ddd.scrum.domain.Email;
import br.icc.ddd.scrum.domain.Entidade;
import br.icc.ddd.scrum.domain.ValidacaoException;

@Entity
public class Membro extends Entidade {

	private static final long serialVersionUID = 1L;

	@NotNull(message="O nome é obrigatório")
	@Size(max=100, message="O nome deve ter no máximo 100 caracteres")
	private String nome;

	@NotNull(message="O email é obrigatório")
	@Email
	private String email;

	@NotNull(message="O nome de usuário é obrigatório")
	@Size(max=50, message="O nome de usuário deve possuir no máximo 50 caracteres")
	private String nomeDeUsuario;

	@NotNull
	private boolean ativo;

	@ManyToOne(optional=true)
	private Equipe equipe;

	public Membro() {
		super();
		this.setAtivo(true);
	}

	public Membro(String nome, String email, String nomeDeUsuario, Equipe equipe) {
		this.setNome(nome);
		this.setEmail(email);
		this.setNomeDeUsuario(nomeDeUsuario);
		this.setAtivo(true);
		this.setEquipe(equipe);
	}

	/**
	 * Verifica se o membro já é membro de uma outra equipe que não seja esta.
	 * @param idEquipe id da equipe a desconsiderar
	 * @return True se o membro é membro de outra equipe que não esta. False caso contrário.
	 */
	public boolean ehMembroDeAlgumaOutraEquipe(Long idEquipe) {
		return getEquipe() != null && getEquipe().getId() != idEquipe;
	}

	/**
	 * Vincula o membro a equipe
	 * @param equipe na qual o membro será vinculado
	 */
	public void vincularAEquipe(Equipe equipe) {
		setEquipe(equipe);
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;

		violacoes = obterValidador().validateProperty(this, "email");
		if(!violacoes.isEmpty()) {
			throw new ValidacaoException(getClass(), violacoes);
		}
	}

	public String getNomeDeUsuario() {
		return nomeDeUsuario;
	}

	public void setNomeDeUsuario(String nomeDeUsuario) {
		this.nomeDeUsuario = nomeDeUsuario;

		violacoes = obterValidador().validateProperty(this, "nomeDeUsuario");
		if(!violacoes.isEmpty()) {
			throw new ValidacaoException(getClass(), violacoes);
		}
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;

		violacoes = obterValidador().validateProperty(this, "ativo");
		if(!violacoes.isEmpty()) {
			throw new ValidacaoException(getClass(), violacoes);
		}
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	@Override
	public String toString() {
		return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Membro)) {
			return false;
		}
		Membro other = (Membro) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!(id == other.id)) {
			return false;
		}

		return true;
	}
}
