package service;

import dao.StudentDAO;
import dao.EnrollmentDAO;
import dao.CourseDAO;
import model.Student;
import model.Course;
import java.util.List;
import java.util.Scanner;

public class StudentService {
    private StudentDAO studentDAO;
    private EnrollmentDAO enrollmentDAO;
    private CourseDAO courseDAO;
    private Scanner scanner;

    public StudentService() {
        this.studentDAO = new StudentDAO();
        this.enrollmentDAO = new EnrollmentDAO();
        this.courseDAO = new CourseDAO();
        this.scanner = new Scanner(System.in);
    }

    public Student authenticateStudent() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        return studentDAO.authenticate(username, password);
    }

    public boolean registerStudent() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        return studentDAO.registerStudent(username, password, name);
    }

    public void showStudentMenu(Student student) {
        while (true) {
            System.out.println("\nStudent Menu");
            System.out.println("1. View Available Courses");
            System.out.println("2. Enroll in a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. View My Courses");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");
            
            int choice = Integer.parseInt(scanner.nextLine());
            
            switch (choice) {
                case 1:
                    viewAvailableCourses();
                    break;
                case 2:
                    enrollCourse(student.getStudentId());
                    break;
                case 3:
                    dropCourse(student.getStudentId());
                    break;
                case 4:
                    viewMyCourses(student.getStudentId());
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void viewAvailableCourses() {
        List<Course> courses = courseDAO.getAllCourses();
        System.out.println("\nAvailable Courses:");
        for (Course course : courses) {
            System.out.println(course.getCourseCode() + " - " + course.getCourseName());
        }
    }

    private void enrollCourse(int studentId) {
        viewAvailableCourses();
        System.out.print("Enter course code to enroll: ");
        String courseCode = scanner.nextLine();
        
        List<Course> courses = courseDAO.getAllCourses();
        for (Course course : courses) {
            if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
                if (enrollmentDAO.enrollStudent(studentId, course.getCourseId())) {
                    System.out.println("Successfully enrolled in " + course.getCourseName());
                } else {
                    System.out.println("Failed to enroll or already enrolled.");
                }
                return;
            }
        }
        System.out.println("Course not found.");
    }

    private void dropCourse(int studentId) {
        List<Course> myCourses = enrollmentDAO.getStudentCourses(studentId);
        if (myCourses.isEmpty()) {
            System.out.println("You are not enrolled in any courses.");
            return;
        }
        
        System.out.println("\nYour Enrolled Courses:");
        for (Course course : myCourses) {
            System.out.println(course.getCourseCode() + " - " + course.getCourseName());
        }
        
        System.out.print("Enter course code to drop: ");
        String courseCode = scanner.nextLine();
        
        for (Course course : myCourses) {
            if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
                if (enrollmentDAO.dropCourse(studentId, course.getCourseId())) {
                    System.out.println("Successfully dropped " + course.getCourseName());
                } else {
                    System.out.println("Failed to drop course.");
                }
                return;
            }
        }
        System.out.println("Course not found in your enrollments.");
    }

    private void viewMyCourses(int studentId) {
        List<Course> myCourses = enrollmentDAO.getStudentCourses(studentId);
        if (myCourses.isEmpty()) {
            System.out.println("You are not enrolled in any courses.");
            return;
        }
        
        System.out.println("\nYour Enrolled Courses:");
        for (Course course : myCourses) {
            System.out.println(course.getCourseCode() + " - " + course.getCourseName());
        }
    }
}