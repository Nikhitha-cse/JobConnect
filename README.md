# JobConnect

JobConnect is a full-stack job portal developed using Spring Boot, Spring MVC, Thymeleaf, JPA/Hibernate, and MySQL.

## Features

- User registration
- User login and logout
- Browse available jobs
- Search jobs by title, company, or location
- View detailed job information
- Apply for jobs
- Store job applications in MySQL
- Responsive and professional UI

## Technologies Used

- Java
- Spring Boot
- Spring MVC
- Thymeleaf
- Spring Data JPA
- Hibernate
- MySQL
- HTML
- CSS
- Maven

## Architecture

The project follows the MVC architecture:

**Controller → Service → Repository → MySQL Database**

Thymeleaf is used for server-side rendering of the web pages.

## Project Structure

```text
JobConnect
├── src/main/java
│   └── com.jobconnect
│       ├── controller
│       ├── entity
│       ├── repository
│       └── service
│
├── src/main/resources
│   ├── static
│   │   └── css
│   └── templates
│
├── pom.xml
└── README.md

## Database

The application uses MySQL to store:

- Job information
- User accounts
- Job applications

Database credentials are kept outside the GitHub repository using environment variables.

## How to Run

1. Clone the repository.
2. Configure MySQL.
3. Create the `jobconnect` database.
4. Set the `DB_PASSWORD` environment variable.
5. Open the project in Spring Tool Suite or another Java IDE.
6. Run the Spring Boot application.
7. Open:

```text
http://localhost:8080


Future Improvements
Spring Security
Password encryption
User dashboard
Admin job management
Resume file upload
Application tracking

Author
Nikhitha

