#InvoiceGenerator

Steps to run app: 

Step 1: git clone https://github.com/charugarg93/InvoiceGenerator.git

Step 2: Install mysql

Step 3: Determine the required credentials(username and password) of the given mysql user.  Also, make changes to application.properties file accordingly.

Step 4: Create 3 tables: user, order_detail and products_in_order Using the following Queries:

use spring;

CREATE TABLE `products_in_order` (

 `id` int(11) NOT NULL AUTO_INCREMENT,

 `order_id` int(11) NOT NULL,

 `product_description` varchar(45) DEFAULT NULL,

 `rate` float DEFAULT NULL,

 `quantity` int(11) DEFAULT NULL,

 PRIMARY KEY (`id`),

 KEY `index_orderid` (`order_id`)

) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;




CREATE TABLE `order_detail` (

 `id` int(11) NOT NULL AUTO_INCREMENT,

 `user_id` int(11) DEFAULT NULL,

 `amount` float DEFAULT NULL,

 `due_date` date DEFAULT NULL,

 PRIMARY KEY (`id`),

 KEY `index_userid` (`user_id`),

 KEY `index_id` (`id`)

) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;



CREATE TABLE `user` (

 `id` int(11) NOT NULL AUTO_INCREMENT,

 `EMAIL` varchar(255) NOT NULL,

 `NAME` varchar(255) NOT NULL,

 PRIMARY KEY (`id`),

 UNIQUE KEY `UK_ejfk3g58oxsgbb4ju3u4fhivk` (`EMAIL`),

 KEY `email_index` (`EMAIL`)

) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;


User_id (in ‘user' table) and Order_Id (in ‘Order_details' table) have been indexed for faster retrieval as these fields are more prone to be queried.

Step 5: Build the project using mvn clean install

Step 6: After successful build, a war file will be generated in the target folder.

Step 7: Place this war file in the webapp folder of Apache Tomcat.

Step 8: Start the tomcat logs.

Step 9: Start the tomcat server. 

Step 10: Hit the end point http://localhost:8080/InvoiceGenerator/invoiceForm

Step 11: The Invoice form should be displayed

Assumptions : This app is built on following assumptions:

1. Inventory is infinite and catalog for products is not maintained.
2. Due date to be entered has to be in DD/MM/YYYY format.

#Architecture Diagram

https://github.com/charugarg93/InvoiceGenerator/blob/master/Architecture%20Diagram.png
#ER Diagram

https://github.com/charugarg93/InvoiceGenerator/blob/master/ER%20Diagram.png

#Sequence Diagram

https://github.com/charugarg93/InvoiceGenerator/blob/master/Sequence%20Diagram.png



