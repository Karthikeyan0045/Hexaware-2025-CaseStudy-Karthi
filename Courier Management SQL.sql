	create database cour;
	use cour;
	create table User  (
		UserID INT PRIMARY KEY,  
		Name VARCHAR(255),  
		Email VARCHAR(255) UNIQUE,  
		Password VARCHAR(255),  
		ContactNumber VARCHAR(20),  
		Address TEXT  
	);  
	create table Courier  (
		CourierID INT PRIMARY KEY,  
		SenderName VARCHAR(255),  
		SenderAddress TEXT,  
		ReceiverName VARCHAR(255),  
		ReceiverAddress TEXT,  
		Weight DECIMAL(5, 2),  
		Status VARCHAR(50),  
		TrackingNumber VARCHAR(20) UNIQUE,  
		DeliveryDate DATE);  
	create table CourierServices(
		ServiceID INT PRIMARY KEY,  
		ServiceName VARCHAR(100),  
		Cost DECIMAL(8, 2));  
	create table Employee(
		EmployeeID INT PRIMARY KEY,  
		Name VARCHAR(255),  
		Email VARCHAR(255) UNIQUE,  
		ContactNumber VARCHAR(20),  
		Role VARCHAR(50),  
		Salary DECIMAL(10, 2));  
	create table Location(
		LocationID INT PRIMARY KEY,  
		LocationName VARCHAR(100),  
		Address TEXT);  
	create table Payment(
		PaymentID INT PRIMARY KEY,  
		CourierID INT,  
		LocationId INT,  
		Amount DECIMAL(10, 2),  
		PaymentDate DATE,  
		FOREIGN KEY (CourierID) REFERENCES Courier(CourierID),  
		FOREIGN KEY (LocationID) REFERENCES Location(LocationID)); 

INSERT INTO User (UserID, Name, Email, Password, ContactNumber, Address) VALUES
(1, 'Divya Nair', 'divya.nair@email.com', 'secure123', '+919876123450', '15, Park Street, Kochi, Kerala'),
(2, 'Manish Sharma', 'manish.sharma@email.com', 'pass456', '+918765987651', '22, MG Road, Jaipur, Rajasthan'),
(3, 'Sneha Kapoor', 'sneha.kapoor@email.com', 'strong789', '+917654123452', '30, Anna Salai, Chennai, Tamil Nadu'),
(4, 'Ravi Singh', 'ravi.singh@email.com', 'myPass00', '+916543987653', '45, Ring Road, Delhi'),
(5, 'Asha Reddy', 'asha.reddy@email.com', 'reddy1234', '+915432123454', '58, Jubilee Hills, Hyderabad, Telangana'),
(6, 'Vikram Menon', 'vikram.menon@email.com', 'menon5678', '+914321987655', '62, Church Street, Bangalore, Karnataka'),
(7, 'Pooja Joshi', 'pooja.joshi@email.com', 'joshi9012', '+913210123456', '70, Mall Road, Shimla, Himachal Pradesh'),
(8, 'Gaurav Patel', 'gaurav.patel@email.com', 'patel3456', '+912109987657', '88, FC Road, Pune, Maharashtra'),
(9, 'Anjali Verma', 'anjali.verma@email.com', 'verma7890', '+911098123458', '95, Park Street, Kolkata, West Bengal'),
(10, 'Karthik Kumar', 'karthik.kumar@email.com', 'kumar1111', '+919988987659', '100, Brigade Road, Bangalore, Karnataka');

