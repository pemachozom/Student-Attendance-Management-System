package Front_End;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TakeAttendanceDialog extends JDialog {
    public TakeAttendanceDialog() {
        setTitle("Take Attendance");
        setModal(true);
        setSize(300, 150);
        setLocationRelativeTo(null);

        JLabel emailLabel = new JLabel("Student Email:");
        JTextField emailField = new JTextField(20);
        JButton presentButton = new JButton("Present");
        JButton absentButton = new JButton("Absent");

        presentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                takeAttendance(emailField.getText(), true);
            }
        });

        absentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                takeAttendance(emailField.getText(), false);
            }
        });

        JPanel panel = new JPanel();
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(presentButton);
        panel.add(absentButton);

        add(panel);
        setVisible(true);
    }

    private void takeAttendance(String email, boolean present) {
        // Code to call back-end to take attendance
        System.out.println("Attendance taken for: " + email + " - Present: " + present);
        dispose();
    }
}
