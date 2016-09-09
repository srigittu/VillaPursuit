package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;	
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class User {

    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id",unique = true, nullable = false)
    private int userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;
    
    @Column(name = "mobile_number", nullable = false)
    private String mobileNumber;
    
    @Column(name = "email", nullable = false)
    private String email;
    
    @Column(name = "password", nullable = false)
    private String password;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "userAddress_id")
    private Address userAddress;
    
    /*@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "course_id") })
    private Set<Role> roles = new HashSet<Role>();*/
    
    public User(int userId, String userName, String firstName, String lastName, String mobileNumber, String email, String password, Address userAddress) {
        this.userId = userId;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.password = password;  
        this.userAddress = userAddress;
    }
  
    public User() {
    	
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
    
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    } 
    
    public void setEmail(String email) {
        this.email = email;
    } 
    
    public void setPassword(String password) {
        this.password = password;
    } 
    
    public void setUserAddress(Address userAddress) {
        this.userAddress = userAddress;
    } 
    
   /* public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}*/
 
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
    
    public String getMobileNumber() {
        return mobileNumber;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public Address getUserAddress() {
        return userAddress;
    }

   /* public Set<Role> getCourses() {
		return this.roles;
	}*/
}

