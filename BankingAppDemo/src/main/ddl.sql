/* Create tables */
CREATE TABLE CUSTOMERS (
	id integer primary key,
	name varchar2(50),
	username varchar2(50) not null,
	pass varchar2(50) not null,
	balance number,
	active integer
);

/* each column is defined with [name] [type] [constraint] [constraint] */

CREATE TABLE EMPLOYEES (
	id integer primary key,
	username varchar2(50),
	pass varchar2(50)

);

/* Create foreign keys with alter command */
--ALTER TABLE EMPLOYEES ADD CONSTRAINT FKAnimals
--FOREIGN KEY (animal)
--REFERENCES CUSTOMERS (id)
--ON DELETE CASCADE;
