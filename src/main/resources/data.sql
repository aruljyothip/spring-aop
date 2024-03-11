create table person(
id integer not null,
name varchar(255) not null,
location varchar(255),
birthdate timestamp,
primary key(id)
);

INSERT INTO PERSON
(ID, NAME, LOCATION, BIRTHDATE)
values (1,'Arul', 'Coimbatore', '1999-07-01');

INSERT INTO PERSON
(ID, NAME, LOCATION, BIRTHDATE)
values (2,'Omar', 'Chennai', '1998-12-06');

INSERT INTO PERSON
(ID, NAME, LOCATION, BIRTHDATE)
values (3,'Ankit', 'Delhi', '1989-05-18');

INSERT INTO PERSON
(ID, NAME, LOCATION, BIRTHDATE)
values (4,'Sunny', 'Pune', '1990-01-08');

SELECT * from PERSON