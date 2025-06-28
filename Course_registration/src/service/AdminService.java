package service;

import dao.AdminDAO;
import dao.InstructorDAO;
import dao.CourseDAO;
import model.Admin;
import model.Instructor;
import java.util.List;
import java.util.Scanner;

public class AdminService {
    private AdminDAO adminDAO;
    private InstructorDAO instructorDAO;
    private CourseDAO courseDAO;
    private Scanner scanner;

    public AdminService() {
        this.adminDAO = new AdminDAO();
        this.instructorDAO = new InstructorDAO();
        this.courseDAO = new CourseDAO();
        this.scanner = new Scanner(System.in);
    }

    public Admin authenticateAdmin() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        return adminDAO.authenticate(username, password);
    }

    public void showAdminMenu() {
        while (true) {
            System.out.println("\nAdmin Menu");
            System.out.println("1. Add Course");
            System.out.println("2. View All Instructors");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");
            
            int choice = Integer.parseInt(scanner.nextLine());
            
            switch (choice) {
                case 1:
                    addCourse();
                    break;
                case 2:
                    viewAllInstructors();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addCourse() {
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        
        viewAllInstructors();
        System.out.print("Enter instructor ID: ");
        int instructorId = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Enter course capacity: ");
        int capacity = Integer.parseInt(scanner.nextLine());
        
        if (courseDAO.addCourse(courseCode, courseName, instructorId, capacity)) {
            System.out.println("Course added successfully.");
        } else {
            System.out.println("Failed to add course.");
        }
    }

    private void viewAllInstructors() {
        List<Instructor> instructors = instructorDAO.getAllInstructors();
        System.out.println("\nAll Instructors:");
        for (Instructor instructor : instructors) {
            System.out.println(instructor.getInstructorId() + ": " + instructor.getName());
        }
    }
}