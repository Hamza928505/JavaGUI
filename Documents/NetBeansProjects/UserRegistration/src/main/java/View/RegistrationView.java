/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import View.Panels.*;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author حمزة
 */
public class RegistrationView extends JFrame{
    private TextFieldPanel userName, fullName, email, major, skills;
    private PasswordFieldPanel password;
    private RadioButtonPanel gender;
    private JButton registerButton;

    public RegistrationView() {
        userName = new TextFieldPanel("UserName :");
        
        password = new PasswordFieldPanel("Password :", "Confirm Password :");
        
        fullName = new TextFieldPanel("Full Name :");
        email = new TextFieldPanel("Email :");
        major = new TextFieldPanel("Major :");
        skills = new TextFieldPanel("Skills :");
        gender = new RadioButtonPanel("Gender", "Male", "Female");
        registerButton = new JButton("Register");
        
        this.setLayout(new GridLayout(8,1));
        this.getContentPane().add(userName);
        this.getContentPane().add(password);
        this.getContentPane().add(fullName);
        this.getContentPane().add(gender);
        this.getContentPane().add(email);
        this.getContentPane().add(major);
        this.getContentPane().add(skills);
        
        JPanel registerButtonPanel = new JPanel();
        registerButtonPanel.add(registerButton);
        this.getContentPane().add(registerButtonPanel);
        
        this.setTitle("User Registration");
        this.setVisible(true);
        this.setSize(500,500);
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
