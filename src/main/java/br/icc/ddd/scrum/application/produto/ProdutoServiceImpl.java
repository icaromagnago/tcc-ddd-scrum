package br.icc.ddd.scrum.application.produto;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import br.icc.ddd.scrum.domain.ValidacaoException;
import br.icc.ddd.scrum.domain.produto.Produto;
import br.icc.ddd.scrum.domain.produto.ProdutoRepository;

@Stateless
public class ProdutoServiceImpl implements ProdutoService {

	private static final long serialVersionUID = 1L;

	@Inject @Named("produtoHibernateRepository")
	private ProdutoRepository produtoRepository;


	/**
	 * Cria um novo produto
	 * @param produto
	 * @return id do novo produto criado
	 * @throws ValidacaoException
	 */
	@Override
	public Long novoProduto(Produto produto) {
		validarEntidade(produto);
		Produto novoProduto = produtoRepository.incluir(produto);

		return novoProduto.getId();
	}

	/**
	 * Altera informações de um produto existente
	 * @param produto produto a ser atualizado
	 * @throws ValidacaoException, {@link IllegalArgumentException}
	 */
	@Override
	public void alterarProduto(Produto produto) {
		validarEntidade(produto);
		if(produto.getId() == null) {
			throw new IllegalArgumentException("Produto inexistente");
		}

		produtoRepository.atualizar(produto);
	}
}
