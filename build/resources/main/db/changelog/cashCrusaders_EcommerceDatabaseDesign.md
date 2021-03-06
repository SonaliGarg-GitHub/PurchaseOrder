
supplier:
+---------------+--------------+------+-----+---------+---------------------------------+
| Field     	| Type         | Null | Key | Default | Extra          					|
+---------------+--------------+------+-----+---------+---------------------------------+
| supplier_id	| int(11) 	   | NO   | PRI | NULL    | auto_increment					|
| supplier_name | varchar(255) | YES  |     | NULL    |                					|
+---------------+--------------+------+-----+---------+---------------------------------+
supplier_id - primary key

product:
+---------------+--------------+------+-----+---------+---------------------------------+
| Field     	| Type         | Null | Key | Default | Extra          					|
+---------------+--------------+------+-----+---------+---------------------------------+
| product_id	| int(11)      | NO   | PRI | NULL    | auto_increment 					|
| supplier_id	| int(11) 	   | NO   |     | NULL    | REFERENCES supplier(supplier_id)|
| description  	| varchar(255) | YES  |     | NULL    |                					|
| price		  	| float 	   | NO   |     | NULL    |                					|
+---------------+--------------+------+-----+---------+---------------------------------+
product_id - primary key

Orders:
+---------------+--------------+------+-----+-------------------+---------------------------------+
| Field     	| Type         | Null | Key | Default 			| Extra          				  |
+---------------+--------------+------+-----+-------------------+---------------------------------+
| order_id		| int(11)      | NO   | PRI | NULL    			| auto_increment 				  |
| supplier_id	| int(11) 	   | NO   | PRI | NULL    			| REFERENCES supplier(supplier_id)|
| ordered_date  | datetime     | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED				  |
| totalTax 		| float 	   | NO   |     | 18    			|                				  |
| grantTotal 	| float        | NO   |     | NULL    			|                				  |
+---------------+--------------+------+-----+-------------------+---------------------------------+
order_id - primary key

Items:
+---------------+--------------+------+-----+-------------------+---------------------------------+
| Field     	| Type         | Null | Key | Default 			| Extra          				  |
+---------------+--------------+------+-----+-------------------+---------------------------------+
| id    		| int(11)      | NO   | PRI | NULL    			|  	                          	  |
| order_id		| int(11)      | NO   |      | NULL    			| REFERENCES Orders(order_id)     |
| product_id	| int(11) 	   | NO   |      | NULL    			| REFERENCES Product(product_id)  |
| ordered_date  | datetime     | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED				  |
| purchase_price| double	   | NO   |     | NULL    			|                				  |
| quantity	 	| int		   | NO   |     | NULL    			|                				  |
| subTotal	 	| double	   | NO   |     | NULL    			|                				  |
+---------------+--------------+------+-----+-------------------+---------------------------------+
(order_id ,product_id ) - composite primary key
