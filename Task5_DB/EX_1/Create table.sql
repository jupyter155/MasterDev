use masterdev_minhnx12;

CREATE TABLE student(
idStudent varchar(45) PRIMARY KEY ,
nameStudent varchar(45) NOT NULL
);

CREATE TABLE subject(
idSubject varchar(45) PRIMARY KEY,
nameSubject varchar(45) NOT NULL
);

CREATE TABLE teacher(
idTeacher varchar(45) PRIMARY KEY,
nameTeacher varchar(45) NOT NULL,
idSubject varchar(45)
);

CREATE TABLE class(
idClass varchar(45) PRIMARY KEY ,
nameClass varchar(45) NOT NULL,
idTeacher varchar(45),
idSubject varchar(45)
);

CREATE TABLE class_student(
idClass varchar(45) NOT NULL,
idStudent varchar(45) NOT NULL,
idSubject varchar(45) NOT NULL,
mark float(2) NOT NULL,
PRIMARY KEY(idClass,
idStudent)
);