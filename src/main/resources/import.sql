INSERT INTO tb_usuario (id, nome, data_nascimento, email, senha) VALUES (1, 'Carlos Castro', '1985-10-10', 'carlos@gmail.com', '123456');
INSERT INTO tb_usuario (id, nome, data_nascimento, email, senha) VALUES (2, 'João Silva', '1990-01-15', 'joao@gmail.com', '123456');
INSERT INTO tb_usuario (id, nome, data_nascimento, email, senha) VALUES (3, 'Maria Oliveira', '1995-03-20', 'maria@gmail.com', '123456');

INSERT INTO tb_role (perfil) VALUES ('ROLE_ADMIN');
INSERT INTO tb_role (perfil) VALUES ('ROLE_CLIENT');

INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (1, 1);
INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (2, 2);
INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (3, 2);

INSERT INTO tb_categoria (id, nome) VALUES (1, 'Camisetas Personalizadas');

INSERT INTO tb_endereco (cep, bairro, estado, cidade, numero, comprimento, usuario_id) VALUES ('1234-5678', 'Centro', 'São Paulo', 'SP', 123, 'Apto', 1);
INSERT INTO tb_endereco (cep, bairro, estado, cidade, numero, comprimento, usuario_id) VALUES ('3456-8794', 'Esperança', 'Pará', 'PA', 345, 'Casa', 2);
INSERT INTO tb_endereco (cep, bairro, estado, cidade, numero, comprimento, usuario_id) VALUES ('7894-9837', 'Fatima', 'Rio de Janeiro', 'RJ', 764, 'Apto', 3);

INSERT INTO tb_produto (nome, descricao, preco, imagem_url, disponivel) VALUES ('Camiseta de Anime', 'Camiseta com estampa de anime', 49.90, 'https://a-static.mlcdn.com.br/800x560/camiseta-camisa-personalizada-anime-classico-tokyo-ghoul-02-x000d-zahir-store/zahirstore/30587/3fc9eba2c1fe24bccf3701daed04b18e.jpeg', true);
INSERT INTO tb_produto (nome, descricao, preco, imagem_url, disponivel) VALUES ('Camiseta de Série', 'Camiseta inspirada em série famosa', 59.90, 'https://a-static.mlcdn.com.br/800x560/camiseta-camisa-personalizada-series-the-walking-dead-2-x000d-zahir-store/zahirstore/70076/fd9b38182a28bd3c6bf30e8f427d6c58.jpeg', true);
INSERT INTO tb_produto (nome, descricao, preco, imagem_url, disponivel) VALUES ('Camiseta Geek', 'Camiseta com estampa geek', 39.90, 'https://cdn.awsli.com.br/600x700/186/186813/produto/13617375/3c4fbe6313.jpg', true);

INSERT INTO tb_pedido (data_compra, status, usuario_id, endereco_entrega_id) VALUES (TIMESTAMP WITH TIME ZONE '2025-07-03T13:00:00Z', 1, 1, 1);
INSERT INTO tb_pedido (data_compra, status, usuario_id, endereco_entrega_id) VALUES (TIMESTAMP WITH TIME ZONE '2025-07-03T13:00:00Z', 0, 2, 2);
INSERT INTO tb_pedido (data_compra, status, usuario_id, endereco_entrega_id) VALUES (TIMESTAMP WITH TIME ZONE '2025-07-03T13:00:00Z', 2, 3, 3);

INSERT INTO tb_item_pedido (quantidade, preco_unitario, pedido_id, produto_id) VALUES (1, 49.90, 1, 1);
INSERT INTO tb_item_pedido (quantidade, preco_unitario, pedido_id, produto_id) VALUES (3, 59.90, 2, 2);
INSERT INTO tb_item_pedido (quantidade, preco_unitario, pedido_id, produto_id) VALUES (1, 39.90, 1, 3);

INSERT INTO tb_avaliacao (nota, comentario, data_avaliacao, produto_id, usuario_id) VALUES (5.0, 'Produto excelente!', TIMESTAMP WITH TIME ZONE '2025-07-03T13:00:00Z', 1, 2);
INSERT INTO tb_avaliacao (nota, comentario, data_avaliacao, produto_id, usuario_id) VALUES (3.5, 'Produto de baixa qualidade!', TIMESTAMP WITH TIME ZONE '2025-07-03T13:00:00Z', 3, 3);

INSERT INTO tb_produto_avaliacao (avaliacao_id, produto_id) VALUES (1, 1);
INSERT INTO tb_produto_avaliacao (avaliacao_id, produto_id) VALUES (2, 3);

INSERT INTO tb_produto_categoria (categoria_id, produto_id) VALUES (1, 1);
INSERT INTO tb_produto_categoria (categoria_id, produto_id) VALUES (1, 2);
INSERT INTO tb_produto_categoria (categoria_id, produto_id) VALUES (1, 3);