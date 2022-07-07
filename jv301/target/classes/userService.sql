CREATE TABLE User (
	uid				BIGINT							PRIMARY KEY			AUTO_INCREMENT,
	id					VARCHAR(15)				NOT NULL,
	passwd		VARCHAR(25)				NOT NULL,
	name			VARCHAR(10)				NOT NULL,
	email			VARCHAR(40)				NOT NULL,
	addr			VARCHAR(50)				NOT NULL
);

SELECT * FROM User;

SELECT id, passwd FROM User WHERE id=21811053 and passwd=213;
SELECT id FROM User WHERE id=21811053;
SELECT passwd FROM User WHERE passwd=213;

ALTER TABLE User ADD ssn VARCHAR(20) NOT NULL;
update User set ssn='970213' WHERE name='서길동';
update User set ssn='990830' WHERE name='서영정';
update User set ssn='960118' WHERE name='남길동';
update User set ssn='990707' WHERE name='권길동';

update User set ssn='951112' where name='예슈화';