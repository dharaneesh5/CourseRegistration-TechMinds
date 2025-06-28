# Course Registration System

A Java-based application for managing student course enrollments with MySQL database integration.

## Features

### Student Module
- Register/Login
- View available courses
- Enroll/Drop courses
- View personal schedule

### Instructor Module
- View assigned courses
- Check course roster

### Admin Module
- Add/Manage courses
- Manage instructors
- Generate reports

## Technologies Used
- *Backend*: Java (JDBC for database connectivity)
- *Database*: MySQL
- *Architecture*: MVC Pattern
- *Key Concepts*: OOP, Exception Handling, Collections, CRUD Operations

## Database Schema
5 Tables: 
- students, instructors, admins (user accounts)
- courses (course details) 
- enrollments (student-course mappings)

## Setup Instructions

1. *Prerequisites*:
   - Java JDK 8+
   - MySQL Server
   - MySQL Connector/J

2. *Database Setup*:
   bash
   mysql -u root -p < db/registration.sql
   

3. *Configuration*:
   Update database credentials in src/dao/DBConnection.java

4. *Run Application*:
   bash
   cd src/main
   javac Main.java
   java Main
   

## Project Structure

src/
├── model/
│   ├── Admin.java
│   ├── Course.java
│   ├── Enrollment.java
│   ├── Instructor.java
│   └── Student.java
├── dao/
│   ├── AdminDAO.java
│   ├── CourseDAO.java
│   ├── DBConnection.java
│   ├── EnrollmentDAO.java
│   ├── InstructorDAO.java
│   └── StudentDAO.java
├── service/
│   ├── AdminService.java
│   ├── InstructorService.java
│   └── StudentService.java
├── ui/
│   └── MainUI.java
└── main/
    └── Main.java

## Sample Usage
1. Login as admin (username: admin1, password: admin123)
2. Add new courses
3. Login as student to enroll

