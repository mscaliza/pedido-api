CREATE TABLE lanche_ingrediente
(
    id SERIAL PRIMARY KEY,
    lanche_id integer,
    ingrediente_id integer,
    CONSTRAINT lanche_fk
          FOREIGN KEY(lanche_id)
    	  REFERENCES lanche(id),
    CONSTRAINT ingrediente_fk
              FOREIGN KEY(ingrediente_id)
        	  REFERENCES ingrediente(id)
)