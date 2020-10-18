-- Uses MyBatis lib to run database migration rollout and rollback

CREATE TABLE author(
  id int NOT NULL AUTO_INCREMENT,
  name varchar(64),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  CONSTRAINT pk_author PRIMARY KEY(id)
);

CREATE TABLE book_category(
  id int not null,
  name varchar(32),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  CONSTRAINT pk_book_category PRIMARY KEY(id)
);

CREATE TABLE book (
  id int auto_increment,
  name varchar(128),
  book_category_id int NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  CONSTRAINT pk_book PRIMARY KEY(id),
  CONSTRAINT fk_book_book_category FOREIGN KEY (book_category_id) REFERENCES book_category(id)
);

CREATE TABLE book_authors (
  id int auto_increment,
  book_id int not null,
  author_id int not null,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  CONSTRAINT pk_book_authors PRIMARY KEY(id),
  CONSTRAINT fk_book_authors_book FOREIGN KEY (book_id) REFERENCES book(id),
  CONSTRAINT fk_book_authors_author FOREIGN KEY (author_id) REFERENCES author(id)
);

-- //@UNDO
DROP TABLE IF EXISTS book_authors;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS author;
DROP TABLE IF EXISTS book_category;