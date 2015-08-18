/*
Created: 17-Aug-15
Modified: 18-Aug-15
Model: MySQL 5.1
Database: MySQL 5.1
*/



-- Create tables section -------------------------------------------------

-- Table UserData

CREATE TABLE UserData
(
  id Int NOT NULL AUTO_INCREMENT,
  name Varchar(50) NOT NULL,
  password Varchar(50) NOT NULL,
  phone_no Varchar(16) NOT NULL,
  email Varchar(50) NOT NULL,
  license_no Varchar(12) NOT NULL,
  activate_key Varchar(25) NOT NULL,
  session_key Varchar(50),
  status Int NOT NULL,
  time_gen_session_key Timestamp,
  created_on Timestamp NOT NULL,
  created_by Varchar(50) NOT NULL,
  updated_on Timestamp NOT NULL,
  updated_by Varchar(50) NOT NULL,
 PRIMARY KEY (id)
)
  COMMENT = 'status: 
0 pending
1 active
2 blocked

activate key : digunakan pada saat registration user, key activate di cocokan dengan yg di kirim dari email

session key: digunakan pada saat device req ke server '
;

CREATE UNIQUE INDEX idx_email ON UserData (email)
;

CREATE INDEX idx_phone_no ON UserData (phone_no)
;




