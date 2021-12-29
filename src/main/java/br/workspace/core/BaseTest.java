package br.workspace.core;

import static br.workspace.core.DriverFactory.getDriver;
import static br.workspace.core.DriverFactory.killDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;

public class BaseTest {
	
	@Before
	public void inicializar() {
		getDriver().get("http://automationpractice.com/index.php");
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@After
	public void finalizar() throws IOException {
		
		if(Propriedades.FECHAR_BROWSER) {
			killDriver();
		}
	}

}
