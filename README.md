# Expense Manager API

A REST API for a personal expense manager built with Java and Spring Boot.

## Features

- Create transactions (income and expenses)
- List all transactions
- Get a transaction by ID
- Delete transactions
- Financial summary: total income, total expenses, current balance
- In-memory H2 database
- Basic amount validation
- 404 response if the ID does not exist

## Screenshots

(https://github.com/JasonArturoVega/Expense-Manager-Spring-Boot/blob/master/src/images/Screenshot%201.png)
(https://github.com/JasonArturoVega/Expense-Manager-Spring-Boot/blob/master/src/images/Screenshot%201.png)

## Technologies

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Maven

## Endpoints

| Method | Path | Description |
|--------|------|-------------|
| GET | `/transactions` | Lists all transactions |
| GET | `/transactions/{id}` | Retrieves a transaction |
| POST | `/transactions` | Creates a transaction |
| DELETE | `/transactions/{id}` | Deletes a transaction |
| GET | `/transactions/summary` | Returns totals |

## How to run

Clone the repository
Open it in IntelliJ IDEA
Run ExpenseManagerApplication
The API is available at http://localhost:8080

How to test
You can use Postman or a similar tool:

- GET http://localhost:8080/transactions
- POST http://localhost:8080/transactions
- DELETE http://localhost:8080/transactions/1
- GET http://localhost:8080/transactions/summary

You can also view the database at:
http://localhost:8080/h2-console
Key takeaways

Controller / Service / Repository structure
Persistence with JPA
REST endpoint design
Basic validation
Handling "resource not found" scenarios

### Creation example (`POST /transactions`)

```json
{
"amount": 1500,
"type": "EXPENSE",
"category": "FOOD",
"description": "Lunch"
}
