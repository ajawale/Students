CREATE TABLE STUDENT
(
  RNO BIGINT,
  NAME VARCHAR2(255),
  PRIMARY KEY (RNO),
  CNO BIGINT
 );
 
 CREATE TABLE COURSE
(
  CNO BIGINT ,
  CNAME VARCHAR2(255),
  PRIMARY KEY (CNO),
 
);

INSERT INTO STUDENT (RNO,NAME,CNO) VALUES (1,'TEST',1);
INSERT INTO STUDENT (RNO,NAME,CNO) VALUES (2,'ANUP',2);

INSERT INTO COURSE (CNO,CNAME) VALUES (1,'JAVA');
INSERT INTO COURSE (CNO,CNAME) VALUES (2,'SQL');
INSERT INTO COURSE (CNO,CNAME) VALUES (3,'PYTHON');