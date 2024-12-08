/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import View.Panels.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author حمزة
 */
public class RegistrationView extends JFrame {

    private TextFieldPanel userName, fullName, email, major, skills;
    private PasswordFieldPanel password;
    private RadioButtonPanel gender;
    private JButton registerButton;

    public RegistrationView() {
        // Initialize components
        userName = new TextFieldPanel("UserName:");
        password = new PasswordFieldPanel("Password:", "Confirm Password:");
        fullName = new TextFieldPanel("Full Name:");
        email = new TextFieldPanel("Email:");
        major = new TextFieldPanel("Major:");
        skills = new TextFieldPanel("Skills:");
        gender = new RadioButtonPanel("Gender :", "Male", "Female");
        registerButton = new JButton("Register");

        // Set layout manager
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Add components to the layout
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.getContentPane().add(userName, gbc);

        gbc.gridy++;
        this.getContentPane().add(fullName, gbc);

        gbc.gridy++;
        this.getContentPane().add(email, gbc);

        gbc.gridy++;
        this.getContentPane().add(password, gbc);

        gbc.gridy++;
        this.getContentPane().add(major, gbc);

        gbc.gridy++;
        this.getContentPane().add(skills, gbc);

        gbc.gridy++;
        this.getContentPane().add(gender, gbc);
        // Add register button
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER;
        JPanel registerButtonPanel = new JPanel();
        registerButtonPanel.add(registerButton);
        this.getContentPane().add(registerButtonPanel, gbc);

        // Final frame setup
        this.setTitle("User Registration");
        this.setSize(500, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public TextFieldPanel getUserName() {
        return userName;
    }

    public void setUserName(TextFieldPanel userName) {
        this.userName = userName;
    }

    public TextFieldPanel getFullName() {
        return fullName;
    }

    public void setFullName(TextFieldPanel fullName) {
        this.fullName = fullName;
    }

    public TextFieldPanel getEmail() {
        return email;
    }

    public void setEmail(TextFieldPanel email) {
        this.email = email;
    }

    public TextFieldPanel getMajor() {
        return major;
    }

    public void setMajor(TextFieldPanel major) {
        this.major = major;
    }

    public TextFieldPanel getSkills() {
        return skills;
    }

    public void setSkills(TextFieldPanel skills) {
        this.skills = skills;
    }

    public RadioButtonPanel getGender() {
        return gender;
    }

    public void setGender(RadioButtonPanel gender) {
        this.gender = gender;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

    public void setRegisterButton(JButton registerButton) {
        this.registerButton = registerButton;
    }

    public PasswordFieldPanel getPassword() {
        return password;
    }

    public void setPassword(PasswordFieldPanel password) {
        this.password = password;
    }

    public String getGenderSelection() {
        return gender.getGroup().getSelection() == null ? "" : gender.getGroup().getSelection().toString();
    }

}
