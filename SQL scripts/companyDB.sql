SHOW DATABASES;

#USE school;
SELECT user();

SELECT @@port;

CREATE DATABASE IF NOT EXISTS Company;

USE Company;
CREATE TABLE employee(
	id INT PRIMARY KEY,
    name VARCHAR(50),
    salary  INT);
    
INSERT INTO employee Values(1, "Adam", 25000);
INSERT INTO employee Values(2, "Bob", 30000);
INSERT INTO employee VALUES(3, "Charles", 25640);

DESC employee;

SELECT * FROM employee;
