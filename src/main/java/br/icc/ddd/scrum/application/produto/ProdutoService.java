package br.icc.ddd.scrum.application.produto;

import br.icc.ddd.scrum.application.ApplicationService;
import br.icc.ddd.scrum.domain.produto.Produto;

public interface ProdutoService extends ApplicationService {
	Long novoProduto(Produto produto);
	void alterarProduto(Produto produto);
}
