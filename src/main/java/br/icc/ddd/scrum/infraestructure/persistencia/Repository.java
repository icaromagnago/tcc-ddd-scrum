package br.icc.ddd.scrum.infraestructure.persistencia;

import java.io.Serializable;
import java.util.List;

import br.icc.ddd.scrum.domain.Entidade;

public interface Repository<E extends Entidade> extends Serializable {

	/**
	 * Recupera uma entidade a partir do seu identificador.
	 *
	 * @param id Identificador da entidade
	 * @return Entidade recuperada
	 */
	E obter(Long id);

	/**
	 * Recupera todas as entidade.
	 *
	 * @return List<E> Entidades recuperadas
	 */
	List<E> obterTodos();

	/**
	 * Persiste uma entidade na base de dados através do persit.
	 *
	 * @param entidade Entidade a ser persistida.
	 * @return Entidade gerenciada.
	 */
	E incluir(E entidade);

	/**
	 * Persiste uma lista de entidades
	 * @param entidades
	 */
	void incluir(List<E> entidades);

	/**
	 * Atualiza uma entidade na base de dados através do merge.
	 *
	 * @param entidade Entidade a ser persistida.
	 * @return Entidade gerenciada.
	 */
	E atualizar(E entidade);

	/**
	 * Atualiza uma lista de entidades
	 * @param entidades
	 */
	void atualizar(List<E> entidades);

	/**
	 * Remove a entidade do repositório.
	 *
	 * @param entidade Entidade a ser removida
	 */
	void excluir(E entidade);

	/**
	 * Exclui uma entidade através do identificador
	 * @param id
	 */
	void excluir(Long id);
}
