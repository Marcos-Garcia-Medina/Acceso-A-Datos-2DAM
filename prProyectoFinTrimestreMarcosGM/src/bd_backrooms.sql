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
	/*ID de la entidad*/
    entityNum INT PRIMARY KEY,
	/*Nombre de la entidad*/
    entityName       VARCHAR(40) NOT NULL,
    /*Numero de la backroom*/
	backroomNum 	 INT NOT NULL,
    /*Peligrosidad de la backroom*/
    dangerousness    VARCHAR(40) NOT NULL,
    /*Descripcion de la backroom*/
    entityDesc 		 VARCHAR(40) NOT NULL
);

ALTER TABLE entitys ADD FOREIGN KEY (backroomNum) REFERENCES backrooms(levelNum);
SELECT * FROM entitys;