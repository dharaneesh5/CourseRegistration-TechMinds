package model;

public class Admin {
    private int adminId;
    private String username;
    private String password;
    private String name;

    public Admin(int adminId, String username, String password, String name) {
        this.adminId = adminId;
        this.username = username;
        this.password = password;
        this.name = name;
    }

    // Getters and setters
    public int getAdminId() { return adminId; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getName() { return name; }
}