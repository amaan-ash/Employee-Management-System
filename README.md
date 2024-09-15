# Employee Management System 🗃️👔

**Employee Management System** is a robust Java application designed for managing employee records efficiently. It features a simple yet effective interface to handle various employee-related tasks with ease.

## Features ✨

### 1. Login 🔑
- Secure login with username and password
- Authentication to ensure authorized access

### 2. Add Employee ➕
- **Form for Input**: Enter details such as name, position, department, and contact information
- **Validation**: Ensures that all required fields are completed and correct

### 3. View Employees 👁️
- **Employee List**: Displays all employees with options to search and filter
- **Detailed View**: Shows comprehensive information about each employee

### 4. Update Employee ✏️
- **Modify Records**: Edit existing employee details like address, phone number, and job title
- **Save Changes**: Updates are saved in the database

### 5. Remove Employee ❌
- **Delete Records**: Remove employees from the system
- **Confirmation Prompt**: Prevents accidental deletions with a confirmation step

## Tech Stack 🛠️

- **Programming Language**: Java
- **GUI Framework**:
  - **AWT (Abstract Window Toolkit)**: For basic GUI components
  - **Swing**: For enhanced GUI components and functionalities
  
- **Database**: MySQL
  - Manages and stores employee data

- **Database Connectivity**: JDBC (Java Database Connectivity)
  - Facilitates communication between the Java application and MySQL

## Screenshots 📸

| Feature | Screenshot |
|---------|------------|
| **Welcome Page** |<img src="https://github.com/amaan-ash/Employee-Management-System/blob/master/screenshots/splash-screen.png" width="200"/>
| **Dashboard Screen** |<img src="https://github.com/amaan-ash/Employee-Management-System/blob/master/screenshots/dashboard-screen.png" width="200"/>
| **Login Screen** |<img src="https://github.com/amaan-ash/Employee-Management-System/blob/master/screenshots/login-screen.png" width="200"/>|
| **Add Employee Form** |<img src="https://github.com/amaan-ash/Employee-Management-System/blob/master/screenshots/add-employee.png" width="200"/>|
| **Employee List** |<img src="https://github.com/amaan-ash/Employee-Management-System/blob/master/screenshots/view-employees.png" width="200"/>|
| **Update Employee** |<img src="https://github.com/amaan-ash/Employee-Management-System/blob/master/screenshots/update-employee.png" width="200"/>|
| **Remove Employee** |<img src="https://github.com/amaan-ash/Employee-Management-System/blob/master/screenshots/remove-employee.png" width="200"/>|

## Getting Started 🚀

To get a local copy up and running, follow these steps:

### Prerequisites
- Java SDK
- MySQL Server

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/amaan-ash/EmployeeManagementSystem.git
    ```

2. Navigate to the project directory:
    ```bash
    cd EmployeeManagementSystem
    ```

3. Compile the Java files:
    ```bash
    javac -d bin src/*.java
    ```

4. Run the application:
    ```bash
    java -cp bin MainClassName
    ```

5. Configure the database:
    - Update the database connection settings in `db_config.properties` with your MySQL credentials.

## Contributions 🤝

Contributions are welcome! If you have suggestions or improvements, please follow these steps:

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License 📝

Distributed under the MIT License. See `LICENSE` for more information.

## Contact 📧

**Amaan Ali Shaikh** - [skamaanali07@gmail.com](mailto:skamaanali07@gmail.com)

Project Link: [https://github.com/amaan-ash/EmployeeManagementSystem](https://github.com/amaan-ash/EmployeeManagementSystem)

---

*Efficient employee management, simplified.*
