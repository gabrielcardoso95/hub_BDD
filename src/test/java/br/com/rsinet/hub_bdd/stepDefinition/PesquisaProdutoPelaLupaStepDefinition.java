package br.com.rsinet.hub_bdd.stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_bdd.pages.PaginaInicial;
import br.com.rsinet.hub_bdd.utilities.DriverFactory;
import br.com.rsinet.hub_bdd.utilities.Screenshot;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class PesquisaProdutoPelaLupaStepDefinition {
	WebDriver driver;
	
	@Dado("^que usuário está na tela de barra de pesquisa$")
	public void que_usuário_está_na_tela_de_barra_de_pesquisa() throws Throwable {
		driver = new DriverFactory().iniciaNavegador("chrome", "https://www.advantageonlineshopping.com/#/");
	}

	@Quando("^clica no ícone de lupa e pesquisa por \"([^\"]*)\" e clica no produto$")
	public void clica_no_ícone_de_lupa_e_pesquisa_por_e_clica_no_produto(String produto) throws Throwable {
	    PaginaInicial paginaInicial = new PaginaInicial(driver);
	    paginaInicial.clica_menuDeBusca();
	    paginaInicial.preenche_barraDePesquisa(produto);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"output\"]/div/div[2]/a[2]")));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", driver.findElement(By.xpath("//*[@id=\"output\"]/div/div[2]/a[2]/p")));
	}

	@Então("^as especificaçoes do produto aparecem na tela$")
	public void as_especificaçoes_do_produto_aparecem_na_tela() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Description\"]/h1")));
	    Assert.assertTrue(driver.getPageSource().contains("PRODUCT SPECIFICATIONS"));
	    Screenshot.getScreenShot(driver, "Screenshot");
	    DriverFactory.encerraNavegador();
	}
	
	@Quando("^clica no ícone de lupa e pesquisa por \"([^\"]*)\" e pressiona Enter$")
	public void clica_no_ícone_de_lupa_e_pesquisa_por_e_pressiona_Enter(String produtoInvalido) throws Throwable {
		PaginaInicial homePage = new PaginaInicial(driver);
	    homePage.clica_menuDeBusca();
	    homePage.preenche_barraDePesquisa(produtoInvalido + Keys.ENTER);
	}

	@Então("^mensagem produto não encontrado aparece na tela\\.$")
	public void mensagem_produto_não_encontrado_aparece_na_tela() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"searchPage\"]/div[3]/div/label/span")));
		Assert.assertTrue(driver.getPageSource().contains("No results for"));
		Screenshot.getScreenShot(driver, "Screenshot");
		DriverFactory.encerraNavegador();
	}
}
