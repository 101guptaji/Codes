CREATE DATABASE eCommerce;

USE eCommerce;

CREATE TABLE Customers (
	CustomerID INT PRIMARY KEY,
    CustomerName VARCHAR(50));
    
CREATE TABLE Orders(
	OrderID INT PRIMARY KEY,
    CustomerID INT,
    Product VARCHAR(100),
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
    ON UPDATE CASCADE
    ON DELETE CASCADE);
    
SELECT * FROM Customers;
SELECT * FROM Orders;

INSERT INTO Customers
VALUES (1, "Alice"),  (2, "Bob"), (3, "Carol"), (4, "Danny");

INSERT INTO Orders
VALUES (101, 1, "Laptop"),  
	(102, 3, "Smartphone"),  
    (103, 2, "Headphone"),
	(104, null, "Watch");
    
SELECT c.CustomerName, o.Product 
	FROM Customers AS c
	INNER JOIN Orders AS o
	ON c.CustomerID = o.CustomerID;
    
SELECT c.CustomerName, o.Product 
	FROM Customers AS c
	LEFT JOIN Orders AS o
	ON c.CustomerID = o.CustomerID;
 
SELECT c.CustomerName, o.Product 
	FROM Customers AS c
	RIGHT JOIN Orders AS o
	ON c.CustomerID = o.CustomerID;
    
SELECT c.CustomerName, o.Product 
	FROM Customers AS c
	JOIN Orders AS o
	ON c.CustomerID = o.CustomerID;

SELECT c.CustomerName, o.Product 
	FROM Customers AS c
	LEFT JOIN Orders AS o
	ON c.CustomerID = o.CustomerID
	UNION    
	SELECT c.CustomerName, o.Product 
	FROM Customers AS c
	RIGHT JOIN Orders AS o
	ON c.CustomerID = o.CustomerID;
    
-- Left  Exclusive Join --
SELECT c.CustomerName, o.Product 
	FROM Customers AS c
	LEFT JOIN Orders AS o
	ON c.CustomerID = o.CustomerID
	WHERE  o.CustomerID IS NULL;
    
-- Cross Join --
SELECT c.CustomerName, o.Product 
	FROM Customers AS c
	CROSS JOIN Orders AS o;
    
-- Self Join -- 
SELECT c.CustomerName, o.Product 
	FROM Customers AS c
	JOIN Orders AS o
	ON c.CustomerID = o.CustomerID;
    
CREATE TABLE Staff(
	id INT PRIMARY KEY,
    staffName VARCHAR(50));
    
INSERT INTO Staff
VALUES (1,"Sohan"), (2,"Rahul");

SELECT CustomerName FROM Customers
UNION
SELECT staffName FROM staff;