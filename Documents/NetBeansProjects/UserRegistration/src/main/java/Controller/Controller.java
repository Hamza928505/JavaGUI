/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DTO.DtoUser;
import View.RegistrationView;
import Model.Model;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.*;
import javax.swing.JOptionPane;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author حمزة
 */
public class Controller {

    private Model model;
    private RegistrationView view;

    public Controller(RegistrationView view, Model model) {
        this.model = model;
        this.view = view;

        this.view.getRegisterButton().addActionListener(new CreateUser());
        //this.view.getRegisterButton().addActionListener(new HoverField());

        HoverField hover = new HoverField();
        this.view.getUserName().getTextField().addFocusListener(hover);
        this.view.getPassword().getPasswordField().addFocusListener(hover);
        this.view.getPassword().getConfirmPasswordField().addFocusListener(hover);
        this.view.getFullName().getTextField().addFocusListener(hover);
        this.view.getEmail().getTextField().addFocusListener(hover);
        this.view.getMajor().getTextField().addFocusListener(hover);
        this.view.getSkills().getTextField().addFocusListener(hover);
    }

    private class CreateUser implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            DtoUser newUser = new DtoUser();
            try {
                newUser.setUserName(view.getUserName().getTextField().getText());
                newUser.setPassword(view.getPassword().getPasswordField().getText());
                newUser.setFullName(view.getFullName().getTextField().getText());
                newUser.setEmail(view.getEmail().getTextField().getText());
                newUser.setMajor(view.getMajor().getTextField().getText());
                newUser.setSkills(view.getSkills().getTextField().getText());
                
                try {
                    view.getPassword().isValidPassword();
                }
                catch(IllegalArgumentException error) { 
                    JOptionPane.showMessageDialog(null, error.getMessage(), "Password Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                if (view.getGender().getGroup().getSelection() == null) {
                    newUser.setGender("");
                } else {
                    newUser.setGender(view.getGender().getGroup().getSelection().toString()); // need to fix.
                }

                if (newUser.isValid()) {
                    model.CreateUser(newUser);
                    newUser.printUserInfo();
                } else {
                    JOptionPane.showMessageDialog(null, newUser.getMissingInfo(), "Missing Information", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (HeadlessException e) {
                System.out.println("Error : " + e.getMessage());
            }

            System.out.println("pass" + newUser.getPassword());
        }
    }

    private class HoverField implements FocusListener {

        @Override
        public void focusGained(FocusEvent event) { 
            try {
                Object field = event.getSource();
                
                if(field instanceof JTextField textField) {
                    textField.setBackground(Color.decode("#eeeeee"));
                }
                else if(field instanceof JPasswordField passwordField) {
                    passwordField.setBackground(Color.decode("#eeeeee"));
                }
                else {
                    throw new Exception("Unkonw focused item.");
                }
            }
            catch(Exception e) {
                System.out.println("Error : " + e.getMessage());
            }
        }

        @Override
        public void focusLost(FocusEvent event) {
            try {
                Object field = event.getSource();
            
                if(field instanceof JTextField textField) {
                    textField.setBackground(Color.white);
                }
                else if((field instanceof JPasswordField passwordField)) {
                    passwordField.setBackground(Color.white);
                }
                else {
                    throw new Exception("Unkonw focused item.");
                }
            }
            catch(Exception e) {
                System.out.println("Error : " + e.getMessage());
            }
        }
    }
}
