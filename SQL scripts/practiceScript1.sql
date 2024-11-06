CREATE DATABASE IF NOT EXISTS companyXYZ;

USE companyXYZ;

CREATE TABLE IF NOT EXISTS employee(id INT primary key, name VARCHAR(50), salary long);

SHOW TABLES;

INSERT INTO employee VALUES(1,"adam", 25000), (2,"bob", 30000), (3, "casey", 40000);

SELECT * FROM employee;

CREATE TABLE IF NOT EXISTS managers(
	id INT primary key, 
    office VARCHAR(50), 
    emp_id INT,
    FOREIGN KEY (emp_Id) REFERENCES employee(id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
    );
    
INSERT INTO managers
VALUE (101, "South-B", 2),
	(102, "North-A", 1);

SELECT * FROM employee AS e
INNER JOIN managers AS m
ON e.id = m.emp_id


