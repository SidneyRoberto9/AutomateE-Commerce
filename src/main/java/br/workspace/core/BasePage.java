package br.workspace.core;

import static br.workspace.core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	
	// ----------------------------------------------- TextArea
	
	public void Escrever(By by, String texto) {
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(texto);
		
	}
	public void Escrever(String id_campo, String texto) {
		Escrever(By.id(id_campo), texto);
	}
	
	public String ObterTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public String ObterTexto(String id_campo) {
		return ObterTexto(By.id(id_campo));
	}
	
	// ----------------------------------------------- ButtonArea
	
	public void ClicarBotao(By by) {
		getDriver().findElement(by).click();
	}
	public void ClicarBotao(String id_campo) {
		ClicarBotao(By.id(id_campo));
	}

	// ----------------------------------------------- ComboArea
	
	public void selecionarCombo(By by, String valor) {
		WebElement element = getDriver().findElement(by);
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}
	
	public void selecionarCombo(String id_campo, String valor) {
		selecionarCombo(By.id(id_campo), valor);
	}

	
	public void selecionarComboValue(By by, String valor) {
		WebElement element = getDriver().findElement(by);
		Select combo = new Select(element);
		combo.selectByValue(valor);
	}
	
	public void selecionarComboValue(String id_campo, String valor) {
		selecionarComboValue(By.id(id_campo), valor);
	}
	
	
	public List<String> ObterValoresCombo(String id_campo){
		WebElement element = getDriver().findElement(By.id(id_campo));
		Select combo = new Select(element);
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		List<String> valores = new ArrayList<String>();
		for(WebElement opcao: allSelectedOptions) {
			valores.add(opcao.getText());
		}
		return valores;
	}
	
	public int obterQuantidadeOpcoesCombo(String id_campo){
		WebElement element = getDriver().findElement(By.id(id_campo));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		return options.size();
	}
	
	// ----------------------------------------------- AlerttArea
	
	public String obterMensagemSucesso() {
		return ObterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public String obterMensagemFalha() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return ObterTexto(By.xpath("//*[@class='alert alert-danger']"));
	}
	
	public void irPagina(String pagina) {
		getDriver().navigate().to(pagina);
	}
}
