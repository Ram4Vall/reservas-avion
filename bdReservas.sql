DROP DATABASE IF EXISTS reservas_vuelos;

CREATE DATABASE reservas_vuelos CHARACTER SET utf8;

USE reservas_vuelos;

SET default_storage_engine=INNODB;

drop table if exists ciudad;
create table ciudad (
    id_ciudad   smallint(6) primary key NOT NULL AUTO_INCREMENT,
    nombre  varchar(30) NOT NULL,
    pais    varchar(30) NOT NULL
);

drop table if exists aeropuerto;
create table aeropuerto (
    cod_aeropuerto  char(3) primary key NOT NULL,#el código de aeropuertos es de 3 letras y no es único, pero como es un trabajo con fechas, no voy a hacer florituras.
    nombre  varchar(40) NOT NULL,
    categoria   integer NOT NULL,
    id_ciudad   smallint(6) NOT NULL
);

drop table if exists aerolinea;
create table aerolinea (
    cod_aerolinea   char(3) primary key NOT NULL,#lo mismo que arriba
    nombre  varchar(20) NOT NULL 
);

drop table if exists vuelo_generico;
create table vuelo_generico (
    num_vuelo   smallint(6) primary key NOT NULL AUTO_INCREMENT,
    hora_salida char(5) NOT NULL,
    hora_llegada char(5) NOT NULL,
    precio  float(6,2) NOT NULL,
    capacidad   integer NOT NULL,
    cod_aerolinea char(3),
    cod_aeropuerto_salida char(3) NOT NULL,
    cod_aeropuerto_llegada char(3) NOT NULL
);

drop table if exists vuelo;
create table vuelo (
    id_vuelo   smallint(6) primary key NOT NULL AUTO_INCREMENT,
    fecha char(8) NOT NULL,
    plazas_libres   integer NOT NULL,
    num_vuelo   smallint(6) NOT NULL
);


drop table if exists reserva;
create table reserva (
    num_reserva smallint(6) primary key NOT NULL AUTO_INCREMENT,
    nombre  varchar(30) NOT NULL,
    apellidos   varchar(40) NOT NULL,
    telefono    char(9) NOT NULL,
    tarjeta char(16) NOT NULL,
    importe float(6,2) NOT NULL,
    id_vuelo smallint(6) NOT NULL

);

ALTER TABLE aeropuerto 
ADD CONSTRAINT fk_ciudad_aeropuerto
FOREIGN KEY (id_ciudad)
REFERENCES ciudad(id_ciudad);

ALTER TABLE vuelo_generico 
ADD CONSTRAINT fk_aerolinea_vueGenerico
FOREIGN KEY (cod_aerolinea)
REFERENCES aerolinea(cod_aerolinea);

ALTER TABLE vuelo_generico 
ADD CONSTRAINT fk_aeropuerto_vueGenerico_salida
FOREIGN KEY (cod_aeropuerto_salida)
REFERENCES aeropuerto(cod_aeropuerto);

ALTER TABLE vuelo_generico 
ADD CONSTRAINT fk_aeropuerto_vueGenerico_llegada
FOREIGN KEY (cod_aeropuerto_llegada)
REFERENCES aeropuerto(cod_aeropuerto);

ALTER TABLE vuelo
ADD CONSTRAINT fk_vueGenerico_vuelo
FOREIGN KEY (num_vuelo)
REFERENCES vuelo_generico(num_vuelo);


ALTER TABLE reserva
ADD CONSTRAINT fk_vuelo_reserva
FOREIGN KEY (id_vuelo)
REFERENCES vuelo(id_vuelo);

insert into ciudad (nombre, pais) values('Tenerife', 'España');
insert into ciudad (nombre, pais) values('Madrid', 'España');
insert into ciudad (nombre, pais) values('Londres', 'Inglaterra');
insert into ciudad (nombre, pais) values('Tokio', 'Japón');
insert into ciudad (nombre, pais) values('Buenos Aires', 'Argentina');
insert into ciudad (nombre, pais) values('Lima', 'Perú');
insert into ciudad (nombre, pais) values('Cochabamba', 'Bolivia');
insert into ciudad (nombre, pais) values('París', 'Francia');
insert into ciudad (nombre, pais) values('Frankfurt', 'Alemania');
insert into ciudad (nombre, pais) values('Roma', 'Italia');
insert into ciudad (nombre, pais) values('Toronto', 'Canadá');
insert into ciudad (nombre, pais) values('Cancún', 'México');
insert into ciudad (nombre, pais) values('Dubái', 'Emiratos Árabes');
insert into ciudad (nombre, pais) values('Pekín', 'China');
insert into ciudad (nombre, pais) values('Ciudad del Cabo', 'Sudáfrica');
insert into ciudad (nombre, pais) values('Johannesburgo', 'Sudáfrica');
insert into ciudad (nombre, pais) values('Sharm el-Sheij', 'Egipto');
insert into ciudad (nombre, pais) values('Sidney', 'Australia');
insert into ciudad (nombre, pais) values('Melbourne', 'Australia');
insert into ciudad (nombre, pais) values('Auckland', 'Nueva Zelanda');
insert into ciudad (nombre, pais) values('Praga', 'República Checa');


