# Customer Database Management System

## Overview
This is a standalone console-based CRUD (Create, Read, Update, Delete) application built using Spring Framework that manages a customer database. The application stores customer details, calculates Simple Interest (SI) based on customer input, and efficiently handles data persistence using Spring JDBC and MySQL.

## Key Features
- **CRUD Operations**: Add, update, retrieve, and delete customer details including:
  - Customer ID (`cid`)
  - Customer Name (`cname`)
  - Customer Address (`caddr`)
  - Principal Amount (`pamt`)
  - Rate of Interest (`rate`)
  - Time Period in years (`time`)
  - Simple Interest (`si`)
  
- **Simple Interest Calculation**: Automatically calculates the Simple Interest using the formula:

  
  Simple Interest (si) = ( Principal(pamt) * Rate(rate) * Time(time) )/100
  

  The result is then stored in the database for each customer.


- **Spring Integration**:
  - Utilizes Spring Context for Dependency Injection (DI) to manage the various service and DAO components.
  - Spring JDBC is used for seamless interaction with the MySQL database, ensuring efficient and secure database operations.

## Bean Definitions
- **CustomerVo (Value Object)**: Represents raw input from the user, where all attributes are stored as String types.
- **CustomerDto (Data Transfer Object)**: Converts data from CustomerVo to their respective types (Integer and Float) and ensures validation between layers.
- **CustomerBo (Business Object)**: Encapsulates the business logic, managing core processing such as calculating Simple Interest and transforming CustomerDto data for persistence.

## Project Structure
The project follows a layered architecture with a clear separation of concerns. Each layer has an interface-to-class implementation structure to promote loose coupling and maintainability:

- **Controller Layer**:
  - Manages user inputs and converts CustomerVo (with all attributes as String types) to CustomerDto (with appropriate types like Integer, Float, etc.).
  - Interface: `ICustomerController`
  - Implementation: `CustomerControllerImpl`
  
- **Service Layer**:
  - Contains business logic for interest calculation and data validation.
  - Interface: `ICustomerService`
  - Implementation: `CustomerServiceImpl`
  
- **DAO Layer**:
  - Handles all database operations (CRUD actions) using Spring JDBC.
  - Interface: `ICustomerDao`
  - Implementation: `CustomerDaoImpl`
  
- **Model Layer**:
  - Represents customer information and interest calculation with beans such as CustomerVo, CustomerDto, and CustomerBo.

- **View**:
  - Console-based interface allowing users to perform CRUD operations and interact with the system.

## Technologies Used
- **Spring Framework**:
  - Spring Core (for Dependency Injection)
  - Spring JDBC (for database access)
- **MySQL**: For storing customer data and calculated interest values.
- **Java**: As the core language for business logic and application flow.
- **Maven**: For managing dependencies like Spring Context, Spring JDBC, and MySQL Connector J.
- **JDBC**: To perform SQL operations like Insert, Update, Delete, and Select.

## Database Schema
The application uses a MySQL database with the following schema for the Customer table:

```sql
CREATE TABLE Customer (
    cid INT AUTO_INCREMENT PRIMARY KEY,
    cname VARCHAR(100),
    caddr VARCHAR(255),
    pamt FLOAT,
    rate FLOAT,
    time INT,
    si FLOAT
);
```
## Future Enhancements
- I will implement a web interface using Spring MVC to provide a more user-friendly experience compared to the console-based interface.
- I aim to extend the interest calculation feature to include more complex formulas, such as compound interest

## Contributing
Feel free to fork this repository, create a new branch, and submit a pull request with your improvements or bug fixes. Contributions are welcome!

## Contact
For any questions or suggestions, please reach out to soudeepghosh7@gmail.com .
