create database BD_Marketing_Digital;
use BD_Marketing_Digital;
drop database BD_Marketing_Digital;
CREATE TABLE Cliente (
    id VARCHAR(50) PRIMARY KEY,
    nombre VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    apellidos VARCHAR(100),
    telefono INT
);

CREATE TABLE ClienteFidelizado (
    id VARCHAR(50) PRIMARY KEY,
    nombre VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    apellidos VARCHAR(100),
    telefono INT
);


CREATE TABLE Empleado (
    dni INT PRIMARY KEY,
    nombre VARCHAR(100),
    apellidos VARCHAR(100),
    cargo VARCHAR(100),
    email VARCHAR(100) UNIQUE
);

CREATE TABLE RRHH (
    idRrhh INT PRIMARY KEY,
    nombre VARCHAR(100),
    telefono INT,
    cargo VARCHAR(100),
    email VARCHAR(100)
);

CREATE TABLE DepRedesSociales (
    id INT PRIMARY KEY,
    nombreEquipo VARCHAR(100),
    fechaCreacion DATE,
    fechaFin DATE
);


CREATE TABLE PublicidadRS (
    idRs VARCHAR(50) PRIMARY KEY,
    nombre VARCHAR(100),
    tipo VARCHAR(100),
    numSeguidores INT
);
CREATE TABLE TipoRedes (
    idRs VARCHAR(50) PRIMARY KEY,
    nombre VARCHAR(100),
    tipo VARCHAR(100),
    numSeguidores INT
);


CREATE TABLE EquipoContenido (
    id INT PRIMARY KEY,
    nombre VARCHAR(100),
    fechaCreacion DATE,
    numeroMiembros INT,
    fechaFin DATE
);


CREATE TABLE DepVentaDesarrollo (
    codigo INT PRIMARY KEY,
    fecha DATE,
    precio INT
);


CREATE TABLE DepAnaliticaMetrica (
    id INT PRIMARY KEY,
    fecha DATE,
    numMiembros INT,
    nombreEquipo VARCHAR(100)
);


CREATE TABLE CampañaPublicitaria (
    id INT PRIMARY KEY AUTO_INCREMENT,
    fechaInicio DATE,
    fechaFin DATE
);


CREATE TABLE EquipoDiseño (
    id INT PRIMARY KEY,
    nombreDepartamento VARCHAR(100),
    numMiembros INT,
    fechaFinProyecto DATE,
    fechaCreacionProyecto DATE
);

CREATE TABLE Proyecto (
    idProyecto INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    fechaInicio DATE,
    fechaFin DATE
);
CREATE TABLE TipoDiseño (
    id INT PRIMARY KEY,
    nombreDepartamento VARCHAR(100),
    numMiembros INT,
    fechaFinProyecto DATE,
    fechaCreacionProyecto DATE
);

ALTER TABLE CampañaPublicitaria ADD COLUMN cliente_id VARCHAR(50), ADD FOREIGN KEY (cliente_id) REFERENCES Cliente(id);
ALTER TABLE Proyecto ADD COLUMN empleado_dni INT, ADD FOREIGN KEY (empleado_dni) REFERENCES Empleado(dni);
ALTER TABLE Empleado ADD COLUMN rrhh_id INT, ADD FOREIGN KEY (rrhh_id) REFERENCES RRHH(idRrhh);
ALTER TABLE PublicidadRS ADD COLUMN dep_id INT, ADD FOREIGN KEY (dep_id) REFERENCES DepRedesSociales(id);
ALTER TABLE EquipoContenido ADD COLUMN dep_id INT, ADD FOREIGN KEY (dep_id) REFERENCES DepRedesSociales(id);
ALTER TABLE EquipoDiseño ADD COLUMN dep_id INT, ADD FOREIGN KEY (dep_id) REFERENCES DepVentaDesarrollo(codigo);
ALTER TABLE DepAnaliticaMetrica ADD COLUMN proyecto_id INT, ADD FOREIGN KEY (proyecto_id) REFERENCES Proyecto(idProyecto);

