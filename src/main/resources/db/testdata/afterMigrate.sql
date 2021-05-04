delete from item_ingrediente;
delete from pedido_item_promocao;
delete from pedido_item;
delete from pedido;
delete from restaurante;
delete from lanche_ingrediente;
delete from ingrediente;
delete from lanche;
delete from promocao;

insert into restaurante (id, nome, data_cadastro, data_atualizacao)  values (1, 'Pizzaria QTall', now(), now());
insert into restaurante (id, nome, data_cadastro, data_atualizacao)  values (2, 'Pizza & Tal', now(), now());
insert into restaurante (id, nome, data_cadastro, data_atualizacao)  values (3, 'Maria do Bimbo', now(), now());
insert into restaurante (id, nome, data_cadastro, data_atualizacao)  values (4, 'Oliveiras', now(), now());
insert into restaurante (id, nome, data_cadastro, data_atualizacao)  values (5, 'Restaurante da Estiva', now(), now());
insert into restaurante (id, nome, data_cadastro, data_atualizacao)  values (6, 'Restaurante Terra Nostra', now(), now());

INSERT INTO lanche(id, descricao, tipo)VALUES (1, 'X-Bacon', 'NORMAL');
INSERT INTO lanche(id, descricao, tipo)VALUES (2, 'X-Burguer', 'NORMAL');
INSERT INTO lanche(id, descricao, tipo)VALUES (3, 'X-Egg', 'NORMAL');
INSERT INTO lanche(id, descricao, tipo)VALUES (4, 'X-Egg Bacon', 'NORMAL');
INSERT INTO lanche(id, descricao, tipo)VALUES (5, 'Personalizado', 'PERSONALIZADO');

INSERT INTO ingrediente(id, descricao, valor) VALUES (1, 'Alface', 0.4);
INSERT INTO ingrediente(id, descricao, valor) VALUES (2, 'Bacon', 2);
INSERT INTO ingrediente(id, descricao, valor) VALUES (3, 'Hambúrguer', 3);
INSERT INTO ingrediente(id, descricao, valor) VALUES (4, 'Ovo', 0.8);
INSERT INTO ingrediente(id, descricao, valor) VALUES (5, 'Queijo', 1.5);

INSERT INTO lanche_ingrediente(lanche_id, ingrediente_id) VALUES (1,2);
INSERT INTO lanche_ingrediente(lanche_id, ingrediente_id) VALUES (1,3);
INSERT INTO lanche_ingrediente(lanche_id, ingrediente_id) VALUES (1,5);
INSERT INTO lanche_ingrediente(lanche_id, ingrediente_id) VALUES (2,3);
INSERT INTO lanche_ingrediente(lanche_id, ingrediente_id) VALUES (2,5);
INSERT INTO lanche_ingrediente(lanche_id, ingrediente_id) VALUES (3,4);
INSERT INTO lanche_ingrediente(lanche_id, ingrediente_id) VALUES (3,3);
INSERT INTO lanche_ingrediente(lanche_id, ingrediente_id) VALUES (3,5);
INSERT INTO lanche_ingrediente(lanche_id, ingrediente_id) VALUES (4,4);
INSERT INTO lanche_ingrediente(lanche_id, ingrediente_id) VALUES (4,2);
INSERT INTO lanche_ingrediente(lanche_id, ingrediente_id) VALUES (4,3);
INSERT INTO lanche_ingrediente(lanche_id, ingrediente_id) VALUES (4,5);

INSERT INTO promocao(id, descricao, ativa) VALUES (1, 'Light', true);
INSERT INTO promocao(id, descricao, ativa) VALUES (2, 'Muita carne', true);
INSERT INTO promocao(id, descricao, ativa) VALUES (3, 'Muito queijo', true);


