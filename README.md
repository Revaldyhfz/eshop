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

## Reflection 3

### Reflection 3.1

### Project Principles and SOLID Principles Application

- **Open/Closed Principle (OCP)**:
    - Implemented in the `ProductService.create` method to check if the `productId` is null and generate a random UUID if necessary.
      ```java
      public Product create(Product product) {
          if (product.getProductId() == null) {
              UUID uuid = UUID.randomUUID();
              product.setProductId(uuid.toString());
          }
          productData.add(product);
          return product;
      }
      ```

- **Liskov Substitution Principle (LSP)**:
    - Demonstrated by separating the `CarController` and `ProductController` classes to remove dependencies on the `Car` class hierarchy, improving flexibility and maintainability.

- **Dependency Inversion Principle (DIP)**:
    - Introduced interfaces (`CarRepositoryInterface` and `ProductRepositoryInterface`) to decouple the repository classes from the service classes, enhancing testability and flexibility.
      ```java
      // Example of CarRepositoryInterface
      public interface CarRepositoryInterface {
          Car create(Car car);
          Iterator<Car> findAll();
          Car findById(String id);
          Car update(String id, Car updatedCar);
          void delete(String id);
      }
      ```

## Advantages of Applying SOLID Principles

- **OCP**:
    - Increases code flexibility and extensibility. For example, adding new product creation rules or behaviors can be done without modifying existing code.

- **LSP**:
    - Enhances code maintainability and readability. For instance, separating the controllers improves code organization and makes it easier to understand and modify.

- **DIP**:
    - Improves code maintainability and testability. By depending on abstractions rather than concrete implementations, the code becomes easier to test and change.

## Disadvantages of Not Applying SOLID Principles

- **OCP**:
    - Without OCP, modifying existing code to accommodate new requirements can lead to code fragility and increased risk of introducing bugs.

- **LSP**:
    - Violating LSP can result in code that is difficult to understand and maintain, as it may not adhere to expected behaviors and interfaces.

- **DIP**:
    - Lack of DIP can lead to tightly coupled code, making it challenging to test and change individual components without affecting other parts of the system.

## Reflection 4

### Test-Driven Development (TDD) Workflow Evaluation:

#### Reflection on Percival (2017) Self-Reflective Questions:
- *Did I write the tests before the code?* - Yes, I followed the TDD practice by writing failing unit tests before writing the implementation code.
- *Did I only write enough code to fulfill the test?* - Mostly, I focused on writing the minimum code required to pass the failing tests.
- *Did I only refactor after the tests were passing?* - Yes, I ensured that the tests were passing before refactoring the code.
- *Did I make use of IDE auto-completion to generate test methods?* - Yes, I utilized IDE features to streamline the test writing process.
- *Did I follow the "Red, Green, Refactor" cycle strictly?* - Yes, I followed the Red-Green-Refactor cycle iteratively throughout the development process.

#### F.I.R.S.T. Principle Evaluation:

##### F.I.R.S.T. Principle Review:
- *Fast*: The unit tests run quickly and independently, facilitating rapid feedback during development.
- *Isolated/Independent*: Each unit test is isolated from others and does not rely on external dependencies, ensuring independence and reproducibility.
- *Repeatable*: The tests produce consistent results when executed multiple times, enabling reliable verification of code changes.
- *Self-Validating*: The test results are self-explanatory and do not require manual inspection, aiding in the detection of failures.
- *Timely*: The tests are written in a timely manner, preferably before or during code implementation, to ensure early detection of defects.

##### Adherence to F.I.R.S.T. Principle:
- The unit tests adhere to the F.I.R.S.T. principle by being fast, isolated, repeatable, self-validating, and timely.
- Each test focuses on a specific unit of functionality, ensuring clear and concise validation of the code behavior.
- The tests are self-contained and do not rely on external factors, promoting consistency and reliability in the testing process.

### Modifications to Test Suite:

#### Test Suite Adaptation:
- The existing test suite has been modified to accommodate additional test cases and edge scenarios.
- New tests have been added to cover functionalities related to the Cash On Delivery sub-feature, ensuring comprehensive test coverage.
- Test methods have been updated to address any failures or errors encountered during testing, improving the robustness of the test suite.

#### Test Coverage and Quality:

##### Test Coverage Evaluation:
- The test coverage has been expanded to include critical functionalities and edge cases, enhancing the overall quality of the test suite.
- New tests have been added to verify the behavior of the application under different conditions, leading to more thorough validation of the codebase.
- Test assertions have been refined to accurately reflect the expected outcomes and ensure the correctness of the implementation.

##### Future Improvements:
- Continuous efforts will be made to further increase test coverage and improve the quality of the test suite.
- Emphasis will be placed on identifying and addressing any gaps in test coverage, especially in complex or error-prone areas of the codebase.
- Test refactoring and optimization will be performed periodically to maintain the efficiency and effectiveness of the test suite.

### Conclusion

The TDD workflow and adherence to the F.I.R.S.T. principle have been instrumental in ensuring the reliability, maintainability, and quality of the codebase. Continuous reflection and improvement efforts will be pursued to further enhance the testing process and overall project outcomes.

## Contributors

- [Revady Hafizhy Mukhtar](https://github.com/Revaldyhfz)
