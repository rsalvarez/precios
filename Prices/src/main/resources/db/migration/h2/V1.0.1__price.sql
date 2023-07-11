create table products (
id IDENTITY NOT NULL PRIMARY KEY,
name varchar(255)
);


create table brands (
id IDENTITY NOT NULL PRIMARY KEY,
name varchar(255)
);


create table price_lists (
id IDENTITY NOT NULL PRIMARY KEY,
name varchar(255)
);


create table prices (
id IDENTITY NOT NULL PRIMARY KEY,
brand_id numeric(10) not null,
start_date TIMESTAMP not null,
end_date TIMESTAMP default null,
price_list_id numeric(10) not null,
product_id numeric(10) not null,
priority    numeric(1) not null,
price numeric(10,2) not null,
curr VARCHAR(10) not null);

ALTER TABLE prices ADD FOREIGN KEY (brand_id) REFERENCES brands(id);
ALTER TABLE prices ADD FOREIGN KEY (product_id) REFERENCES products(id);
ALTER TABLE prices ADD FOREIGN KEY (price_list_id) REFERENCES price_lists(id);

insert into products (id, name) values (35455,'CAFE');
insert into brands (id, name) values (1,'ZARA');
insert into price_lists (id, name) values (1,'LISTA1');
insert into price_lists (id, name) values (2,'LISTA2');
insert into price_lists (id, name) values (3,'LISTA3');
insert into price_lists (id, name) values (4,'LISTA4');
insert into prices (brand_id, start_date, end_date, price_list_id, product_id, priority
, price, curr)values (1,'2020-06-14 00.00.00','2020-12-31 23.59.59',1,35455, 0 ,35.50 ,'EUR');
insert into prices (brand_id, start_date, end_date, price_list_id, product_id, priority
, price, curr)values(1,'2020-06-14 15.00.00','2020-06-14 18.30.00',2,35455, 1,25.45 ,'EUR');
insert into prices (brand_id, start_date, end_date, price_list_id, product_id, priority
, price, curr)values(1,'2020-06-15 00.00.00','2020-06-15 11.00.00',3,35455 , 1,30.50 ,'EUR');
insert into prices (brand_id, start_date, end_date, price_list_id, product_id, priority
, price, curr)values (1,'2020-06-15 16.00.00','2020-12-31 23.59.59',4,35455,1,38.95,'EUR');
