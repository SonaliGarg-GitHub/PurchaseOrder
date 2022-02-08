**Database Design For ProductPurchase :**

**supplier Table :**

  supplier_id - primary key
| Field     	  | Type         | Null | Key | Default | Extra          					        |
|---------------|--------------|------|-----|---------|---------------------------------|
| supplier_id	  | int(11) 	   | NO   | PRI |     | auto_increment					        |
| supplier_name | varchar(255) | YES  |     |     |                					        |



**product Table :**

product_id - primary key
| Field     	  | Type         | Null | Key | Default | Extra          					        |
|---------------|--------------|------|-----|---------|---------------------------------|
| product_id	  | int(11)      | NO   | PRI |     | auto_increment 					        | 
| supplier_id	  | int(11) 	   | NO   |     |     | REFERENCES supplier(supplier_id)|
| description  	| varchar(255) | YES  |     |     |                					        |
| price		  	  | float 	     | NO   |     |     |                					        |

**Orders Table:**

order_id - primary key
| Field     	  | Type         | Null | Key | Default 			    | Extra          				          |
|---------------|--------------|------|-----|---------|---------------------------------|
| order_id		  | int(11)      | NO   | PRI |     			    | auto_increment 				          |
| supplier_id	  | int(11) 	   | NO   | PRI |     			    | REFERENCES supplier(supplier_id)|
| ordered_date  | datetime     | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED				        |
| totalTax 		  | float 	     | NO   |     | 18    			      |                				          |
| grantTotal 	  | float        | NO   |     |     			    |                 				        |

**Items Table:**

id - primary key
| Field     	  | Type         | Null | Key | Default 			    | Extra          				          |
|---------------|--------------|------|-----|---------|---------------------------------|
| id    		    | int(11)      | NO   | PRI |     			    |  	                          	  |
| order_id		  | int(11)      | NO   |     |     			    | REFERENCES Orders(order_id)     |
| product_id	  | int(11) 	   | NO   |     |     			    | REFERENCES Product(product_id)  |
| ordered_date  | datetime     | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED				        |
| purchasAtprice| double	     | NO   |     |     			    |                				          |
| quantity	  	| int		       | NO   |     |     			    |                				          |
| subTotal	 	  | double	     | NO   |     |     			    |                				          |

