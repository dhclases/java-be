# Clases 11

## Instalacion de H2

    Enlace de jar y demas detalles de H2 
    
    - [H2 Database Engine](https://www.h2database.com/html/main.html)

## Conexiona Bases de Datos con JDBC

- Crear Tabla

"""

DROP TABLE IF EXISTS ANIMALES; 

CREATE TABLE ANIMALES 
 (  ID INT PRIMARY KEY,
    NOMBRE varchar(100) NOT NULL, 
    TIPO varchar(100) NOT NULL )


"""

- Insertar Registro

"""

INSERT INTO ANIMALES (ID, NOMBRE, TIPO) VALUES (1, 'Pancho', 'Perro')

INSERT INTO ANIMALES (ID, NOMBRE, TIPO) VALUES (2, 'Pillo', 'Gato')

INSERT INTO ANIMALES (ID, NOMBRE, TIPO) VALUES (3, 'Cepillo', 'Elefante')

INSERT INTO ANIMALES (ID, NOMBRE, TIPO) VALUES (4, 'Pepe', 'Perro')

INSERT INTO ANIMALES (ID, NOMBRE, TIPO) VALUES (5, 'Rolo', 'Caballo')

"""

- Eliminar tabla

"""

    DELETE FROM ANIMALES WHERE ID=2

"""
