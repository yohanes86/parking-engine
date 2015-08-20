/*
Created: 17-Aug-15
Modified: 20-Aug-15
Model: MySQL 5.1
Database: MySQL 5.1
*/



-- Create tables section -------------------------------------------------

-- Table UserData

CREATE TABLE UserData
(
  id Int NOT NULL AUTO_INCREMENT,
  name Varchar(50) NOT NULL,
  password Varchar(80),
  phone_no Varchar(16) NOT NULL,
  email Varchar(50) NOT NULL,
  license_no Varchar(12) NOT NULL,
  activate_key Varchar(35),
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

-- Table Transaction

CREATE TABLE Transaction
(
  id Int NOT NULL AUTO_INCREMENT,
  customer_first_name Varchar(128) NOT NULL,
  customer_last_name Varchar(128),
  customer_email Varchar(64),
  customer_phone Varchar(64) NOT NULL,
  billing_first_name Varchar(128) NOT NULL,
  billing_last_name Varchar(128) NOT NULL,
  billing_address Varchar(128),
  billing_city Varchar(64),
  billing_postal_code Varchar(32),
  billing_country_code Varchar(128),
  billing_phone Varchar(128),
  shipping_first_name Varchar(128),
  shipping_last_name Varchar(128),
  shipping_address Varchar(128),
  shipping_city Varchar(128),
  shipping_postal_code Varchar(128),
  shipping_phone Varchar(128),
  shipping_country_code Varchar(128),
  payment_order_id Varchar(128),
  payment_transaction_id Varchar(128),
  total_price_idr Bigint,
  payment_method Varchar(128),
  payment_status Varchar(128),
  payment_fds_status Varchar(128),
  created_on Timestamp NOT NULL,
  created_by Varchar(50) NOT NULL,
  updated_on Timestamp NOT NULL,
  updated_by Varchar(50) NOT NULL,
 PRIMARY KEY (id)
)
;

CREATE UNIQUE INDEX idx_orderId_paymentId ON Transaction (payment_order_id,payment_transaction_id)
;

-- Table TransactionDetail

CREATE TABLE TransactionDetail
(
  id Int NOT NULL AUTO_INCREMENT,
  transaction_id Int NOT NULL,
  name_item Varchar(128),
  price_each_idr Bigint,
 PRIMARY KEY (id)
)
;

CREATE UNIQUE INDEX idx_transactionId ON TransactionDetail (transaction_id)
;




