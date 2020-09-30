### Car System. 

The Car System was implemented with a back-end in Spring boot

---

## ðŸ�� Getting Started 

These instructions will get you a copy of the project for running on your local machine.

---

### Back-end (ApiCarSystem)

The ApiCarSystm runs on port 3000 and uses the H2 database

The application.properties file contains the connection data to the database

## â›�ï¸� Built Using 

- [Maven dependencies]


## ðŸ”§ Running the application

Run as Java application


## End-points:

# Users:

1. Lists all users:

(Get) http://localhost:3000/ApiCarSystem/user

ðŸŽˆ return json

[
  {
    "id": 1,
    "firstName": "Maria",
    "lastName": "teste",
    "email": "teste@gmail,com",
    "birthday": "2020-01-01",
    "phone": "8133336658",
    "login": "maria",
    "password": "12346",
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

 ðŸ§� Body:
 
 {
	"name": "Mary",
	"email": "mary@email.com",
	"is_loyalty": false
}

ðŸŽˆ return

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

 ðŸ§� Body:
{
	"name": "Anne",
	"is_loyalty": false
}

ðŸŽˆ return 

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

ðŸŽˆ return
{
    "message": "Deleted user!"
}

# Cars:

1. Lists all cars:

(Get) http://localhost:3000/ApiCarSystem/car

ðŸŽˆ return
[
  {
    "id": 1,
    "licensePlate": "kkk-1234",
    "model": "ka",
    "color": "preto"
  }
]

2. Create car: 

(Post) http://localhost:3001/cars

 ðŸ§� Body:
 
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

ðŸŽˆ return

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

 ðŸ§� Body:
 
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

ðŸŽˆ return 

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

ðŸŽˆ return
{
    "message": "Deleted car!"
}

# Rents:

1. Lists all rents:

(Get) http://localhost:3001/rents

ðŸŽˆ return

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

 ðŸ§� Body:
 
 {
  {
	"user_id": 1,
	"car_id": 1,
	"start_date": "20201020",
	"end_date": "20201021",
	"rent_cost": 200.00
 }
}

ðŸŽˆ return
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

 ðŸ§� Body:
{
	"start_date": "20201020",
	"end_date": "20201021",
	"rent_cost": 300.00
}

ðŸŽˆ return 

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

ðŸŽˆ return
{
    "message": "Deleted rent!"
}

# Searches:

1. Lists all cars by category:

(Get) http://localhost:3001/carsByCategorySearch

 ðŸ§� Body:
{
	"category": "1"
}

ðŸŽˆ return 

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

 ðŸ§� Body:
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

ðŸŽˆ return 

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





## âœ�ï¸� Authors <a name = "authors"></a>

- [@annakokay](agebrandao@gmail.com) - Idea & Initial work