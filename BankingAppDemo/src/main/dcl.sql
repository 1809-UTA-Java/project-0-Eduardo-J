/* Drop database and user if it exists */
DROP USER bank CASCADE;

/* Create database and user */
CREATE USER bank
IDENTIFIED BY password
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

/* Grant permissions to user */
GRANT connect to bank;
GRANT resource to bank;
GRANT create session to bank;
GRANT create table to bank;
GRANT create view to bank;

