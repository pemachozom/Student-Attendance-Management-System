package Front_End;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotifyStudentsDialog extends JDialog {
    public NotifyStudentsDialog() {
        setTitle("Notify Students");
        setModal(true);
        setSize(300, 150);
        setLocationRelativeTo(null);

        JLabel messageLabel = new JLabel("Message:");
        JTextField messageField = new JTextField(20);
        JButton notifyButton = new JButton("Notify");

        notifyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to call back-end to send notification
                System.out.println("Notification sent: " + messageField.getText());
                dispose();
            }
        });

        JPanel panel = new JPanel();
        panel.add(messageLabel);
        panel.add(messageField);
        panel.add(notifyButton);

        add(panel);
        setVisible(true);
    }
}