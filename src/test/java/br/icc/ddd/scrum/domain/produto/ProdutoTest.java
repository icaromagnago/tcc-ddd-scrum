package br.icc.ddd.scrum.domain.produto;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

import br.icc.ddd.scrum.teste.util.TestUtils;

public class ProdutoTest {
	
	private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

	@Test
	public void falharNomeNull() {
		Produto produto = new Produto(null, "descricao");
		Set<ConstraintViolation<Produto>> constraintViolations =
                validator.validate(produto);
		
		assertEquals(1, constraintViolations.size());
	}
	
	@Test
	public void falharNomeMaiorQue50() {
		String nome = TestUtils.randomString(60);
		Produto produto = new Produto(nome, "descricao");
		Set<ConstraintViolation<Produto>> constraintViolations =
                validator.validate(produto);
		
		assertEquals(1, constraintViolations.size());
	}
	
	@Test
	public void falharDescricaoMaiorQue255() {
		String descricao = TestUtils.randomString(300);
		Produto produto = new Produto("Projeto 1", descricao);
		Set<ConstraintViolation<Produto>> constraintViolations =
                validator.validate(produto);
		
		assertEquals(1, constraintViolations.size());
	}
	
	@Test
	public void okDescricaoNull() {
		Produto produto = new Produto("Projeto 1", null);
		Set<ConstraintViolation<Produto>> constraintViolations =
                validator.validate(produto);
		
		assertEquals(0, constraintViolations.size());
	}
}