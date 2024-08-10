# About Registration-Login Project

Here i have added some useful examples of restapis and user. <br>
login and signup which is very important for making Restful api services.


## Project MetaDeta

Use the project set up a new Spring Boot project. 
It allows you to generate a ready-to-use project structure.

```metadata
group - com.foodApp.UserLogin
Artifact - Registration - Login
Name - Registration - Login
Description - Spring Boot project for Registration and Login
Package name - com.foodApp_UserLogin

# returns 'phenomenon'
foobar.singularize('phenomena')
```

## Required Dependency for Development
```Dependency
# returns 'First dependency'
1.Spring web

# returns 'Second dependency'
2.spring data jpa

# returns 'Third dependency'
3.lombok

# returns 'Fourth dependency'
4.postgre SQL Driver/My SQL Driver

# returns 'Fifth dependency'
5.spring boot DevTools
```

Project Configuration (application.properties)
```Configuration
#db configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/Registration-Login
spring.datasource.username=postgres
spring.datasource.password=root

# Hibernate properties
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.format_sql=true
```

EndPoints and Json Body
```
Create Registration/SignUp
Request : http://localhost:8080/api/signUp
Json Body : 
{
    "userName":"vinayakfarud",
    "password":"passasc",
    "mobileNo":"9099604580",
    "email":"vinayak@gmail.com"
}
ResponseBody :
{
    "userId": 2,
    "userName": "vinayakfarud",
    "password": "passasc",
    "mobileNo": "9099604580",
    "email": "vinayak@gmail.com"
}
```
Login User
```
Request : Post : http://localhost:8080/api/login
Json Body :
{
    "userId":2,
    "userName":"vinayakfarud",
    "password": "passasc"
}
Response : 
CurrentUserSession(id=1, userId=2, uuid=179190, localDateTime=2024-08-10T10:28:14.194274100)
```
Update User 
```
Request::Put : http://localhost:8080/api/updateSignUp?key=179190
Json Body :
{
   "userId": 2,
    "userName":"vinayak",
    "password":"passasc",
    "mobileNo":"9099604589",
    "email":"vinayak9@gmail.com"
}
Response :
{
    "userId": 2,
    "userName": "vinayak",
    "password": "passasc",
    "mobileNo": "9099604589",
    "email": "vinayak9@gmail.com"
}
```	



Logout user
```
Request : Patch : http://localhost:8080/api/logout?key=179190
Response : Logged Out......
```
	
