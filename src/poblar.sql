--EPS
INSERT INTO EPS (id, nombre) VALUES ('EPS001', 'SaludTotal');
INSERT INTO EPS (id, nombre) VALUES ('EPS002', 'Sanitas');


--IPS
INSERT INTO IPS (nit, nombre, direccion, telefono, id_eps) VALUES ('NIT001', 'Clínica del Norte', 'Calle 123 #45-67', 1234567, 'EPS001');
INSERT INTO IPS (nit, nombre, direccion, telefono, id_eps) VALUES ('NIT002', 'Hospital Central', 'Avenida 89 #12-34', 7654321, 'EPS002');

--tipo servicio
INSERT INTO TipoServicio (id,nombre) VALUES (1,'Consulta General');
INSERT INTO TipoServicio (id, nombre) VALUES (2,'Radiología');


--IPS-TipoServicio
INSERT INTO IPS_TipoServicio (id_ips, id_servicio) VALUES ('NIT001', 1);
INSERT INTO IPS_TipoServicio (id_ips, id_servicio) VALUES ('NIT002', 2);

--afiliado
INSERT INTO Afiliado (numero_documento, nombre, tipo_documento, tipo_afiliado, id_eps) 
VALUES ('CC1001', 'Juan Pérez', 'CEDULA', 'CONTRIBUYENTE', 'EPS001');

INSERT INTO Afiliado (numero_documento, nombre, tipo_documento, tipo_afiliado, id_eps) 
VALUES ('CC1002', 'Ana Gómez', 'CEDULA', 'BENEFICIARIO', 'EPS002');

INSERT INTO Afiliado (numero_documento, nombre, tipo_documento, tipo_afiliado, id_eps) 
VALUES ('CC1003', 'Juana Gómez', 'CEDULA', 'BENEFICIARIO', 'EPS002');
--beneficiario
INSERT INTO Beneficiario (numero_documento, parentesco, contribuyente_asociado) 
VALUES ('CC1002', 'Hija', 'CC1001');

INSERT INTO Beneficiario (numero_documento, parentesco, contribuyente_asociado) 
VALUES ('CC1003', 'Esposo', 'CC1001');

--medico
INSERT INTO Medico (numero_documento, nombre, tipo_documento, especialidad, registro_medico) 
VALUES ('MED001', 'Dr. Rodríguez', 'CEDULA', 'Pediatría', 'RM12345');

INSERT INTO Medico (numero_documento, nombre, tipo_documento, especialidad, registro_medico) 
VALUES ('MED002', 'Dra. Martínez', 'CEDULA', 'Radiología', 'RM67890');

--ips-medico
INSERT INTO IPS_Medico (id_ips, id_medico) VALUES ('NIT001', 'MED001');
INSERT INTO IPS_Medico (id_ips, id_medico) VALUES ('NIT002', 'MED002');

--OrdenServicio
INSERT INTO OrdenServicio (id,fecha, estado, servicio, id_afiliado, id_medico) 
VALUES (1,TO_DATE('2024-02-27', 'YYYY-MM-DD'), 'VIGENTE', 1, 'CC1001', 'MED001');

INSERT INTO OrdenServicio (id,fecha, estado, servicio, id_afiliado, id_medico) 
VALUES (2,TO_DATE('2024-02-28', 'YYYY-MM-DD'), 'COMPLETADA', 2, 'CC1002', 'MED002');


--PrestacionServicio
INSERT INTO PrestacionServicio (id, fecha, hora, servicio, estado, id_ips, id_medico, id_afiliado, id_orden) 
VALUES ('PS001', TO_DATE('2024-02-27', 'YYYY-MM-DD'), '10:00', 1, 'RESERVADO', 'NIT001', 'MED001', 'CC1001', 1);

INSERT INTO PrestacionServicio (id, fecha, hora, servicio, estado, id_ips, id_medico, id_afiliado, id_orden) 
VALUES ('PS002', TO_DATE('2024-02-28', 'YYYY-MM-DD'), '15:30', 2, 'PRESTADO', 'NIT002', 'MED002', 'CC1002', 2);


