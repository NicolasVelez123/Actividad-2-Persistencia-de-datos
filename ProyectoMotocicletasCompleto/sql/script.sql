-- =========================================
-- SCRIPT SQL: BASE DE DATOS MOTOCICLETAS
-- =========================================
-- Ejecutar en pgAdmin en la BD bd_motocicleta

-- Crear tabla tb_tipo_motocicleta
CREATE TABLE tb_tipo_motocicleta (
    id_tipo SERIAL PRIMARY KEY,
    descripcion_tipo VARCHAR(100) NOT NULL
);

-- Crear tabla tb_motocicleta
CREATE TABLE tb_motocicleta (
    id_moto SERIAL PRIMARY KEY,
    id_tipo INTEGER NOT NULL,
    marca_moto VARCHAR(50) NOT NULL,
    modelo_moto VARCHAR(50) NOT NULL,
    anio_moto INTEGER NOT NULL,
    precio_moto DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (id_tipo) REFERENCES tb_tipo_motocicleta(id_tipo)
);

-- Insertar tipos de motocicleta
INSERT INTO tb_tipo_motocicleta (descripcion_tipo) VALUES ('Deportiva');
INSERT INTO tb_tipo_motocicleta (descripcion_tipo) VALUES ('Crucero');
INSERT INTO tb_tipo_motocicleta (descripcion_tipo) VALUES ('Touring');
INSERT INTO tb_tipo_motocicleta (descripcion_tipo) VALUES ('Offroad');
INSERT INTO tb_tipo_motocicleta (descripcion_tipo) VALUES ('Scooter');

-- Insertar motocicletas de ejemplo
INSERT INTO tb_motocicleta (id_tipo, marca_moto, modelo_moto, anio_moto, precio_moto) 
VALUES (1, 'Yamaha', 'YZF-R1', 2024, 15000.00);

INSERT INTO tb_motocicleta (id_tipo, marca_moto, modelo_moto, anio_moto, precio_moto) 
VALUES (2, 'Harley-Davidson', 'Street 750', 2023, 7500.00);

INSERT INTO tb_motocicleta (id_tipo, marca_moto, modelo_moto, anio_moto, precio_moto) 
VALUES (3, 'BMW', 'R 1250 GS', 2024, 18000.00);

INSERT INTO tb_motocicleta (id_tipo, marca_moto, modelo_moto, anio_moto, precio_moto) 
VALUES (4, 'KTM', '250 SX-F', 2023, 8500.00);

INSERT INTO tb_motocicleta (id_tipo, marca_moto, modelo_moto, anio_moto, precio_moto) 
VALUES (1, 'Kawasaki', 'Ninja H2', 2024, 20000.00);

INSERT INTO tb_motocicleta (id_tipo, marca_moto, modelo_moto, anio_moto, precio_moto) 
VALUES (5, 'Piaggio', 'Vespa 300', 2023, 5000.00);

-- Verificar que funcionó
SELECT * FROM tb_tipo_motocicleta;
SELECT * FROM tb_motocicleta;
