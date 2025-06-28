package model;

public class Course {
    private int courseId;
    private String courseCode;
    private String courseName;
    private int instructorId;
    private int capacity;

    public Course(int courseId, String courseCode, String courseName, int instructorId, int capacity) {
        this.courseId = courseId;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.instructorId = instructorId;
        this.capacity = capacity;
    }

    // Getters and setters
    public int getCourseId() { return courseId; }
    public String getCourseCode() { return courseCode; }
    public String getCourseName() { return courseName; }
    public int getInstructorId() { return instructorId; }
    public int getCapacity() { return capacity; }
}