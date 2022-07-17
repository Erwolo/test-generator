create table if not exists USER (id identity primary key, login varchar (255) not null, password varchar (255) not null);
truncate table USER;
insert into USERS (login, password) values ('erwol', '123');
insert into USERS (login, password) values ('kurwol', '456');