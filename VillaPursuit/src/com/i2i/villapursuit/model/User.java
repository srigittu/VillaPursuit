package com.i2i.villapursuit.model;

import java.util.Set;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;	
import javax.persistence.UniqueConstraint;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;

import org.hibernate.validator.NotNull; 

import com.i2i.villapursuit.model.Address;
import com.i2i.villapursuit.model.Role;

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "user_id"))
public class User {

    @Id 
    @GeneratedValue
    @NotNull
    @Column(name = "id", nullable = false)
    private int userId;

    @NotNull
    @Column(name = "user_name")
    private String userName;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "confirm_password")
    private String confirmPassword;

    @NotNull
    @Column(name = "mobile_no")
    private String mobileNo;

    @NotNull
    @Column(name = "email")
    private String email;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name="address")
    //List<Address> addresses = new ArrayList<Address>();
    Address address = new Address();
    
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name="role")
    List<Role> role = new ArrayList<Role>();
    
    
    public User()  {
        
    }
    
    public User(int userId, String userName, String firstName, String lastName, String password, String confirmPassword,
        String mobileNo, String email) {
        this.userId = userId;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.mobileNo = mobileNo;
        this.email = email;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }   
 
    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   /* public void setAddresses(Set addresses) {
        this.addresses = addresses;
    }*/

    public void setAddress(Address address) {
        this.address = address;
    }


    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() { 
        return lastName;
    }

    public String getPassword()  {
        return password;
    }

    public String getConfirmPassword()  {
        return confirmPassword;
    } 

    public String getMobileNo() {
        return mobileNo;
    }

    public String getEmail() {
        return email;
    }

    /* public Set<Address> getAddresses() {
        return addresses;
    }*/

    public Address getAddresss() {
        return address;
    }
}
