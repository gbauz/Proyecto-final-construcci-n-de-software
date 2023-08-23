CREATE TABLE fecha_calendario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    hora_partido INT,
    fecha_partido DATE,
    lugar_partido VARCHAR(255),
    equipo_local VARCHAR(255),
    equipo_rival VARCHAR(255)
);