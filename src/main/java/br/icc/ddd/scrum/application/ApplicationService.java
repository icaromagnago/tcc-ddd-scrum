package br.icc.ddd.scrum.application;

import java.io.Serializable;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import br.icc.ddd.scrum.domain.Entidade;
import br.icc.ddd.scrum.domain.ValidacaoException;

public interface ApplicationService extends Serializable {

	/**
	 * Valida as entidades através do bean validation
	 * @param entidade a ser validada
	 * @throws ValidacaoException
	 */
	default public void validarEntidade(Entidade entidade) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Set<ConstraintViolation<Entidade>> violacoes = factory.getValidator().validate(entidade);
		if(!violacoes.isEmpty()) {
			throw new ValidacaoException(violacoes);
		}
	}
}
