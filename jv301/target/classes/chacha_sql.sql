CREATE TABLE Voucher (
	vid					BIGINT						PRIMARY KEY				NOT NULL,
	vType				VARCHAR(1)				NOT NULL,
	buyTime			INT,
	useTime			INT,
	use					VARCHAR(1)				NOT NULL,
	uid					BIGINT						NOT NULL,
	regDate			TIMESTAMP				NOT NULL						DEFAULT CURRENT_TIMESTAMP,
	
	CONSTRAINT		Voucher_Uid_FK		FOREIGN KEY	(uid)	REFERENCES	UserInfo(uid)
)AUTO_INCREMENT = 1;