INSERT INTO Courier (CourierID, SenderName, SenderAddress, ReceiverName, ReceiverAddress, Weight, Status, TrackingNumber, DeliveryDate) VALUES
(1, 'Divya Nair', '15, Park Street, Kochi, Kerala', 'Manish Sharma', '22, MG Road, Jaipur, Rajasthan', 3.50, 'In Transit', 'TN1234567891', '2023-12-11'),
(2, 'Sneha Kapoor', '30, Anna Salai, Chennai, Tamil Nadu', 'Ravi Singh', '45, Ring Road, Delhi', 6.75, 'Delivered', 'DL9876543211', '2023-12-13'),
(3, 'Asha Reddy', '58, Jubilee Hills, Hyderabad, Telangana', 'Vikram Menon', '62, Church Street, Bangalore, Karnataka', 2.20, 'Pending', 'KL5678901235', '2023-12-16'),
(4, 'Vikram Menon', '62, Church Street, Bangalore, Karnataka', 'Pooja Joshi', '70, Mall Road, Shimla, Himachal Pradesh', 4.00, 'In Transit', 'HP1234987651', '2023-12-19'),
(5, 'Pooja Joshi', '70, Mall Road, Shimla, Himachal Pradesh', 'Gaurav Patel', '88, FC Road, Pune, Maharashtra', 8.00, 'Delivered', 'RJ0987123457', '2023-12-21'),
(6, 'Gaurav Patel', '88, FC Road, Pune, Maharashtra', 'Anjali Verma', '95, Park Street, Kolkata, West Bengal', 5.80, 'Pending', 'WB6543219871', '2023-12-23'),
(7, 'Anjali Verma', '95, Park Street, Kolkata, West Bengal', 'Karthik Kumar', '100, Brigade Road, Bangalore, Karnataka', 3.10, 'In Transit', 'MH3210987655', '2023-12-25'),
(8, 'Karthik Kumar', '100, Brigade Road, Bangalore, Karnataka', 'Divya Nair', '15, Park Street, Kochi, Kerala', 7.30, 'Delivered', 'KA7890123457', '2023-12-27'),
(9, 'Manish Sharma', '22, MG Road, Jaipur, Rajasthan', 'Sneha Kapoor', '30, Anna Salai, Chennai, Tamil Nadu', 2.80, 'Pending', 'TN1029384757', '2023-12-29'),
(10, 'Ravi Singh', '45, Ring Road, Delhi', 'Asha Reddy', '58, Jubilee Hills, Hyderabad, Telangana', 9.20, 'In Transit', 'AP6574839202', '2023-12-31');

INSERT INTO CourierServices (ServiceID, ServiceName, Cost) VALUES
(1, 'Standard', 200.00),
(2, 'Express', 400.00),
(3, 'SameDay', 600.00),
(4, 'Intl', 1500.00),
(5, 'Heavy', 500.00),
(6, 'Docs', 150.00),
(7, 'Fragile', 300.00),
(8, 'Rural', 250.00),
(9, 'Overnight', 450.00),
(10, 'Bulk', 900.00);

INSERT INTO Employee (EmployeeID, Name, Email, ContactNumber, Role, Salary) VALUES
(1, 'Rajesh Kumar', 'rajesh.kumar@email.com', '+919911223355', 'Manager', 60000.00),
(2, 'Seema Kumari', 'seema.kumari@email.com', '+918877665555', 'Supervisor', 40000.00),
(3, 'Mahesh Nair', 'mahesh.nair@email.com', '+917766554444', 'Driver', 30000.00),
(4, 'Deepa Desai', 'deepa.desai@email.com', '+916655443333', 'Customer', 33000.00),
(5, 'Ajay Singh', 'ajay.singh@email.com', '+915544332222', 'Warehouse', 25000.00),
(6, 'John Doe', 'rekha.rao@email.com', '+914433221111', 'Accountant', 35000.00),
(7, 'Suresh Gupta', 'suresh.gupta@email.com', '+913322119999', 'IT', 33000.00),
(8, 'Geeta Iyer', 'geeta.iyer@email.com', '+912211998888', 'HR', 50000.00),
(9, 'Rakesh Patel', 'rakesh.patel@email.com', '+911199887777', 'Logistics', 43000.00),
(10, 'Sunita Sharma', 'sunita.sharma@email.com', '+919988776666', 'Admin', 38000.00);

INSERT INTO Location (LocationID, LocationName, Address) VALUES
(1, 'Bangalore Hub', '10, Brigade Road, Bangalore'),
(2, 'Mumbai Depot', '25, Linking Road, Mumbai'),
(3, 'Delhi Office', '40, Connaught Place, Delhi'),
(4, 'Chennai Branch', '60, Mount Road, Chennai'),
(5, 'Hyderabad Center', '80, Banjara Hills, Hyderabad'),
(6, 'Kolkata Site', '90, Park Street, Kolkata'),
(7, 'Pune Station', '110, FC Road, Pune'),
(8, 'Jaipur Warehouse', '130, MI Road, Jaipur'),
(9, 'Kochi Terminal', '150, MG Road, Kochi'),
(10, 'Shimla Point', '170, Mall Road, Shimla');

