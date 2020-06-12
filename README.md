
### Build with
Eclipse

### How to run

1. You need go to the spring-boot-sample folder
2. In your terminal, do the mvn clean install
3. Then mvn clean spring-boot:run


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
URL: `http://localhost:8080/books`

JSON:
`{
    "code":"00001",
    "title":"Book Title"
}`

For **GET** request
**Get all books**, URL: `http://localhost:8080/books`
**Get book by id**, URL: `http://localhost:8080/books/{id}`


