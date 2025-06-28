package ui;

import service.StudentService;
import service.InstructorService;
import service.AdminService;
import model.Student;
import model.Instructor;
import model.Admin;
import java.util.Scanner;

public class MainUI {
    private StudentService studentService;
    private InstructorService instructorService;
    private AdminService adminService;
    private Scanner scanner;

    public MainUI() {
        this.studentService = new StudentService();
        this.instructorService = new InstructorService();
        this.adminService = new AdminService();
        this.scanner = new Scanner(System.in);
    }

    public void showMainMenu() {
        while (true) {
            System.out.println("\nCourse Registration System");
            System.out.println("1. Student Login");
            System.out.println("2. Student Register");
            System.out.println("3. Instructor Login");
            System.out.println("4. Admin Login");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = Integer.parseInt(scanner.nextLine());
            
            switch (choice) {
                case 1:
                    studentLogin();
                    break;
                case 2:
                    studentRegister();
                    break;
                case 3:
                    instructorLogin();
                    break;
                case 4:
                    adminLogin();
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void studentLogin() {
        Student student = studentService.authenticateStudent();
        if (student != null) {
            System.out.println("\nWelcome, " + student.getName() + "!");
            studentService.showStudentMenu(student);
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private void studentRegister() {
        if (studentService.registerStudent()) {
            System.out.println("Registration successful. You can now login.");
        } else {
            System.out.println("Registration failed. Username might be taken.");
        }
    }

    private void instructorLogin() {
        Instructor instructor = instructorService.authenticateInstructor();
        if (instructor != null) {
            System.out.println("\nWelcome, " + instructor.getName() + "!");
            instructorService.showInstructorMenu(instructor);
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private void adminLogin() {
        Admin admin = adminService.authenticateAdmin();
        if (admin != null) {
            System.out.println("\nWelcome, " + admin.getName() + "!");
            adminService.showAdminMenu();
        } else {
            System.out.println("Invalid username or password.");
        }
    }
}