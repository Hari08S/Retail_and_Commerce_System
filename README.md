**Retail & Commerce System**

A Java-based web application developed using JSP, Servlets, JDBC, and Oracle Database to manage retail transaction records.

This project allows users to add, view, and manage retail transactions efficiently.

**Project Objective**

To develop an online application for entering and viewing retail transaction details including:

Customer Name,
Product Name,
Purchase Date,
Quantity,
Price,
Remarks,
The system validates input, prevents duplicate entries, and allows retrieval of records.

**Tech Stack**

Java (JDK 8),
JSP & Servlets,
JDBC,
Oracle Database (XE),
Apache Tomcat 9,
Eclipse IDE,
HTML.

**Functionalities**

**Add Retail Transaction**

Validates input fields,
Prevents duplicate records (same customer & date),
Auto-generates Record ID,
Shows success or error message.

**View Retail Transaction**

Search by Customer Name & Purchase Date,
Displays matching record,
Shows message if not found.

**View All Transactions**

Displays all transaction records,
Shows message if database is empty.

**How to Run the Project**

Install Oracle XE,
Create database user and tables,

Configure DB credentials in:

DBUtil.java,
Add ojdbc8.jar to project build path,
Deploy project on Apache Tomcat,

Run:
http://localhost:8080/Retail_and_Commerce_System/menu.html

**Test Cases Covered**

Add valid transaction,
Add invalid customer name,
Add invalid quantity/price,
Duplicate record prevention,
View existing transaction,
View non-existing transaction,
View all records.

**OUTPUT:**

<img width="714" height="400" alt="image" src="https://github.com/user-attachments/assets/b733a935-dac5-4b99-971c-7bf2df1db7c3" />

<img width="819" height="644" alt="image" src="https://github.com/user-attachments/assets/b35a7f01-eef9-489b-bbd6-05ad98166cf0" />

<img width="699" height="469" alt="image" src="https://github.com/user-attachments/assets/cfa4d357-df5f-4e98-9ddb-8cb96d371b16" />

<img width="817" height="488" alt="image" src="https://github.com/user-attachments/assets/cbc2edc2-671a-46da-ac6b-21b4a0166413" />

<img width="702" height="597" alt="image" src="https://github.com/user-attachments/assets/d0c4bc4c-35dc-4b99-b44d-6e68c3f3b9eb" />

<img width="787" height="488" alt="image" src="https://github.com/user-attachments/assets/5ae5ea82-2503-45b0-b378-abee65028c4a" />

<img width="908" height="810" alt="image" src="https://github.com/user-attachments/assets/a6869bbf-67b6-438b-88ad-2e73121ff9a8" />

