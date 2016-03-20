package br.icc.ddd.scrum.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * Toda entidade do sistema deve herdar desta classe abstrata
 */
@MappedSuperclass
public abstract class Entidade implements Serializable {

	private static final long serialVersionUID = 4394209939156982282L;

	@Transient
	protected Set<ConstraintViolation<Entidade>> violacoes =
			new HashSet<ConstraintViolation<Entidade>>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	protected Validator obterValidador() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        return factory.getValidator();
	}
}
