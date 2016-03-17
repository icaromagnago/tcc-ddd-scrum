package br.icc.ddd.scrum.infraestructure.persistencia;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;

import br.icc.ddd.scrum.domain.Entidade;

@SuppressWarnings("unchecked")
public abstract class AbstractHibernateRepository<E extends Entidade> implements Repository<E> {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	protected EntityManager em;
	protected Class<E> clazz;
	public static final Integer BATCH_SIZE = 20;

	@PostConstruct
	public void postConstruct() {
		clazz = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * Recupera a sessão do Hibernate.
	 *
	 * @return Sessão do Hibernate.
	 */
	protected Session getSession() {
		return (Session) em.getDelegate();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E obter(Long id) {
		return em.find(clazz, id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<E> obterTodos() {
		return em.createQuery("from " + clazz.getName()).getResultList();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E incluir(E entidade) {
		em.persist(entidade);
		em.flush();

		return entidade;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void incluir(List<E> entidades) {
		Session session = getSession();
		entidades.forEach(entidade -> {
			int index = 0;
			session.saveOrUpdate(entidade);
			if (index % BATCH_SIZE == 0) {
				session.flush();
				session.clear();
			}
		});
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E atualizar(E entidade) {
		E entidadeAtualizada = em.merge(entidade);

		return entidadeAtualizada;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void atualizar(List<E> entidades) {
		entidades.forEach(entidade -> em.merge(entidade));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void excluir(E entidade) {
		em.remove(entidade);
		em.flush();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void excluir(Long id) {
		E entidade = obter(id);
		excluir(entidade);
	}
}
