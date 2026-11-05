# PassItOn – Community Resource Sharing and Exchange System

**Share what you can. Find what you need.**

PassItOn is a Java-based community resource sharing and exchange system developed using Object-Oriented Programming (OOP) concepts, JDBC, and MySQL. It helps organize information about useful resources that can be shared or donated within a community.

The application allows users to add, view, search, update, and delete resource listings, making resource management easier and encouraging reuse instead of unnecessary wastage.

## Features

- **Add Resources:** Add new resources with details such as title, category, description, sharing type, condition, owner name, and availability.
- **View Resources:** Display resource listings stored in the database.
- **Search Resources:** Find resources using relevant search criteria.
- **Update Resources:** Modify details of existing resource listings.
- **Delete Resources:** Remove resource listings from the database.
- **Persistent Storage:** Store resource information in a MySQL database using JDBC.

## Technologies Used

| Technology | Purpose |
|---|---|
| Java | Application development |
| Java Console | User interaction |
| JDBC | Java–database connectivity |
| MySQL | Database management |
| VS Code | Development environment |

## Object-Oriented Programming Concepts

The project demonstrates the following OOP concepts:

- **Encapsulation:** Organizing resource data and related operations within classes.
- **Inheritance:** Using specialized resource classes derived from a common resource class.
- **Abstraction:** Defining common resource behavior through abstract classes and interfaces.
- **Polymorphism:** Supporting different resource types through common parent-class references and overridden methods.
- **Classes and Objects:** Structuring the application into reusable and organized components.

## Project Structure

```text
PassItOn/
│
├── src/
│   ├── Main.java
│   ├── PassItOnConsole.java
│   ├── Resource.java
│   ├── BookResource.java
│   ├── GeneralResource.java
│   ├── ResourceOperations.java
│   ├── ResourceDAO.java
│   └── DatabaseConnection.java
│
├── schema.sql
├── db.properties
├── .gitignore
└── README.md
```

*Note: Adjust the structure above if your actual project contains additional folders or files.*

## Prerequisites

Before running the application, ensure that you have:

- Java Development Kit (JDK 21 or a compatible version).
- MySQL Server.
- MySQL Connector/J (JDBC driver).
- Visual Studio Code or another Java development environment.

## Database Setup

1. Install and start MySQL Server.
2. Open MySQL Workbench and connect to your MySQL server.
3. Create the project database:

```sql
CREATE DATABASE passiton;
```

4. Select the database:

```sql
USE passiton;
```

5. Execute the SQL statements in `schema.sql` to create the required tables.

## Database Configuration

The application uses a `db.properties` file to store database connection settings.

Create the file in the project root directory:

```properties
db.url=jdbc:mysql://localhost:3306/passiton
db.username=YOUR_MYSQL_USERNAME
db.password=YOUR_MYSQL_PASSWORD
```

Replace the placeholder values with your MySQL account credentials.

**Important:** Do not upload `db.properties` or expose database credentials in a public repository. The file should be excluded using `.gitignore`.

## Running the Application

### 1. Clone the Repository

```bash
git clone YOUR_GITHUB_REPOSITORY_URL
```

Navigate into the project directory:

```bash
cd PassItOn
```

### 2. Configure the Database

- Start your MySQL server.
- Execute `schema.sql` in MySQL Workbench.
- Create and configure `db.properties` in the project root directory.
- Ensure that your MySQL account has the necessary privileges on the `passiton` database.

### 3. Add MySQL Connector/J

Download the MySQL Connector/J JDBC driver and place the JAR file in a `lib` folder inside the project.

Example:

```text
PassItOn/
├── lib/
│   └── mysql-connector-j-<version>.jar
```

### 4. Compile the Java Files

Open the terminal in the project root directory.

**Windows:**

```bash
javac -cp "lib/*" -d out src/*.java
```

### 5. Run the Application

**Windows:**

```bash
java -cp "out;lib/*" Main
```

The application will start in the terminal and display the PassItOn main menu.

**Note:** The commands above assume that all Java files are directly inside `src/`, have no package declarations, and that `Main.java` contains the `main()` method. If your project uses packages, the commands and class name may need adjustment.

## Sample Resource Categories

The application can be used to manage resources such as:

- Books and educational materials
- Stationery and drawing instruments
- Electronic accessories
- College supplies
- Other reusable resources

## Future Enhancements

Possible future improvements include:

- User registration and authentication.
- A resource request and approval mechanism.
- Improved resource filtering and categorization.
- A graphical user interface.
- Notifications for resource availability.
- Support for a larger community of users.

## Project Objective

PassItOn aims to encourage a culture of sharing, reduce resource wastage, and make useful resources easier to discover within a community. It also demonstrates the practical application of Java OOP concepts and relational database connectivity.

---

**PassItOn – Share what you can. Find what you need.**