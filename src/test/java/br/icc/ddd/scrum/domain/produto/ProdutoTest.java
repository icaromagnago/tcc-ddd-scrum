package br.icc.ddd.scrum.domain.produto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import br.icc.ddd.scrum.domain.ValidacaoException;
import br.icc.ddd.scrum.teste.util.TestUtils;

public class ProdutoTest {

	@Test(expected=ValidacaoException.class)
	public void falharNomeNull() {
		new Produto(null, "descricao");
	}

	@Test(expected=ValidacaoException.class)
	public void falharNomeMaiorQue50() {
		String nome = TestUtils.randomString(60);
		new Produto(nome, "descricao");
	}

	@Test(expected=ValidacaoException.class)
	public void falharDescricaoMaiorQue255() {
		String descricao = TestUtils.randomString(300);
		new Produto("Projeto 1", descricao);
	}

	@Test
	public void okDescricaoNull() {
		Produto produto = new Produto("Projeto 1", null);

		assertNotNull(produto);
		assertEquals("Projeto 1", produto.getNome());
		assertNull(produto.getDescricao());
	}
}