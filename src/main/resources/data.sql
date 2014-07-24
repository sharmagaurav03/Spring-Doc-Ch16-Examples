insert into Customer (id, email, firstname, lastname) values (1, 'dave@dmband.com', 'Dave', 'Matthews');
insert into Customer (id, email, firstname, lastname) values (2, 'carter@dmband.com', 'Carter', 'Beauford');
insert into Customer (id, email, firstname, lastname) values (3, 'boyd@dmband.com', 'Boyd', 'Tinsley');
insert into Customer (id, email, firstname, lastname) values (4, 'boyd@dmband.com', 'Boyd', 'Tinsley');
insert into Customer (id, email, firstname, lastname) values (5, 'boyd@dmband.com', 'Boyd', 'Tinsley');
insert into Customer (id, email, firstname, lastname) values (6, 'boyd@dmband.com', 'Boyd', 'Tinsley');
insert into Customer (id, email, firstname, lastname) values (7, 'boyd@dmband.com', 'Boyd', 'Tinsley');
insert into Customer (id, email, firstname, lastname) values (8, 'boyd@dmband.com', 'Boyd', 'Tinsley');
insert into Customer (id, email, firstname, lastname) values (9, 'boyd@dmband.com', 'Boyd', 'Tinsley');
insert into Customer (id, email, firstname, lastname) values (10, 'boyd@dmband.com', 'Boyd', 'Tinsley');
insert into Customer (id, email, firstname, lastname) values (11, 'boyd@dmband.com', 'Boyd', 'Tinsley');

insert into Address (id, street, city, country, customer_id) values (1, '27 Broadway', 'New York', 'United States', 1);
insert into Address (id, street, city, country, customer_id) values (3, '27 Broadway3', 'New York3', 'United States3', 1);
insert into Address (id, street, city, country, customer_id) values (2, '27 Broadway', 'New York', 'United States', 1);

insert into Product (id, name, description, price) values (1, 'iPad', 'Apple tablet device', 499.0);
insert into Product (id, name, description, price) values (2, 'MacBook Pro', 'Apple notebook', 1299.0);
insert into Product (id, name, description, price) values (3, 'Dock', 'Dock for iPhone/iPad', 49.0);

insert into Product_Attributes (attributes_key, product_id, attributes) values ('connector', 1, 'socket');
insert into Product_Attributes (attributes_key, product_id, attributes) values ('connector', 3, 'plug');

insert into Orders (id, customer_id, shippingaddress_id) values (1, 1, 2);
insert into LineItem (id, product_id, amount, order_id, price) values (1, 1, 2, 1, 499.0);
insert into LineItem (id, product_id, amount, order_id, price) values (2, 2, 1, 1, 1299.0);

insert into Person (id, firstname, lastname) values (1,  'Dave', 'Matthews');
insert into Person (id,  firstname, lastname) values (2,'Carter', 'Beauford');
insert into Person (id,  firstname, lastname) values (3, 'Boyd', 'Tinsley3');
insert into Person (id, firstname, lastname) values (4,'Boyd', 'Tinsley4');
insert into Person (id,  firstname, lastname) values (5,  'Boyd', 'Tinsley');
insert into Person (id,  firstname, lastname) values (6, 'Boyd', 'Tinsley');
insert into Person (id, firstname, lastname) values (7,  'Boyd', 'Tinsley');
insert into Person (id,  firstname, lastname) values (8,  'Boyd', 'Tinsley');
insert into Person (id, firstname, lastname) values (9,  'Boyd', 'Tinsley');
insert into Person (id, firstname, lastname) values (10,'Boyd', 'Tinsley');
insert into Person (id, firstname, lastname) values (11,  'Boyd', 'Tinsley');
