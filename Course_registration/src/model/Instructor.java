package model;

public class Instructor {
    private int instructorId;
    private String username;
    private String password;
    private String name;

    public Instructor(int instructorId, String username, String password, String name) {
        this.instructorId = instructorId;
        this.username = username;
        this.password = password;
        this.name = name;
    }

    // Getters and setters
    public int getInstructorId() { return instructorId; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getName() { return name; }
}