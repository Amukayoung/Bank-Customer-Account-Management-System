package com.example.BankAccountManager.User;

import com.example.BankAccountManager.Institution.Institution;
import com.example.BankAccountManager.Role.Role;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Arrays;
@Entity
public class User {

@Id
    private Long id;
    private String firstName;

    private String lastName;
    private String email;

    private String userName;

    private char[] password;

    private Long institutionID;
    private Long roleID;

    private Long branchID;
    @ManyToOne
    private Institution institution;
    @OneToMany
    private Role role;

    public User() {

    }

    public User(Long id,
                String firstName,
                String lastName,
                String email,
                String userName,
                char[] password,
                Long institutionID,
                Long roleID,
                Long branchID) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.institutionID = institutionID;
        this.roleID = roleID;
        this.branchID = branchID;
    }

    public User(String firstName,
                String lastName,
                String email,
                String userName,
                char[] password,
                Long institutionID,
                Long roleID,
                Long branchID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.institutionID = institutionID;
        this.roleID = roleID;
        this.branchID = branchID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public Long getInstitutionID() {
        return institutionID;
    }

    public void setInstitutionID(Long institutionID) {
        this.institutionID = institutionID;
    }

    public Long getRoleID() {
        return roleID;
    }

    public void setRoleID(Long roleID) {
        this.roleID = roleID;
    }

    public Long getBranchID() {
        return branchID;
    }

    public void setBranchID(Long branchID) {
        this.branchID = branchID;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", password=" + Arrays.toString(password) +
                ", institutionID=" + institutionID +
                ", roleID=" + roleID +
                ", branchID=" + branchID +
                '}';
    }
}
