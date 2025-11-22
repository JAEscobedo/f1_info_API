<div align="center">

<img width="200" height="auto" alt="f1_info_api_logo" src="https://github.com/user-attachments/assets/82f1c39c-4bcb-4444-9e3f-03baaa4d2a51" />

# F1 Info API

![GitHub license](https://img.shields.io/github/license/JAEscobedo/f1_info_API?style=flat-square&color=blue)
![GitHub last commit](https://img.shields.io/github/last-commit/JAEscobedo/f1_info_API?style=flat-square&color=orange)
![GitHub repo size](https://img.shields.io/github/repo-size/JAEscobedo/f1_info_API?style=flat-square&color=green)

<p>
  <b>A comprehensive RESTful API for Formula 1 driver management built with Spring Boot.</b>
</p>

<br>

<img src="https://img.shields.io/badge/Java_21-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java 21" />
  <img src="https://img.shields.io/badge/Spring_Boot_3.5.7-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white" alt="Spring Boot 3.5.7" />
  <img src="https://img.shields.io/badge/Spring_Data_JPA-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white" alt="Spring Data JPA" />
  <img src="https://img.shields.io/badge/H2_Database-003B57?style=for-the-badge&logoColor=white" alt="H2 Database" />
  <img src="https://img.shields.io/badge/Project_Lombok-BC0230?style=for-the-badge&logo=lombok&logoColor=white" alt="Lombok" />
  <img src="https://img.shields.io/badge/Apache_Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" alt="Maven" />

</div>

---

## Table of Contents
- [Project Description](#project-description)
- [Prerequisites](#prerequisites)
- [Installation & Setup](#installation-instructions)
- [API Endpoints](#api-endpoints)
- [Database](#database)
- [Testing](#testing)
- [Contributing](#contributing-guidelines)
- [License & Author](#license-information)

---

## Project Description
The **F1 Info API** is a RESTful API built with Spring Boot that provides comprehensive data related to Formula 1 drivers. This API allows you to manage driver information including their personal details, team affiliations, and racing numbers. It currently includes the full driver lineup for the **2024 Formula 1 Season**. It is designed as a learning project to demonstrate clean architecture and REST principles.

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

### Season Endpoints
Base URL: `http://localhost:8081/api/v1/f1_info`

#### Get Available Seasons
```http
GET /api/v1/f1_info/seasons
```
Returns a list of all available seasons in the database.

#### Get Season Statistics
```http
GET /api/v1/f1_info/seasons/{season}/stats
```
Returns statistics for a specific season (total drivers, total teams, etc.).

#### Get Teams by Season
```http
GET /api/v1/f1_info/seasons/{season}/teams
```
Returns a list of all teams participating in a specific season.

### Driver Endpoints

#### Get Current Season Drivers
```http
GET /api/v1/f1_info/drivers
```
Returns a list of drivers for the current season (defaults to 2024).

#### Get All Drivers (All Seasons)
```http
GET /api/v1/f1_info/drivers/all
```
Returns a list of all drivers across all seasons.

#### Get Drivers by Season
```http
GET /api/v1/f1_info/seasons/{season}/drivers
```
Returns a list of drivers for a specific season.

#### Get Driver by Season and ID
```http
GET /api/v1/f1_info/seasons/{season}/drivers/{driverId}
```
Returns a specific driver from a specific season.

#### Get Drivers by Team and Season
```http
GET /api/v1/f1_info/seasons/{season}/teams/{team}/drivers
```
Returns a list of drivers for a specific team in a specific season.

#### Get Driver by ID
```http
GET /api/v1/f1_info/drivers/{id}
```
Returns a specific driver by their unique database ID.

### Management Endpoints

#### Create a New Driver
```http
POST /api/v1/f1_info/drivers
```

**Request Body:**
```json
{
  "firstName": "Kimi",
  "lastName": "Antonelli",
  "team": {
    "id": 1
  },
  "nationality": "Mexico",
  "driverNumber": 11,
  "season": 2024,
  "driverChampionshipPoints": 152,
  "driverChampionshipPosition": 8
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
  "id": 1,
  "firstName": "Max",
  "lastName": "Verstappen",
  "team": {
    "id": 1,
    "name": "Red Bull Racing",
    "principal": "Christian Horner",
    "base": "Milton Keynes"
  },
  "nationality": "Netherlands",
  "driverNumber": 1,
  "season": 2024,
  "driverChampionshipPoints": 437,
  "driverChampionshipPosition": 1
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
- JDBC URL: `jdbc:h2:mem:f1db`
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

If you're looking for something to work on, check out the [Issues](https://github.com/JAEscobedo/f1_info_API/issues) tab! We have a list of features and improvements we'd love help with.

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
