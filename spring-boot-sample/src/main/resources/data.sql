DROP TABLE IF EXISTS books;

CREATE TABLE books (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  title VARCHAR(250) NOT NULL,
  author VARCHAR(250) NOT NULL
);

INSERT INTO books (title, author) VALUES
  ('Book1', 'George R.R. Martin '),
  ('Book2', 'George R.R. Martin '),
  ('Book3', 'George R.R. Martin '),
  ('Book4', 'George R.R. Martin '),
  ('To Kill a Mockingbird', 'Harper Lee'),
  ('A Tale of Two Cities', 'Charles Dickens'),
  ('The Lightning Theif', 'Rick Riordan'),
  ('The Titans Curse', 'Rick Riordan'),
  ('The Last Olympian', 'Rick Riordan'),
  ('Pride and Prejudice', 'Jane Austen'),
  ('Don Quixote', 'Miguel de Cervantes'),
  ('1984', 'George Orwell'),
  ('Harry Potter and the Sorcerers Stone', 'J.K. Rowling'),
  ('A Christmas Carol', 'Charles Dickens'),
  ('Anne of Green Gables', 'L.M. Montgomery'),
  ('A Game of Thrones', 'George R.R. Martin '),
  ('The Hobbit', 'J.R.R. Tolkien');