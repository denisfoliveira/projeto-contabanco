
# ContaBanco

Projeto feito para o curso de Java da Dio.me

    1) Tela inicial:
        O Terminal de Caixa Eletronico, solicitará que o cliente digite uma opção para criar sua conta ou consultar 
        seu saldo de uma conta já criada.

    1) Abertura da Conta
        - O sistema solicitará os dados para o Cliente, como Nome, Senha e o valor do primeiro depósito.
        - Os dados informados pelo Cliente são enviados para o arquivo JSON (Cliente.json). (Para simular um Banco de Dados)
        - Após o envio dos dados e a criação do arquivo json, o Cliente receberá um retorno dizendo a conta foi criada, junto 
          das informações da conta.

    3) Consulta Saldo
        - O Terminal solicitará alguns dados para o Cliente, como Agencia, Conta e Senha.
        - O sistema percorrerá o arquivo JSON e verificará se tem algum objeto em paridade com as informações 
          recebidas do Cliente.
        - Sendo positivo, ele retornará os dados da conta na tela, caso negativo, informará que os dados ou senha estão incorretos.







