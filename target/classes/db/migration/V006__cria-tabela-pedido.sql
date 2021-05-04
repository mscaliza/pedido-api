CREATE TABLE pedido
(
    id SERIAL PRIMARY KEY,
    data timestamp,
    promocao_id integer,
    valor_promocional numeric(10,2),
    CONSTRAINT promocao_fk
          FOREIGN KEY(promocao_id)
    	  REFERENCES promocao(id)
)