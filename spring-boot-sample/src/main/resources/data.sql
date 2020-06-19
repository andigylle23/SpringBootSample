DROP table employee IF EXISTS;
DROP table employee_details IF EXISTS;
DROP table work_time_history IF EXISTS;


CREATE TABLE employee (
  id INT(11) AUTO_INCREMENT,
  employee_id VARCHAR(250) NOT NULL,
  username VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  date_created  DATETIME,
  date_updated  DATETIME,
  PRIMARY KEY (id)
);

CREATE TABLE employee_details (
  id INT(11) AUTO_INCREMENT,
  employee_id VARCHAR(250) NOT NULL,
  first_name VARCHAR(100) NOT NULL,
  last_name VARCHAR(100) NOT NULL,
  department VARCHAR(100),
  current_work_location VARCHAR(250),
  current_project VARCHAR(250),
  date_created  DATETIME,
  date_updated  DATETIME,
  PRIMARY KEY (id)
);

CREATE TABLE work_time_history (
  id INT(11) AUTO_INCREMENT,
  employee_id VARCHAR(250) NOT NULL,
  clocked_in  DATETIME,
  clocked_out  DATETIME,
  date_created  DATETIME,
  date_updated  DATETIME,
  PRIMARY KEY (id)
);
	