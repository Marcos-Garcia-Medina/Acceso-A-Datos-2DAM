use bd_backrooms;

CREATE TABLE backrooms (
	/*Numero de Backroom*/
    levelNum         INT PRIMARY KEY,
    /*Nombre de Backroom*/
	backroomName 	 VARCHAR(40) UNIQUE NOT NULL,
    /*Numero de entidades en la backroom*/
    entitysNum       INT NOT NULL,
    /*Dificultad de la backroom*/
    difficulty		 VARCHAR(40) NOT NULL
);

CREATE TABLE entitys (
	/*Nombre de la entidad*/
    entityName       VARCHAR(40) PRIMARY KEY,
    /*Numero de la backroom*/
	backroomNum 	 INT NOT NULL,
    /*Peligrosidad de la backroom*/
    dangerousness    VARCHAR(40) NOT NULL,
    /*Descripcion de la backroom*/
    entityDesc 		 VARCHAR(40) NOT NULL
);

SELECT * FROM entitys;