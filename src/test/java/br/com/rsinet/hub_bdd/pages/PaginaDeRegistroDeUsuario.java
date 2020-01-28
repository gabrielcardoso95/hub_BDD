package br.com.rsinet.hub_bdd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PaginaDeRegistroDeUsuario {

	final WebDriver driver;

	public PaginaDeRegistroDeUsuario(WebDriver driver) {
		this.driver = null;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"formCover\"]/div[1]/div[2]/sec-view[1]/div/label")
	WebElement mensagemSenhaInvalida;

	@FindBy(how = How.NAME, using = "usernameRegisterPage")
	WebElement userName;
	
	@FindBy(how = How.NAME, using = "emailRegisterPage")
	WebElement userEmail;

	@FindBy(how = How.NAME, using = "passwordRegisterPage")
	WebElement userPassword;
	
	@FindBy(how = How.NAME, using = "confirm_passwordRegisterPage")
	WebElement confirmUserPassword;

	@FindBy(how = How.NAME, using = "first_nameRegisterPage")
	WebElement firstName;

	@FindBy(how = How.NAME, using = "last_nameRegisterPage")
	WebElement lastName;

	@FindBy(how = How.NAME, using = "phone_numberRegisterPage")
	WebElement phoneNumber;

	@FindBy(how = How.NAME, using = "countryListboxRegisterPage")
	WebElement countryListbox;
	
	@FindBy(how = How.NAME, using = "cityRegisterPage")
	WebElement city;
	
	@FindBy(how = How.NAME, using = "addressRegisterPage")
	WebElement adress;
	
	@FindBy(how = How.NAME, using = "state_/_province_/_regionRegisterPage")
	WebElement stateProvinceRegion;

	@FindBy(how = How.NAME, using = "i_agree")
	WebElement iAgree;
	
	@FindBy(how = How.ID, using = "register_btnundefined")
	WebElement registerButton;
	
	@FindBy(how = How.NAME, using = "postal_codeRegisterPage")
	WebElement postalCode;
	
	public void preenche_emailDeUsuário(String emailDeUsuario) {
		userEmail.sendKeys(emailDeUsuario);
	}
	
	public void preenche_senhaDeUsuário(String senhaDeUsuario) {
		userPassword.sendKeys(senhaDeUsuario);
	}
	
	public void confirma_senhaDeUsuário(String senhaDeUsuario) {
		confirmUserPassword.sendKeys(senhaDeUsuario);
	}
	
	public void seleciona_país(String país) {
		Select drpCountry = new Select(countryListbox);
		drpCountry.selectByVisibleText(país);
	}
	
	public void preenche_primeiroNome(String primeiroNome) {
		firstName.sendKeys(primeiroNome);
	}
	
	public void preenche_sobrenome(String sobreNome) {
		lastName.sendKeys(sobreNome);
	}
	
	public void preenche_numeroTelefonico(String numeroTelefonico) {
		phoneNumber.sendKeys(numeroTelefonico);
	}
	
	public void preenche_cidade(String cidade) {
		city.sendKeys(cidade);
	}
	
	public void preenche_unidadeFederal(String unidadeFederal) {
		stateProvinceRegion.sendKeys(unidadeFederal);
	}
	
	public void preenche_endereço(String endereço) {
		adress.sendKeys(endereço);
	}

	public void preenche_caixaPostal(String caixaPostal) {
		postalCode.sendKeys(caixaPostal);
	}
	
	public void checa_concordoComOsTermos() {
		iAgree.click();
	}

	public void registra_novoUsuário() {
		registerButton.click();
	}
	
	public void preenche_nomeDeUsuário(String nomeDeUsuario) {
		userName.sendKeys(nomeDeUsuario);
	}
}
