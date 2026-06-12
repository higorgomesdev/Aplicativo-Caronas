-- 1. Inserir Roles (Papéis de acesso)
INSERT INTO tb_role (authority) VALUES ('ROLE_USER');
INSERT INTO tb_role (authority) VALUES ('ROLE_DRIVER');

-- Inserir Endereços (tb_address)
INSERT INTO tb_address (city, neighborhood, street, number, complement) VALUES ('Rio de Janeiro', 'Copacabana', 'Avenida Atlântica', '1500', 'Bloco B, Sala 201');
INSERT INTO tb_address (city, neighborhood, street, number, complement) VALUES ('São Paulo', 'Ferraz de vasconcelos', 'Rua joão de deus morais', '298', 'casa 2');
INSERT INTO tb_address (city, neighborhood, street, number, complement) VALUES ('Paulistana', 'sertanejo', 'travessa rio grande do sul', '380', 'esquina');
INSERT INTO tb_address (city, neighborhood, street, number, complement) VALUES ('Paulistana', 'sertanejo', 'areolino de abreu', '68', 'esquina');

INSERT INTO tb_address (city, neighborhood, street, number, complement) VALUES ('Curitiba', 'Centro', 'Rua XV de Novembro', '550', 'Sala 12');
INSERT INTO tb_address (city, neighborhood, street, number, complement) VALUES ('Belo Horizonte', 'Savassi', 'Rua Pernambuco', '1200', 'Loja 5');
INSERT INTO tb_address (city, neighborhood, street, number, complement) VALUES ('Salvador', 'Barra', 'Avenida Oceânica', '300', 'Apto 101');
INSERT INTO tb_address (city, neighborhood, street, number, complement) VALUES ('Porto Alegre', 'Moinhos de Vento', 'Rua Padre Chagas', '420', 'Cobertura');
INSERT INTO tb_address (city, neighborhood, street, number, complement) VALUES ('Fortaleza', 'Meireles', 'Avenida Beira Mar', '2500', 'Bloco A, Apto 802');
INSERT INTO tb_address (city, neighborhood, street, number, complement) VALUES ('Vitória', 'Praia do Canto', 'Rua Aleixo Neto', '95', 'Casa');
INSERT INTO tb_address (city, neighborhood, street, number, complement) VALUES ('Curitiba', 'Centro', 'Rua XV de Novembro', '550', 'Sala 12');

-- 2. Inserir Dados de Motorista (tb_driver_data)
INSERT INTO tb_driver_data (cnh, vehicle_Model, license_Plate, color, vehicle_year) VALUES ('12345678901', 'Renault fluence', 'OCH3B83', 'PRETO', '2026');
INSERT INTO tb_driver_data (cnh, vehicle_Model, license_Plate, color, vehicle_year) VALUES ('10987654321', 'BYD dolphi', 'OBJ4V97', 'BRANCO', '2026');

INSERT INTO tb_driver_data (cnh, vehicle_Model, license_Plate, color, vehicle_year) VALUES ('12345678901', 'Gol', 'OOI3B89', 'PRATA', '2026');
INSERT INTO tb_driver_data (cnh, vehicle_Model, license_Plate, color, vehicle_year) VALUES ('12345678901', 'Punto', 'AQR3B86', 'BEGE', '2026');
INSERT INTO tb_driver_data (cnh, vehicle_Model, license_Plate, color, vehicle_year) VALUES ('12345678901', 'Prisma', 'GBH3B23', 'VERMELHO', '2026');
INSERT INTO tb_driver_data (cnh, vehicle_Model, license_Plate, color, vehicle_year) VALUES ('12345678901', 'Fiat', 'MLK3B81', 'AMARELO', '2026');
INSERT INTO tb_driver_data (cnh, vehicle_Model, license_Plate, color, vehicle_year) VALUES ('12345678901', 'ferrary', 'VXZ3B85', 'MARROM', '2026');
INSERT INTO tb_driver_data (cnh, vehicle_Model, license_Plate, color, vehicle_year) VALUES ('12345678901', 'fusca', 'TER3B84', 'CINZA', '2026');


