ALTER TABLE pedido_item ADD COLUMN promocao_id integer;
ALTER TABLE pedido_item ADD CONSTRAINT promocao_fk FOREIGN KEY(promocao_id) REFERENCES promocao(id);