INSERT INTO Payment (PaymentID, CourierID, LocationId, Amount, PaymentDate) VALUES
(1, 1, 1, 350.00, '2023-12-12'),
(2, 2, 2, 65.00, '2023-12-14'),
(3, 3, 3, 55.00, '2023-12-17'),
(4, 4, 4, 40.00, '2023-12-20'),
(5, 5, 5, 30.00, '2023-12-22'),
(6, 6, 6, 50.00, '2023-12-24'),
(7, 7, 7, 20.00, '2023-12-26'),
(8, 8, 8, 70.00, '2023-12-28'),
(9, 9, 9, 80.00, '2023-12-30'),
(10, 10, 10, 90.00, '2024-01-01');

-- 1
select * from User;
-- 2
select * from Courier where SenderName ="Karthik Kumar";
-- 3
select * from Courier;
-- 4
select * from  Courier where CourierID=1;
-- 5
select * from  Courier where CourierID=5;
-- 6
select * from Courier where Status<>'Delivered';
-- 7
select * from  Courier where DeliveryDate = CURDATE();
-- 8
select * from Courier where Status='In Transit';
-- 9
select SenderName,count(*)as total from Courier as c group by CourierID;

-- 10 
SELECT CourierID, AVG(DATEDIFF(DeliveryDate, NOW())) AS Avg_Delivery_Time 
FROM Courier 
GROUP BY CourierID;

-- 11
select * from Courier where Weight Between 2 and 6;
-- 12
select * from Employee where Name LIKE '%John%';
-- 13
select * from courier join payment where payment.CourierID=courier.courierID having payment.amount>=50;

-- 14 Determine the total number of couriers managed by each employee. 
-- However, since your schema lacks a direct Employee-Courier relationship, 
-- this query cannot be executed unless there is an assignment table that connects employees to couriers. 
-- If employees are responsible for handling couriers, 
-- you need to establish that relationship.

-- 15 
SELECT Location.LocationID, Location.LocationName, SUM(Payment.Amount) AS TotalRevenue
FROM Payment 
JOIN Location ON Payment.LocationID = Location.LocationID
GROUP BY Location.LocationID;

-- 16
SELECT ReceiverAddress, COUNT(CourierID) AS COUNT
FROM Courier
WHERE Status = 'Delivered'
GROUP BY ReceiverAddress;

-- 17 Find the courier with the highest average delivery time.
-- dispatch time not given so we can't find the average delivery time 

-- 18
SELECT Location.Locationid, Location.LocationName, SUM(Payment.Amount) AS Total
FROM Payment 
JOIN Location ON Payment.Locationid = Location.Locationid
GROUP BY Location.Locationid, Location.LocationName
HAVING Total < 55;

-- 19
SELECT Locationid, SUM(Amount) AS Total
FROM Payment
GROUP BY Locationid;

-- 20
SELECT Courier.SenderName, Courier.ReceiverName, SUM(Payment.Amount) AS Total
FROM Payment
JOIN Courier ON Payment.CourierID = Courier.CourierID
WHERE Payment.LocationID = 6
GROUP BY Courier.CourierID, Courier.SenderName, Courier.ReceiverName
HAVING Total < 1000;

-- 21
SELECT Courier.SenderName, Courier.ReceiverName, SUM(Payment.Amount) AS Total
FROM Payment
JOIN Courier ON Payment.Courierid = Courier.Courierid
WHERE Payment.Paymentdate < '2023-12-24'
GROUP BY Courier.CourierID
HAVING Total < 1000;

-- 23
SELECT Courier.SenderName, Courier.ReceiverName, SUM(Payment.Amount) AS Total
FROM Payment
JOIN Courier ON Payment.Courierid = Courier.Courierid
WHERE Payment.Paymentdate > '2023-12-24'
GROUP BY Courier.CourierID
HAVING Total < 1000;

-- 24
SELECT * 
FROM Payment
INNER JOIN Location ON Payment.LocationID = Location.LocationID;

-- 25
SELECT *
FROM Payment
INNER JOIN Courier ON Payment.CourierID = Courier.CourierID
INNER JOIN Location ON Payment.LocationID = Location.LocationID;

