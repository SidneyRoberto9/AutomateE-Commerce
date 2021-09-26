package br.ce.workspace.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.workspace.core.BaseTest;
import br.ce.workspace.pages.TestProcurarProdutoPage;

public class TestProcurarProduto extends BaseTest {
	
	private TestProcurarProdutoPage page = new TestProcurarProdutoPage();
	
	@Test
	public void pesquisaProduto() {
		page.logar("contaRegistrada@yopmail.com","12345");
		page.categoriaCamisetasfemininas();
		page.pesquisar();
		
		Assert.assertEquals("Faded Short Sleeve T-shirts", page.nomeProdutoShirts());
	}

}
