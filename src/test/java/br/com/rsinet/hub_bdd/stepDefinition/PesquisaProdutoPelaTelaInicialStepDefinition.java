package br.com.rsinet.hub_bdd.stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_bdd.pages.PaginaInicial;
import br.com.rsinet.hub_bdd.utilities.DriverFactory;
import br.com.rsinet.hub_bdd.utilities.Screenshot;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class PesquisaProdutoPelaTelaInicialStepDefinition {
	WebDriver driver;

	@Dado("^que usuário está na tela de pesquisa$")
	public void que_usuário_está_na_tela_de_pesquisa() throws Throwable {
		driver = new DriverFactory().iniciaNavegador("chrome", "https://www.advantageonlineshopping.com/#/");
	}

	@Quando("^clica no menu de speakers$")
	public void clica_no_menu_de_speakers() throws Throwable {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", driver.findElement(By.id("speakersImg")));
	}

	@Quando("^clica no produto \"([^\"]*)\"$")
	public void clica_no_produto(String produto) throws Throwable {
		driver.findElement(By.partialLinkText(produto)).click();
	}

	@Então("^visualiza as especificações do produto na tela$")
	public void visualiza_as_especificações_do_produto_na_tela() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/section/article[2]/h2")));
		Assert.assertTrue(driver.getPageSource().contains("PRODUCT SPECIFICATIONS"));
		Screenshot.getScreenShot(driver, "Screenshot");
		DriverFactory.encerraNavegador();
	}
	
	@Quando("^clica no link View Details do HP elitebook folio$")
	public void clica_no_link_View_Details_do_HP_elitebook_folio() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"follow\"]/a[3]/img")));
	    PaginaInicial homePage = new PaginaInicial(driver);
	    homePage.clica_verDetalhesHPElitebookFolio();
	}

	@Então("^visualiza as especificações de um produto diferente do consultado$")
	public void visualiza_as_especificações_de_um_produto_diferente_do_consultado() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Description\"]/h1")));
		Assert.assertTrue(driver.getPageSource().contains("HP CHROMEBOOK 14 G1(ES)"));
		Screenshot.getScreenShot(driver, "Screenshot");
		DriverFactory.encerraNavegador();
	}
}
