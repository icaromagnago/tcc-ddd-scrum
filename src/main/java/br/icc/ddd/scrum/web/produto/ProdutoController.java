package br.icc.ddd.scrum.web.produto;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import br.icc.ddd.scrum.application.produto.ProdutoService;
import br.icc.ddd.scrum.domain.produto.Produto;
import br.icc.ddd.scrum.domain.produto.ProdutoRepository;
import br.icc.ddd.scrum.web.BaseController;

@Named
@ViewScoped
public class ProdutoController extends BaseController {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProdutoService produtoService;

	@Inject
	private ProdutoRepository produtoRepository;

	private Produto produto;

	@PostConstruct
	public void postConstruct() {
		produto = new Produto();
	}

	public void criar() {
		produtoService.novoProduto(produto);
		addInfoMessageToFacesContext("O produto foi criado com sucesso", null);
		redirect("/produto/listar.xhtml", null);
	}

	public List<Produto> listarTodosOsProdutos() {
		return produtoRepository.obterTodos();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
