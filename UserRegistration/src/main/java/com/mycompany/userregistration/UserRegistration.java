/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.userregistration;

import Model.Model;
import View.RegistrationView;
import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author حمزة
 */
public class UserRegistration {

    public static void main(String[] args) {
        Controller cont = new Controller(new RegistrationView(), new Model());
    }
}