-- 3. Inserir Utilizadores (tb_user)
-- A Ana (ID 1) e o Bruno (ID 2) têm driver_id preenchido.
INSERT INTO tb_user (cpf, name, email, birth_date, phone, password, photo_url, driver_id, address_id) VALUES ('11111111111', 'Ana Silva', 'ana@gmail.com', '1990-01-01', '911111111', '$2a$10$I22XFwxtI9zDckzkmPgZ.ufRRicP31Q.7tAiRiodGvnwU2/bloUvS', 'https://picsum.photos/id/1011/600/400', 1, 1);
INSERT INTO tb_user (cpf, name, email, birth_date, phone, password, photo_url, driver_id, address_id) VALUES ('22222222222', 'Bruno Costa', 'bruno@gmail.com', '1985-05-15', '922222222', '$2a$10$I22XFwxtI9zDckzkmPgZ.ufRRicP31Q.7tAiRiodGvnwU2/bloUvS', 'https://picsum.photos/id/1011/600/400', 2, 2);

-- O Carlos (ID 3), a Diana (ID 4) e o Eduardo (ID 5) são apenas passageiros (driver_id é NULL)
INSERT INTO tb_user (cpf, name, email, birth_date, phone, password, photo_url, driver_id, address_id) VALUES ('33333333333', 'Carlos Dias', 'carlos@gmail.com', '1992-08-20', '933333333', '$2a$10$I22XFwxtI9zDckzkmPgZ.ufRRicP31Q.7tAiRiodGvnwU2/bloUvS', 'https://picsum.photos/id/1011/600/400', NULL, 3);
INSERT INTO tb_user (cpf, name, email, birth_date, phone, password, photo_url, driver_id, address_id) VALUES ('44444444444', 'Diana Faria', 'diana@gmail.com', '1998-12-10', '944444444', '$2a$10$I22XFwxtI9zDckzkmPgZ.ufRRicP31Q.7tAiRiodGvnwU2/bloUvS', 'https://picsum.photos/id/1011/600/400', NULL, 4);
INSERT INTO tb_user (cpf, name, email, birth_date, phone, password, photo_url, driver_id, address_id) VALUES ('55555555555', 'Eduardo Gomes', 'eduardo@gmail.com', '2000-03-30', '955555555', '$2a$10$I22XFwxtI9zDckzkmPgZ.ufRRicP31Q.7tAiRiodGvnwU2/bloUvS', 'https://picsum.photos/id/1011/600/400', NULL, 5);

--inseridos depois para mais testes
INSERT INTO tb_user (cpf, name, email, birth_date, phone, password, photo_url, driver_id, address_id) VALUES ('11111111111', 'Higor Gomes', 'higor@gmail.com', '1990-01-01', '911111111', '$2a$10$I22XFwxtI9zDckzkmPgZ.ufRRicP31Q.7tAiRiodGvnwU2/bloUvS', 'https://picsum.photos/id/1011/600/400', 3, 6);
INSERT INTO tb_user (cpf, name, email, birth_date, phone, password, photo_url, driver_id, address_id) VALUES ('11111111111', 'Jennifer Yasmin', 'jennifer@gmail.com', '1990-01-01', '911111111', '$2a$10$I22XFwxtI9zDckzkmPgZ.ufRRicP31Q.7tAiRiodGvnwU2/bloUvS', 'https://picsum.photos/id/1011/600/400', 4, 7);
INSERT INTO tb_user (cpf, name, email, birth_date, phone, password, photo_url, driver_id, address_id) VALUES ('11111111111', 'Hiagor Silva', 'hiagor@gmail.com', '1990-01-01', '911111111', '$2a$10$I22XFwxtI9zDckzkmPgZ.ufRRicP31Q.7tAiRiodGvnwU2/bloUvS', 'https://picsum.photos/id/1011/600/400', 5, 8);
INSERT INTO tb_user (cpf, name, email, birth_date, phone, password, photo_url, driver_id, address_id) VALUES ('11111111111', 'Breno Gomes', 'breno@gmail.com', '1990-01-01', '911111111', '$2a$10$I22XFwxtI9zDckzkmPgZ.ufRRicP31Q.7tAiRiodGvnwU2/bloUvS', 'https://picsum.photos/id/1011/600/400', 6, 9);
INSERT INTO tb_user (cpf, name, email, birth_date, phone, password, photo_url, driver_id, address_id) VALUES ('11111111111', 'jacirleide Josefa', 'jacirleide@gmail.com', '1990-01-01', '911111111', '$2a$10$I22XFwxtI9zDckzkmPgZ.ufRRicP31Q.7tAiRiodGvnwU2/bloUvS', 'https://picsum.photos/id/1011/600/400', 7, 10);
INSERT INTO tb_user (cpf, name, email, birth_date, phone, password, photo_url, driver_id, address_id) VALUES ('11111111111', 'Josimar Silva', 'josimar@gmail.com', '1990-01-01', '911111111', '$2a$10$I22XFwxtI9zDckzkmPgZ.ufRRicP31Q.7tAiRiodGvnwU2/bloUvS', 'https://picsum.photos/id/1011/600/400',8, 11);


