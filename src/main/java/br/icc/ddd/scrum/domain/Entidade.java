package br.icc.ddd.scrum.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Toda entidade do sistema deve herdar desta classe abstrata
 */
@MappedSuperclass
public abstract class Entidade implements Serializable {

	private static final long serialVersionUID = 4394209939156982282L;
	
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
}
