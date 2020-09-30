### Car Rental System. 

The Car Rental application was implemented with a back-end in node.js and a front-end with ReactJS using Hooks.

---

## 🏁 Getting Started 

These instructions will get you a copy of the project for running on your local machine.

---

### Back-end (car-rental-back)

The car-rental-back application runs on port 3001 and uses the Postgres database created in the AWS RDS

The .env file contains the connection data to the database

## ⛏️ Built Using 

- [Express]
- [NodeJs]
- [Nodemon]
- [Sequelize]
- [sequelize-cli]
- [pg]
- [cors]
- [dotenv]
- [supertest]
- [jest]


## 🔧 Running the application

Commands for running the application:

1. yarn install (is used to install all dependencies for a project)

2. yarn sequelize db:migrate (Creates the tables in the database)

3. yarn dev (runs the application)

4. yarn test (runs the application test)

5. yarn sequelize db:migrate:undo:all (Delete the database tables)


## End-points:

# Users:

1. Lists all users:

(Get) http://localhost:3001/users

🎈 return

[
    {
        "id": 1,
        "name": "Mary",
        "email": "mary@email.com",
        "is_loyalty": true,
        "createdAt": "2020-02-01T21:02:22.289Z",
        "updatedAt": "2020-02-04T21:02:22.289Z"
    }
]

2. Create user: 

(Post) http://localhost:3001/users

 🧐 Body:
 
 {
	"name": "Mary",
	"email": "mary@email.com",
	"is_loyalty": false
}

🎈 return

{
    "id": 1,
    "name": "Mary",
    "email": "Mary@email.com",
    "is_loyalty": true,
    "updatedAt": "2020-02-05T00:11:04.536Z",
    "createdAt": "2020-02-05T00:11:04.536Z"
}

3. Update user:

(PUT) http://localhost:3001/users/1

 🧐 Body:
{
	"name": "Anne",
	"is_loyalty": false
}

🎈 return 

{
    "id": 1,
    "name": "Anne",
    "email": "Mary@email.com",
    "is_loyalty": false,
    "updatedAt": "2020-02-05T00:11:04.536Z",
    "createdAt": "2020-02-05T00:11:04.536Z"
}

4. Delete user:

(DELETE) http://localhost:3001/users/1

🎈 return
{
    "message": "Deleted user!"
}

# Cars:

1. Lists all cars:

(Get) http://localhost:3001/cars

🎈 return
[
    {
        "id": 1,
        "manufacturer": "HONDA",
        "model": "Accord Sedan LX 2.0 16V 150/156cv Aut.",
        "model_year": "2020",
        "category": "2",
        "weekday_price": "120.00",
        "weekend_price": "110.00",
        "weekday_loyalty_price": "110.00",
        "weekend_loyalty_price": "100.00",
        "createdAt": "2020-02-03T21:04:51.815Z",
        "updatedAt": "2020-02-03T21:04:51.815Z"
    }
 ]

2. Create user: 

(Post) http://localhost:3001/cars

 🧐 Body:
 
 {
        "manufacturer": "HONDA",
        "model": "Accord Sedan LX 2.0 16V 150/156cv Aut.",
        "model_year": "2020",
        "category": "2",
        "weekday_price": "120.00",
        "weekend_price": "110.00",
        "weekday_loyalty_price": "110.00",
        "weekend_loyalty_price": "100.00",
        "createdAt": "2020-02-03T21:04:51.815Z",
        "updatedAt": "2020-02-03T21:04:51.815Z"
  }

🎈 return

{
        "id": 1,
        "manufacturer": "HONDA",
        "model": "Accord Sedan LX 2.0 16V 150/156cv Aut.",
        "model_year": "2020",
        "category": "2",
        "weekday_price": "120.00",
        "weekend_price": "110.00",
        "weekday_loyalty_price": "110.00",
        "weekend_loyalty_price": "100.00",
        "createdAt": "2020-02-03T21:04:51.815Z",
        "updatedAt": "2020-02-03T21:04:51.815Z"
 }

3. Update car:

(PUT) http://localhost:3001/cars/1

 🧐 Body:
 
{
	"manufacturer": "Ford",
	"model": "Ka 1.0 SEL TiVCT Flex 5p",
	"model_year": "2013",
	"category": 1,
	"weekday_price": 130.00,
	"weekend_price": 120.00,
	"weekday_loyalty_price": 100.00,
	"weekend_loyalty_price": 90.00
}

🎈 return 

{
    "id": 1,
	"manufacturer": "Ford",
	"model": "Ka 1.0 SEL TiVCT Flex 5p",
	"model_year": "2013",
	"category": 1,
	"weekday_price": 130.00,
	"weekend_price": 120.00,
	"weekday_loyalty_price": 100.00,
	"weekend_loyalty_price": 90.00
    "createdAt": "2020-02-03T21:04:51.815Z",
    "updatedAt": "2020-02-03T21:04:51.815Z"
}

