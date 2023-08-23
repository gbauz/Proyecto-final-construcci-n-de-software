-- -----------------------------------------------------
-- TABLA JUGADOR
-- VALORES DE ID PREDETERMINADOS EN 900
-- -----------------------------------------------------
CREATE TABLE
IF NOT EXISTS jugador
(
  id_jugador INT NOT NULL AUTO_INCREMENT,
 nombre VARCHAR(45) NOT NULL,
  apellido VARCHAR(45) NOT NULL,
nombre_usuario VARCHAR(35) NOT NULL,
email VARCHAR(55) NOT NULL,
contrasenia VARCHAR(45) NOT NULL,
  fecha_nac DATE NOT NULL,
nacionalidad VARCHAR(45) NOT NULL,
create_at DATE NULL,
  delete_at DATE NULL,
  updated_at DATE NULL,
  estado VARCHAR(2) NULL,
  club_id_club INT NOT NULL,
  PRIMARY KEY (id_jugador)
);

ALTER TABLE jugador AUTO_INCREMENT = 900;

ALTER TABLE jugador ADD CONSTRAINT fk_jugador_id_club
    FOREIGN KEY (club_id_club)
    REFERENCES club (id_club);




-- -----------------------------------------------------
-- TABLA ASISTENCIA_JUGADOR
-- VALORES DE ID PREDETERMINADOS EN 900
-- -----------------------------------------------------
CREATE TABLE
IF NOT EXISTS asistencia_jugador
(
  id_asistencia INT NOT NULL AUTO_INCREMENT,
  partido VARCHAR
(45) NOT NULL,
  lugar VARCHAR
(45) NOT NULL,
  fecha_encuentro DATE NOT NULL,
  asistencia TINYINT NOT NULL COMMENT 'Tipo de dato BOOLEAN',
  estado VARCHAR
(2) NULL,
  jugador_id_jugador INT NOT NULL,
  PRIMARY KEY (id_asistencia)
);

ALTER TABLE asistencia_jugador AUTO_INCREMENT = 900;

ALTER TABLE asistencia_jugador 
ADD CONSTRAINT fk_asistencia_jugador
FOREIGN KEY (jugador_id_jugador)     REFERENCES jugador (id_jugador);


-- Agregar columna de fecha con valor predeterminado
ALTER TABLE partido
ADD fecha DATE;

ALTER TABLE partido
ADD hora TIME;