insert into aeropuerto (cod_aeropuerto, nombre, categoria, id_ciudad) 
values('TFN', 'Tenerife Norte', 3, 1);
insert into aeropuerto (cod_aeropuerto, nombre, categoria, id_ciudad) 
values('TFS', 'Tenerife Sur', 3, 1);
insert into aeropuerto (cod_aeropuerto, nombre, categoria, id_ciudad) 
values('LCY', 'Ciudad de Londres', 2, 3);
insert into aeropuerto (cod_aeropuerto, nombre, categoria, id_ciudad) 
values('MAD', 'Madrid Barajas', 2, 2);
insert into aeropuerto (cod_aeropuerto, nombre, categoria, id_ciudad) 
values('HND', 'AI de Tokio', 3, 4);
insert into aeropuerto (cod_aeropuerto, nombre, categoria, id_ciudad) 
values('EZE', 'AI Ministro Pistarini de Ezeiza', 3, 5);
insert into aeropuerto (cod_aeropuerto, nombre, categoria, id_ciudad) 
values('LIM', 'AI Jorge Chávez', 2, 6);
insert into aeropuerto (cod_aeropuerto, nombre, categoria, id_ciudad) 
values('CBB', 'AI Jorge Wilstermann', 2, 7);
insert into aeropuerto (cod_aeropuerto, nombre, categoria, id_ciudad) 
values('CDG', 'Aeropuerto París-Charles de Gaulle', 2, 8);
insert into aeropuerto (cod_aeropuerto, nombre, categoria, id_ciudad) 
values('FRA', 'Aeropuerto de Frankfurt', 3, 9);
insert into aeropuerto (cod_aeropuerto, nombre, categoria, id_ciudad) 
values('FCO', 'Aeropuerto de Roma-Fiumicino', 3, 10);
insert into aeropuerto (cod_aeropuerto, nombre, categoria, id_ciudad) 
values('YYZ', 'AI Toronto Pearson', 3, 11);
insert into aeropuerto (cod_aeropuerto, nombre, categoria, id_ciudad) 
values('CUN', 'Aeropuerto Internacional de Cancún', 3, 12);
insert into aeropuerto (cod_aeropuerto, nombre, categoria, id_ciudad) 
values('DXB', 'Aeropuerto Internacional de Dubái', 3, 13);
insert into aeropuerto (cod_aeropuerto, nombre, categoria, id_ciudad) 
values('PEK', 'Aeropuerto Internacional de Pekín', 3, 14);
insert into aeropuerto (cod_aeropuerto, nombre, categoria, id_ciudad) 
values('CPT', 'AI de la Ciudad del Cabo', 3, 15);
insert into aeropuerto (cod_aeropuerto, nombre, categoria, id_ciudad) 
values('JNB', 'Aeropuerto de Johannesburgo', 2, 16);
insert into aeropuerto (cod_aeropuerto, nombre, categoria, id_ciudad) 
values('SSH', 'AI de Sharm el-Sheij', 3, 17);
insert into aeropuerto (cod_aeropuerto, nombre, categoria, id_ciudad) 
values('SYD', 'Aeropuerto de Sídney', 3, 18);
insert into aeropuerto (cod_aeropuerto, nombre, categoria, id_ciudad) 
values('MEL', 'Aeropuerto de Melbourne', 3, 19);
insert into aeropuerto (cod_aeropuerto, nombre, categoria, id_ciudad) 
values('AKL', 'Aeropuerto Internacional de Auckland', 3, 20);
insert into aeropuerto (cod_aeropuerto, nombre, categoria, id_ciudad) 
values('PRG', 'Aeropuerto Internacional de Praga', 3, 21);


insert into aerolinea (cod_aerolinea, nombre) values('PMI', 'Air Europa');
insert into aerolinea (cod_aerolinea, nombre) values('IBE', 'Iberia');
insert into aerolinea (cod_aerolinea, nombre) values('WGP', 'Grand Prix');
insert into aerolinea (cod_aerolinea, nombre) values('AAL', 'Américan Airlines');
insert into aerolinea (cod_aerolinea, nombre) values('AMX', 'Aeroméxico');
insert into aerolinea (cod_aerolinea, nombre) values('BER', 'Air Berlin');
insert into aerolinea (cod_aerolinea, nombre) values('UAE', 'Emirates');
insert into aerolinea (cod_aerolinea, nombre) values('QTR', 'Qatar Airways');
insert into aerolinea (cod_aerolinea, nombre) values('VLG', 'Vueling Airlines');
insert into aerolinea (cod_aerolinea, nombre) values('RYR', 'Ryanair');
insert into aerolinea (cod_aerolinea, nombre) values('LAN', 'LAN Airlines');


