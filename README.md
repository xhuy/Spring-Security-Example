# README #

1) Run scripts in /security-hibernate/src/main/sql in order.


1.a) Check /security-hibernate/src/main/webapp/WEB-INF/spring/db-context.xml, to ensure that the user and password for the database are correects, also the port.

2) Run application in the servlet container of your preference (Developed and tested in Apache Tomcat v8)


3) Go to http://localhost:8080/security-hibernate/


4) Go to http://localhost:8080/security-hibernate/controlPanel (you should get to the login screen, thats is because of the Spring-Security configuration, you can change it for no redirect and show 403 page.


5) Go to index or register http://localhost:8080/security-hibernate/register


6) Create a user, the user is created in database and persisted. Also the password is encrypted.


7) Log in, enjoy 

### What is this repository for? ###

* Version 1.0

### How do I get set up? ###

* Maven
* JDK 1.8