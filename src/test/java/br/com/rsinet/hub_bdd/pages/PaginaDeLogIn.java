package br.com.rsinet.hub_bdd.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PaginaDeLogIn {

	final WebDriver driver;

	public PaginaDeLogIn(WebDriver driver) {
		this.driver = null;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.LINK_TEXT, using = "CREATE NEW ACCOUNT")
	WebElement criarNovaConta;

	public void clica_criarNovaConta() {
		criarNovaConta.sendKeys(Keys.ENTER);
	}

}
