package br.com.rsinet.hub_bdd.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PaginaInicial {
	final WebDriver driver;
	public static WebElement element;

	public PaginaInicial(WebDriver driver) {
		this.driver = null;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "details_10")
	WebElement verDetalhesHPElitebookFolio;
	
	@FindBy(how = How.ID, using = "autoComplete")
	WebElement barraDePesquisa;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"menuUserLink\"]/span")
	WebElement usuarioLogado;

	@FindBy(how = How.ID, using = "menuSearch")
	WebElement menuDeBusca;

	@FindBy(how = How.ID, using = "menuUser")
	WebElement menuDeUsuario;

	@FindBy(how = How.LINK_TEXT, using = "CREATE NEW ACCOUNT")
	WebElement criarNovaConta;

	@FindBy(how = How.ID, using = "speakersImg")
	WebElement caixasDeSom;
	
	public void clica_verDetalhesHPElitebookFolio() {
		verDetalhesHPElitebookFolio.click();
	}
	public void clica_menuDeUsuario() {
		menuDeUsuario.click();
	}

	public void clica_criarNovaConta() {
		criarNovaConta.sendKeys(Keys.ENTER);
	}

	public void clica_menuDeBusca() {
		menuDeBusca.click();
	}
	
	public void preenche_barraDePesquisa(String produto) {
		barraDePesquisa.sendKeys(produto);
	}
	
}
