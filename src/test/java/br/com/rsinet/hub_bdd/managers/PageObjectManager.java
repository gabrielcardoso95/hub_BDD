package br.com.rsinet.hub_bdd.managers;

import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_bdd.pages.PaginaDeLogIn;
import br.com.rsinet.hub_bdd.pages.PaginaDeProdutos;
import br.com.rsinet.hub_bdd.pages.PaginaDeRegistroDeUsuario;
import br.com.rsinet.hub_bdd.pages.PaginaInicial;

public class PageObjectManager {

	private WebDriver driver;
	private PaginaInicial paginaInicial;	
	private PaginaDeRegistroDeUsuario paginaDeRegistroDeUsuario;
	private PaginaDeLogIn paginaDeLogIn;
	private PaginaDeProdutos paginaDeProdutos;
	
	
	public PageObjectManager(WebDriver driver) {
		this.driver=driver;		
	}
	
	public PaginaInicial getPaginaInicial() {
		
		return (paginaInicial==null)?new PaginaInicial(driver):paginaInicial;
	}
	
	public PaginaDeRegistroDeUsuario getPaginaDeRegistroDeUsuario() {
		
		return (paginaDeRegistroDeUsuario == null) ? paginaDeRegistroDeUsuario = new PaginaDeRegistroDeUsuario(driver) : paginaDeRegistroDeUsuario; 
	}
 
	public PaginaDeLogIn getPaginaDeLogIn() {

		return (paginaDeLogIn == null) ? paginaDeLogIn = new PaginaDeLogIn(driver) : paginaDeLogIn;
 
	}
  
	public PaginaDeProdutos getPaginaDeProdutos() {
 
		return (paginaDeProdutos == null) ? paginaDeProdutos = new PaginaDeProdutos(driver) : paginaDeProdutos;
 
	}

}
