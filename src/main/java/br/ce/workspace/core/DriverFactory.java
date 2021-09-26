package br.ce.workspace.core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import br.ce.workspace.core.Propriedades.TipoExecucao;

public class DriverFactory {
	
	private static ThreadLocal<WebDriver> ThreadDriver =  new ThreadLocal<WebDriver>() {
		@Override
		protected synchronized WebDriver initialValue() {
			return initDriver();
		}
	};
		
	private DriverFactory() {}
	
	public static WebDriver getDriver() {
		return ThreadDriver.get();
	}
	
	public static WebDriver initDriver() {
		WebDriver driver = null;
		
		if(Propriedades.TIPO_EXECUCAO == TipoExecucao.LOCAL) {
			switch(Propriedades.BROWSER) {
				case FIREFOX:
					System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
					driver =  new FirefoxDriver(); 
					break;
				case CHROME:
					System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
					driver =  new ChromeDriver(); 
					break;
			}
		}
		
		if(Propriedades.TIPO_EXECUCAO == TipoExecucao.GRID) {
			DesiredCapabilities cap = null;
			switch (Propriedades.BROWSER) {
				case FIREFOX:
					System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
					cap =  DesiredCapabilities.firefox(); break;
				case CHROME:
					System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
					cap = DesiredCapabilities.chrome();  break;
			}
			
			try {
				driver = new RemoteWebDriver(new URL("http://192.168.1.5:4444/wd/hub"), cap);
			} catch (MalformedURLException e) {
				System.err.println("Falha na conexão com o GRID");
				e.printStackTrace();
			}
		}
		return driver;
	}
	
	public static void killDriver() {
		WebDriver driver = getDriver(); 
		if(driver != null) {
			driver.quit();
			driver = null;
		}
		if(ThreadDriver != null) {
			ThreadDriver.remove();
		}
	}

}
