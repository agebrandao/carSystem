###  Car System. 

The Car System was implemented with a back-end in Spring boot.

---

## Getting Started 

These instructions will get you a copy of the project for running on your local machine.

---

### Back-end (ApiCarSystem)

The ApiCarSystm runs on port 3000 and uses the H2 database

The application.properties file contains the connection data to the database

## Built Using 

- [Maven dependencies]
  - JPA
  - Security
  - JUnit
  - JWT
  - H2
  - Tomcat


## Running the application 

Run as Java application

## Running the unit test

Run as maven test

<img src=”https://github.com/agebrandao/carSystem/blob/master/images/testResult-backend.png”>

## Running the build

 Run as maven build
 Goal: clean install

## EndPoints:

# Users:

1. Lists all users:

(Get) http://localhost:3000/apiCarSystem/users/

  return:
 
[
    {
        "id": 2,
        "firstName": "Anna",
        "lastName": "Kokay",
        "email": "anna@gmail.com",
        "birthday": null,
        "phone": "8133336658",
        "login": "anna",
        "password": "$2a$10$rpFeS/R3io6djG.9ZuC.Wea8Ih0f3JyNjQI4gTrcwyTy4IYM9go8e",
        "cars": [
	        {
		        "id": 1,
		        "licensePlate": "kkk-1234",
		        "model": "ka",
		        "color": "preto"
	      	}
        ]
    }
]

2. Create user: 

(Post) http://localhost:3000/ApiCarSystem/car

  Body:
 
   { 
    "firstName": "Maria",
    "lastName": "Silva",
    "email": "maria@gmail.com",
    "phone": "8133339999",
    "login": "maria",
    "password": "123456"
  }

  return:

{
    "id": 2,
    "firstName": "Maria",
    "lastName": "Silva",
    "email": "maria@gmail.com",
    "birthday": null,
    "phone": "8133339999",
    "login": "maria",
    "password": "$2a$10$rpFeS/R3io6djG.9ZuC.Wea8Ih0f3JyNjQI4gTrcwyTy4IYM9go8e",
    "cars": [
	        {
		        "id": 1,
		        "licensePlate": "kkk-1234",
		        "model": "ka",
		        "color": "preto"
	      	}
        ]
}

3. Update user:

(PUT) http://localhost:3000/users

  Body:
 
  {
    "id":2,
    "firstName": "Maria",
    "lastName": "Silva",
    "email": "maria123@gmail.com",
    "login": "maria"       
  }

  return: 

{
    "id": 2,
    "firstName": "Maria",
    "lastName": "Silva",
    "email": "mari2a@gmail.com",
    "birthday": null,
    "phone": 8133336658,
    "login": "maria",
    "password": "$2a$10$rpFeS/R3io6djG.9ZuC.Wea8Ih0f3JyNjQI4gTrcwyTy4IYM9go8e",
    "cars": [
	        {
		        "id": 1,
		        "licensePlate": "kkk-1234",
		        "model": "ka",
		        "color": "preto"
	      	}
        ]
}

4. Delete user:

(DELETE) http://localhost:3000/users/1

 return:
{
    "message": "Deleted user!"
}

# Cars:

1. Lists all cars:

(Get) http://localhost:3000/ApiCarSystem/cars

 return: 
	[
		{
		    "id": 1,
		    "year": 2000,
		    "licensePlate": "kkk-1234",
		    "model": "ka",
		    "color": "preto"
		}
	]

2. Create car: 

(Post) http://localhost:3000/ApiCarSystem/cars

 Body:
 
   {
     	"year": 2000,
        "licensePlate": "kkk-1234",
        "model": "ka",
        "color": "preto"
   }

 return:

   {
       "id": 1,
       "year": 2000,
       "licensePlate": "kkk-1234",
       "model": "ka",
       "color": "preto"
   }

3. Update car:

(PUT) http://localhost:3000/apiCarSystem/cars

 Body:
 
   {  
       "id":"1",  
       "licensePlate": "kkk-9999",
       "model": "ka",
       "color": "preto"
   }

 return:

   {
       "id": 1,
       "year": 2000,
       "licensePlate": "kkk-9999",
       "model": "ka",
       "color": "preto"
    }

4. Delete car:

(DELETE) http://localhost:3000/users/1

 return:
	{
	    "message": "Deleted car!"
	}


# Searches:

1. Search the user by id:

(Get) http://localhost:3000/apiCarSystem/users/1

 return:

   {
       "id": 1,
       "firstName": "Jose",
       "lastName": "Silva",
       "email": "jose@gmail.com",
       "birthday": null,
       "phone": "8133336658",
       "login": "jose",
       "password": "$2a$10$vlNpsEi0XcIe.UIoHCHequZWEAWwvCBxZavyeoDXKCXDQDw9/lN16",
       "cars": []
   }

2.  Search the car by id:

(GET) http://localhost:3000/apiCarSystem/cars/1 

 return: 

   {
       "id": 1,
       "year": null,
       "licensePlate": "kkk-9999",
       "model": "ka",
       "color": "preto"
   }

# Login:

(Post) http://localhost:3000/login

 Body:
{
    "login": "maria",
    "password": "123456"
}

 return:
   
  Header:
  Authorization:
  Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhbm5hIiwiZXhwIjoxNjAxNjg3N
  	jUzfQ.b5m92XywKOYxMhy-L938zcxT757lCkgZ5xuqizW-oTRoV7L_EDQSS7rrMKkXJg8r1iUVnw7IXybtARZCH-uEUw
  	
# Sprints:

  1. Initial Settings
  2. Crud Operations 
  3. JWT Authentication
  4. JWT Authorization
  5. Validations
  6. Unit test
  
### Front-end (ApiCarSystem)
 
 The Car System was implemented with a front-end in React.js (Hooks)

 This application runs on port 3001
 
 http://localhost:3001/login
 http://localhost:3001/home
 http://localhost:3001/users
 http://localhost:3001/user/:user
 http://localhost:3001/cars
 http://localhost:3001/car/:car
 
 <img src=”https://github.com/agebrandao/carSystem/blob/master/images/homeScreen.png”>

## Built Using 

- [react] 16.12.0
- [axios]
- [bootstrap]
- [font-awesome]
- [react-datepicker]
- [react-dom]
- [react-router]
- [react-router-dom]
- [react-scripts]


## Running the application

Commands for running the application:
1. yarn install (is used to install all dependencies for a project)
2. yarn start

## Screens

1 List of cars:

Displays all registered cars displaying: year, License Plate, model  and color.

On this screen it is possible to delete cars and choose a car to update.

<img src=”https://github.com/agebrandao/carSystem/blob/master/images/carsScreen.png”>

2. Car registration:

Displays all fields for registering cars

<img src=”https://github.com/agebrandao/carSystem/blob/master/images/carScreen.png”>

3. List of users:

Displays all registered users displaying: firstName, lastName, email, birthday, login, phone and cars.

On this screen it is possible to delete users and choose a user to update.

<img src=”https://github.com/agebrandao/carSystem/blob/master/images/usersScreen.png”>

4. User registration:

Displays all fields for registering users

<img src=”https://github.com/agebrandao/carSystem/blob/master/images/userScreen.png”>
   
## Authors <a name = "authors"></a>

- [@agebrandao] - Idea & Initial work