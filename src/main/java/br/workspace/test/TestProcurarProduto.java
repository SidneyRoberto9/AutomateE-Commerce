package br.workspace.test;

import org.junit.Assert;
import org.junit.Test;

import br.workspace.core.BaseTest;
import br.workspace.page.TestProcurarProdutoPage;

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
