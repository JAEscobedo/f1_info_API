# F1 Info API

## Project Description
The F1 Info API is a RESTful API built with Spring Boot that provides comprehensive data related to Formula 1 drivers. This API allows you to manage driver information including their personal details, team affiliations, and racing numbers.

## Technologies Used
- **Java 21** - Programming language
- **Spring Boot 3.5.7** - Framework for building the API
- **Spring Data JPA** - For database operations
- **H2 Database** - In-memory database for development
- **Lombok** - To reduce boilerplate code
- **Maven** - Build and dependency management

## Prerequisites
Before running this project, make sure you have:
- Java 21 (JDK) installed
- Maven 3.9+ installed
- Your `JAVA_HOME` environment variable set to JDK 21

## Installation Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/JAEscobedo/f1_info_API.git
   ```

2. Navigate to the project directory:
   ```bash
   cd f1_info_API/myapp
   ```

3. Build the project:
   ```bash
   mvn clean install
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

The API will start on `http://localhost:8081`

## API Endpoints

### Drivers Endpoints
Base URL: `http://localhost:8081/api/v1/f1_info/drivers`

#### Get All Drivers
```http
GET /api/v1/f1_info/drivers
```
Returns a list of all drivers.

#### Get Driver by ID
```http
GET /api/v1/f1_info/drivers/{id}
```
Returns a specific driver by ID.

**Parameters:**
- `id` (Long) - Driver ID

**Response:** `200 OK` or `404 Not Found`

#### Create a New Driver
```http
POST /api/v1/f1_info/drivers
```

**Request Body:**
```json
{
  "firstName": "Max",
  "lastName": "Verstappen",
  "team": "Red Bull Racing",
  "nationality": "Dutch",
  "driverNumber": 1
}
```

**Response:** `201 Created`

#### Update a Driver
```http
PUT /api/v1/f1_info/drivers/{id}
```

**Parameters:**
- `id` (Long) - Driver ID

**Request Body:**
```json
{
  "firstName": "Max",
  "lastName": "Verstappen",
  "team": "Red Bull Racing",
  "nationality": "Dutch",
  "driverNumber": 1
}
```

**Response:** `200 OK` or `404 Not Found`

#### Delete a Driver
```http
DELETE /api/v1/f1_info/drivers/{id}
```

**Parameters:**
- `id` (Long) - Driver ID

**Response:** `204 No Content` or `404 Not Found`

## Database
The project uses H2 in-memory database for development. The database is automatically created and populated when the application starts.

To access the H2 Console (if enabled):
- URL: `http://localhost:8081/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (leave blank)

## Testing
You can test the API endpoints using:
- **Postman** - Recommended
- **Thunder Client** (VS Code extension)
- **curl** commands

Example curl command:
```bash
curl -X GET http://localhost:8081/api/v1/f1_info/drivers
```

## Contributing Guidelines
**This project is open to collaboration!** Contributions are welcome and appreciated. 

To contribute:

1. Fork the repository
2. Create a new branch for your feature or bug fix:
   ```bash
   git checkout -b feature/your-feature-name
   ```

3. Make your changes and commit them with descriptive messages:
   ```bash
   git commit -m "Add: description of your changes"
   ```

4. Push to your branch:
   ```bash
   git push origin feature/your-feature-name
   ```

5. Create a Pull Request with a clear description of your changes

### Coding Standards
- Follow Java naming conventions
- Write clear, self-documenting code
- Add comments for complex logic
- Ensure all endpoints are properly tested

### Ideas for Contributions
- Add more F1 entities (Teams, Races, Circuits, etc.)
- Implement search and filtering capabilities
- Add data validation and error handling
- Create unit and integration tests
- Add API documentation with Swagger/OpenAPI
- Implement authentication and authorization

## License Information
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for more details.

## Author
**JAEscobedo**

## Contact
For questions or suggestions, please open an issue in the repository.

---
**Note:** This is a learning/practice project. Feel free to use it as a starting point for your own F1 API or similar projects!