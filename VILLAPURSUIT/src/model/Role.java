package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;	
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.NotNull; 

@Entity
@Table(name = "role", uniqueConstraints = @UniqueConstraint(columnNames = "role_id"))
public class Role {
		
	@Id 
    @GeneratedValue
    @NotNull
    @Column(name = "role_id",unique = true, nullable = false)
    private int roleId;
		
	@NotNull
    @Column(name = "role_type")
    private String roleType;
   
	public Role() {
			
	}
		
	public Role(int roleId, String roleType) {
		this.roleId = roleId;
		this.roleType = roleType;
	}
		
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public int getRoleId() {
		return roleId;
	}
		
	public String getRoleType() {
		return roleType;
	}
		
}