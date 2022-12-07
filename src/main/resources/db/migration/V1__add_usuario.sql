--  1 - Cliente Varejista, 2 - Cliente Atacadista, 3 - Vendedor, 4 - Gerente, 0 - Outros

-- VENDEDOR 1  
INSERT INTO tb_pessoa VALUES (1, '12/12/1958', 'F', 'MARIA JOANA - VENDEDOR', 'ativo', '3133194444', 3);
INSERT INTO tb_endereco (id, bairro, cep, cidade, complemento, estado, logradouro, numero, pais, referencia, pessoa_id) VALUES (1, 'CORAÇÃO EUCARISTICO', '30535901', 'Belo Horizonte', null, 'MG', 'Rua Dom José Gaspar', '500', 'Brasil', null, 1);

INSERT INTO tb_pessoa VALUES (2, '12/12/1958', 'F', 'VANIA MELO - GERENTE', 'ativo', '3133194444', 4);
INSERT INTO tb_endereco (id, bairro, cep, cidade, complemento, estado, logradouro, numero, pais, referencia, pessoa_id) VALUES (2, 'CORAÇÃO EUCARISTICO', '30535901', 'Belo Horizonte', null, 'MG', 'Rua Dom José Gaspar', '501', 'Brasil', null, 2);

INSERT INTO tb_pessoa VALUES (3, '12/12/1958', 'F', 'JULIA - VAREJISTA', 'ativo', '3133194444', 1);
INSERT INTO tb_endereco (id, bairro, cep, cidade, complemento, estado, logradouro, numero, pais, referencia, pessoa_id) VALUES (3, 'CORAÇÃO EUCARISTICO', '30535901', 'Belo Horizonte', null, 'MG', 'Rua Dom José Gaspar', '502', 'Brasil', null, 3);

INSERT INTO tb_pessoa VALUES (4, '12/12/1958', 'F', 'CATARINA - ATACADISTA', 'ativo', '3133194444', 2);
INSERT INTO tb_endereco (id, bairro, cep, cidade, complemento, estado, logradouro, numero, pais, referencia, pessoa_id) VALUES (4, 'CORAÇÃO EUCARISTICO', '30535901', 'Belo Horizonte', null, 'MG', 'Rua Dom José Gaspar', '503', 'Brasil', null, 4);


--Carga incial.
INSERT INTO tb_tipo_pagamento (id, cod_tipo_pagamento, tipo_pagamento) VALUES (1, '01', 'dinheiro');
INSERT INTO tb_tipo_pagamento (id, cod_tipo_pagamento, tipo_pagamento) VALUES (2, '02', 'pix');
INSERT INTO tb_tipo_pagamento (id, cod_tipo_pagamento, tipo_pagamento) VALUES (3, '03', 'debito');
INSERT INTO tb_tipo_pagamento (id, cod_tipo_pagamento, tipo_pagamento) VALUES (4, '04', 'credito');
INSERT INTO tb_tipo_pagamento (id, cod_tipo_pagamento, tipo_pagamento) VALUES (5, '05', 'outros');


-- Carga produto.
insert into tb_produto(id, codigo_produto, codigo_barras_antigo, codigo_barras_atual, data_alteracao_valor_venda, data_cadastro, descricao, qr_code, quantidade, tipo_produto, valor_custo, valor_venda) 
    values (1, 'BB123123', '11111111111111', '11111111111110', '01/12/2022', '01/12/2022', 'Brinco 1', 'Qr Brinco 1', 10, 0, 15.00, 35.90);
    
insert into tb_produto(id, codigo_produto, codigo_barras_antigo, codigo_barras_atual, data_alteracao_valor_venda, data_cadastro, descricao, qr_code, quantidade, tipo_produto, valor_custo, valor_venda) 
    values (2, 'CC123123', '12222222222222', '22222222222220', '01/12/2022', '01/12/2022', 'Colar 2', 'Qr Colar 2', 10, 3,50.25, 125.60);

insert into tb_produto(id, codigo_produto, codigo_barras_antigo, codigo_barras_atual, data_alteracao_valor_venda, data_cadastro, descricao, qr_code, quantidade, tipo_produto, valor_custo, valor_venda) 
    values (3, 'PP123123', '13333333333333', '33333333333330', '01/12/2022', '01/12/2022', 'Pulseira 3', 'Pulseira 3', 10, 4, 18.45, 67.90);
    
insert into tb_produto(id, codigo_produto, codigo_barras_antigo, codigo_barras_atual, data_alteracao_valor_venda, data_cadastro, descricao, qr_code, quantidade, tipo_produto, valor_custo, valor_venda) 
    values (4, 'PI123123', '14444444444444', '44444444444440', '01/12/2022', '01/12/2022', 'Pingente 4', 'Qr Pingente 4', 10, 6, 78.00, 252.65);
    
insert into tb_produto(id, codigo_produto, codigo_barras_antigo, codigo_barras_atual, data_alteracao_valor_venda, data_cadastro, descricao, qr_code, quantidade, tipo_produto, valor_custo, valor_venda) 
    values (5, 'AN123123', '15555555555555', '55555555555550', '01/12/2022', '01/12/2022', 'Anel 5', 'Qr Anel 5', 10, 0, 12.36, 29.90);
    
insert into tb_produto(id, codigo_produto, codigo_barras_antigo, codigo_barras_atual, data_alteracao_valor_venda, data_cadastro, descricao, qr_code, quantidade, tipo_produto, valor_custo, valor_venda) 
    values (6, 'AL123123', '16666666666666', '66666666666660', '01/12/2022', '01/12/2022', 'Aliança 6', 'Qr Aliança 6', 2, 2, 2300.60, 4300.50);    
