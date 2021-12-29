package br.workspace.page;

import org.openqa.selenium.By;

import br.workspace.core.BasePage;

public class TestComprarProdutoPage extends BasePage{
	public void botaoLogar() {
		ClicarBotao(By.xpath("//a[@title='Log in to your customer account']"));
	}
	
	public void setEmail(String email) {
		Escrever("email", email);
	}

	public void setSenha(String senha) {
		Escrever("passwd", senha);
	}
	
	public void logar(String email, String senha) {
		botaoLogar();
		setEmail(email); 
		setSenha(senha);
		ClicarBotao("SubmitLogin");
	}
	
	public void categoriaCamisetasfemininas() {
		irPagina("http://automationpractice.com/index.php?id_category=5&controller=category");
	}
	
	public void clicarMore() { //para o primeiro produto sempre
		ClicarBotao(By.xpath("//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img"));
	}
	
	public void menuProduto(String quantidade, String tamanho, String cor) {
		Escrever("quantity_wanted", quantidade);
		selecionarCombo("group_1", tamanho);
		ClicarBotao(By.xpath("//*[@name='"+cor+"']"));
	}
	
	public void adicionarCarrinho() {
		ClicarBotao(By.xpath("//button[@name='Submit']//span"));
	}
	
	public void finalizarCompra() {
		ClicarBotao(By.xpath("//*[@title='Proceed to checkout']/span"));
	}
	
	public void finalizarPagamento() {
		ClicarBotao(By.xpath("//*[@id='center_column']//a[@title='Proceed to checkout']/span"));
	}
	
	public void finalizarLocalEnvio() {
		ClicarBotao(By.xpath("//button[@name='processAddress']//span"));
	}
	
	public void finalizarTransporte() {
		ClicarBotao("cgv");
		ClicarBotao(By.xpath("//*[@id='form']/p/button/span"));
	}
	
	public void formaPagamento() {
		ClicarBotao(By.xpath("//*[@class='bankwire']"));
	}
	
	public void finalizarTudo() {
		ClicarBotao(By.xpath("//*[@id='cart_navigation']/button"));
	}
	
	public String validacaoCompra() {
		return ObterTexto(By.xpath("//*[@id='center_column']/div/p/strong"));
	}
	
	public void adicionarFavoritos() {
		ClicarBotao("wishlist_button");
	}
	
	public String validarFavoritos() {
		return ObterTexto(By.xpath("//*[@id='product']//*[@class='fancybox-inner']/p"));
	}
	
	public void quantidadeMaisUM() {
		ClicarBotao(By.xpath("//*[@id='cart_quantity_up_1_4_0_574165']/span"));
	}
	
	public String precoTotal() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return ObterTexto("total_price");
	}
	
	
	
	
	
}
