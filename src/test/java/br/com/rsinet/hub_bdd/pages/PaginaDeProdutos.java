package br.com.rsinet.hub_bdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PaginaDeProdutos {
	final WebDriver driver;
	public static WebElement element;

	public PaginaDeProdutos(WebDriver driver) {
		this.driver = null;
		PageFactory.initElements(driver, PaginaInicial.class);
	}

	public void clicaNoProduto(String modeloDesejado) {
		driver.findElement(By.partialLinkText(modeloDesejado)).click();
	}
}
