-- Tabla EPS
CREATE TABLE EPS (
    id VARCHAR2(50) PRIMARY KEY,
    nombre VARCHAR2(100) NOT NULL
);

-- Tabla IPS
CREATE TABLE IPS (
    nit VARCHAR2(50) PRIMARY KEY,
    nombre VARCHAR2(100) NOT NULL,
    direccion VARCHAR2(255),
    telefono NUMBER NOT NULL,
    id_eps VARCHAR2(50) NOT NULL,
    FOREIGN KEY (id_eps) REFERENCES EPS(id)
);

-- Tabla TipoServicio (Única Enumeración Necesaria)
CREATE TABLE TipoServicio (
    id NUMBER PRIMARY KEY,
    nombre VARCHAR2(50) UNIQUE NOT NULL 
);

-- Tabla de Relación IPS-TipoServicio (Muchos a Muchos)
CREATE TABLE IPS_TipoServicio (
    id_ips VARCHAR2(50) NOT NULL,
    id_servicio NUMBER NOT NULL,
    PRIMARY KEY (id_ips, id_servicio),
    FOREIGN KEY (id_ips) REFERENCES IPS(nit),
    FOREIGN KEY (id_servicio) REFERENCES TipoServicio(id)
);

-- Tabla Afiliado
CREATE TABLE Afiliado (
    numero_documento VARCHAR2(50) PRIMARY KEY,
    nombre VARCHAR2(100) NOT NULL,
    tipo_documento VARCHAR2(20) NOT NULL CHECK (tipo_documento IN ('CEDULA', 'TARJETA_IDENTIDAD', 'REGISTRO_CIVIL', 'PASAPORTE')),
    tipo_afiliado VARCHAR2(50) NOT NULL CHECK (tipo_afiliado IN ('CONTRIBUYENTE', 'BENEFICIARIO')),
    id_eps VARCHAR2(50),
    FOREIGN KEY (id_eps) REFERENCES EPS(id)
);

-- Tabla Beneficiario (Herencia de Afiliado)
CREATE TABLE Beneficiario (
    numero_documento VARCHAR2(50) PRIMARY KEY,
    parentesco VARCHAR2(50) NOT NULL,
    contribuyente_asociado VARCHAR2(50) NOT NULL,
    FOREIGN KEY (numero_documento) REFERENCES Afiliado(numero_documento),
    FOREIGN KEY (contribuyente_asociado) REFERENCES Afiliado(numero_documento)
);

-- Tabla Médico
CREATE TABLE Medico (
    numero_documento VARCHAR2(50) PRIMARY KEY,
    nombre VARCHAR2(100) NOT NULL,
    tipo_documento VARCHAR2(20) NOT NULL CHECK (tipo_documento IN ('CEDULA', 'TARJETA_IDENTIDAD', 'REGISTRO_CIVIL', 'PASAPORTE')),
    especialidad VARCHAR2(100) NOT NULL,
    registro_medico VARCHAR2(50) UNIQUE NOT NULL
);

-- Tabla de Relación IPS-Médico (Muchos a Muchos)
CREATE TABLE IPS_Medico (
    id_ips VARCHAR2(50) NOT NULL,
    id_medico VARCHAR2(50) NOT NULL,
    PRIMARY KEY (id_ips, id_medico),
    FOREIGN KEY (id_ips) REFERENCES IPS(nit),
    FOREIGN KEY (id_medico) REFERENCES Medico(numero_documento)
);

-- Tabla OrdenServicio
CREATE TABLE OrdenServicio (
    id NUMBER PRIMARY KEY,
    fecha DATE NOT NULL,
    estado VARCHAR2(20) NOT NULL CHECK (estado IN ('VIGENTE', 'CANCELADA', 'COMPLETADA')),
    servicio NUMBER NOT NULL,
    id_afiliado VARCHAR2(50) NOT NULL,
    id_medico VARCHAR2(50) NOT NULL,
    FOREIGN KEY (servicio) REFERENCES TipoServicio(id),
    FOREIGN KEY (id_afiliado) REFERENCES Afiliado(numero_documento),
    FOREIGN KEY (id_medico) REFERENCES Medico(numero_documento)
);

-- Tabla PrestacionServicio
CREATE TABLE PrestacionServicio (
    id VARCHAR2(50) PRIMARY KEY,
    fecha DATE NOT NULL,
    hora VARCHAR2(5) NOT NULL, -- Se usa VARCHAR2 en lugar de TIME
    servicio NUMBER NOT NULL,
    estado VARCHAR2(20) NOT NULL CHECK (estado IN ('DISPONIBLE', 'RESERVADO', 'PRESTADO')),
    id_ips VARCHAR2(50) NOT NULL,
    id_medico VARCHAR2(50),
    id_afiliado VARCHAR2(50),
    id_orden NUMBER,
    FOREIGN KEY (servicio) REFERENCES TipoServicio(id),
    FOREIGN KEY (id_ips) REFERENCES IPS(nit),
    FOREIGN KEY (id_medico) REFERENCES Medico(numero_documento),
    FOREIGN KEY (id_afiliado) REFERENCES Afiliado(numero_documento),
    FOREIGN KEY (id_orden) REFERENCES OrdenServicio(id)
);

