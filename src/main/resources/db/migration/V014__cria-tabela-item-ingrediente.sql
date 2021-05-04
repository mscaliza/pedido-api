CREATE TABLE item_ingrediente
(
    id integer NOT NULL PRIMARY KEY,
    pedido_item_id integer NOT NULL,
    descricao varchar(80) NULL,
    quantidade integer null,
    valor numeric(10,2) NULL,
    CONSTRAINT pedido_item_fk
          FOREIGN KEY(pedido_item_id)
    	  REFERENCES pedido_item(id)
)