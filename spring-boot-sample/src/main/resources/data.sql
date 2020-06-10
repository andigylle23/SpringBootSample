DROP TABLE IF EXISTS books;
 
CREATE TABLE books (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  code VARCHAR(250) NOT NULL,
  book_title VARCHAR(250) NOT NULL
);
 
INSERT INTO books (code, book_title) VALUES
  ('00001', 'Nature Spring'),
  ('00002', 'Programming for dummies'),
  ('00003', 'Just for fun'),
  ('00004', 'Coming soon'),
  ('00005', 'Beginner guide to code'),
  ('00006', 'Harry Potter'),
  ('00007', 'Percy Jackson'),
  ('00008', 'The devils gateway'),
  ('00009', 'Blue lutos'),
  ('00010', 'Children of the future');