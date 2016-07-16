package br.icc.ddd.scrum.infraestructure.persistencia.hibernate;

import br.icc.ddd.scrum.domain.equipe.Equipe;
import br.icc.ddd.scrum.domain.equipe.EquipeRepository;
public class EquipeHibernateRepository extends AbstractHibernateRepository<Equipe> implements EquipeRepository {
	private static final long serialVersionUID = 1L;

}
