package br.ce.workspace.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.workspace.core.BaseTest;
import br.ce.workspace.pages.TestComprarProdutoPage;

public class TestComprarProduto extends BaseTest{
	
	private TestComprarProdutoPage page = new TestComprarProdutoPage();
	
	@Test
	public void fazerCompra() {		
		page.logar("contaRegistrada@yopmail.com","12345");
		page.categoriaCamisetasfemininas();
		page.clicarMore();
		page.menuProduto("2", "L", "Blue");
		page.adicionarCarrinho();
		page.finalizarCompra();
		
		page.finalizarPagamento();
		page.finalizarLocalEnvio();
		page.finalizarTransporte();
		page.formaPagamento();
		page.finalizarTudo();
		
		Assert.assertEquals("Your order on My Store is complete.", page.validacaoCompra());
	}
	
	@Test
	public void adicionarFavoritos() {
		page.logar("contaRegistrada@yopmail.com","12345");
		page.categoriaCamisetasfemininas();
		page.clicarMore();
		page.adicionarFavoritos(); 
		
		Assert.assertEquals("Added to your wishlist.", page.validarFavoritos());
	}
	
	@Test
	public void precoCorreto() {
		page.logar("contaRegistrada@yopmail.com","12345");
		page.categoriaCamisetasfemininas();
		page.clicarMore();
		page.menuProduto("1", "M", "Blue");
		page.adicionarCarrinho();
		page.finalizarCompra();
		
		Assert.assertEquals("$18.51", page.precoTotal());
		
		page.quantidadeMaisUM();
		
		Assert.assertEquals("$35.02", page.precoTotal());
	}
}
