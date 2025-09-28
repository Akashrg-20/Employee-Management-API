Employee Management REST API

A simple REST API built with Spring Boot to manage employee records. 
This beginner-friendly project demonstrates how to build CRUD operations (Create, Read, Update, Delete) 
using Spring Boot, JPA, and an in-memory H2 database.

--------------------------------------

Features
<ul>
<li>Add a new employee</li>
<li>Get all employees</li>
<li>Get an employee by ID</li>
<li>Update employee details</li>
<li>Delete an employee</li>
<li>Input validation and error handling</li>
</ul>


-----------------------

Tech Stack
<ul>
<li>Java 17 or higher</li>
<li>Spring Boot (Web, Data JPA,)</li>
<li>MySql Database</li>
<li>Maven</li>
<li>Post Man</li>
</ul>


------------------------

API Endpoints

Employees
<ul>
<li>POST : /employees → Add a new employee</li>
<li>GET : /employees → Get all employees</li>
<li>GET : /employees/{id} → Get an employee by ID</li>
<li>PUT : /employees/{id} → Update employee details/li>
<li>DELETE /employees/{id} → Delete employee/li>
</ul>

-----------------------

Example JSON

Create Employee (POST : /employees)

{
"name": "Akash",
"salary": "25000",
"address": "Hubli"
}

Response (201 Created):

{
"id": 1,
"name": "Akash",
"salary": "25000",
"address": "Hubli"
}

-----------------------------


The API will run at:

http://localhost:8080/employees



✨ This project is perfect for learning Spring Boot REST APIs, CRUD operations, and working with an in-memory database.