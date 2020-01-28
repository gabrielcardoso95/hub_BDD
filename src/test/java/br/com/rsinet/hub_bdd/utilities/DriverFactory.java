package br.com.rsinet.hub_bdd.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
	static WebDriver driver;
	
	public WebDriver iniciaNavegador(String nomeDoNavegador, String url) {
		if(nomeDoNavegador.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if(nomeDoNavegador.equals("chrome")){
			driver = new ChromeDriver(); 			
		} else if(nomeDoNavegador.equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		
		return driver;
	}
	
	public static void encerraNavegador() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
	public WebDriver getDriver() {
		return driver;
	}
}
