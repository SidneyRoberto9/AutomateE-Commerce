package br.workspace.page;

import org.openqa.selenium.By;

import br.workspace.core.BasePage;

public class TestProcurarProdutoPage extends BasePage{
	
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
	
	public String nomeProdutoShirts() {
		return ObterTexto(By.xpath("//*[@id='center_column']/ul/li/div//h5/a"));
	}
	
	public void pesquisar() {
		Escrever("search_query_top", nomeProdutoShirts());
		ClicarBotao(By.xpath("//*[@id='searchbox']/button"));
	}

}
