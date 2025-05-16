package Back_End;

import Back_End.AttendanceManagementFramework.AuthenticationManager;
import Back_End.AttendanceManagementFramework.AuthorizationManager;
import Back_End.AttendanceManagementFramework.DatabaseManager;
import Back_End.AttendanceManagementFramework.Student;

public class AuthManager {

    // Method to authenticate user
    public static boolean authenticate(String username, String password) {
        return AuthenticationManager.authenticate(username, password);
    }

    // Method to sign up user
    public static boolean signUp(String name, String email, String username, String password) {
        // Add user to the database
        Student student = new Student(name, username, password, "student", password);
        DatabaseManager.getInstance().addStudent(student);
        return true; // Dummy implementation for successful sign up
    }

    // Method to authorize user based on role
    public static boolean authorize(String username, String role) {
        return AuthorizationManager.authorize(username, role);
    }
}
