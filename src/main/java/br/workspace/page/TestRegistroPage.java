package br.workspace.page;

import static br.workspace.core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.workspace.core.BasePage;

public class TestRegistroPage extends BasePage{
	
	public void botaoLogar() {
		ClicarBotao(By.xpath("//a[@title='Log in to your customer account']"));
	}
	
	public void setEmail(String email) {
		Escrever("email_create", email);
	}
	
	public void botaoCriarConta() {
		ClicarBotao("SubmitCreate");
	}
	
	public void setPrimeiroNome(String nome) {
		Escrever("customer_firstname", nome);
	}
	
	public void setUltimoNome(String nome) {
		Escrever("customer_lastname", nome);
	}
	
	public void setSenha(String senha) {
		Escrever("passwd", senha);
	}
	
	public void setDataNascimento(String dia, String mes, String ano) {
		selecionarComboValue("days", dia);
		selecionarComboValue("months", mes);
		selecionarComboValue("years", ano);
	}
	
	public void setEndereco(String rua) {
		Escrever("address1", rua);
	}
	
	public void setCidade(String cidade) {
		Escrever("city", cidade);
	}
	
	public void setEstado(String estado) {
		selecionarCombo("id_state", estado);
	}
	
	public void setZipCode(String code) {
		Escrever("postcode", code);
	}
	
	public void setTelefone(String numero) {
		Escrever("phone_mobile", numero);
	}
	
	public void registar() {
		ClicarBotao("submitAccount");
	}
	
	public String validacaoRegistro() {
		return ObterTexto(By.xpath("//*[@id='center_column']/h1"));
	}
	
	public String mensagemError() {
		return obterMensagemFalha();
	}
	
	public List<String> obterErros() {
		List<WebElement> erros = getDriver().findElements(By.xpath("//*[@id='center_column']/div/ol/li"));
		List<String> retorno = new ArrayList<String>();
		for(WebElement erro:erros) {
			retorno.add(erro.getText());
		}
		return retorno;
	}
}