
README
======

Prerequisites:
--------------
- Java 5 and above
- MySQL 5 and above


Installation for Linux:
-----------------------
1. Create a new directory e.g. /opt/joget and extract the tar.gz bundle into that directory
2. Install the Java Runtime Environment (JRE) or Java Development Kit (JDK) version 5 and above
    e.g. in Ubuntu: sudo apt-get install sun-java6-jdk
3. Install MySQL Server version 5 and above
    e.g. in Ubuntu: sudo apt-get install mysql-server
4. Create an empty database 'wflowdb' in the MySQL server
5. Execute the setup script to create the required database tables: ./setup.sh
    Alternatively, manually create the database tables as follows:
    4.1 Populate the wflowdb database with the SQL script in data/wflowdb-empty.sql
    4.2 Edit wflow/datasource-default.properties to match your database settings
6. Execute the bundled Apache Tomcat application server: ./tomcat6.sh run
7. Access the Workflow Management Console at http://localhost:8080/wflow-wfweb


Installation for Windows:
------------------------
1. Create a new folder e.g. C:\Joget and extract the ZIP bundle
2. Install the Java Runtime Environment (JRE) or Java Development Kit (JDK) version 5 and above
3. Install MySQL Server version 5 and above
4. Create an empty database 'wflowdb' in the MySQL server
5. Populate the wflowdb database with the SQL script in data\wflowdb-empty.sql
6. Edit wflow\datasource-default.properties to match your database settings
7. Edit tomcat6-run.bat and change JAVA_HOME to your Java installation directory
8. Run tomcat6-run.bat to start the bundled Apache Tomcat application server
9. Access the Workflow Management Console at http://localhost:8080/wflow-wfweb

