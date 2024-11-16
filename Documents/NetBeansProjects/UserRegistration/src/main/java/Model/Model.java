package Model;


import DTO.DtoUser;
import java.util.HashSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author حمزة
 */
public class Model {
    
    private HashSet<DtoUser> users;

    public Model() {
        users = new HashSet<DtoUser>();
    }

    public HashSet<DtoUser> getUsers() {
        return users;
    }

    public void setUsers(HashSet<DtoUser> users) {
        this.users = users;
    }
    
    public void CreateUser(DtoUser newUser) {
        try {
            if(newUser.isValid()) {
                users.add(newUser);
            }
            else {
                System.out.println("hi");
            }
        }
        catch(Exception e) {
            
        }
        
    }
    
}