-- 4. Associar Utilizadores às Roles na tabela intermédia (tb_user_role)
-- Ana (ID 1) e Bruno (ID 2) recebem as roles USER (1) e DRIVER (2)
INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
-- Carlos, Diana e Eduardo recebem apenas a role USER (1)
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (4, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (5, 1);
--inseridos depois
INSERT INTO tb_user_role (user_id, role_id) VALUES (6, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (6, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (7, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (7, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (8, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (8, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (9, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (9, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (10, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (10, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (11, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (11, 2);

-- 5. Inserir 10 Viagens (tb_ride) corrigido
-- Nota: Ajuste os valores de "state", "neighborhood" e "meetingPoint" conforme necessário.

INSERT INTO tb_ride (departure_time, capacity, price, status, driver_id, starting_state, starting_city, starting_neighborhood, starting_street, starting_Point, destination_state, destination_city, destination_neighborhood, destination_street, destination_Point) VALUES ('2026-06-01T08:00:00Z', 4, 20.5, 'AVAILABLE', 1, 'SP', 'São Paulo', 'Pinheiros', 'Rua A', 'Ponto 1', 'SP', 'Santos', 'Centro', 'Rua B', 'Ponto 2');
INSERT INTO tb_ride (departure_time, capacity, price, status, driver_id, starting_state, starting_city, starting_neighborhood, starting_street, starting_Point, destination_state, destination_city, destination_neighborhood, destination_street, destination_Point) VALUES ('2026-06-02T09:00:00Z', 4, 15.0, 'AVAILABLE', 1, 'SP', 'São Paulo', 'Itaim', 'Rua C', 'Ponto 3', 'SP', 'Campinas', 'Bairro 1', 'Rua D', 'Ponto 4');
INSERT INTO tb_ride (departure_time, capacity, price, status, driver_id, starting_state, starting_city, starting_neighborhood, starting_street, starting_Point, destination_state, destination_city, destination_neighborhood, destination_street, destination_Point) VALUES ('2026-06-03T10:00:00Z', 4, 25.0, 'AVAILABLE', 1, 'SP', 'São Paulo', 'Lapa', 'Rua E', 'Ponto 5', 'SP', 'Jundiaí', 'Bairro 2', 'Rua F', 'Ponto 6');
INSERT INTO tb_ride (departure_time, capacity, price, status, driver_id, starting_state, starting_city, starting_neighborhood, starting_street, starting_Point, destination_state, destination_city, destination_neighborhood, destination_street, destination_Point) VALUES ('2026-06-04T11:00:00Z', 4, 18.0, 'FINISHED', 1, 'SP', 'São Paulo', 'Centro', 'Rua G', 'Ponto 7', 'SP', 'Sorocaba', 'Bairro 3', 'Rua H', 'Ponto 8');
INSERT INTO tb_ride (departure_time, capacity, price, status, driver_id, starting_state, starting_city, starting_neighborhood, starting_street, starting_Point, destination_state, destination_city, destination_neighborhood, destination_street, destination_Point) VALUES ('2026-06-05T14:00:00Z', 4, 22.0, 'CANCELLED', 1, 'SP', 'São Paulo', 'Moema', 'Rua I', 'Ponto 9', 'SP', 'Piracicaba', 'Bairro 4', 'Rua J', 'Ponto 10');
INSERT INTO tb_ride (departure_time, capacity, price, status, driver_id, starting_state, starting_city, starting_neighborhood, starting_street, starting_Point, destination_state, destination_city, destination_neighborhood, destination_street, destination_Point) VALUES ('2026-06-01T15:00:00Z', 3, 30.0, 'AVAILABLE', 2, 'RJ', 'Rio de Janeiro', 'Copacabana', 'Rua K', 'Ponto 11', 'RJ', 'Niterói', 'Centro', 'Rua L', 'Ponto 12');
INSERT INTO tb_ride (departure_time, capacity, price, status, driver_id, starting_state, starting_city, starting_neighborhood, starting_street, starting_Point, destination_state, destination_city, destination_neighborhood, destination_street, destination_Point) VALUES ('2026-06-02T16:00:00Z', 3, 28.0, 'AVAILABLE', 2, 'RJ', 'Rio de Janeiro', 'Ipanema', 'Rua M', 'Ponto 13', 'RJ', 'Petrópolis', 'Bairro 5', 'Rua N', 'Ponto 14');
INSERT INTO tb_ride (departure_time, capacity, price, status, driver_id, starting_state, starting_city, starting_neighborhood, starting_street, starting_Point, destination_state, destination_city, destination_neighborhood, destination_street, destination_Point) VALUES ('2026-06-03T17:00:00Z', 3, 32.0, 'FULL', 2, 'RJ', 'Rio de Janeiro', 'Leblon', 'Rua O', 'Ponto 15', 'RJ', 'Teresópolis', 'Bairro 6', 'Rua P', 'Ponto 16');
INSERT INTO tb_ride (departure_time, capacity, price, status, driver_id, starting_state, starting_city, starting_neighborhood, starting_street, starting_Point, destination_state, destination_city, destination_neighborhood, destination_street, destination_Point) VALUES ('2026-06-04T08:00:00Z', 3, 20.0, 'AVAILABLE', 2, 'RJ', 'Rio de Janeiro', 'Barra', 'Rua Q', 'Ponto 17', 'RJ', 'Angra', 'Bairro 7', 'Rua R', 'Ponto 18');
INSERT INTO tb_ride (departure_time, capacity, price, status, driver_id, starting_state, starting_city, starting_neighborhood, starting_street, starting_Point, destination_state, destination_city, destination_neighborhood, destination_street, destination_Point) VALUES ('2026-06-05T09:00:00Z', 3, 25.0, 'AVAILABLE', 2, 'RJ', 'Rio de Janeiro', 'Botafogo', 'Rua S', 'Ponto 19', 'RJ', 'Búzios', 'Bairro 8', 'Rua T', 'Ponto 20');
INSERT INTO tb_ride (departure_time, capacity, price, status, driver_id, starting_state, starting_city, starting_neighborhood, starting_street, starting_point, destination_state, destination_city, destination_neighborhood, destination_street, destination_point) VALUES ('2026-06-04T07:30:00Z', 4, 80.0, 'AVAILABLE', 1, 'SP', 'São Paulo', 'Moema', 'Rua Azul', 'Terminal 1', 'RJ', 'Rio de Janeiro', 'Copacabana', 'Av Atlântica', 'Rodoviária');

INSERT INTO tb_ride (departure_time, capacity, price, status, driver_id, starting_state, starting_city, starting_neighborhood, starting_street, starting_point, destination_state, destination_city, destination_neighborhood, destination_street, destination_point) VALUES ('2026-06-05T06:00:00Z', 3, 120.0, 'AVAILABLE', 2, 'MG', 'Belo Horizonte', 'Savassi', 'Rua Minas', 'Shopping BH', 'SP', 'Campinas', 'Taquaral', 'Rua Verde', 'Terminal Central');

INSERT INTO tb_ride (departure_time, capacity, price, status, driver_id, starting_state, starting_city, starting_neighborhood, starting_street, starting_point, destination_state, destination_city, destination_neighborhood, destination_street, destination_point) VALUES ('2026-06-06T14:00:00Z', 4, 95.0, 'AVAILABLE', 1, 'PR', 'Curitiba', 'Centro', 'Rua XV', 'Praça Central', 'SC', 'Florianópolis', 'Trindade', 'Rua das Flores', 'UFSC');

INSERT INTO tb_ride (departure_time, capacity, price, status, driver_id, starting_state, starting_city, starting_neighborhood, starting_street, starting_point, destination_state, destination_city, destination_neighborhood, destination_street, destination_point) VALUES ('2026-06-07T18:00:00Z', 2, 150.0, 'AVAILABLE', 2, 'BA', 'Salvador', 'Barra', 'Av Oceânica', 'Farol da Barra', 'PE', 'Recife', 'Boa Viagem', 'Av Boa Viagem', 'Shopping Recife');

INSERT INTO tb_ride (departure_time, capacity, price, status, driver_id, starting_state, starting_city, starting_neighborhood, starting_street, starting_point, destination_state, destination_city, destination_neighborhood, destination_street, destination_point) VALUES ('2026-06-08T05:30:00Z', 4, 200.0, 'AVAILABLE', 1, 'GO', 'Goiânia', 'Setor Bueno', 'Rua 10', 'Praça Bueno', 'DF', 'Brasília', 'Asa Sul', 'SQS 308', 'Rodoviária Plano Piloto');

INSERT INTO tb_ride (departure_time, capacity, price, status, driver_id, starting_state, starting_city, starting_neighborhood, starting_street, starting_point, destination_state, destination_city, destination_neighborhood, destination_street, destination_point) VALUES ('2026-06-09T11:00:00Z', 4, 180.0, 'AVAILABLE', 2, 'RS', 'Porto Alegre', 'Moinhos de Vento', 'Rua Padre Chagas', 'Parque Moinhos', 'SC', 'Joinville', 'América', 'Rua Blumenau', 'Terminal Norte');

INSERT INTO tb_ride (departure_time, capacity, price, status, driver_id, starting_state, starting_city, starting_neighborhood, starting_street, starting_point, destination_state, destination_city, destination_neighborhood, destination_street, destination_point) VALUES ('2026-06-10T09:30:00Z', 3, 220.0, 'AVAILABLE', 1, 'CE', 'Fortaleza', 'Meireles', 'Av Beira Mar', 'Beira Mar', 'RN', 'Natal', 'Ponta Negra', 'Rua Praia', 'Shopping Natal');

INSERT INTO tb_ride (departure_time, capacity, price, status, driver_id, starting_state, starting_city, starting_neighborhood, starting_street, starting_point, destination_state, destination_city, destination_neighborhood, destination_street, destination_point) VALUES ('2026-06-11T13:00:00Z', 4, 160.0, 'AVAILABLE', 2, 'ES', 'Vitória', 'Praia do Canto', 'Rua Alegria', 'Shopping Vitória', 'RJ', 'Campos dos Goytacazes', 'Centro', 'Rua Santos Dumont', 'Rodoviária');

INSERT INTO tb_ride (departure_time, capacity, price, status, driver_id, starting_state, starting_city, starting_neighborhood, starting_street, starting_point, destination_state, destination_city, destination_neighborhood, destination_street, destination_point) VALUES ('2026-06-12T20:00:00Z', 4, 300.0, 'AVAILABLE', 1, 'SP', 'São Paulo', 'Vila Mariana', 'Rua Domingos', 'Metrô Ana Rosa', 'PR', 'Londrina', 'Centro', 'Rua Paraná', 'Terminal Londrina');

INSERT INTO tb_ride (departure_time, capacity, price, status, driver_id, starting_state, starting_city, starting_neighborhood, starting_street, starting_point, destination_state, destination_city, destination_neighborhood, destination_street, destination_point) VALUES ('2026-06-13T15:00:00Z', 3, 140.0, 'AVAILABLE', 2, 'MT', 'Cuiabá', 'Centro Norte', 'Rua das Palmeiras', 'Mercado Central', 'GO', 'Anápolis', 'Jundiaí', 'Rua Goiás', 'Terminal Sul');

--ADICIONADOS DEPOIS PARA MAIS TESTES
INSERT INTO tb_ride (departure_time, capacity, price, status, driver_id, starting_state, starting_city, starting_neighborhood, starting_street, starting_Point, destination_state, destination_city, destination_neighborhood, destination_street, destination_Point) VALUES ('2026-06-01T08:00:00Z', 4, 20.5, 'AVAILABLE', 6, 'SP', 'São Paulo', 'Pinheiros', 'Rua A', 'Ponto 1', 'SP', 'Santos', 'Centro', 'Rua B', 'Ponto 2');
INSERT INTO tb_ride (departure_time, capacity, price, status, driver_id, starting_state, starting_city, starting_neighborhood, starting_street, starting_Point, destination_state, destination_city, destination_neighborhood, destination_street, destination_Point) VALUES ('2026-06-01T08:00:00Z', 4, 20.5, 'AVAILABLE', 7, 'SP', 'São Paulo', 'Pinheiros', 'Rua A', 'Ponto 1', 'SP', 'Santos', 'Centro', 'Rua B', 'Ponto 2');
INSERT INTO tb_ride (departure_time, capacity, price, status, driver_id, starting_state, starting_city, starting_neighborhood, starting_street, starting_Point, destination_state, destination_city, destination_neighborhood, destination_street, destination_Point) VALUES ('2026-06-01T08:00:00Z', 4, 20.5, 'AVAILABLE', 8, 'SP', 'São Paulo', 'Pinheiros', 'Rua A', 'Ponto 1', 'SP', 'Santos', 'Centro', 'Rua B', 'Ponto 2');
INSERT INTO tb_ride (departure_time, capacity, price, status, driver_id, starting_state, starting_city, starting_neighborhood, starting_street, starting_Point, destination_state, destination_city, destination_neighborhood, destination_street, destination_Point) VALUES ('2026-06-01T08:00:00Z', 4, 20.5, 'AVAILABLE', 9, 'SP', 'São Paulo', 'Pinheiros', 'Rua A', 'Ponto 1', 'SP', 'Santos', 'Centro', 'Rua B', 'Ponto 2');
INSERT INTO tb_ride (departure_time, capacity, price, status, driver_id, starting_state, starting_city, starting_neighborhood, starting_street, starting_Point, destination_state, destination_city, destination_neighborhood, destination_street, destination_Point) VALUES ('2026-06-01T08:00:00Z', 4, 20.5, 'AVAILABLE', 10, 'SP', 'São Paulo', 'Pinheiros', 'Rua A', 'Ponto 1', 'SP', 'Santos', 'Centro', 'Rua B', 'Ponto 2');
INSERT INTO tb_ride (departure_time, capacity, price, status, driver_id, starting_state, starting_city, starting_neighborhood, starting_street, starting_Point, destination_state, destination_city, destination_neighborhood, destination_street, destination_Point) VALUES ('2026-06-01T08:00:00Z', 4, 20.5, 'AVAILABLE', 11, 'SP', 'São Paulo', 'Pinheiros', 'Rua A', 'Ponto 1', 'SP', 'Santos', 'Centro', 'Rua B', 'Ponto 2');



INSERT INTO tb_booking (instant_booking, status, seats, ride_id, passenger_id) VALUES ('2026-05-28T10:00:00Z', 'ACCEPTED', 1, 1, 3);
INSERT INTO tb_booking (instant_booking, status, seats, ride_id, passenger_id) VALUES ('2026-05-01T11:00:00Z', 'PENDING', 1, 1, 4);
INSERT INTO tb_booking (instant_booking, status, seats, ride_id, passenger_id) VALUES ('2026-04-27T12:00:00Z', 'ACCEPTED', 1, 2, 5);
INSERT INTO tb_booking (instant_booking, status, seats, ride_id, passenger_id) VALUES ('2026-04-15T13:00:00Z', 'PENDING', 1, 3, 3);
INSERT INTO tb_booking (instant_booking, status, seats, ride_id, passenger_id) VALUES ('2026-04-08T14:00:00Z', 'ACCEPTED', 1, 6, 4);
INSERT INTO tb_booking (instant_booking, status, seats, ride_id, passenger_id) VALUES ('2026-03-28T15:00:00Z', 'ACCEPTED', 1, 7, 5);
INSERT INTO tb_booking (instant_booking, status, seats, ride_id, passenger_id) VALUES ('2026-03-24T16:00:00Z', 'REJECTED', 1, 8, 3);
INSERT INTO tb_booking (instant_booking, status, seats, ride_id, passenger_id) VALUES ('2026-03-20T17:00:00Z', 'PENDING', 1, 9, 4);
INSERT INTO tb_booking (instant_booking, status, seats, ride_id, passenger_id) VALUES ('2026-02-15T18:00:00Z', 'ACCEPTED', 1, 10, 5);
INSERT INTO tb_booking (instant_booking, status, seats, ride_id, passenger_id) VALUES ('2026-02-01T19:00:00Z', 'PENDING', 1, 5, 3);