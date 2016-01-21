create table weterynarz
(
id INTEGER NOT NULL primary key,
imie varchar(40) not null,
nazwisko varchar(40) not null,
primary key (id),
);

create table zwierze
(
id INTEGER NOT NULL,
imie varchar(40) not null,
gatunek varchar(40) not null,
dataur Date,
wetid integer,
primary key (id),
foreign key (wetid) references weterynarz(id)
);
