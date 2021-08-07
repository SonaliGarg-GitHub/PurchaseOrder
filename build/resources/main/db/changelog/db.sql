create database testDb;
CREATE TABLE supplier( supplier_id INT PRIMARY KEY,  supplier_name VARCHAR(50) NOT NULL);

CREATE TABLE products
( product_id INT PRIMARY KEY,
  supplier_id INT NOT NULL REFERENCES supplier(supplier_id),
  description VARCHAR(50),
  price double,

  CONSTRAINT fk_products_supplier_id
    FOREIGN KEY (supplier_id)
    REFERENCES products (supplier_id)
    ON DELETE CASCADE
);



CREATE TABLE orders
(
  order_id INT PRIMARY KEY,
  supplier_id INT NOT NULL REFERENCES supplier(supplier_id),
  ordered_date DATE ,
  tax double,
  grantTotal double
);

CREATE TABLE ordered_products
(
  order_id  INT NOT NULL REFERENCES orders(order_id),
  product_id INT NOT NULL REFERENCES products(product_id),
  description VARCHAR(50),
  unitPrice double,
  qty double,
  subtotal double ,

    PRIMARY KEY (order_id ,product_id )
);


SELECT * FROM  SUPPLIER ;
SELECT * FROM PRODUCT;
SELECT * FROM ITEMS;
SELECT * FROM ORDERS ;
SELECT * FROM Orders orders JOIN Orders.items items WHERE items.order_id = orders.order_id

INSERT INTO supplier VALUES(1, 'flipkart'), (2, 'AMAZON');

INSERT INTO Product  VALUES(1, 'Mobile from flipkart', 12345.67,1);
INSERT INTO Product VALUES(2,'Mobile from Amazon', 12345.67,2);
INSERT INTO Product VALUES(3, 'Mobile from Aside', 12345.67,2);
INSERT INTO Product VALUES(4, 'Mobile from Aside', 12345.67,2);
INSERT INTO Product  VALUES(5, 'Mobile from flipkart', 12345.67,1);