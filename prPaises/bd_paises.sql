use bd_paises;

CREATE TABLE continentes(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(30) UNIQUE NOT NULL,
    poblacion INT NOT NULL
);

CREATE TABLE paises(
	id INT PRIMARY KEY AUTO_INCREMENT,
     nombre VARCHAR(40) NOT NULL,
     poblacion INT NOT NULL,
     jefe_Estado VARCHAR(60),
     continente_id INT NOT NULL,
     CONSTRAINT pais_continente_fk FOREIGN KEY (continente_id) REFERENCES continentes(id)
);