#language: pt
	Funcionalidade: Deve consultar um produto a partir da tela inicial
	
	@PesquisaProdutoPeloMenuComSucesso
	Cenário: Pesquisa produto
		Dado que usuário está na tela de pesquisa
		Quando clica no menu de speakers
		E clica no produto "HP Roar Mini"
		Então visualiza as especificações do produto na tela
		
	@PesquisaProdutoInexistentePeloMenu
	Cenário: Produto inexistente
		Dado que usuário está na tela de pesquisa
		Quando clica no link View Details do HP elitebook folio
		Então visualiza as especificações de um produto diferente do consultado
		