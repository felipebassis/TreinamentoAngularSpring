insert into clientedto (id,nome) values (1,'Eletrônicos Eletro');
insert into clientedto (id,nome) values (2,'Smart Compras');

insert into produtodto (id,nome,valor) values(1,'PC',1000.00)
insert into produtodto (id,nome,valor) values (2,'Mouse',100.00);

insert into vendadto (id, clientedto_id, frete, total, cadastro) values (1,1,15.0,2965.0,sysdate());

insert into itemdto (id, vendadto_id, produtodto_id, quantidade) values (1,1,1,1)