insert into vuelo_generico (hora_salida, hora_llegada, precio, 
capacidad, cod_aerolinea, cod_aeropuerto_salida, cod_aeropuerto_llegada)
values('14:00', '16:00', 75.50, 80, 'PMI', 'TFN', 'MAD');
insert into vuelo_generico (hora_salida, hora_llegada, precio, 
capacidad, cod_aerolinea, cod_aeropuerto_salida, cod_aeropuerto_llegada)
values('17:00', '19:00', 105.00, 100, 'WGP', 'MAD', 'LCY');
insert into vuelo_generico (hora_salida, hora_llegada, precio, 
capacidad, cod_aerolinea, cod_aeropuerto_salida, cod_aeropuerto_llegada)
values('11:00', '18:00', 725.00, 120, 'AAL', 'HND', 'EZE');
insert into vuelo_generico (hora_salida, hora_llegada, precio, 
capacidad, cod_aerolinea, cod_aeropuerto_salida, cod_aeropuerto_llegada)
values('07:00', '09:00', 308.00, 70, 'VLG', 'CBB', 'LIM');
insert into vuelo_generico (hora_salida, hora_llegada, precio, 
capacidad, cod_aerolinea, cod_aeropuerto_salida, cod_aeropuerto_llegada)
values('02:00', '06:00', 262.00, 100, 'BER', 'CDG', 'FRA');
insert into vuelo_generico (hora_salida, hora_llegada, precio, 
capacidad, cod_aerolinea, cod_aeropuerto_salida, cod_aeropuerto_llegada)
values('00:00', '10:00', 1002.00, 150, 'UAE', 'FCO', 'YYZ');
insert into vuelo_generico (hora_salida, hora_llegada, precio, 
capacidad, cod_aerolinea, cod_aeropuerto_salida, cod_aeropuerto_llegada)
values('15:00', '23:30', 1598.00, 120, 'AMX', 'CUN', 'DXB');
insert into vuelo_generico (hora_salida, hora_llegada, precio, 
capacidad, cod_aerolinea, cod_aeropuerto_salida, cod_aeropuerto_llegada)
values('10:00', '20:10', 643.00, 110, 'QTR', 'CPT', 'PEK');
insert into vuelo_generico (hora_salida, hora_llegada, precio, 
capacidad, cod_aerolinea, cod_aeropuerto_salida, cod_aeropuerto_llegada)
values('01:00', '06:00', 522.00, 100, 'VLG', 'JNB', 'SSH');
insert into vuelo_generico (hora_salida, hora_llegada, precio, 
capacidad, cod_aerolinea, cod_aeropuerto_salida, cod_aeropuerto_llegada)
values('11:00', '14:00', 277.00, 100, 'AAL', 'SYD', 'AKL');
insert into vuelo_generico (hora_salida, hora_llegada, precio, 
capacidad, cod_aerolinea, cod_aeropuerto_salida, cod_aeropuerto_llegada)
values('12:00', '19:00', 759.00, 80, 'UAE', 'MEL', 'PRG');
insert into vuelo_generico (hora_salida, hora_llegada, precio, 
capacidad, cod_aerolinea, cod_aeropuerto_salida, cod_aeropuerto_llegada)
values('10:00', '22:30', 599.99, 160, 'IBE', 'TFS', 'HND');
insert into vuelo_generico (hora_salida, hora_llegada, precio, 
capacidad, cod_aerolinea, cod_aeropuerto_salida, cod_aeropuerto_llegada)
values('05:00', '11:50', 299.95, 80, 'RYR', 'TFS', 'PRG');


insert into vuelo (fecha, plazas_libres, num_vuelo) values('20/01/17', 40, 1);
insert into vuelo (fecha, plazas_libres, num_vuelo) values('21/01/17', 20, 2);
insert into vuelo (fecha, plazas_libres, num_vuelo) values('05/02/17', 100, 3);
insert into vuelo (fecha, plazas_libres, num_vuelo) values('12/01/17', 70, 4);
insert into vuelo (fecha, plazas_libres, num_vuelo) values('01/02/17', 35, 5);
insert into vuelo (fecha, plazas_libres, num_vuelo) values('29/01/17', 63, 6);
insert into vuelo (fecha, plazas_libres, num_vuelo) values('09/02/17', 126, 7);
insert into vuelo (fecha, plazas_libres, num_vuelo) values('24/05/17', 112, 8);
insert into vuelo (fecha, plazas_libres, num_vuelo) values('16/04/17', 12, 9);
insert into vuelo (fecha, plazas_libres, num_vuelo) values('16/04/17', 26, 10);
insert into vuelo (fecha, plazas_libres, num_vuelo) values('12/01/17', 57, 11);
insert into vuelo (fecha, plazas_libres, num_vuelo) values('01/02/17', 159, 12);
insert into vuelo (fecha, plazas_libres, num_vuelo) values('20/03/17', 33, 13);


insert into reserva (nombre, apellidos, telefono, tarjeta, importe, id_vuelo) 
values('Prueba', 'Prueba de la Prueba', '922346413', '1234567890123456', 151, 1);
insert into reserva (nombre, apellidos, telefono, tarjeta, importe, id_vuelo) 
values('Prueba Segundo', 'Prueba de la Prueba', '923456413', '5643567890123456', 420, 2);
