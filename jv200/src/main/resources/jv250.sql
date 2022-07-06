CREATE TABLE Sample10 (
	no					INT(11)				DEFAULT NULL,
	name				VARCHAR(20) 		DEFAULT NULL,
	birthday		DATE					DEFAULT NULL,
	address		VARCHAR(40)		DEFAULT NULL
);

SELECT * FROM Sample10;

INSERT INTO Sample10 VALUES (1, '유비', '1996-10-25', '대구 중구 반월당');
INSERT INTO Sample10 VALUES (2, '관우', '1998-09-24', '대구 달서구 상인동');
INSERT INTO Sample10 VALUES (3, '장비', '1997-03-19', '대구 서구 평리동');

CREATE TABLE Customer (
	cid					BIGINT					PRIMARY KEY	AUTO_INCREMENT,
	name 				VARCHAR(20)			NOT NULL,
	ssn 					VARCHAR(14)			NOT NULL,
	phone 				VARCHAR(14)			NOT NULL,
	customerId 		VARCHAR(16) 			NOT NULL,
	passwr				VARCHAR(16)			NOT NULL,
	regDate			TIMESTAMP			NOT NULL			DEFAULT CURRENT_TIMESTAMP
) AUTO_INCREMENT = 1001;

ALTER TABLE Customer CHANGE CustomerId userId VARCHAR(16) NOT NULL;

SELECT * FROM Customer;

INSERT INTO Customer (name, ssn, phone, customerId, passwr) VALUES ('유비', '991213-2712346', '010-1234-2222','java', '1111');
INSERT INTO Customer (name, ssn, phone, customerId, passwr) VALUES ('관우', '980623-1717846', '010-1234-7854','javascript', '2222');
INSERT INTO Customer (name, ssn, phone, customerId, passwr) VALUES ('장비', '970319-1712926', '010-4578-2222','jquery', '3333');

UPDATE Customer SET ssn = '961213-2712346' WHERE name='유비';
UPDATE Customer SET ssn = '961231-2712346',  phone = '010-9874-2100' WHERE name='유비';

DELETE FROM Customer;

UPDATE Customer SET cid = 1001 WHERE name = '유비';

DROP TABLE Customer;


CREATE TABLE Customer (
	cid					BIGINT					PRIMARY KEY	AUTO_INCREMENT,
	name 				VARCHAR(20)			NOT NULL,
	ssn 					VARCHAR(14)			NOT NULL,
	phone 				VARCHAR(14)			NOT NULL,
	customerId 		VARCHAR(16) 			NOT NULL,
	passwr				VARCHAR(16)			NOT NULL,
	regDate			TIMESTAMP			NOT NULL			DEFAULT CURRENT_TIMESTAMP
) AUTO_INCREMENT = 100;
INSERT INTO Customer (name, ssn, phone, customerId, passwr) VALUES ('유비', '991213-2712346', '010-1234-2222','java', '1111');
INSERT INTO Customer (name, ssn, phone, customerId, passwr) VALUES ('관우', '980623-1717846', '010-1234-7854','javascript', '2222');
INSERT INTO Customer (name, ssn, phone, customerId, passwr) VALUES ('장비', '970319-1712926', '010-4578-2222','jquery', '3333');

SELECT * FROM Customer;

CREATE TABLE Account(
		aid						BIGINT					PRIMARY KEY AUTO_INCREMENT,
		accountNum			VARCHAR(11)			NOT NULL,
		balance					DOUBLE					NOT NULL				DEFAULT 0.0,
		interestRate			DOUBLE					NOT NULL				DEFAULT 0.0,
		overdraft				DOUBLE					NOT NULL				DEFAULT 0.0,
		accountType			CHAR(1)					NOT NULL				DEFAULT 'S',
		customerId			BIGINT					NOT NULL,
		regDate				TIMESTAMP			NOT NULL				DEFAULT CURRENT_TIMESTAMP,
		
		CONSTRAINT		Account_customerId_FK		FOREIGN KEY	(customerId)		REFERENCES Customer(cid)
) AUTO_INCREMENT = 300;

SELECT * FROM Account;

INSERT INTO Account (accountNum, balance, interestRate, accountType, customerId) VALUES ('111-22-3333', 30000.0, 20, 'S', '100');
INSERT INTO Account (accountNum, balance, overdraft, accountType, customerId) VALUES ('234-55-6666', 60000.0, 50000, 'C', '101');
INSERT INTO Account (accountNum, balance, interestRate, accountType, customerId) VALUES ('698-99-1234', 45000.0, 15, 'S', '103');

-- inner join
SELECT * FROM Account, Customer WHERE Account.customerId = Customer.cid;
SELECT * FROM Account, Customer WHERE Account.customerId = Customer.cid AND Customer.ssn = '991213-2712346';

-- 정형화된 inner join SQL 문법
SELECT * FROM Account a INNER JOIN Customer c ON a.customerId = c.cid;
SELECT * FROM Account a INNER JOIN Customer c ON a.customerId = c.cid WHERE c.ssn='991213-2712346';

DELETE FROM Account WHERE aid >=321 AND aid<=324;


SELECT a.aid, a.accountNum, a.balance, a.interestRate, a.overdraft, a.accountType, c.name, c.ssn, c.phone FROM Account a INNER JOIN Customer c ON a.customerId = c.cid WHERE c.ssn='980623-1717846';

