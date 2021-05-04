CREATE TABLE pedido_item_promocao
(
    id SERIAL PRIMARY KEY,
    pedido_item_id integer NOT NULL,
    promocao_id integer NOT NULL,
    CONSTRAINT pedido_item_fk
          FOREIGN KEY(pedido_item_id)
    	  REFERENCES pedido_item(id),

    	  CONSTRAINT promocao_fk
                    FOREIGN KEY(promocao_id)
              	  REFERENCES promocao(id)
)