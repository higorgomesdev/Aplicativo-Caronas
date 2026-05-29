-- 1. Inserir Roles (Papéis de acesso)
INSERT INTO tb_role (authority) VALUES ('ROLE_USER');
INSERT INTO tb_role (authority) VALUES ('ROLE_DRIVER');

-- Inserir Endereços (tb_address)
INSERT INTO tb_address (city, neighborhood, street, number, complement) VALUES ('São Paulo', 'Pinheiros', 'Rua Teodoro Sampaio', '1020', 'Apto 45');
INSERT INTO tb_address (city, neighborhood, street, number, complement) VALUES ('Rio de Janeiro', 'Copacabana', 'Avenida Atlântica', '1500', 'Bloco B, Sala 201');
INSERT INTO tb_address (city, neighborhood, street, number, complement) VALUES ('São Paulo', 'Ferraz de vasconcelos', 'Rua joão de deus morais', '298', 'casa 2');
INSERT INTO tb_address (city, neighborhood, street, number, complement) VALUES ('Paulistana', 'sertanejo', 'travessa rio grande do sul', '380', 'esquina');
INSERT INTO tb_address (city, neighborhood, street, number, complement) VALUES ('Paulistana', 'sertanejo', 'areolino de abreu', '68', 'esquina');


-- 2. Inserir Dados de Motorista (tb_driver_data)
INSERT INTO tb_driver_data (cnh, vehicle_Model, license_Plate) VALUES ('12345678901', 'Renault fluence', 'OCH3B83');
INSERT INTO tb_driver_data (cnh, vehicle_Model, license_Plate) VALUES ('10987654321', 'BYD dolphi', 'OBJ4V97');

-- 3. Inserir Utilizadores (tb_user)
-- A Ana (ID 1) e o Bruno (ID 2) têm driver_id preenchido.
INSERT INTO tb_user (cpf, name, email, birth_date, phone, password, driver_id, address_id) VALUES ('11111111111', 'Ana Silva', 'ana@email.com', '1990-01-01', '911111111', 'senha123', 1, 1);
INSERT INTO tb_user (cpf, name, email, birth_date, phone, password, driver_id, address_id) VALUES ('22222222222', 'Bruno Costa', 'bruno@email.com', '1985-05-15', '922222222', 'senha123', 2, 2);

-- O Carlos (ID 3), a Diana (ID 4) e o Eduardo (ID 5) são apenas passageiros (driver_id é NULL)
INSERT INTO tb_user (cpf, name, email, birth_date, phone, password, driver_id, address_id) VALUES ('33333333333', 'Carlos Dias', 'carlos@email.com', '1992-08-20', '933333333', 'senha123', NULL, 3);
INSERT INTO tb_user (cpf, name, email, birth_date, phone, password, driver_id, address_id) VALUES ('44444444444', 'Diana Faria', 'diana@email.com', '1998-12-10', '944444444', 'senha123', NULL, 4);
INSERT INTO tb_user (cpf, name, email, birth_date, phone, password, driver_id, address_id) VALUES ('55555555555', 'Eduardo Gomes', 'eduardo@email.com', '2000-03-30', '955555555', 'senha123', NULL, 5);

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

INSERT INTO tb_booking (instant_booking, status, ride_id, passenger_id) VALUES ('2026-05-28T10:00:00Z', 'ACCEPTED', 1, 3);
INSERT INTO tb_booking (instant_booking, status, ride_id, passenger_id) VALUES ('2026-05-01T11:00:00Z', 'PENDING', 1, 4);
INSERT INTO tb_booking (instant_booking, status, ride_id, passenger_id) VALUES ('2026-04-27T12:00:00Z', 'ACCEPTED', 2, 5);
INSERT INTO tb_booking (instant_booking, status, ride_id, passenger_id) VALUES ('2026-04-15T13:00:00Z', 'PENDING', 3, 3);
INSERT INTO tb_booking (instant_booking, status, ride_id, passenger_id) VALUES ('2026-04-08T14:00:00Z', 'ACCEPTED', 6, 4);
INSERT INTO tb_booking (instant_booking, status, ride_id, passenger_id) VALUES ('2026-03-28T15:00:00Z', 'ACCEPTED', 7, 5);
INSERT INTO tb_booking (instant_booking, status, ride_id, passenger_id) VALUES ('2026-03-24T16:00:00Z', 'REJECTED', 8, 3);
INSERT INTO tb_booking (instant_booking, status, ride_id, passenger_id) VALUES ('2026-03-20T17:00:00Z', 'PENDING', 9, 4);
INSERT INTO tb_booking (instant_booking, status, ride_id, passenger_id) VALUES ('2026-02-15T18:00:00Z', 'ACCEPTED', 10, 5);
INSERT INTO tb_booking (instant_booking, status, ride_id, passenger_id) VALUES ('2026-02-01T19:00:00Z', 'PENDING', 5, 3);