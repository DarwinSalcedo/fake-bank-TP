/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Darwin
 * 
 */

public class sql {
    
}
/*create sequence CodigoTarjeta
minvalue 1
maxvalue 10000
increment by 1;

create table Clientes(ci int,
						nombre varchar,						
						contrasenia varchar,
						tipo int,
						primary key (ci));

create table Becados(ci_becados int primary key references Clientes (ci));

create table Tarjeta_Coordenadas(cod_tarjeta int,
									ci_cliente int references Clientes (ci),
									coordenadas varchar,
									primary key (cod_tarjeta));

create table Cuentas(nro_cuenta int,
						ci_cliente int references Clientes (ci),
						monto double precision,
						principal boolean,
						tipo_cuenta varchar,
						primary key (nro_cuenta));

create table Transferencias(nro_referencia varchar,
							nro_cuenta_origen int references Cuentas(nro_cuenta),
							nro_cuenta_destino int,
							monto_trans double precision,
							fecha date,
							primary key (nro_referencia));
							
create table Depositos(nro_referencia varchar,
							nro_cuenta_destino int,
							monto_trans double precision,
							fecha date,
							primary key (nro_referencia));
							
create table Retiros(nro_referencia varchar,
							nro_cuenta_origen int references Cuentas(nro_cuenta),
							monto_trans double precision,
							fecha date,
							primary key (nro_referencia));
							
create table Servicios(tipo int,
						nombre varchar,
						primary key (tipo));
							
create table Pagos(nro_referencia varchar,
							nro_cuenta_origen int references Cuentas(nro_cuenta),
							servicio int references Servicios(tipo), 
							monto_trans double precision,
							fecha date,
							primary key (nro_referencia));
*/							
/*
	--Borrar todas o algunas tablas
	
	 -- Se eliminan estas primero porque no tienen dependencias
	
	drop table Becados;
	drop table Tarjeta_Coordenadas;	
	drop table Transferencias;
	drop table Depositos;
	drop table Retiros;	
	drop table Pagos;
	
	-- Luego se eliminan estas en este orden
	
	drop table Servicios;
	drop table Cuentas;
	drop table Clientes;
        drop sequence CodigoTarjeta;
*/	


/*
	Selects de las diferentes tablas
	
	select * from Clientes;
	select * from Becados;
	select * from Tarjeta_Coordenadas;
	select * from Cuentas;
	select * from Tranferencias;
	select * from Depositos;
	select * from Retiros;
	select * from Servicios;
	select * from Pagos;
*/

/*
        insert into Clientes values(23638689,'Isaac Yriarte',1,12345);
        
*/