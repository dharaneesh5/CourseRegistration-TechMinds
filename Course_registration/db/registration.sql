-- Database creation
CREATE DATABASE IF NOT EXISTS course_registration;
USE course_registration;

-- Tables creation
CREATE TABLE IF NOT EXISTS students (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(50) NOT NULL,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS instructors (
    instructor_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(50) NOT NULL,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS admins (
    admin_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(50) NOT NULL,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS courses (
    course_id INT AUTO_INCREMENT PRIMARY KEY,
    course_code VARCHAR(20) UNIQUE NOT NULL,
    course_name VARCHAR(100) NOT NULL,
    instructor_id INT,
    capacity INT NOT NULL,
    FOREIGN KEY (instructor_id) REFERENCES instructors(instructor_id)
);

CREATE TABLE IF NOT EXISTS enrollments (
    enrollment_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT NOT NULL,
    course_id INT NOT NULL,
    enrollment_date DATE NOT NULL,
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (course_id) REFERENCES courses(course_id),
    UNIQUE (student_id, course_id)
);

-- Sample data
INSERT INTO admins (username, password, name) VALUES 
('admin', 'admin123', 'John Admin');

INSERT INTO instructors (username, password, name) VALUES 
('inst1', 'inst123', 'Prof. Smith'),
('inst2', 'inst123', 'Prof. Johnson'),
('inst3', 'inst123', 'Prof. Williams');

INSERT INTO students (username, password, name) VALUES 
('pandi', 'pass123', 'Pandi Selvam'),
('vasanth', 'pass123', 'Vasanth Kumar'),
('kevin', 'pass123', 'Kevin D');

INSERT INTO courses (course_code, course_name, instructor_id, capacity) VALUES 
('CS101', 'Introduction to Programming', 1, 30),
('CS201', 'Data Structures', 2, 25),
('CS301', 'Algorithms', 3, 20),
('MATH101', 'Calculus I', 1, 40),
('PHYS101', 'Physics I', 2, 35),
('ENG101', 'English Composition', 3, 30);