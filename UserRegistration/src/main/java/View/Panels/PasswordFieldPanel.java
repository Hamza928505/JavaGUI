/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Panels;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

/**
 *
 * @author حمزة
 */
public class PasswordFieldPanel extends JPanel {

    private JLabel passwordLabel, confirmLabel;
    private JPasswordField passwordField, confirmPasswordField;

    public PasswordFieldPanel(String passwordLabel, String confirmLabel) {
        this.passwordLabel = new JLabel(passwordLabel);
        this.passwordField = new JPasswordField(10);

        this.confirmLabel = new JLabel(confirmLabel);
        this.confirmPasswordField = new JPasswordField(10);

        this.passwordLabel.setPreferredSize(new Dimension(120, 20));
        this.confirmLabel.setPreferredSize(new Dimension(120, 20));
        
        this.setLayout(new GridLayout(2, 1, 0, 10));
        
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT, 30, 10);
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        panel1.setLayout(flowLayout);
        panel2.setLayout(flowLayout);
        
        panel1.add(this.passwordLabel);
        panel1.add(this.passwordField);
        
        panel2.add(this.confirmLabel);
        panel2.add(this.confirmPasswordField);
        
        this.add(panel1);
        this.add(panel2);
    }

    public JLabel getPasswordLabel() {
        return passwordLabel;
    }

    public void setPasswordLabel(JLabel passwordLabel) {
        this.passwordLabel = passwordLabel;
    }

    public JLabel getConfirmLabel() {
        return confirmLabel;
    }

    public void setConfirmLabel(JLabel confirmLabel) {
        this.confirmLabel = confirmLabel;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public JPasswordField getConfirmPasswordField() {
        return confirmPasswordField;
    }

    public void setConfirmPasswordField(JPasswordField confirmPasswordField) {
        this.confirmPasswordField = confirmPasswordField;
    }

    
    public boolean isValidPassword() throws IllegalArgumentException {
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();
        
        if (password == null || confirmPassword == null) {
            throw new IllegalArgumentException("Password fields cannot be empty.");
        }
        
        if(password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long.");
        }
        
        if(!password.equals(confirmPassword)) {
            throw new IllegalArgumentException("Passwords do not match.");
        }

        return true;
    }

}
