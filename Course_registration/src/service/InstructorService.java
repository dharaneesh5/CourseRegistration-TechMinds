package service;

import dao.InstructorDAO;
import dao.CourseDAO;
import model.Instructor;
import model.Course;
import java.util.List;
import java.util.Scanner;

public class InstructorService {
    private InstructorDAO instructorDAO;
    private CourseDAO courseDAO;
    private Scanner scanner;

    public InstructorService() {
        this.instructorDAO = new InstructorDAO();
        this.courseDAO = new CourseDAO();
        this.scanner = new Scanner(System.in);
    }

    public Instructor authenticateInstructor() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        return instructorDAO.authenticate(username, password);
    }

    public void showInstructorMenu(Instructor instructor) {
        while (true) {
            System.out.println("\nInstructor Menu");
            System.out.println("1. View My Courses");
            System.out.println("2. Logout");
            System.out.print("Choose an option: ");
            
            int choice = Integer.parseInt(scanner.nextLine());
            
            switch (choice) {
                case 1:
                    viewMyCourses(instructor.getInstructorId());
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void viewMyCourses(int instructorId) {
        List<Course> courses = courseDAO.getCoursesByInstructor(instructorId);
        if (courses.isEmpty()) {
            System.out.println("You are not assigned to any courses.");
            return;
        }
        
        System.out.println("\nYour Courses:");
        for (Course course : courses) {
            System.out.println(course.getCourseCode() + " - " + course.getCourseName() + 
                             " (Capacity: " + course.getCapacity() + ")");
        }
    }
}