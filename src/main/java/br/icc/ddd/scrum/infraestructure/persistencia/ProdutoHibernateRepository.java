package br.icc.ddd.scrum.infraestructure.persistencia;

import br.icc.ddd.scrum.domain.produto.Produto;
import br.icc.ddd.scrum.domain.produto.ProdutoRepository;

public class ProdutoHibernateRepository extends AbstractHibernateRepository<Produto> implements ProdutoRepository {

	private static final long serialVersionUID = 1L;

	public ProdutoHibernateRepository() {

	}

}
