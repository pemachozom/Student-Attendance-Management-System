package Front_End;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenerateReportDialog extends JDialog {
    public GenerateReportDialog() {
        setTitle("Generate Report");
        setModal(true);
        setSize(300, 150);
        setLocationRelativeTo(null);

        JLabel emailLabel = new JLabel("Student Email:");
        JTextField emailField = new JTextField(20);
        JButton generateButton = new JButton("Generate");

        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to call back-end to generate report
                System.out.println("Report generated for: " + emailField.getText());
                dispose();
            }
        });

        JPanel panel = new JPanel();
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(generateButton);

        add(panel);
        setVisible(true);
    }
}