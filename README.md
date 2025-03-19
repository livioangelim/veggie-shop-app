# Veggie Shop Application

## Overview
The Veggie Shop Application is a Spring Boot web application designed for selling fresh produce to customers. It provides functionalities for managing product inventory, processing orders, and handling customer interactions in a user-friendly manner.

## Features
- **Product Management**: Add, update, and delete products from the inventory.
- **Order Processing**: Customers can place orders and receive confirmations.
- **Error Handling**: Custom error pages and global exception handling for a better user experience.
- **Responsive Design**: The application is designed to be responsive and user-friendly.

## Project Structure
```
veggie-shop-app
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── veggieshop
│   │   │           ├── VeggieShopApplication.java
│   │   │           ├── config
│   │   │           │   └── WebConfig.java
│   │   │           ├── controller
│   │   │           │   ├── AboutController.java
│   │   │           │   ├── MainController.java
│   │   │           │   ├── OrderController.java
│   │   │           │   ├── ProductController.java
│   │   │           │   └── error
│   │   │           │       └── ErrorController.java
│   │   │           ├── dto
│   │   │           │   ├── OrderDto.java
│   │   │           │   └── ProductDto.java
│   │   │           ├── exception
│   │   │           │   ├── GlobalExceptionHandler.java
│   │   │           │   ├── InsufficientInventoryException.java
│   │   │           │   └── ResourceNotFoundException.java
│   │   │           ├── model
│   │   │           │   ├── BaseEntity.java
│   │   │           │   ├── Customer.java
│   │   │           │   ├── Order.java
│   │   │           │   ├── OrderItem.java
│   │   │           │   └── Product.java
│   │   │           ├── repository
│   │   │           │   ├── CustomerRepository.java
│   │   │           │   ├── OrderItemRepository.java
│   │   │           │   ├── OrderRepository.java
│   │   │           │   └── ProductRepository.java
│   │   │           ├── service
│   │   │           │   ├── CustomerService.java
│   │   │           │   ├── OrderService.java
│   │   │           │   ├── ProductService.java
│   │   │           │   └── impl
│   │   │           │       ├── CustomerServiceImpl.java
│   │   │           │       ├── OrderServiceImpl.java
│   │   │           │       └── ProductServiceImpl.java
│   │   │           └── validator
│   │   │               ├── OrderValidator.java
│   │   │               └── ProductValidator.java
│   │   └── resources
│   │       ├── application.properties
│   │       ├── static
│   │       │   ├── css
│   │       │   │   ├── main.css
│   │       │   │   └── forms.css
│   │       │   ├── js
│   │       │   │   └── main.js
│   │       │   └── images
│   │       └── templates
│   │           ├── about.html
│   │           ├── fragments
│   │           │   ├── footer.html
│   │           │   └── header.html
│   │           ├── error
│   │           │   ├── 404.html
│   │           │   └── general-error.html
│   │           ├── index.html
│   │           ├── product
│   │           │   ├── list.html
│   │           │   ├── form.html
│   │           │   └── details.html
│   │           └── order
│   │               ├── checkout.html
│   │               └── confirmation.html
│   └── test
│       └── java
│           └── com
│               └── veggieshop
│                   ├── controller
│                   │   ├── ProductControllerTest.java
│                   │   └── OrderControllerTest.java
│                   ├── service
│                   │   ├── ProductServiceTest.java
│                   │   └── OrderServiceTest.java
│                   └── repository
│                       └── ProductRepositoryTest.java
├── .gitignore
├── README.md
├── mvnw
├── mvnw.cmd
└── pom.xml
```

## Getting Started
1. Clone the repository:
   ```
   git clone https://github.com/<username>/veggie-shop-app.git
   ```
2. Navigate to the project directory:
   ```
   cd veggie-shop-app
   ```
3. Run the application:
   ```
   ./mvnw spring-boot:run
   ```

## Technologies Used
- Java 11
- Spring Boot
- Thymeleaf
- Maven
- H2 Database (for development)


## Technologies Used
- Java 17
- Spring Boot 2.6.6
- Thymeleaf
- Spring Data JPA
- Spring Security
- Maven
- H2 Database (for development)
- Lombok
- Spring Boot DevTools

## Implementation Plan

### Phase 1: Project Setup and Basic Structure (Week 1)
- [x] Initialize Spring Boot project with necessary dependencies
- [ ] Set up project structure following clean architecture principles
- [ ] Configure H2 database for development
- [ ] Implement basic Spring Security configuration
- [ ] Create basic Thymeleaf templates with fragments

### Phase 2: Core Domain Implementation (Week 2)
- [ ] Design and implement domain models with proper OOP principles
  - [ ] Create base abstract classes/interfaces for common functionality
  - [ ] Implement domain-specific validations
  - [ ] Apply proper encapsulation and inheritance patterns
- [ ] Implement repository layer with Spring Data JPA
- [ ] Develop service layer with well-defined interfaces
  - [ ] Apply SOLID principles, especially Single Responsibility and Interface Segregation
  - [ ] Implement proper exception handling
  - [ ] Add business validation logic

### Phase 3: UI Development (Week 3)
- [ ] Create responsive Thymeleaf templates
  - [ ] Implement reusable fragments (header, footer, navigation)
  - [ ] Design product listing and details pages
  - [ ] Create shopping cart and checkout flow
- [ ] Implement form validation with error messages
- [ ] Add client-side enhancements with JavaScript where necessary

### Phase 4: Testing and Security (Week 4)
- [ ] Implement comprehensive unit tests for service layer
- [ ] Add integration tests for controllers and repositories
- [ ] Configure proper security with authentication and authorization
- [ ] Implement role-based access control (customer vs. admin)
- [ ] Add proper logging throughout the application

### Phase 5: Final Touches and Deployment (Week 5)
- [ ] Perform code review and refactoring
- [ ] Optimize performance where necessary
- [ ] Document API endpoints
- [ ] Prepare production configuration
- [ ] Set up CI/CD pipeline

## Architecture and Design Patterns

### Clean Architecture
The application follows a layered architecture:
- **Presentation Layer**: Controllers and views
- **Service Layer**: Business logic and orchestration
- **Repository Layer**: Data access
- **Domain Layer**: Core business entities and logic

### Design Patterns Used
- **Repository Pattern**: For data access abstraction
- **DTO Pattern**: For data transfer between layers
- **Factory Pattern**: For creating complex objects
- **Strategy Pattern**: For implementing different business rules
- **Template Method**: For defining skeleton algorithms in base classes

### OOP Principles Applied
- **Inheritance**: Base entity class extended by domain models
- **Encapsulation**: Private fields with accessor methods
- **Polymorphism**: Interface implementations for services
- **Abstraction**: Abstract classes and interfaces for common behavior

## Contributing
Contributions are welcome! Please open an issue or submit a pull request for any enhancements or bug fixes.

## License
This project is licensed under the MIT License. See the LICENSE file for more details.

## Contributing
Contributions are welcome! Please open an issue or submit a pull request for any enhancements or bug fixes.

## License
This project is licensed under the MIT License. See the LICENSE file for more details.