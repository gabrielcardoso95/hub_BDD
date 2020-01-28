package br.com.rsinet.hub_bdd.stepDefinition;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_bdd.pages.PaginaDeRegistroDeUsuario;
import br.com.rsinet.hub_bdd.pages.PaginaInicial;
import br.com.rsinet.hub_bdd.utilities.DriverFactory;
import br.com.rsinet.hub_bdd.utilities.Screenshot;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class CadastraUsuarioStepDefinition {
	WebDriver driver;
	PaginaInicial paginaInicial;
	
	@Dado("^que usuário está na página inicial$")
	public void que_usuário_está_na_página_inicial() throws Throwable {
		driver = new DriverFactory().iniciaNavegador("chrome", "https://www.advantageonlineshopping.com/#/");
	}

	@Quando("^seleciona no menu de usuário a opção de criar nova conta$")
	public void seleciona_no_menu_de_usuário_a_opção_de_criar_nova_conta() throws Throwable {
		paginaInicial = new PaginaInicial(driver);
		paginaInicial.clica_menuDeUsuario();
		paginaInicial.clica_criarNovaConta();
	}

	@Quando("^preenche o formulário com informações válidas$")
	public void preenche_o_formulário_com_informações_válidas(List<Credenciais> credenciaisdeusuario) throws Throwable {
		PaginaDeRegistroDeUsuario r = new PaginaDeRegistroDeUsuario(driver);
		for (Credenciais credenciais : credenciaisdeusuario) {
			r.preenche_nomeDeUsuário(credenciais.getUserName());
			r.preenche_emailDeUsuário(credenciais.getEmail());
			r.preenche_senhaDeUsuário(credenciais.getPassword());
			r.confirma_senhaDeUsuário(credenciais.getPassword());
			r.preenche_primeiroNome(credenciais.getFirstName());
			r.preenche_sobrenome(credenciais.getLastName());
			r.preenche_numeroTelefonico(credenciais.getPhoneNumber());
			r.seleciona_país(credenciais.getCountry());
			r.preenche_cidade(credenciais.getCity());
			r.preenche_endereço(credenciais.getAddress());
			r.preenche_unidadeFederal(credenciais.getStateProvinceRegion());
			r.preenche_caixaPostal(credenciais.getPostalCode());
		}
		r.checa_concordoComOsTermos();
		r.registra_novoUsuário();
	}

	@Então("^volta para a página inicial com o novo usuário logado$")
	public void volta_para_a_página_inicial_com_o_novo_usuário_logado() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menuUserLink\"]/span")));
		Assert.assertTrue(driver.getPageSource().contains("GabrielTest"));
		Screenshot.getScreenShot(driver, "Screenshot");
		DriverFactory.encerraNavegador();
	}

	@Quando("^no campo de senha insere \"([^\"]*)\"$")
	public void no_campo_de_senha_insere(String senhaInvalida) throws Throwable {
		PaginaDeRegistroDeUsuario registerPage = new PaginaDeRegistroDeUsuario(driver);
		registerPage.preenche_senhaDeUsuário(senhaInvalida + Keys.TAB);
	}

	@Então("^recebe a mensagem de senha inválida$")
	public void recebe_a_mensagem_de_senha_inválida() throws Throwable {
		Assert.assertTrue(driver.getPageSource().contains("One upper letter required"));
		Screenshot.getScreenShot(driver, "MensagemDeSenhaInvalida");
		Screenshot.getScreenShot(driver, "Screenshot");
		DriverFactory.encerraNavegador();
	}
}
