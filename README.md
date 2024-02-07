# eShop Project

## Overview

The eShop project is a web application designed to manage products in an online store. It allows users to create, edit, delete, and view products in the store's inventory.

## Features

- Create new products with names and quantities
- Edit existing product details
- Delete products from the inventory
- View a list of all products in the inventory

## Technologies Used

- Spring Boot
- Thymeleaf
- Mockito
- JUnit
- Selenium WebDriver

## Project Structure

The project follows the MVC (Model-View-Controller) architecture:

- `src/main/java`: Contains Java source code
- `src/main/resources`: Contains application properties and HTML templates
- `src/test/java`: Contains unit and functional tests

## Reflection 1
## Clean Code Principles Applied

1. **Descriptive Naming**: Variables, methods, and classes are named in a descriptive manner, making the code easier to understand.
2. **Single Responsibility Principle (SRP)**: Each class and method is responsible for one clear task, promoting modularity and maintainability.
3. **Code Formatting**: Consistent indentation, spacing, and code style are maintained throughout the project for readability.
4. **Comments**: Code is well-documented with comments to explain complex logic or provide context where necessary.

## Secure Coding Practices

1. **Input Validation**: User inputs are validated on the server-side to prevent injection attacks and ensure data integrity.
2. **Secure Communication**: HTTPS protocol is used to encrypt data transmitted between the client and server, ensuring confidentiality.
3. **Session Management**: Secure session management practices are implemented to prevent session hijacking and ensure user authentication and authorization.
4. **Password Hashing**: User passwords are securely hashed and salted before storage to protect against data breaches and unauthorized access.

## Improvements

- Increase test coverage: Write more unit and functional tests to cover edge cases and improve code reliability.
- Implement role-based access control: Restrict access to certain features based on user roles to enhance security.
- Implement logging: Add logging functionality to track system events and aid in debugging and auditing.


## Reflection 2

After writing the unit test, I feel more confident about the reliability of the core functionalities of the application. However, determining the exact number of unit tests to be written in a class can vary depending on factors such as the complexity of the class and the number of methods it contains. Generally, each method and edge case should have its own corresponding unit test to ensure comprehensive coverage.

While achieving 100% code coverage is desirable, it does not guarantee the absence of bugs or errors in the code. Code coverage only measures the extent to which the source code is executed by the tests, but it does not assess the quality or correctness of the tests themselves. Therefore, having 100% code coverage should be seen as a good practice, but it does not replace the need for thorough testing and validation.

Regarding the new functional test suite created to verify the number of items in the product list, the cleanliness of the code may be affected if it follows a similar structure to the previous test suites. Repeating setup procedures and instance variables in each test suite can lead to code duplication and reduced maintainability.

Potential clean code issues in the new functional test suite:

1. **Code Duplication**: Repeating setup procedures and instance variables in each test suite can lead to code duplication.
2. **Low Cohesion**: Each test suite should focus on testing a specific feature or functionality, but if setup procedures are duplicated, it can reduce cohesion.
3. **High Coupling**: Dependency on specific instance variables and setup procedures can increase coupling between test cases and reduce flexibility.

Possible improvements to make the code cleaner:

1. **Test Setup Method**: Create a separate setup method or class to handle common setup procedures and instance variables shared across test suites.
2. **Parameterized Tests**: Consider using parameterized tests to test different scenarios with varying input values, reducing the need for separate test cases for each scenario.
3. **Test Data Generation**: Use test data generation techniques to create test objects dynamically, reducing dependency on hardcoded values and improving test flexibility.

By addressing these clean code issues and making the necessary improvements, the new functional test suite can maintain code quality and readability while ensuring comprehensive test coverage.


## Contributors

- [Revady Hafizhy Mukhtar](https://github.com/Revaldyhfz)


