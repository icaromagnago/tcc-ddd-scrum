package br.icc.ddd.scrum.domain;

import java.util.Set;

import javax.validation.ConstraintViolation;

public class ValidacaoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private Class<? extends Entidade> clazz;
	private Set<ConstraintViolation<Entidade>> violacoes;

	public ValidacaoException(Class<? extends Entidade> clazz,
			Set<ConstraintViolation<Entidade>> violacoes) {
		this.clazz = clazz;
		this.violacoes = violacoes;
	}

	public ValidacaoException(Set<ConstraintViolation<Entidade>> violacoes) {
		this.violacoes = violacoes;
	}

	public Class<? extends Entidade> getClazz() {
		return clazz;
	}

	public void setClazz(Class<? extends Entidade> clazz) {
		this.clazz = clazz;
	}

	public Set<ConstraintViolation<Entidade>> getViolacoes() {
		return violacoes;
	}

	public void setViolacoes(Set<ConstraintViolation<Entidade>> violacoes) {
		this.violacoes = violacoes;
	}
}
