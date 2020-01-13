DROP TABLE IF EXISTS users;
 
CREATE TABLE users (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL,
  password VARCHAR(250) DEFAULT NULL
);
 
INSERT INTO users (first_name, last_name, email, password) VALUES
  ('Joe', 'Dirt', 'joe.dirt@gmail.com', HASH('SHA256', STRINGTOUTF8('password'), 1000)),
  ('Glass', 'Steel', 'glass.steel@gmail.com', HASH('SHA256', STRINGTOUTF8('pass'), 1000)),
  ('The', 'Rock', 'the.rock@gmail.com', HASH('SHA256', STRINGTOUTF8('pass'), 1000));
  
DROP TABLE IF EXISTS receipes;
 
CREATE TABLE receipes (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  receipeName VARCHAR(250) NOT NULL,
  servingSize INT,
  region VARCHAR(250) DEFAULT NULL,
  entreeType VARCHAR(250) DEFAULT NULL
  
);
 
INSERT INTO receipes(receipeName) VALUES
  ('Spaghetti'),
  ('Banana Pancakes'),
  ('Soup');
  
DROP TABLE IF EXISTS steps;
 
CREATE TABLE steps (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  receipeID INT NOT NULL,
  step_ordinal int NOT NULL,
  cookTime TIME NULL,
  instructions BLOB DEFAULT NOT NULL,
  foreign key(receipeID) references receipes(id)
);
 
--INSERT INTO steps (step_ordinal, instructions, entryID) VALUES
--  ('Aliko', 'Dangote', 'Billionaire Industrialist'),
--  ('Bill', 'Gates', 'Billionaire Tech Entrepreneur'),
--  ('Folrunsho', 'Alakija', 'Billionaire Oil Magnate');
  