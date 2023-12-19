-- SELECT CURRENT_DATE ;
-- SELECT CURRENT_TIMESTAMP;


/*
	WISH LIST "LISTA DE DESEOS"
*/
------------------------------------------------------

DROP TABLE cliente
/*CREATE TABLE cliente (
	id_cliente bigint          PRIMARY KEY,
	nombre     VARCHAR ( 250 ) NOT NULL
);*/

INSERT INTO cliente (id_cliente, nombre) 
	VALUES (1013, 'carvajal crvjl');

--
------------------------------------------------------

DROP TABLE cuenta
/*CREATE TABLE cuenta (
	id_cuenta    serial          PRIMARY KEY,
	correo       VARCHAR ( 255 ) UNIQUE NOT NULL,
	contrasena   VARCHAR ( 50 )  NOT NULL,	
	creado_en    DATE            NOT NULL,
    ultimo_login TIMESTAMP       NULL,
	id_cliente   bigint          NOT NULL,
	FOREIGN KEY (id_cliente)
      REFERENCES cliente (id_cliente)
);*/

INSERT INTO cuenta (correo, contrasena, creado_en, ultimo_login, cliente_id_cliente) 
	VALUES ('carvajal@carvajal.com', 'c1', CURRENT_DATE, CURRENT_TIMESTAMP, 1013);

--
------------------------------------------------------

DROP TABLE producto
DELETE FROM producto
/*CREATE TABLE producto (
	id_producto    serial          PRIMARY KEY,
	nombre         VARCHAR ( 250 ) NOT NULL,
	precio         bigint          NOT NULL,  --money
	cantidad_stock int             NOT NULL,
	url_imagen     text            NOT NULL,
);*/

INSERT INTO producto (nombre, precio, cantidad_stock, url_imagen) 
	VALUES ('Xbox Series X', 2750000, 9, 'https://generacionxbox.com/wp-content/uploads/2021/03/Xbox-Series-X-personalizadageneracionxbox.jpg'),
		   ('Play Station 5', 3000000, 7, 'https://cdn.computerhoy.com/sites/navi.axelspringer.es/public/styles/1200/public/media/image/2020/11/analisis-ps5-computerhoy-2140441.jpg?itok=3O0gb1ee'), 
		   ('Nintendo Switch ', 1200000, 5, 'https://areajugones.sport.es/wp-content/uploads/2020/05/nintendo-switch.jpg'),
		   ('Wii', 1432000, 3, 'https://i2.wp.com/codigoespagueti.com/wp-content/uploads/2021/11/Nintendo-Wii-15-anos-consola-1.jpg?fit=1280%2C720&quality=80&ssl=1'), 
		   ('Atari 2600', 180000, 1, 'https://i0.wp.com/hipertextual.com/wp-content/uploads/2015/02/atari-2600.jpg?resize=1000%2C667&ssl=1');

--
------------------------------------------------------

--PARA "WISH_LIST" CRUD
DROP TABLE lista_deseo
/*CREATE TABLE lista_deseo (
	id_lista_deseo SERIAL  PRIMARY KEY,
	fecha          DATE    NOT NULL,
	me_gusta       BOOLEAN NOT NULL DEFAULT FALSE,
	id_producto    int     NOT NULL,
	id_cliente     bigint  NOT NULL,
	FOREIGN KEY (id_producto)
      REFERENCES producto (id_producto),
	FOREIGN KEY (id_cliente)
      REFERENCES cliente (id_cliente)
);*/

INSERT INTO public.lista_deseo(
	fecha, me_gusta, cliente_id_cliente, producto_id_producto)
	VALUES ('2022-01-13', true, 1013, 1)
	      ,('2022-01-13', true, 1013, 2);

--
------------------------------------------------------

--not references "historial de lista de deseos"
DROP TABLE record_wishlist
/*CREATE TABLE record_wishlist (
	id_record_wish   SERIAL        PRIMARY KEY,
	nombre_cliente   varchar(255)  NOT NULL,
	nombre_producto  varchar(255)  NOT NULL,
	me_gusta         BOOLEAN       NOT NULL DEFAULT FALSE,
	fecha            timestamp     DEFAULT CURRENT_TIMESTAMP
);*/

--
------------------------------------------------------
SELECT* FROM cliente;
SELECT* FROM cuenta;
SELECT* FROM producto;
SELECT* FROM lista_deseo;
SELECT* FROM record_wishlist;
------------------------------------------------------

INSERT INTO cliente (id_cliente, nombre) 
	VALUES (1013, 'carvajal crvjl');
	
INSERT INTO cuenta (correo, contrasena, creado_en, ultimo_login, cliente_id_cliente) 
	VALUES ('carvajal@carvajal.com', 'c1', CURRENT_DATE, CURRENT_TIMESTAMP, 1013);
	
INSERT INTO producto (nombre, precio, cantidad_stock, url_imagen) 
	VALUES ('Xbox Series X', 2750000, 9, 'https://generacionxbox.com/wp-content/uploads/2021/03/Xbox-Series-X-personalizadageneracionxbox.jpg'),
		   ('Play Station 5', 3000000, 7, 'https://cdn.computerhoy.com/sites/navi.axelspringer.es/public/styles/1200/public/media/image/2020/11/analisis-ps5-computerhoy-2140441.jpg?itok=3O0gb1ee'), 
		   ('Nintendo Switch ', 1200000, 5, 'https://areajugones.sport.es/wp-content/uploads/2020/05/nintendo-switch.jpg'),
		   ('Wii', 1432000, 3, 'https://i2.wp.com/codigoespagueti.com/wp-content/uploads/2021/11/Nintendo-Wii-15-anos-consola-1.jpg?fit=1280%2C720&quality=80&ssl=1'), 
		   ('Atari 2600', 180000, 1, 'https://i0.wp.com/hipertextual.com/wp-content/uploads/2015/02/atari-2600.jpg?resize=1000%2C667&ssl=1');


		  
		  
		  
		  