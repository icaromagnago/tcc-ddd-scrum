package br.icc.ddd.scrum.infraestructure.persistencia;

import br.icc.ddd.scrum.domain.produto.backlogitem.BacklogItem;
import br.icc.ddd.scrum.domain.produto.backlogitem.BacklogItemRepository;

public class BacklogItemHibernateRepository extends AbstractHibernateRepository<BacklogItem> implements BacklogItemRepository {

	private static final long serialVersionUID = 1L;

	public BacklogItemHibernateRepository() {

	}

}
