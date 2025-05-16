package Front_End;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {
    public MainPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setAlignmentX(CENTER_ALIGNMENT);
        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SignUpDialog((JFrame) SwingUtilities.getWindowAncestor(MainPanel.this));
            }
        });
        add(signUpButton);

        JButton loginButton = new JButton("Login");
        loginButton.setAlignmentX(CENTER_ALIGNMENT);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LoginDialog((JFrame) SwingUtilities.getWindowAncestor(MainPanel.this));
            }
        });
        add(loginButton);

        JButton takeAttendanceButton = new JButton("Take Attendance");
        takeAttendanceButton.setAlignmentX(CENTER_ALIGNMENT);
        takeAttendanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TakeAttendanceDialog();
            }
        });
        add(takeAttendanceButton);

        JButton editAttendanceButton = new JButton("Edit Attendance");
        editAttendanceButton.setAlignmentX(CENTER_ALIGNMENT);
        editAttendanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new EditAttendanceDialog();
            }
        });
        add(editAttendanceButton);

        JButton generateReportButton = new JButton("Generate Report");
        generateReportButton.setAlignmentX(CENTER_ALIGNMENT);
        generateReportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GenerateReportDialog();
            }
        });
        add(generateReportButton);

        JButton notifyButton = new JButton("Notify Students");
        notifyButton.setAlignmentX(CENTER_ALIGNMENT);
        notifyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new NotifyStudentsDialog();
            }
        });
        add(notifyButton);
    }
}
