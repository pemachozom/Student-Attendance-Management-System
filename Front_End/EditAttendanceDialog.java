package Front_End;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditAttendanceDialog extends JDialog {
    public EditAttendanceDialog() {
        setTitle("Edit Attendance");
        setModal(true);
        setSize(300, 150);
        setLocationRelativeTo(null);

        JLabel emailLabel = new JLabel("Student Email:");
        JTextField emailField = new JTextField(20);
        JButton editButton = new JButton("Edit");

        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to call back-end to edit attendance
                System.out.println("Attendance edited for: " + emailField.getText());
                dispose();
            }
        });

        JPanel panel = new JPanel();
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(editButton);

        add(panel);
        setVisible(true);
    }
}
