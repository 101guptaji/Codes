CREATE DATABASE IF NOT EXISTS db1;

create database if not exists db2;

SHOW databases;

DROP DATABASE IF EXISTS db1;

drop database if  exists db2;

CREATE DATABASE IF NOT EXISTS College;

USE College;

CREATE TABLE student(
	id INT PRIMARY KEY,
    NAME VARCHAR(50),
    age  INT NOT NULL);
    
Insert into student Values(1, "Hanni", 24);
Insert into student Values(2, "himanshu", 26);
INSERT INTO student VALUES(0, "ram", 30), (4, "Jitu", 28);

show tables;

Select * from student;

DROP TABLE IF EXISTS student;

CREATE TABLE student(
	rollno INT PRIMARY KEY,
    name VARCHAR(50),
    marks INT NOT NULL,
    grade VARCHAR(1),
    city VARCHAR(20)
    );
    
CREATE TABLE dept(
	id INT PRIMARY KEY,
    department VARCHAR(50)
    );
    
CREATE TABLE teacher(
	id INT PRIMARY KEY,
    name VARCHAR(50),
    dept_id INT,
    FOREIGN KEY (dept_id) REFERENCES dept(id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
    );
    
INSERT INTO student
	(rollno, name, marks, grade, city)
VALUES
	(101, "anil", 78, "C", "Pune"),
    (102, "bhumika", 93, "A", "Mumbai"),
    (103, "chetan", 85, "B", "Mumbai"),
    (104, "dhruv", 96, "A", "Delhi"),
    (105, "emanuel", 12, "F", "Delhi"),
    (106, "farah", 82, "B", "Delhi");

INSERT INTO dept 
VALUES (201, "English"),
	(202, "IT");

INSERT INTO teacher
VALUES (501, "Adam", 201),
	(502, "Bob", 202),
    (503, "Charles", 201);
    
SELECT * FROM student;

SELECT * FROM dept;

SELECT * FROM teacher;

SELECT DISTINCT city FROM student;

SELECT * FROM student WHERE marks >= 80;

SELECT * FROM student WHERE marks >= 80 AND city = "mumbai"; 

SELECT * FROM student WHERE marks BETWEEN 78 AND 85;

SELECT * FROM student WHERE city IN ("delhi", "mumbai");

SELECT * FROM student WHERE city NOT IN ("delhi", "mumbai");

SELECT * FROM student WHERE marks >= 80 LIMIT 3;

SELECT COUNT(rollno) FROM student;

SELECT MAX(marks) FROM student;

SELECT MIN(marks) FROM student;

SELECT SUM(marks) FROM student;

SELECT AVG(marks) FROM student;

SELECT * FROM student ORDER BY marks DESC LIMIT 3;

SELECT city, count(name) FROM student GROUP BY city; 

SELECT city, AVG(marks) FROM student GROUP BY city ORDER BY AVG(marks) DESC;

SELECT grade, COUNT(rollno) FROM student GROUP BY grade;

-- having clause --
SELECT city, count(rollno) FROM student GROUP BY city HAVING MAX(marks) > 90;

UPDATE student SET grade = "D" WHERE marks < 50;

-- To update a table entries, need to off safe update --
SET SQL_SAFE_UPDATES = 0;

DELETE FROM student WHERE marks < 30;

SELECT * FROM student;

SELECT * FROM dept;

SELECT * FROM teacher;

UPDATE dept SET id = 212 WHERE id = 202;

ALTER TABLE student ADD COLUMN age INT NOT NULL DEFAULT 20;

ALTER TABLE student MODIFY age VARCHAR(2);

ALTER TABLE student CHANGE age st_age INT; 

ALTER TABLE student DROP COLUMN st_age;

ALTER TABLE student RENAME TO studento;

ALTER TABLE studento RENAME TO student;

TRUNCATE TABLE student;  -- To delete all data of table--
SELECT * FROM student;

SELECT rollno, name FROM student
WHERE rollno % 2 = 0; 

SELECT  MAX(marks) FROM student
WHERE city = "Delhi";

CREATE OR REPLACE VIEW view1 AS
SELECT rollno, name, marks 
FROM student;

SELECT * FROM view1;

DROP VIEW view1;

