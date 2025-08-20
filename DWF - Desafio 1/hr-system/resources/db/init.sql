-- Script para crear la base de datos RecursosHumanos y datos de prueba
DROP DATABASE IF EXISTS RecursosHumanos;
CREATE DATABASE RecursosHumanos CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE RecursosHumanos;

CREATE TABLE Departamento (
  idDepartamento INT AUTO_INCREMENT PRIMARY KEY,
  nombreDepartamento VARCHAR(100) NOT NULL,
  descripcionDepartamento TEXT
);

CREATE TABLE Cargos (
  idCargo INT AUTO_INCREMENT PRIMARY KEY,
  cargo VARCHAR(100) NOT NULL,
  descripcionCargo TEXT,
  jefatura BOOLEAN DEFAULT FALSE
);

CREATE TABLE TipoContratacion (
  idTipoContratacion INT AUTO_INCREMENT PRIMARY KEY,
  tipoContratacion VARCHAR(100) NOT NULL
);

CREATE TABLE Empleados (
  idEmpleado INT AUTO_INCREMENT PRIMARY KEY,
  numeroDui VARCHAR(20),
  nombrePersona VARCHAR(150) NOT NULL,
  usuario VARCHAR(50),
  numeroTelefono VARCHAR(30),
  correoInstitutional VARCHAR(100),
  fechaNacimiento DATE
);

CREATE TABLE Contrataciones (
  idContratacion INT AUTO_INCREMENT PRIMARY KEY,
  idDepartamento INT,
  idEmpleado INT,
  idCargo INT,
  idTipoContratacion INT,
  fechaContratacion DATE,
  salario DECIMAL(10,2),
  estado BOOLEAN DEFAULT TRUE,
  FOREIGN KEY (idDepartamento) REFERENCES Departamento(idDepartamento),
  FOREIGN KEY (idEmpleado) REFERENCES Empleados(idEmpleado),
  FOREIGN KEY (idCargo) REFERENCES Cargos(idCargo),
  FOREIGN KEY (idTipoContratacion) REFERENCES TipoContratacion(idTipoContratacion)
);

-- Datos de prueba
INSERT INTO Departamento (nombreDepartamento, descripcionDepartamento) VALUES
('Recursos Humanos', 'Gestiona personal y nómina'),
('Tecnología', 'Soporte y desarrollo'),
('Finanzas', 'Contabilidad y control');

INSERT INTO Cargos (cargo, descripcionCargo, jefatura) VALUES
('Analista RRHH', 'Responsable de procesos de recursos humanos', FALSE),
('Desarrollador', 'Desarrolla sistemas internos', FALSE),
('Jefe de Finanzas', 'Lidera el área financiera', TRUE);

INSERT INTO TipoContratacion (tipoContratacion) VALUES
('Tiempo completo'),
('Medio tiempo'),
('Temporal');

INSERT INTO Empleados (numeroDui, nombrePersona, usuario, numeroTelefono, correoInstitutional, fechaNacimiento) VALUES
('01234567-8', 'Ana López', 'alopez', '7777-7777', 'ana.lopez@institucion.edu', '1990-05-12'),
('23456789-0', 'Carlos Martínez', 'cmartinez', '7888-8888', 'carlos.m@institucion.edu', '1985-03-04'),
('34567890-1', 'María Gómez', 'mgomez', '7999-9999', 'maria.g@institucion.edu', '1992-07-22');

INSERT INTO Contrataciones (idDepartamento, idEmpleado, idCargo, idTipoContratacion, fechaContratacion, salario, estado) VALUES
(1, 1, 1, 1, '2020-01-15', 450.00, TRUE),
(2, 2, 2, 1, '2019-08-01', 800.00, TRUE),
(3, 3, 3, 2, '2021-06-10', 1200.00, TRUE);
