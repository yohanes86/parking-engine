/*
Created: 8/17/2015
Modified: 8/27/2015
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
  activate_key Varchar(35),
  session_key Varchar(50),
  status Int NOT NULL,
  time_gen_session_key Datetime,
  group_user Varchar(20),
  created_on Datetime NOT NULL,
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
  id Bigint NOT NULL AUTO_INCREMENT,
  order_id Varchar(128)NOT NULL,
  transaction_status Varchar(128),
  fraud_status Varchar(128),
  transaction_id Varchar(128),
  customer_first_name Varchar(128) NOT NULL,
  name_item Varchar(128) NOT NULL,
  total_price_idr Bigint,
  payment_type Varchar(128),
  bank Varchar(128),  
  approval_code Varchar(128),  
  signature_key Varchar(128),
  email_notification int,
  email_notification_reason Varchar(128),  
  created_on Datetime NOT NULL,
  created_by Varchar(50) NOT NULL,
  updated_on Timestamp NOT NULL,
  updated_by Varchar(50) NOT NULL,
 PRIMARY KEY (id)
)
;

CREATE UNIQUE INDEX order_id ON Transaction (order_id)
;

-- Table Transaction_Notif

CREATE TABLE Transaction_Notif
(
  id Bigint NOT NULL AUTO_INCREMENT,
  order_id Varchar(128)NOT NULL,
  transaction_status Varchar(128),
  transaction_description Varchar(128),
  fraud_status Varchar(128),
  transaction_id Varchar(128),
  customer_first_name Varchar(128) ,
  name_item Varchar(128) ,
  total_price_idr Bigint,
  payment_type Varchar(128),
  bank Varchar(128),  
  approval_code Varchar(128),  
  signature_key Varchar(128),
  email_notification int,
  email_notification_reason Varchar(128),  
  created_on Datetime NOT NULL,
  created_by Varchar(50) NOT NULL,
  updated_on Timestamp NOT NULL,
  updated_by Varchar(50) NOT NULL,
 PRIMARY KEY (id)
)
;

CREATE UNIQUE INDEX transaction_id ON Transaction_Notif (transaction_id)
;

-- Table Mall

CREATE TABLE Mall
(
  id Int NOT NULL AUTO_INCREMENT,
  mall_code Varchar(128),
  mall_name Varchar(128),
  mall_address Varchar(128),
  mall_phone Varchar(64),
  status Int DEFAULT 1,
  created_on Datetime,
  created_by Varchar(128),
  updated_on Timestamp,
  updated_by Varchar(128),
 PRIMARY KEY (id)
)
;

CREATE UNIQUE INDEX idx ON Mall (created_on,created_by,updated_on,updated_by,mall_code,mall_name)
;

-- Table Mall_Slots

CREATE TABLE Mall_Slots
(
  id Int NOT NULL AUTO_INCREMENT,
  mall_id Int,
  slots_name Varchar(128),
  slots_price_idr Bigint,
  slots_status Int,
  created_on Datetime,
  created_by Varchar(128),
  updated_on Timestamp,
  updated_by Varchar(128),
 PRIMARY KEY (id)
)
  COMMENT = 'slots_status 0 = FREE
slots_status 1 = BOOKED
'
;

CREATE UNIQUE INDEX idx ON Mall_Slots (created_on,created_by,updated_on,updated_by,slots_name,slots_status)
;

-- Table Booking

CREATE TABLE Booking
(
  id Int NOT NULL AUTO_INCREMENT,
  name Varchar(50),
  phone_no Varchar(16),
  email Varchar(50),
  mall_name Varchar(128),
  id_slot Int,
  booking_id Varchar(128),
  booking_code Varchar(128),
  booking_date Datetime,
  booking_status Int DEFAULT 0,
 PRIMARY KEY (id)
)
;

CREATE UNIQUE INDEX idx ON Booking (booking_code,booking_date,booking_id,email)
;



ALTER TABLE parkingonline.mall
 ADD mall_image VARCHAR(64) AFTER mall_phone;


INSERT INTO mall(
   mall_code
  ,mall_name
  ,mall_address
  ,mall_phone
  ,mall_image
  ,created_on
  ,created_by
  ,updated_on
  ,updated_by
) VALUES (
  'KOKAS-001'
  ,'Kota Casablanka'  -- mall_name - IN varchar(128)
  ,'Jalan Raya Tebet No 100'  -- mall_address - IN varchar(128)
  ,'021-55934854'  -- mall_phone - IN varchar(64)
  ,'kota_kasablanka'  -- mall_phone - IN varchar(64)
  ,CURRENT_TIMESTAMP -- created_on - IN timestamp
  ,'SYS'  -- created_by - IN varchar(128)
  ,CURRENT_TIMESTAMP -- updated_on - IN timestamp
  ,'SYS'  -- updated_by - IN varchar(128)
);

INSERT INTO mall_slots(
   mall_id
  ,slots_name
  ,slots_price_idr
  ,slots_status
  ,created_on
  ,created_by
  ,updated_on
  ,updated_by
) VALUES (
   1,'B1-A27'  -- slots_name - IN varchar(128)
  ,10000   -- slots_price_idr - IN bigint(20)
  ,0   -- slots_status - IN int(11)
  ,CURRENT_TIMESTAMP -- created_on - IN timestamp
  ,'SYS'  -- created_by - IN varchar(128)
  ,CURRENT_TIMESTAMP -- updated_on - IN timestamp
  ,'SYS'  -- updated_by - IN varchar(128)
);

INSERT INTO mall_slots(
   mall_id
  ,slots_name
  ,slots_price_idr
  ,slots_status
  ,created_on
  ,created_by
  ,updated_on
  ,updated_by
) VALUES (
   1,'B1-A28'  -- slots_name - IN varchar(128)
  ,10000   -- slots_price_idr - IN bigint(20)
  ,0   -- slots_status - IN int(11)
  ,CURRENT_TIMESTAMP -- created_on - IN timestamp
  ,'SYS'  -- created_by - IN varchar(128)
  ,CURRENT_TIMESTAMP -- updated_on - IN timestamp
  ,'SYS'  -- updated_by - IN varchar(128)
);

INSERT INTO mall_slots(
   mall_id
  ,slots_name
  ,slots_price_idr
  ,slots_status
  ,created_on
  ,created_by
  ,updated_on
  ,updated_by
) VALUES (
   1,'B1-A29'  -- slots_name - IN varchar(128)
  ,10000   -- slots_price_idr - IN bigint(20)
  ,0   -- slots_status - IN int(11)
  ,CURRENT_TIMESTAMP -- created_on - IN timestamp
  ,'SYS'  -- created_by - IN varchar(128)
  ,CURRENT_TIMESTAMP -- updated_on - IN timestamp
  ,'SYS'  -- updated_by - IN varchar(128)
);

INSERT INTO mall_slots(
   mall_id
  ,slots_name
  ,slots_price_idr
  ,slots_status
  ,created_on
  ,created_by
  ,updated_on
  ,updated_by
) VALUES (
   1,'B1-A30'  -- slots_name - IN varchar(128)
  ,10000   -- slots_price_idr - IN bigint(20)
  ,0   -- slots_status - IN int(11)
  ,CURRENT_TIMESTAMP -- created_on - IN timestamp
  ,'SYS'  -- created_by - IN varchar(128)
  ,CURRENT_TIMESTAMP -- updated_on - IN timestamp
  ,'SYS'  -- updated_by - IN varchar(128)
);


ALTER TABLE parking_online.userdata
 ADD branch_mall VARCHAR(64) AFTER updated_by;
 
 ALTER TABLE parking_online.transaction
 ADD email_notification int AFTER booking_id;

