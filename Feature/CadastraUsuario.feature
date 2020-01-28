#language: pt
Funcionalidade: Deve cadastrar usuário caso sejam inseridas informações válidas

@CadastraUsuarioComSucesso
Cenário: Deve cadastrar novo usuário
	Dado que usuário está na página inicial
	Quando seleciona no menu de usuário a opção de criar nova conta
	E preenche o formulário com informações válidas
	 | Username   | email |	password | firstname | lastname | phonenumber | country | city | address | stateprovinceregion | postalcode |
	   | GabrielTest122 | gabriel_cardoso1@outlook.com | Aa123 | Gabriel | Cardoso | +5511999911011 | Brazil | São Bernardo do Campo | Rua Cásper Líbero, 639 | São Paulo | 09691-200 |
	Então volta para a página inicial com o novo usuário logado

@MensagemDeSenhaInvalida	
Cenário: Deve visualizar texto de senha inválida
	Dado que usuário está na página inicial
	Quando seleciona no menu de usuário a opção de criar nova conta
	E no campo de senha insere "abc123"
	Então recebe a mensagem de senha inválida