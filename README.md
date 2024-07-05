# Todo Manager Application

## Overview

The Todo Manager is a web-based application built using Spring Boot and Thymeleaf, designed to help users organize their tasks efficiently. It provides essential features for task management, user authentication, and sorting tasks based on different criteria.

## Features

### User Management

- **User Registration and Login:** Users can create accounts and securely log in to manage their tasks.
- **Session Management:** Uses Spring Security for managing user sessions and authentication.

### Task Management

- **Task Creation:** Users can add new tasks with details such as title, description, priority, and due date.
- **Task Listing:** Displays a list of tasks belonging to the logged-in user.
- **Task Sorting:** Tasks can be sorted by title and priority, enhancing user experience in task organization.

### User Interface

- **Responsive Design:** The web interface is responsive, ensuring a consistent experience across different devices and screen sizes.
- **Task Filtering:** Users can filter tasks based on different criteria to find specific tasks quickly.
- **Dark Mode:** Provides a dark mode option for users who prefer a darker color scheme.

### Data Management

- **Database Integration:** Uses PostgreSQL for storing user data and task information.
- **Spring Data JPA:** Implements data access using Spring Data JPA for seamless database operations.

## Technologies Used

- **Backend:** Java, Spring Boot, Spring Security, Spring Data JPA
- **Frontend:** Thymeleaf, HTML, CSS, Bootstrap, Javascript
- **Database:** PostgreSQL
- **Development Tools:** IntelliJ IDEA, Maven

## Setup Instructions

1. **Clone the repository:**
    ```
   git clone https://github.com/shubhranshii/To-Do-Manager.git
    cd todo-manager
   ```

2. **Database Configuration:**
- Install and configure PostgreSQL.
- Update `application.properties` with database credentials.
- create table taskdb with tables users and task.

3. **Build and Run:**
- Build the project using Maven:
  ```
    mvn clean package
  ```
- Run the application:
  ```
    java -jar target/todo-manager-1.0.jar
  ```
  Alternatively run directly from IDE.

4. **Access the Application:**
- Open a web browser and go to `http://localhost:8080`.
- Register a new account or log in with existing credentials to start managing tasks.






