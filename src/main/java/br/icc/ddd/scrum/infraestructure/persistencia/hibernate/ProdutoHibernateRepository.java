package br.icc.ddd.scrum.infraestructure.persistencia.hibernate;

import javax.inject.Named;

import br.icc.ddd.scrum.domain.produto.Produto;
import br.icc.ddd.scrum.domain.produto.ProdutoRepository;

@Named
public class ProdutoHibernateRepository extends AbstractHibernateRepository<Produto> implements ProdutoRepository {

	private static final long serialVersionUID = 1L;

	@Override
	public Produto incluir(Produto produto) {
		em.persist(produto);
		em.flush();

		return produto;
	}
}
