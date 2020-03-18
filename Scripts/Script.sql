drop table if exists BOOKS, AUTHORS;

create table if not exists AUTHORS (
	id serial primary key,
	name VARCHAR(50)
);

create table if not exists BOOKS (
	id serial primary key,
	authorId INT references AUTHORS(id),
	title VARCHAR(100),
	url VARCHAR(200)
);

INSERT INTO authors(id, name) VALUES(1, 'Jack London');
INSERT INTO authors(id, name) VALUES(2, 'Honore de Balzac');
INSERT INTO authors(id, name) VALUES(3, 'Lion Feuchtwanger');
INSERT INTO authors(id, name) VALUES(4, 'Emile Zola');
INSERT INTO authors(id, name) VALUES(5, 'Truman Capote');

INSERT INTO books(id, authorId, title, url) VALUES(1, 1, 'Call of the Wild', 'http://localhost');
INSERT INTO books(id, authorId, title, url) VALUES(2, 1, 'Martin Eden', 'http://localhost');
INSERT INTO books(id, authorId, title, url) VALUES(3, 2, 'Old Goriot', 'http://localhost');
INSERT INTO books(id, authorId, title, url) VALUES(4, 2, 'Cousin Bette', 'http://localhost');
INSERT INTO books(id, authorId, title, url) VALUES(5, 3, 'Jew Suess', 'http://localhost');
INSERT INTO books(id, authorId, title, url) VALUES(6, 4, 'Nana', 'http://localhost');
INSERT INTO books(id, authorId, title, url) VALUES(7, 4, 'The Belly of Paris', 'http://localhost');
INSERT INTO books(id, authorId, title, url) VALUES(8, 5, 'In Cold blood', 'http://localhost');
INSERT INTO books(id, authorId, title, url) VALUES(9, 5, 'Breakfast at Tiffany', 'http://localhost');