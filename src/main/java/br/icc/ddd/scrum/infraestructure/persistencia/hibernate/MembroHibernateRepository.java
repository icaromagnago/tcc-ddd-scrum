package br.icc.ddd.scrum.infraestructure.persistencia.hibernate;

import java.util.List;

import javax.persistence.Query;

import br.icc.ddd.scrum.domain.equipe.Membro;
import br.icc.ddd.scrum.domain.equipe.MembroRepository;

@SuppressWarnings("unchecked")
public class MembroHibernateRepository extends AbstractHibernateRepository<Membro> implements MembroRepository {

	private static final long serialVersionUID = 1L;

	@Override
	public List<Membro> todosOsMembrosDaEquipe(Long idEquipe) {
		Query query = em.createQuery("from Membro m where m.equipe.id = :idEquipe");
		query.setParameter("idEquipe", idEquipe);

		return query.getResultList();
	}

	@Override
	public List<Membro> membrosPorNome(String nome) {
		Query query = em.createQuery("from Membro m where m.nome like :nome");
		query.setParameter("nome", "%"+nome+"%");

		return query.getResultList();
	}
}
