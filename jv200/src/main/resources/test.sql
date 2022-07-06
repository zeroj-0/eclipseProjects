CREATE TABLE MenuItem (
	id				INT							PRIMARY KEY,
	cateId	INT,
	name		VARCHAR(20),
	price		DOUBLE,
	
	CONSTRAINT MenuItem_MenuCategory_FK FOREIGN KEY (cateId) REFERENCES MenuCategory(id)
);

CREATE TABLE MenuCategory (
	id				INT							PRIMARY KEY
);

INSERT INTO MenuCategory(id) VALUES (1);
INSERT INTO MenuCategory(id) VALUES (2);

SELECT * FROM MenuCategory;

INSERT INTO MenuItem(id,cateId,name,price) VALUES (1,1,'라면',2500);
INSERT INTO MenuItem(id,cateId,name,price) VALUES (2,1,'떡볶이',1500);
INSERT INTO MenuItem(id,cateId,name,price) VALUES (3,1,'떡국',3000);
INSERT INTO MenuItem(id,cateId,name,price) VALUES (4,1,'만두',1000);
INSERT INTO MenuItem(id,cateId,name,price) VALUES (5,1,'어묵',1000);

INSERT INTO MenuItem(id,cateId,name,price) VALUES (6,2,'짜장',2500);
INSERT INTO MenuItem(id,cateId,name,price) VALUES (7,2,'짬뽕',1500);
INSERT INTO MenuItem(id,cateId,name,price) VALUES (8,2,'볶음밥',3000);
INSERT INTO MenuItem(id,cateId,name,price) VALUES (9,2,'만두',1000);
INSERT INTO MenuItem(id,cateId,name,price) VALUES (10,2,'냉짬뽕',1000);

SELECT * FROM MenuItem;

SELECT COUNT(*) FROM MenuItem WHERE cateId=1;
SELECT COUNT(*) FROM MenuItem GROUP BY cateId;