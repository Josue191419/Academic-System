-- CREAR TABLAS EN LA BASE DE DATOS
-- Ejecuta estos comandos primero para crear las tablas necesarias

-- Tabla Estudiante
CREATE TABLE IF NOT EXISTS `u484426513_proc126`.`estudiante` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `identificacion` VARCHAR(20) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `fecha_nacimiento` DATE NOT NULL,
  `estado` ENUM('activo','inactivo') NOT NULL DEFAULT 'activo',
  PRIMARY KEY (`id`),
  UNIQUE KEY `identificacion_UNIQUE` (`identificacion`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Tabla Profesor
CREATE TABLE IF NOT EXISTS `u484426513_proc126`.`profesor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `identificacion` VARCHAR(20) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `departamento` VARCHAR(50) NOT NULL,
  `estado` ENUM('activo','inactivo') NOT NULL DEFAULT 'activo',
  PRIMARY KEY (`id`),
  UNIQUE KEY `identificacion_UNIQUE` (`identificacion`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Tabla Grupo
CREATE TABLE IF NOT EXISTS `u484426513_proc126`.`grupo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `descripcion` TEXT,
  `estado` ENUM('activo','inactivo') NOT NULL DEFAULT 'activo',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Tabla Curso
CREATE TABLE IF NOT EXISTS `u484426513_proc126`.`curso` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `descripcion` TEXT,
  `estado` ENUM('activo','inactivo') NOT NULL DEFAULT 'activo',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Tabla GrupoCurso (relación muchos a muchos entre Grupo y Curso)
CREATE TABLE IF NOT EXISTS `u484426513_proc126`.`grupo_curso` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `grupo_id` INT NOT NULL,
  `curso_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_grupo_curso_grupo_idx` (`grupo_id`),
  KEY `fk_grupo_curso_curso_idx` (`curso_id`),
  CONSTRAINT `fk_grupo_curso_grupo` FOREIGN KEY (`grupo_id`) REFERENCES `u484426513_proc126`.`grupo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_grupo_curso_curso` FOREIGN KEY (`curso_id`) REFERENCES `u484426513_proc126`.`curso` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

==========================================

EJEMPLOS DE DATOS DE PRUEBA
============================

Copia y pega estos comandos SQL en phpMyAdmin o MySQL Workbench
para insertar datos de prueba en la aplicación.

==========================================

INSERTAR ESTUDIANTES:

INSERT INTO `u484426513_proc126`.`estudiante` (nombre, identificacion, email, fecha_nacimiento, estado)
VALUES ('Juan Pérez García', '1234567890', 'juan.perez@email.com', '2000-01-15', 'activo');

INSERT INTO `u484426513_proc126`.`estudiante` (nombre, identificacion, email, fecha_nacimiento, estado)
VALUES ('María López Rodríguez', '0987654321', 'maria.lopez@email.com', '2001-05-22', 'activo');

INSERT INTO `u484426513_proc126`.`estudiante` (nombre, identificacion, email, fecha_nacimiento, estado)
VALUES ('Carlos Martínez González', '5555555555', 'carlos.martinez@email.com', '1999-12-10', 'activo');

INSERT INTO `u484426513_proc126`.`estudiante` (nombre, identificacion, email, fecha_nacimiento, estado)
VALUES ('Laura Sánchez Flores', '1111111111', 'laura.sanchez@email.com', '2000-08-30', 'activo');

INSERT INTO `u484426513_proc126`.`estudiante` (nombre, identificacion, email, fecha_nacimiento, estado)
VALUES ('Roberto Díaz Morales', '9999999999', 'roberto.diaz@email.com', '2002-03-18', 'inactivo');

==========================================

INSERTAR PROFESORES:

INSERT INTO `u484426513_proc126`.`profesor` (nombre, identificacion, email, departamento, estado)
VALUES ('Dr. Carlos López Ruiz', '1111223344', 'c.lopez@universidad.edu', 'Ingeniería', 'activo');

INSERT INTO `u484426513_proc126`.`profesor` (nombre, identificacion, email, departamento, estado)
VALUES ('Dra. Patricia Fernández Silva', '2222334455', 'p.fernandez@universidad.edu', 'Ciencias', 'activo');

INSERT INTO `u484426513_proc126`.`profesor` (nombre, identificacion, email, departamento, estado)
VALUES ('Ing. Miguel Rodríguez Campos', '3333445566', 'm.rodriguez@universidad.edu', 'Ingeniería', 'activo');

INSERT INTO `u484426513_proc126`.`profesor` (nombre, identificacion, email, departamento, estado)
VALUES ('Lic. Ana García Ponce', '4444556677', 'a.garcia@universidad.edu', 'Humanidades', 'activo');

INSERT INTO `u484426513_proc126`.`profesor` (nombre, identificacion, email, departamento, estado)
VALUES ('Mtro. Javier Sánchez Rueda', '5555667788', 'j.sanchez@universidad.edu', 'Ingeniería', 'inactivo');

==========================================

INSERTAR GRUPOS:

INSERT INTO `u484426513_proc126`.`grupo` (nombre, descripcion, estado)
VALUES ('Grupo A - Mañana', 'Estudiantes del turno matutino, primer semestre', 'activo');

INSERT INTO `u484426513_proc126`.`grupo` (nombre, descripcion, estado)
VALUES ('Grupo B - Tarde', 'Estudiantes del turno vespertino, primer semestre', 'activo');

INSERT INTO `u484426513_proc126`.`grupo` (nombre, descripcion, estado)
VALUES ('Grupo C - Noche', 'Estudiantes del turno nocturno, primer semestre', 'activo');

INSERT INTO `u484426513_proc126`.`grupo` (nombre, descripcion, estado)
VALUES ('Grupo D - Especial', 'Grupo de estudiantes con necesidades especiales', 'activo');

INSERT INTO `u484426513_proc126`.`grupo` (nombre, descripcion, estado)
VALUES ('Grupo E - Nivelación', 'Grupo para estudiantes que requieren nivelación', 'inactivo');

==========================================

INSERTAR CURSOS:

INSERT INTO `u484426513_proc126`.`curso` (nombre, descripcion, estado)
VALUES ('Matemáticas Básicas', 'Curso fundamental de matemáticas para primer semestre', 'activo');

INSERT INTO `u484426513_proc126`.`curso` (nombre, descripcion, estado)
VALUES ('Programación en Java', 'Introducción a la programación orientada a objetos con Java', 'activo');

INSERT INTO `u484426513_proc126`.`curso` (nombre, descripcion, estado)
VALUES ('Cálculo Diferencial', 'Estudio de límites, derivadas e integrales', 'activo');

INSERT INTO `u484426513_proc126`.`curso` (nombre, descripcion, estado)
VALUES ('Bases de Datos MySQL', 'Diseño e implementación de bases de datos relacionales', 'activo');

INSERT INTO `u484426513_proc126`.`curso` (nombre, descripcion, estado)
VALUES ('Diseño de Software', 'Patrones de diseño y arquitectura de software', 'activo');

INSERT INTO `u484426513_proc126`.`curso` (nombre, descripcion, estado)
VALUES ('Comunicación Efectiva', 'Desarrollo de habilidades de comunicación profesional', 'inactivo');

==========================================

ASIGNAR CURSOS A GRUPOS:

INSERT INTO `u484426513_proc126`.`grupo_curso` (grupo_id, curso_id)
VALUES (1, 1); -- Grupo A - Matemáticas Básicas

INSERT INTO `u484426513_proc126`.`grupo_curso` (grupo_id, curso_id)
VALUES (1, 2); -- Grupo A - Programación en Java

INSERT INTO `u484426513_proc126`.`grupo_curso` (grupo_id, curso_id)
VALUES (1, 3); -- Grupo A - Cálculo Diferencial

INSERT INTO `u484426513_proc126`.`grupo_curso` (grupo_id, curso_id)
VALUES (2, 1); -- Grupo B - Matemáticas Básicas

INSERT INTO `u484426513_proc126`.`grupo_curso` (grupo_id, curso_id)
VALUES (2, 2); -- Grupo B - Programación en Java

INSERT INTO `u484426513_proc126`.`grupo_curso` (grupo_id, curso_id)
VALUES (3, 4); -- Grupo C - Bases de Datos MySQL

==========================================

VERIFICAR LOS DATOS INSERTADOS:

SELECT * FROM `u484426513_proc126`.`estudiante`;
SELECT * FROM `u484426513_proc126`.`profesor`;
SELECT * FROM `u484426513_proc126`.`grupo`;
SELECT * FROM `u484426513_proc126`.`curso`;
SELECT * FROM `u484426513_proc126`.`grupo_curso`;

