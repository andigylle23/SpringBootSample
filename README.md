
### Build with
Eclipse

### How to run

#### For spring-boot-using-temp-db branch

1. You need go to the spring-boot-sample folder
2. In your terminal, do the mvn clean install
3. Then mvn clean spring-boot:run

#### For develop branch
1. You need to install mysql server
2. In the application.properties, updated it based on your settings
3. The do mvn clean spring-boot:run


### How to access
1. After successful run, access in your browser http://localhost:8080/
2. It show a page someone writing

### How to access the temp H2 databse
1. Access in your browser http://localhost:8080/h2
2. Then click the Connect button
3. It should show the console page of the h2 database where the database is auto created via Entity annotations

### How to access via api/postman
1. Start the spring app
2. Then open your postman

For **POST** request
```
URL: http://localhost:8080/books
```

JSON:
```
{
    "code":"00001",
    "title":"Book Title"
}
```

For **GET** request
```
Get all books, URL: `http://localhost:8080/books`
Get book by id**, URL: `http://localhost:8080/books/{id}
```

### How to deploy war files in Tomcat manually
1. First you need to have a tomcat server. You can download it from here https://tomcat.apache.org/download-90.cgi
2. Then run **mvn install** in this project
3. After successfully run, in the **Project Explorer tab**, go to target folder
4. You should see a war file that was created in there, **copy it**
5. In you tomcat server folder, go to **webapps** and **paste the copied war files**
6. Rename the war file to simple name, so that when we access it, it is much easier like ex. sample-website
7. Now, we need to set up an admin to login to the tomcat server, go to **tomcat folder** and then go to **conf**
8. Edit the tomcat-user.xml and add the following and save

```
 <role rolename="manager-gui"/>
 <user username="admin" password="admin" roles="manager-gui"/
```
	
9. Then we are now ready to start the tomcat server, open a terminal or git bash, then go to the apache tomcat folder, then bin
10. Input **./startup.bat** for windows or **./startup.sh** for linux, this will start the server and deploy the war files that you put in the webapps
11. Once it is successully start, then open a web browser and enter http://localhost:8080/{name-of-the-war-file} (This should display what you have build)
12. Also if you want to **check what war files was deployed** you can go to http://localhost:8080/manager/html
13. Then you can input the **user and password from the tomcat-user.xml** that you've set
