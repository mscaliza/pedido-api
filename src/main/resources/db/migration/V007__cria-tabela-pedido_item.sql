CREATE TABLE pedido_item
(
    id SERIAL PRIMARY KEY,
    pedido_id integer NOT NULL,
	lanche_id integer NOT NULL,
    ingrediente_id integer NOT NULL,
    valor numeric(10,2),
    CONSTRAINT pedido_fk
          FOREIGN KEY(pedido_id)
    	  REFERENCES pedido(id),
    CONSTRAINT lanche_fk
              FOREIGN KEY(lanche_id)
        	  REFERENCES lanche(id),
    CONSTRAINT ingrediente_fk
                  FOREIGN KEY(ingrediente_id)
            	  REFERENCES ingrediente(id)
)