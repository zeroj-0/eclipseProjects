CREATE TABLE Category(
	cid					BIGINT					PRIMARY KEY			AUTO_INCREMENT,
	mainTitle		VARCHAR(20)		NOT NULL,
	subTitle			VARCHAR(20)		NOT NULL,
	regDate			TIMESTAMP			NOT NULL					DEFAULT		CURRENT_TIMESTAMP
)AUTO_INCREMENT = 1;


CREATE TABLE MenuItem(
	mid					BIGINT					PRIMARY KEY			AUTO_INCREMENT,
	cid					BIGINT					NOT NULL,
	mainTitle		VARCHAR(20)		NOT NULL,
	subTitle			VARcHAR(20)		NOT NULL,
	name				VARCHAR(20)		NOT NULL,
	cost					DOUBLE						NOT NULL,
	imgURL			VARCHAR(100)		NOT NULL,
	explanation	VARCHAR(150)		NOT NULL,
	regDate			TIMESTAMP			NOT NULL					DEFAULT		CURRENT_TIMESTAMP,
	
	CONSTRAINT MenuItem_categoryId_FK		FOREIGN KEY (cid)	REFERENCES Category(cid)
)AUTO_INCREMENT = 1;

DROP TABLE MenuItem;
SELECT cid, mainTitle, subTitle FROM Category GROUP BY mainTitle;
SELECT cid, mainTitle, subTitle FROM Category ORDER BY mainTitle DESC;

SELECT mid, cid, name, cost, imgURL, explanation FROM MenuItem ORDER BY cid;

ALTER TABLE MenuItem ADD mainTitle VARCHAR(20)	NOT NULL;
ALTER TABLE MenuItem ADD subTitle VARCHAR(20)	NOT NULL;
SELECT mid, cid, mainTitle, name, cost, imgURL, explanation FROM MenuItem ORDER BY mainTitle DESC;