-- 26
SELECT *
FROM Payment
LEFT JOIN Courier ON Payment.CourierID = Courier.CourierID;

-- 27
SELECT CourierID, SUM(Amount) AS Total
FROM Payment
GROUP BY CourierID;

-- 28
SELECT * FROM Payment WHERE PaymentDate = '2024-08-19'; 

-- 29
SELECT *
FROM Payment
INNER JOIN Courier ON Payment.CourierID = Courier.CourierID;

-- 30
SELECT *
FROM Payment
INNER JOIN Location ON Payment.LocationID = Location.LocationID;

-- 31
SELECT CourierID, SUM(Amount) AS Total
FROM Payment
GROUP BY CourierID;

-- 32
SELECT * FROM Payment WHERE PaymentDate BETWEEN '2024-10-09' AND '2024-08-11';

-- 33
SELECT *
FROM User
LEFT JOIN Courier ON User.UserID = Courier.courierid;

-- 34
SELECT *
FROM Courier
LEFT JOIN CourierServices ON Courier.CourierID = CourierServices.ServiceID;

-- 35
SELECT *
FROM Employee
LEFT JOIN Payment ON Employee.EmployeeID =Payment.PaymentID;

-- 36
SELECT * FROM User CROSS JOIN CourierServices;

-- 37
SELECT * FROM Employee CROSS JOIN Location;

-- 38
SELECT CourierID, SenderName, SenderAddress FROM Courier;

-- 39
SELECT CourierID, ReceiverName, ReceiverAddress FROM Courier;

-- 40
SELECT *
FROM Courier
LEFT JOIN CourierServices ON Courier.CourierID = CourierServices.ServiceID;
 
 -- 41
SELECT Employee.EmployeeID,Employee.Name, COUNT(Courier.CourierID) AS Total
FROM Employee 
LEFT JOIN Courier ON Employee.EmployeeID = Courier.CourierID
GROUP BY Employee.EmployeeID,Employee.Name;

-- 42
SELECT l.LocationID, l.LocationName, SUM(p.Amount) AS total
FROM Payment p
JOIN Location l ON p.LocationID = l.LocationID
GROUP BY l.LocationID, l.LocationName;

-- 43
SELECT SenderName, COUNT(CourierID) AS Total
FROM Courier
GROUP BY SenderName;

-- 44
SELECT Role, COUNT(EmployeeID) AS total
FROM Employee
GROUP BY Role;

-- 45
SELECT Courier.SenderAddress, SUM(Payment.Amount) AS total
FROM Courier 
JOIN Payment ON Courier.CourierID = Payment.CourierID
GROUP BY Courier.SenderAddress;

-- 46
SELECT SenderAddress, COUNT(CourierID) AS TotalCouriers
FROM Courier
GROUP BY SenderAddress;

-- 47
SELECT Employee.EmployeeID, Employee.Name, COUNT(Courier.CourierID) AS total
FROM Employee
LEFT JOIN Courier ON Employee.EmployeeID = Courier.CourierID
WHERE Courier.Status = 'Delivered'
GROUP BY Employee.EmployeeID, Employee.Name;

-- 48
SELECT Courier.CourierID, Payment.Amount, CourierServices.Cost
FROM Payment
JOIN Courier ON Payment.CourierID = Courier.CourierID
JOIN CourierServices ON Courier.CourierID = CourierServices.ServiceID
WHERE Payment.Amount > CourierServices.Cost;

-- 49
SELECT * FROM Courier WHERE Weight > (SELECT AVG(Weight) FROM Courier);

-- 50
SELECT * FROM Employee WHERE Salary > (SELECT AVG(Salary) FROM Employee);

-- 51
SELECT SUM(Cost) AS total FROM CourierServices WHERE Cost < (SELECT MAX(Cost) FROM CourierServices);

-- 52
SELECT * FROM Courier WHERE CourierID IN (SELECT DISTINCT CourierID FROM Payment);

-- 53
SELECT LocationID, MAX(Amount) AS max FROM Payment GROUP BY LocationID;

-- 54
SELECT * FROM Courier WHERE Weight > ALL (SELECT Weight FROM Courier WHERE SenderName = 'Alice Johnson');
