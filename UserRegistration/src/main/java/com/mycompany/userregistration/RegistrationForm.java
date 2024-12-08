import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationForm {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RegistrationForm::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Registration Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        // Main panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Username
        JLabel lblUsername = new JLabel("Username:");
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(lblUsername, gbc);

        JTextField txtUsername = new JTextField(20);
        gbc.gridx = 1; gbc.gridy = 0;
        panel.add(txtUsername, gbc);

        // Email
        JLabel lblEmail = new JLabel("Email:");
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(lblEmail, gbc);

        JTextField txtEmail = new JTextField(20);
        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(txtEmail, gbc);

        // Password
        JLabel lblPassword = new JLabel("Password:");
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(lblPassword, gbc);

        JPasswordField txtPassword = new JPasswordField(20);
        gbc.gridx = 1; gbc.gridy = 2;
        panel.add(txtPassword, gbc);

        // Register Button
        JButton btnRegister = new JButton("Register");
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        panel.add(btnRegister, gbc);

        // Feedback label
        JLabel lblFeedback = new JLabel("", SwingConstants.CENTER);
        lblFeedback.setForeground(Color.RED);
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        panel.add(lblFeedback, gbc);

        // Register button action
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText().trim();
                String email = txtEmail.getText().trim();
                String password = new String(txtPassword.getPassword()).trim();

                if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    lblFeedback.setText("All fields are required!");
                } else {
                    lblFeedback.setText("Registration Successful!");
                }
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
