
# FinanceManager – Backend REST API

FinanceManager is a Spring Boot backend application designed to manage personal financial data, including users, categories, and transactions. The system exposes RESTful APIs for creating, updating, and managing financial records using a MySQL database.

This project demonstrates backend engineering skills including REST API design, JPA entity relationships, validation, exception handling, and database integration.

---

### FEATURES

## Category Management

* Create a category
* View all categories
* Update a category
* Delete a category
* Prevents duplicate category names
* Input validation with meaningful error responses

## Transaction Management

* Record income and expense transactions
* Associate transactions with users and categories
* Store transaction amount, description, and date
* Supports transaction types: `INCOME`, `EXPENSE`

## User Management

* User entity support
* Email lookup using repository queries

## Technical Capabilities

* RESTful API architecture
* Spring Data JPA with Hibernate
* MySQL database integration
* Bean validation
* Global exception handling
* Clean layered architecture (Controller → Service → Repository)

---

# Tech Stack

| Layer           | Technology         |
| --------------- | ------------------ |
| Language        | Java 21            |
| Framework       | Spring Boot        |
| ORM             | Hibernate / JPA    |
| Database        | MySQL              |
| Build Tool      | Maven              |
| API Testing     | Postman            |
| IDE             | IntelliJ / VS Code |
| Version Control | Git + GitHub       |

---

## Project Structure


src/main/java/com/lisa/FinanceManager
 ├── controllers
 ├── services
 ├── repositories
 ├── entities
 ├── exceptions
 └── FinanceManagerApplication.java


---

# Setup Instructions

### 1. Clone the Repository


git clone https://github.com/Lisa-byte-creator/FinanceManager.git
cd FinanceManager


---

### 2. Configure Database

Update your `application.properties` file:


spring.datasource.url=jdbc:mysql://localhost:3306/finance_manager
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update
server.port=8081


Make sure MySQL is running and the database exists.

---

### 3. Run the Application

Using IDE:

* Run `FinanceManagerApplication.java`

Or using terminal (if Maven is installed):


mvn spring-boot:run


Application will start on:


http://localhost:8081


---

## API Endpoints

### Category API

| Method | Endpoint               | Description        |
| ------ | ---------------------- | ------------------ |
| POST   | `/api/categories`      | Create category    |
| GET    | `/api/categories`      | Get all categories |
| PUT    | `/api/categories/{id}` | Update category    |
| DELETE | `/api/categories/{id}` | Delete category    |

# Sample POST Request (JSON)

```
{
  "name": "Transport"
}
```

---

Transaction API (Planned / In Progress)

* Create transaction
* View transactions by user
* View transactions by category
* Income and expense tracking

---

Testing

Use Postman or Thunder Client:

* Set request type (POST / GET / PUT / DELETE)
* Set header:

Content-Type: application/json

---

Future Enhancements

* Authentication and authorization
* Frontend user interface
* Dashboard analytics
* Monthly spending summaries
* Cloud deployment

---

Author

Lisa Elsie
Software Developer
GitHub: [https://github.com/Lisa-byte-creator](https://github.com/Lisa-byte-creator)




