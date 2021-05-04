ALTER TABLE pedido_item ADD COLUMN valor_unitario numeric(10,2);
ALTER TABLE pedido_item ADD COLUMN qtde_promocional numeric(10);
ALTER TABLE pedido_item ADD COLUMN percentual_desconto_promocional numeric(10,2);
ALTER TABLE pedido_item ADD COLUMN valor_final numeric(10,2);