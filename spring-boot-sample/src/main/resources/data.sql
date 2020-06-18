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

INSERT INTO books (barcode, title, author,date_created, date_updated) VALUES
  ('00001', 'To Kill a Mockingbird', 'Harper Lee', now(), now()),
  ('00002','A Tale of Two Cities', 'Charles Dickens', now(), now()),
  ('00003','The Lightning Theif', 'Rick Riordan',  now(), now()),
  ('00004','The Titans Curse', 'Rick Riordan',  now(), now()),
  ('00005','The Last Olympian', 'Rick Riordan', now(), now()),
  ('00006','Pride and Prejudice', 'Jane Austen', now(), now()),
  ('00007','Don Quixote', 'Miguel de Cervantes', now(), now()),
  ('00008','1984', 'George Orwell',now(), now()),
  ('00009','Harry Potter and the Sorcerers Stone', 'J.K. Rowling', now(), now()),
  ('000010','A Christmas Carol', 'Charles Dickens', now(), now()),
  ('000011','Anne of Green Gables', 'L.M. Montgomery', now(), now()),
  ('000012','A Game of Thrones', 'George R.R. Martin', now(), now()),
  ('000013','The Hobbit', 'J.R.R. Tolkien', now(), now());