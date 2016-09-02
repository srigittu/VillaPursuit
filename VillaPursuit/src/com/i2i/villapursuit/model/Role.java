package com.i2i.villapursuit.model;

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
	    @Column(name = "street_name")
	    private String type;
   
		public Role() {
			
		}
		
		public Role(int roleId, String type) {
			this.roleId = roleId;
			this.type = type;
		}

}
