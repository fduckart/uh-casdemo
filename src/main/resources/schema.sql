DROP TABLE IF EXISTS message;
DROP TABLE IF EXISTS campus;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS type;
DROP TABLE IF EXISTS designation;
DROP TABLE IF EXISTS holiday;
DROP TABLE IF EXISTS holiday_type;

CREATE TABLE message (
  MSG_ID INT NOT NULL AUTO_INCREMENT,
  MSG_ENABLED varchar(1),
  MSG_TYPE_ID INT NOT NULL,
  MSG_TEXT varchar(2000) NOT NULL,
  CONSTRAINT PK_PSMESSAGE PRIMARY KEY (MSG_ID)
);

-- insert into campus (id, code, actual, description)
-- values (1,  'HA', 'Y', 'Hawaii Community College');

CREATE TABLE campus (
  id INT NOT NULL AUTO_INCREMENT,
  code varchar(3) NOT NULL,
  actual varchar(1) NOT NULL DEFAULT 'Y',
  description varchar(64) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT uc_campus_code UNIQUE (code)
);

-- insert into role (id, role, short_description, description) values (1,  'USER',    'User',          'User');
CREATE TABLE role (
    id INT NOT NULL auto_increment,
    role VARCHAR(50) NOT NULL,
    description VARCHAR(100),
    short_description VARCHAR(40),
    PRIMARY KEY(id)
);

CREATE TABLE type (
  id INT NOT NULL AUTO_INCREMENT,
  version INT NOT NULL default 1,
  description varchar(50) NOT NULL,
  sort_id INT NOT NULL default 0,
  PRIMARY KEY (id)
);

CREATE TABLE designation (
  id INT NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE holiday (
  id INT NOT NULL AUTO_INCREMENT,
  version INT NOT NULL default 1,
  official_year INT NOT NULL,
  official_date DATE NOT NULL,
  observed_date DATE NOT NULL,
  description varchar(100) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE holiday_type (
  type_id INT NOT NULL,
  holiday_id INT NOT NULL,
  CONSTRAINT fk_type_o FOREIGN KEY (type_id) REFERENCES type(id),
  CONSTRAINT fk_holiday_o FOREIGN KEY (holiday_id) REFERENCES holiday(id)
);
