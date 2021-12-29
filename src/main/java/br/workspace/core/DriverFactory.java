package br.workspace.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	public static WebDriver driver;

	private DriverFactory() {
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			switch (Propriedades.BROWSER) {
				case FIREFOX -> {
					System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
					driver = new FirefoxDriver();
				}
				case CHROME -> {
					System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
					driver = new ChromeDriver();
				}
			}
		}
		return driver;
	}

	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}