/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAL.File;
import DTO.DtoUser;
import View.RegistrationView;
import Model.Model;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.*;
import javax.swing.JOptionPane;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author حمزة
 */
public class Controller {

    private Model model;
    private RegistrationView view;
    private File file;

    public Controller(RegistrationView view, Model model) {
        this.model = model;
        this.view = view;
        this.file = new File("C:\\Users\\حمزة\\Documents\\NetBeansProjects\\UserRegistration\\src\\main\\java\\DAL\\UsersFile");

        /**
         * *
         *
         * @ActionCommand
         *
         **
         */
        this.view.getRegisterButton().setActionCommand("Register");

        /**
         * *
         *
         * @ActionListener
         *
         **
         */
        this.view.getRegisterButton().addActionListener(new CreateUser());

        ClickButtons clickButtons = new ClickButtons();
        this.view.getGender().getOption1().addActionListener(clickButtons);
        this.view.getGender().getOption2().addActionListener(clickButtons);

        FocusField focus = new FocusField();
        this.view.getUserName().getTextField().addFocusListener(focus);
        this.view.getPassword().getPasswordField().addFocusListener(focus);
        this.view.getPassword().getConfirmPasswordField().addFocusListener(focus);
        this.view.getFullName().getTextField().addFocusListener(focus);
        this.view.getEmail().getTextField().addFocusListener(focus);
        this.view.getMajor().getTextField().addFocusListener(focus);
        this.view.getSkills().getTextField().addFocusListener(focus);

        HoverField hover = new HoverField();
        this.view.getUserName().getTextField().addMouseListener(hover);
        this.view.getPassword().getPasswordField().addMouseListener(hover);
        this.view.getPassword().getConfirmPasswordField().addMouseListener(hover);
        this.view.getFullName().getTextField().addMouseListener(hover);
        this.view.getEmail().getTextField().addMouseListener(hover);
        this.view.getMajor().getTextField().addMouseListener(hover);
        this.view.getSkills().getTextField().addMouseListener(hover);
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
                newUser.setGender(view.getGenderSelection());

                
                if (newUser.isValid()) {
                    try {
                    view.getPassword().isValidPassword();
                } catch (IllegalArgumentException error) {
                    JOptionPane.showMessageDialog(null, error.getMessage(), "Password Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                    model.CreateUser(newUser);
                    file.createUser(newUser);
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

    private class FocusField implements FocusListener {

        @Override
        public void focusGained(FocusEvent event) {
            try {
                Object field = event.getSource();

                if (field instanceof JTextField textField) {
                    textField.setBackground(Color.decode("#eeeeee"));
                } else if (field instanceof JPasswordField passwordField) {
                    passwordField.setBackground(Color.decode("#eeeeee"));
                } else {
                    throw new Exception("Unkonw focused item.");
                }
            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage());
            }
        }

        @Override
        public void focusLost(FocusEvent event) {
            try {
                Object field = event.getSource();

                if (field instanceof JTextField textField) {
                    textField.setBackground(Color.white);
                } else if ((field instanceof JPasswordField passwordField)) {
                    passwordField.setBackground(Color.white);
                } else {
                    throw new Exception("Unkonw focused item.");
                }
            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage());
            }
        }
    }

    private class HoverField implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mousePressed(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mouseEntered(MouseEvent event) {
            try {
                Object field = event.getSource();

                if (field instanceof JTextField textField) {
                    textField.setBackground(Color.decode("#eeeeee"));
                } else if (field instanceof JPasswordField passwordField) {
                    passwordField.setBackground(Color.decode("#eeeeee"));
                } else {
                    throw new Exception("Unkonw focused item.");
                }
            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage());
            }
        }

        @Override
        public void mouseExited(MouseEvent event) {
            try {
                Object field = event.getSource();

                if (field instanceof JTextField textField) {
                    if (textField.isFocusOwner()) {
                        return;
                    }
                    textField.setBackground(Color.white);
                } else if ((field instanceof JPasswordField passwordField)) {
                    if (passwordField.isFocusOwner()) {
                        return;
                    }
                    passwordField.setBackground(Color.white);
                } else {
                    throw new Exception("Unkonw focused item.");
                }
            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage());
            }
        }

    }

    private class ClickButtons implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            try {
                Object buttonType = event.getSource();

                if (buttonType instanceof JRadioButton) {
                    if (event.getActionCommand() == "Male") {
                        model.getCurrentUser().setGender("Male");
                    } else if (event.getActionCommand() == "Female") {
                        model.getCurrentUser().setGender("Female");
                    } else {
                        model.getCurrentUser().setGender("");
                    }
                }
            } catch (Exception e) {
                model.getCurrentUser().setGender("");
            }
        }
    }
}
