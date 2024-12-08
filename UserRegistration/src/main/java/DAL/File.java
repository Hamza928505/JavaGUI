/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.DtoUser;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author حمزة
 */
public class File {

    private final String filePath;

    public File(String filePath) {
        this.filePath = filePath;
    }

    public void createUser(DtoUser newUser) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(newUser.getUserInfo() + System.lineSeparator());
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
    

}
