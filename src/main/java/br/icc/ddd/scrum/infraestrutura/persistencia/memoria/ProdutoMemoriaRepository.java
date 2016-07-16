package br.icc.ddd.scrum.infraestrutura.persistencia.memoria;

import java.util.List;

import br.icc.ddd.scrum.domain.produto.Produto;
import br.icc.ddd.scrum.domain.produto.ProdutoRepository;

import com.google.common.collect.Lists;

public class ProdutoMemoriaRepository implements ProdutoRepository {

	private static final long serialVersionUID = 1L;
	private static List<Produto> produtos = Lists.newArrayList();

	@Override
	public Produto incluir(Produto produto) {
		produtos.add(produto);

		return produto;
	}

	@Override
	public Produto obter(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void incluir(List<Produto> entidades) {
		// TODO Auto-generated method stub

	}

	@Override
	public Produto atualizar(Produto entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualizar(List<Produto> entidades) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(Produto entidade) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub

	}

}
