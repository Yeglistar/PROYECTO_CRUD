CREATE TABLE Alumnos(
id SERIAL not null primary key,
	nombres varchar(50),
	apellidos varchar(50)
);

INSERT INTO Alumnos (nombres, apellidos) values ('Lohisbell', 'Diaz');

SELECT * FROM Alumnos;

UPDATE Alumnos SET nombres='Yeglimar', apellidos='Montanez' WHERE Alumnos.id=1;

DELETE FROM Alumnos WHERE Alumnos.id=2;