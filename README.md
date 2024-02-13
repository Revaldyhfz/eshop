# eShop Project

[https://eshop-revaldyhfz.koyeb.app/](https://eshop-revaldyhfz.koyeb.app/)

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

### Reflection 1.1

#### Clean Code Principles Applied

1. **Descriptive Naming**: Variables, methods, and classes are named descriptively.
2. **Single Responsibility Principle (SRP)**: Each class and method has one clear task.
3. **Code Formatting**: Consistent indentation, spacing, and style are maintained.
4. **Comments**: Code is well-documented with comments to explain complex logic or provide context.

#### Secure Coding Practices

1. **Input Validation**: User inputs are validated on the server-side.
2. **Secure Communication**: HTTPS protocol is used to encrypt data transmitted.
3. **Session Management**: Secure session management practices are implemented.
4. **Password Hashing**: User passwords are securely hashed and salted.

#### Improvements

- Increase test coverage.
- Implement role-based access control.
- Implement logging.

### Reflection 1.2

After writing the unit test, I feel more confident about the reliability of the core functionalities of the application. However, determining the exact number of unit tests to be written in a class can vary depending on factors such as the complexity of the class and the number of methods it contains. Generally, each method and edge case should have its own corresponding unit test to ensure comprehensive coverage.

While achieving 100% code coverage is desirable, it does not guarantee the absence of bugs or errors in the code. Code coverage only measures the extent to which the source code is executed by the tests, but it does not assess the quality or correctness of the tests themselves. Therefore, having 100% code coverage should be seen as a good practice, but it does not replace the need for thorough testing and validation.

Regarding the new functional test suite created to verify the number of items in the product list, the cleanliness of the code may be affected if it follows a similar structure to the previous test suites. Repeating setup procedures and instance variables in each test suite can lead to code duplication and reduced maintainability.

## Reflection 2

### Reflection 2.1

During the exercise, I encountered several code quality issues that required attention. One issue was incomplete test coverage, particularly in the repository and controller classes. To address this, I developed additional test cases to cover untested functionalities, ensuring comprehensive code coverage. Another issue was an untested section of code, which initially seemed like a simple closing curly bracket. However, upon closer inspection, I realized the need for a specific test case to handle scenarios where the product ID is not found, improving the robustness of the application.

### Reflection 2.2

The implemented CI/CD workflows in GitHub/GitLab have effectively met the definition of Continuous Integration and Continuous Deployment. They automate test execution and deployment processes, facilitating early bug detection, rapid delivery of updates, and seamless collaboration among team members.

## Contributors

- [Revady Hafizhy Mukhtar](https://github.com/Revaldyhfz)