4. Delete car:

(DELETE) http://localhost:3001/users/1

🎈 return
{
    "message": "Deleted car!"
}

# Rents:

1. Lists all rents:

(Get) http://localhost:3001/rents

🎈 return

[
 {
    "id": 1,
    "user_id": 1,
    "car_id": 1,
    "start_date": "2020-10-20",
    "end_date": "2020-10-21T00:00:00.000Z",
    "rent_cost": "200.00",
    "updatedAt": "2020-02-05T00:24:32.486Z",
    "createdAt": "2020-02-05T00:24:32.486Z"
 }
]

2. Create rent: 

(Post) http://localhost:3001/rents

 🧐 Body:
 
 {
  {
	"user_id": 1,
	"car_id": 1,
	"start_date": "20201020",
	"end_date": "20201021",
	"rent_cost": 200.00
 }
}

🎈 return
{
    "id": 1,
    "user_id": 1,
    "car_id": 1,
    "start_date": "2020-10-20",
    "end_date": "2020-10-21T00:00:00.000Z",
    "rent_cost": "200.00",
    "updatedAt": "2020-02-05T00:24:32.486Z",
    "createdAt": "2020-02-05T00:24:32.486Z"
 }

3. Update rent:

(PUT) http://localhost:3001/rents/1

 🧐 Body:
{
	"start_date": "20201020",
	"end_date": "20201021",
	"rent_cost": 300.00
}

🎈 return 

{
    "id": 1,
    "user_id": 1,
    "car_id": 1,
    "start_date": "2020-10-20",
    "end_date": "2020-10-21T00:00:00.000Z",
    "rent_cost": "300.00",
    "updatedAt": "2020-02-05T00:24:32.486Z",
    "createdAt": "2020-02-05T00:24:32.486Z"
 }

4. Delete car:

(DELETE) http://localhost:3001/rents/1

🎈 return
{
    "message": "Deleted rent!"
}

# Searches:

1. Lists all cars by category:

(Get) http://localhost:3001/carsByCategorySearch

 🧐 Body:
{
	"category": "1"
}

🎈 return 

[
    {
        "id": 1,
        "manufacturer": "Ford",
        "model": "Ka 1.0 SEL TiVCT Flex 5p",
        "model_year": "2013",
        "category": "1",
        "weekday_price": "130.00",
        "weekend_price": "120.00",
        "weekday_loyalty_price": "100.00",
        "weekend_loyalty_price": "90.00",
        "createdAt": "2020-02-03T23:33:39.960Z",
        "updatedAt": "2020-02-03T23:33:39.960Z"
    }
]

2. Search the cheapest rental car by date:

(GET) http://localhost:3001/cheapestRentCarSearch 

 🧐 Body:
{
	"start_date": "2020-02-01T21:00:30.086Z",
	"end_date": "2020-02-04T21:00:30.086Z",
	"user":{
		"user_id":1,
		"name": "Mary",
		"email": "mary@email.com",
		"is_loyalty": false
	}
}

🎈 return 

{
    "user": {
        "user_id": 1,
        "name": "Mary",
        "email": "mary@email.com",
        "is_loyalty": false
    },
    "car": {
        "id": 1,
        "manufacturer": "Ford",
        "model": "Ka 1.0 SEL TiVCT Flex 5p",
        "model_year": "2013",
        "category": "2",
        "weekday_price": "130.00",
        "weekend_price": "120.00",
        "weekday_loyalty_price": "100.00",
        "weekend_loyalty_price": "90.00",
        "createdAt": "2020-02-04T19:04:48.059Z",
        "updatedAt": "2020-02-04T19:04:48.059Z"
    },
    "start_date": "2020-02-04T21:00:30.086Z",
    "end_date": "2020-02-04T21:00:30.086Z",
    "rent_cost": 370.99
}

3. Search the cheapest rental car by category: (not finished)
 
(GET) http://localhost:3001/cheapestRentSearch


---

### Front-end (car-rental-front)

The car-rental-back application runs on port 3000

## ⛏️ Built Using 

- [react] 16.12.0
- [axios]
- [bootstrap]
- [font-awesome]
- [react-datepicker]
- [react-dom]
- [react-router]
- [react-router-dom]
- [react-scripts]


## 🔧 Running the application

Commands for running the application:

1. yarn install (is used to install all dependencies for a project)

2. yarn start

## Screens


1 List of cars:

Displays all registered cars displaying: manufacturer, model, model year, category, weekday_price, weekend_price, weekday_loyalt_price, weekend_loyalt_price.

On this screen it is possible to filter the cars by category, delete cars and choose a car to update.

2. Car registration:

Displays all fields for registering cars

The data from the manufacturer and model fields are presented according to the data consulted by fipeAPI.

3. Screen Find the car at the lowest price (not finished)



## ✍️ Authors <a name = "authors"></a>

- [@annakokay](agebrandao@gmail.com) - Idea & Initial work