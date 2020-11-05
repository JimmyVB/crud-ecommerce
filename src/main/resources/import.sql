INSERT INTO regiones (id, nombre) VALUES (1, 'Sudamerica');
INSERT INTO regiones (id, nombre) VALUES (2, 'Centroamerica');
INSERT INTO regiones (id, nombre) VALUES (3, 'Norteamerica');
INSERT INTO regiones (id, nombre) VALUES (4, 'Europa');
INSERT INTO regiones (id, nombre) VALUES (5, 'Asia');
INSERT INTO regiones (id, nombre) VALUES (6, 'Africa');
INSERT INTO regiones (id, nombre) VALUES (7, 'Oceania');
INSERT INTO regiones (id, nombre) VALUES (8, 'Antartida');

INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (1, 'Jimmy', 'Valdez', 'jimmy@gmail.com', '2020-01-01');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (2, 'Richard', 'Blas1', 'richard1@gmail.com', '2020-02-02');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (4, 'Antonio', 'Blas2', 'richar2d@gmail.com', '2020-02-02');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (4, 'Manuel', 'Blas3', 'richard3@gmail.com', '2020-02-02');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (4, 'Francisco', 'Blas4', 'richa4rd@gmail.com', '2020-02-02');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (3, 'David', 'Blas5', 'richar5d@gmail.com', '2020-02-02');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (3, 'Juan', 'Blas6', 'richard6@gmail.com', '2020-02-02');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (3, 'Javier', 'Blas7', 'richard7@gmail.com', '2020-02-02');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (3, 'Daniel', 'Blas8', 'richard8@gmail.com', '2020-02-02');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (5, 'Carmen', 'Blas9', 'richard9@gmail.com', '2020-02-02');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (6, 'Ana', 'Blas10', 'richar10d@gmail.com', '2020-02-02');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (7, 'Josefa', 'Blas11', 'richa11rd@gmail.com', '2020-02-02');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (7, 'Eloy', 'Blas12', 'richard12@gmail.com', '2020-02-02');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (7, 'Eduardo', 'Blas13', 'richar13d@gmail.com', '2020-02-02');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (8, 'Enrique', 'Blas14', 'richard14@gmail.com', '2020-02-02');

INSERT INTO usuarios (username, password, enabled) VALUES ('jimmy', '$2a$10$bVhqWTj/R/dF6NcUwv4Ig.R0UHjesXKpH7RJ8SdoKBOwyBIUUJ3ne', 1);
INSERT INTO usuarios (username, password, enabled) VALUES ('admin', '$2a$10$3Rnj9yhWdHysH/Td9sohTuC0DtpHg0O9HTfauOxgj3PXtikbLbCV.', 1);

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1, 1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 2);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 1);

