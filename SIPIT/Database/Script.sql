create database db_sipit;


create table pengguna (
	username varchar(30) not null primary key,
	password varchar(30) not null,
	nama varchar(30) not null
);

CREATE or replace TABLE bookmark (
	id int not null primary key,
	username varchar(30),
	judulBuku VARCHAR(64) NOT NULL,
	author VARCHAR(30) NOT null,
	halaman varchar(1000),
	foreign key (username) references pengguna(username)
);

create or replace table ratingulasan(
	id int not null primary key,
	username varchar(30),
	judulBuku VARCHAR(64) NOT NULL,
	rating smallint,
	ulasan text,
	foreign key (username) references pengguna(username)
);


CREATE OR replace TABLE buku(
	id int NOT NULL PRIMARY KEY,
	judulBuku varchar(30) NOT NULL,
	author VARCHAR(30) NOT NULL
);



select * from bookmark;
select * from buku;
