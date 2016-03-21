package br.icc.ddd.scrum.web.produto;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.omnifaces.cdi.ViewScoped;

import br.icc.ddd.scrum.application.produto.ProdutoService;
import br.icc.ddd.scrum.domain.ValidacaoException;
import br.icc.ddd.scrum.domain.equipe.Membro;
import br.icc.ddd.scrum.domain.equipe.MembroRepository;
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

	@Inject
	private MembroRepository membroRepository;

	private Produto produto;

	@PostConstruct
	public void postConstruct() {
		String id = obterParametroRequisicao("id");
		if(StringUtils.isEmpty(id)) {
			produto = new Produto();
		} else {
			produto = produtoRepository.obter(Long.valueOf(id));
		}
	}

	public void criar() {
		try {
			produtoService.novoProduto(this.produto);
			addInfoMessageToFacesContext("O produto foi criado com sucesso", null);
			redirect("/produto/listar.xhtml", null);
		} catch(ValidacaoException e) {
			//Tratar o erro de validação
		}
	}

	public void alterar() {
		try {
			produtoService.alterarProduto(this.produto);
			addInfoMessageToFacesContext("O produto foi atualizado com sucesso", null);
			redirect("/produto/listar.xhtml", null);
		} catch(ValidacaoException e) {
			//Tratar o erro de validação
		} catch(IllegalArgumentException e) {
			//Tratar erro
		}
	}

	public List<Produto> listarTodosOsProdutos() {
		return produtoRepository.obterTodos();
	}

	public List<Membro> listarTodosOsMembros() {
		return membroRepository.obterTodos();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
