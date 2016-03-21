package br.icc.ddd.scrum.infraestructure.persistencia;

import br.icc.ddd.scrum.domain.equipe.Membro;
import br.icc.ddd.scrum.domain.equipe.MembroRepository;

public class MembroHibernateRepository extends AbstractHibernateRepository<Membro> implements MembroRepository {

	private static final long serialVersionUID = 1L;
}
