# Getting Started

### Run the Application  
Right click PurchaseOrderApplication and click on run option

### TableEntity
After successful run, check the database @H2.

@H2 : http://localhost:8080/h2-console/

* SELECT * FROM  SUPPLIER ;
* SELECT * FROM PRODUCT;
* SELECT * FROM ITEMS;
* SELECT * FROM ORDERS ;

### Add Dummy Data

Run these from win cmd prompt or use postman

--addSupplier
* curl --request PUT http://localhost:8080/supplier -d "{  \"supplierName\" : \"Sonali GARG NEW \"}" -H "Content-Type: application/json"

--updateSupplier
* curl --request PUT http://localhost:8080/supplier/{supplier_id} -d "{  \"supplierName\" : \"Sonali GARG UPDATED \"}" -H "Content-Type: application/json"

--addProduct with SupplierId
* curl --request PUT http://localhost:8080/supplier/{supplier_id}/product -d "{  \"description\" : \"SONALI PRODUCT ADD \", \"price\" : 10.0}" -H "Content-Type: application/json"

--updateProduct for Supplier
* curl --request PUT http://localhost:8080/supplier/{supplier_id}/product/{product_id} -d "{  \"description\" : \"SONALI PRODUCT UPDATED \", \"price\" : 10.0}" -H "Content-Type: application/json"

--placeOrder  ---- MAP of {"productId":qty} as input
* curl --request PUT http://localhost:8080/placeOrder  -d "{  \"1\" :  10 ,  \"2\" : 10}" -H "Content-Type: application/json"

### Additional Links
These additional references should also help you:

--Show All products for supplier {2}
* http://localhost:8080/supplier/2/product

--Show All products
* http://localhost:8080/product

--Show all supplier
* http://localhost:8080/supplier

--Show all orders
* http://localhost:8080/orders

-- Show order {2} 
* http://localhost:8080/orders/2
