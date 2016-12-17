Health Care Service Management Service Application

To run the application locate

/HealthCare-Service/src/main/java/com/health/care/management/HealthCareServiceApplication.java

and run the application.

Following MySQL db configuration  must be added in the application.properties

sql.datasource.url=jdbc:mysql://<hostname>:<portname>/<db name>
sql.datasource.username=<db_username>
sql.datasource.password=<db_password>
sql.datasource.driver=com.mysql.jdbc.Driver