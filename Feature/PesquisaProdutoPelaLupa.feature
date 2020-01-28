#language: pt
Funcionalidade: Pesquisa produtos pela barra de pesquisa

@PesquisaProdutoPelaLupaComSucesso
Cenário: Pesquisa produto com sucesso
	Dado que usuário está na tela de barra de pesquisa
	Quando clica no ícone de lupa e pesquisa por "hp usb 3 button" e clica no produto
	Então as especificaçoes do produto aparecem na tela

@PesquisaProdutoInexistente
Cenário: Pesquisa produto não existente
	Dado que usuário está na tela de barra de pesquisa
	Quando clica no ícone de lupa e pesquisa por "produto inválido" e pressiona Enter
	Então mensagem produto não encontrado aparece na tela.