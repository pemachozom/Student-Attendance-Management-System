package Back_End;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AttendanceManagementFramework {

    // Verifies user credentials
    public static class AuthenticationManager {
        // Method to authenticate user
        public static boolean authenticate(String username, String password) {
            // Dummy implementation to authenticate user
            return "admin".equals(username) && "password".equals(password);
        }
    }

    // Checks authorization based on their role
    public static class AuthorizationManager {
        // Method to authorize user based on role
        public static boolean authorize(String username, String role) {
            // Dummy implementation to authorize user based on role
            return "admin".equals(username) && "admin".equals(role);
        }
    }

    // Manages database operations using Singleton
    public static class DatabaseManager {
        private static DatabaseManager instance;
        private Map<String, Student> studentDatabase = new HashMap<>();
        private Map<String, List<AttendanceRecord>> attendanceDatabase = new HashMap<>();

        private DatabaseManager() {}

        // Singleton pattern implementation to ensure a single instance of DatabaseManager
        public static synchronized DatabaseManager getInstance() {
            if (instance == null) {
                instance = new DatabaseManager();
            }
            return instance;
        }

        // Add student to the database
        public void addStudent(Student student) {
            studentDatabase.put(student.getId(), student);
            attendanceDatabase.put(student.getId(), new ArrayList<>());
        }

        // Retrieve student from the database
        public Student getStudent(String id) {
            return studentDatabase.get(id);
        }

        // Add attendance record to the database
        public void addAttendanceRecord(AttendanceRecord record) {
            List<AttendanceRecord> records = attendanceDatabase.get(record.getStudent().getId());
            if (records != null) {
                records.add(record);
            }
        }

        // Edit attendance record in the database
        public void editAttendanceRecord(AttendanceRecord record) {
            List<AttendanceRecord> records = attendanceDatabase.get(record.getStudent().getId());
            if (records != null) {
                for (int i = 0; i < records.size(); i++) {
                    if (records.get(i).getDate().equals(record.getDate())) {
                        records.set(i, record);
                        break;
                    }
                }
            }
        }

        // Retrieve attendance records for a student
        public List<AttendanceRecord> getAttendanceRecords(String studentId) {
            return attendanceDatabase.get(studentId);
        }
    }

    // Handles functions like taking attendance, editing and deleting
    public static class AttendanceManager {
        private DatabaseManager databaseManager;

        public AttendanceManager() {
            this.databaseManager = DatabaseManager.getInstance();
        }

        // Method to take attendance and update database
        public void takeAttendance(Student student, Date date, boolean present) {
            AttendanceRecord record = new AttendanceRecord(student, date, present);
            databaseManager.addAttendanceRecord(record);
        }

        // Method to edit attendance record in database
        public void editAttendance(AttendanceRecord attendanceRecord) {
            databaseManager.editAttendanceRecord(attendanceRecord);
        }

        // Method to delete attendance record from database
        public void deleteAttendance(AttendanceRecord attendanceRecord) {
            // Implementation to delete attendance record from database
            // In this example, we won't implement deletion for simplicity
        }
    }

    // Keeps attendance record
    public static class AttendanceRecord {
        private Student student;
        private Date date;
        private boolean present;

        public AttendanceRecord(Student student, Date date, boolean present) {
            this.student = student;
            this.date = date;
            this.present = present;
        }

        public Student getStudent() {
            return student;
        }

        public Date getDate() {
            return date;
        }

        public boolean isPresent() {
            return present;
        }
    }

    // Generates report
    public static class AttendanceReportGenerator {
        private DatabaseManager databaseManager;

        public AttendanceReportGenerator() {
            this.databaseManager = DatabaseManager.getInstance();
        }

        // Method to generate attendance report for student
        public void generateReport(Student student) {
            List<AttendanceRecord> records = databaseManager.getAttendanceRecords(student.getId());
            int totalClasses = records.size();
            int attendedClasses = (int) records.stream().filter(AttendanceRecord::isPresent).count();
            double attendancePercentage = (double) attendedClasses / totalClasses * 100;
            System.out.println("Attendance Report for " + student.getName() + ": " + attendancePercentage + "%");
        }
    }

    // Sends notification to students
    public static class NotificationManager {
        // Method to send notification to student
        public void notifyStudent(Student student, String message) {
            System.out.println("Notification to " + student.getName() + ": " + message);
        }
    }

    // Represents student details
    public static class Student {
        private String id;
        private String name;
        private String username;
        private String password;
        private String role;

        public Student(String id, String name, String username, String password, String role) {
            this.id = id;
            this.name = name;
            this.username = username;
            this.password = password;
            this.role = role;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public String getRole() {
            return role;
        }
    }

    // Provides the functionalities for students to view attendance
    public static class StudentManager {
        private DatabaseManager databaseManager;

        public StudentManager() {
            this.databaseManager = DatabaseManager.getInstance();
        }

        // Method to retrieve attendance using proxy
        public List<AttendanceRecord> viewAttendance(Student student) {
            return databaseManager.getAttendanceRecords(student.getId());
        }
    }

    public static void main(String[] args) {
        // Framework usage example
        DatabaseManager dbManager = DatabaseManager.getInstance();
        AttendanceManager attendanceManager = new AttendanceManager();
        AttendanceReportGenerator reportGenerator = new AttendanceReportGenerator();
        NotificationManager notificationManager = new NotificationManager();

        // Create a student
        Student student = new Student("1", "John Doe", "john.doe", "password123", "student");
        dbManager.addStudent(student);

        // Take attendance
        attendanceManager.takeAttendance(student, new Date(System.currentTimeMillis()), true);
        attendanceManager.takeAttendance(student, new Date(System.currentTimeMillis() - 86400000L), false); // 1 day ago

        // Generate report
        reportGenerator.generateReport(student);

        // Notify student
        notificationManager.notifyStudent(student, "Your attendance has been updated.");
    }
}
