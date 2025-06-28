package model;

public class Student {
    private int studentId;
    private String username;
    private String password;
    private String name;

    public Student(int studentId, String username, String password, String name) {
        this.studentId = studentId;
        this.username = username;
        this.password = password;
        this.name = name;
    }

    // Getters and setters
    public int getStudentId() { return studentId; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getName() { return name; }
}