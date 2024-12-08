/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author حمزة
 */
public class DtoUser {
    private static int id = 0;
    private String userName, password, fullName, gender, email, major, skills;

    public DtoUser() {
        id++;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        DtoUser.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public boolean isValid() {
        boolean valid = true;
        if(this == null) valid = false;
        if(userName.equals("")) valid = false;
        if(password.equals("")) valid = false;
        if(fullName.equals("")) valid = false;
        if(gender.equals("")) valid = false;
        if(major.equals("")) valid = false;
        if(skills.equals("")) valid = false;
        return valid;
    }

    public void printUserInfo() {
        System.out.println("UserName : " + userName);
        System.out.println("Password : " + password);
        System.out.println("FullName : " + fullName);
        System.out.println("Gender : " + gender);
        System.out.println("Email : " + email);
        System.out.println("Major : " + major);
        System.out.println("Skills : " + skills);
    }
    
    public String getMissingInfo() {
        StringBuilder missingInfo = new StringBuilder("Missing information :\n");
        
        if(userName.equals("")) { missingInfo.append("UserName\n"); }
        if(password.equals("")) { missingInfo.append("Password\n"); }
        if(fullName.equals("")) { missingInfo.append("Full Name\n"); }
        if(gender.equals("")) { missingInfo.append("Gender\n"); }
        if(email.equals("")) { missingInfo.append("Email\n"); }
        if(major.equals("")) { missingInfo.append("Major\n"); }
        if(skills.equals("")) { missingInfo.append("Skills"); }
        
        return missingInfo.toString();
    }
    
    public String getUserInfo() {
        String userinfo = id + "-"
                + " User Name : " + userName 
                + ", Password : " + password
                + ", Full Name : " + fullName
                + ", Gender : " + gender
                + ", Email : " + email
                + ", Major : " + major
                + ", Skills : " + skills
                +"\n";
        return userinfo;
    }
}
