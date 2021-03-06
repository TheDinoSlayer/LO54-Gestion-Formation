/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  tds
 * Created: 20 oct. 2017
 */

CREATE TABLE FORMATION.LOCATION (
	ID INTEGER GENERATED ALWAYS AS IDENTITY NOT NULL,
	CITY CHAR(30) NOT NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE FORMATION.COURSE (
	CODE CHAR(4) NOT NULL,
	TITLE VARCHAR(50) NOT NULL,
	PRIMARY KEY (CODE)
);

CREATE TABLE FORMATION.COURSE_SESSION (
	ID INTEGER GENERATED ALWAYS AS IDENTITY NOT NULL,
	START_DATE DATE NOT NULL,
        END_DATE DATE NOT NULL,
	COURSE_CODE CHAR(4) NOT NULL,
        LOCATION_ID INTEGER NOT NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE FORMATION.CLIENT (
	ID INTEGER GENERATED ALWAYS AS IDENTITY NOT NULL,
	LASTNAME CHAR(20) NOT NULL,
        FIRSTNAME CHAR(20) NOT NULL,
	ADDRESS CHAR(30) NOT NULL,
        PHONE CHAR(15) NOT NULL,
        EMAIL CHAR(30),
        COURSE_SESSION_ID INTEGER NOT NULL,
	PRIMARY KEY (ID)
);

ALTER TABLE FORMATION.COURSE_SESSION
	ADD FOREIGN KEY (COURSE_CODE) 
	REFERENCES FORMATION.COURSE (CODE);

ALTER TABLE FORMATION.COURSE_SESSION
	ADD FOREIGN KEY (LOCATION_ID) 
	REFERENCES FORMATION.LOCATION (ID);

ALTER TABLE FORMATION.CLIENT
	ADD FOREIGN KEY (COURSE_SESSION_ID) 
	REFERENCES FORMATION.COURSE_SESSION (ID);