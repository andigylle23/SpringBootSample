DROP table books IF EXISTS;

CREATE TABLE books (
  id INT(11) AUTO_INCREMENT,
  barcode VARCHAR(250) NOT NULL,
  title VARCHAR(250) NOT NULL,
  author VARCHAR(250) NOT NULL,
  date_created  DATETIME,
  date_updated  DATETIME,
  PRIMARY KEY (id)
);