INSERT INTO Cliente (id, nombre, email, apellidos, telefono) VALUES
('C001', 'Ana', 'ana@example.com', 'López', 600123456),
('C002', 'Luis', 'luis@example.com', 'Martín', 611234567);

INSERT INTO ClienteFidelizado (id, nombre, email, apellidos, telefono) VALUES
('CF001', 'María', 'maria@example.com', 'Gómez', 622345678),
('CF002', 'Pedro', 'pedro@example.com', 'Sánchez', 633456789);


INSERT INTO RRHH (idRrhh, nombre, telefono, cargo, email) VALUES
(1, 'Sandra', 644567890, 'Directora RRHH', 'sandra.rrhh@example.com'),
(2, 'Carlos', 655678901, 'Gestor RRHH', 'carlos.rrhh@example.com');

INSERT INTO Empleado (dni, nombre, apellidos, cargo, email, rrhh_id) VALUES
(101, 'Jorge', 'Pérez', 'Diseñador', 'jorge@example.com', 1),
(102, 'Lucía', 'Ramírez', 'Analista', 'lucia@example.com', 2);

INSERT INTO Proyecto (nombre, fechaInicio, fechaFin, empleado_dni) VALUES
('Lanzamiento Primavera', '2025-02-01', '2025-06-01', 101),
('Campaña SEO', '2025-01-15', '2025-05-15', 102);

INSERT INTO DepRedesSociales (id, nombreEquipo, fechaCreacion, fechaFin) VALUES
(1, 'SocialBoost', '2024-01-01', '2025-12-31'),
(2, 'TrendSetters', '2023-06-01', '2024-12-31');

INSERT INTO PublicidadRS (idRs, nombre, tipo, numSeguidores, dep_id) VALUES
('RS001', 'InstaPromo', 'Instagram', 50000, 1),
('RS002', 'FaceAd', 'Facebook', 30000, 2);

INSERT INTO EquipoContenido (id, nombre, fechaCreacion, numeroMiembros, fechaFin, dep_id) VALUES
(1, 'CopyTeam', '2024-05-01', 4, '2025-05-01', 1),
(2, 'DesignCrew', '2024-06-01', 3, '2025-06-01', 2);

INSERT INTO CampañaPublicitaria (fechaInicio, fechaFin, cliente_id) VALUES
('2025-03-01', '2025-06-01', 'C001'),
('2025-04-01', '2025-07-01', 'C002');

INSERT INTO DepVentaDesarrollo (codigo, fecha, precio) VALUES
(1, '2025-01-10', 1200),
(2, '2025-02-20', 2300);

INSERT INTO EquipoDiseño (id, nombreDepartamento, numMiembros, fechaFinProyecto, fechaCreacionProyecto, dep_id) VALUES
(1, 'Diseño UX', 5, '2025-10-01', '2025-01-01', 1),
(2, 'Diseño Visual', 3, '2025-11-01', '2025-02-01', 2);

INSERT INTO DepAnaliticaMetrica (id, fecha, numMiembros, nombreEquipo, proyecto_id) VALUES
(1, '2025-03-15', 2, 'MetricsPro', 1),
(2, '2025-04-01', 3, 'InsightTeam', 2);

INSERT INTO TipoRedes (idRs, nombre, tipo, numSeguidores) VALUES
('TR001', 'TwitterBlast', 'Twitter', 15000),
('TR002', 'LinkedLead', 'LinkedIn', 25000);

INSERT INTO TipoDiseño (id, nombreDepartamento, numMiembros, fechaFinProyecto, fechaCreacionProyecto) VALUES
(1, 'Gráfico', 4, '2025-12-01', '2025-01-10'),
(2, 'UX/UI', 5, '2025-10-10', '2025-01-20');



