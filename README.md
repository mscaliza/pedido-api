# pedido-api

Requisito de banco de dados: 

Banco PostgreSql -> "pedidodb"
Usuário e senha: "postgres"

Swagger -> http://localhost:8080/swagger-ui.html#/

A API tem por objetivo expor os lanches, ingredientes e promoções disponibilizados para montagem de pedidos de lanche.
Existem 4 tipos de lanches com ingredientes pré-definidos e também existe a possibilidade de compor um lanche do tipo "PERSONALIZADO" com os ingredientes que desejar e na quantidade que desejar.

Os lanches podem participar de 3 promoções dependendo de seu conjunto de ingredientes.

O pedido deve ser feito fornecendo uma lista de lanches, sejam do tipo NORMAL ou PERSONALIZADO.

O retorno será o número e o valor total levando em conta as promoções a que cada um se aplica.


