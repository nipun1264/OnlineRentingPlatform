package com.onlineRentingPlatform.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="USER")

public class User {
	@Id	
	@GeneratedValue(strategy= GenerationType.AUTO )
	public int uid;
	@Column(unique=true) 
    public String email;
    public String username;
   public String password;
    public String phone;
    public String address;
   public String role;
   public boolean enabled;
   public int df=0;
   
   public int getDf() {
	return df;
}


public void setDf(int df) {
	this.df = df;
}


@OneToMany(cascade=CascadeType.ALL , fetch=FetchType.LAZY , mappedBy="user")
   public List<Product> products=new ArrayList<>();
    
	public List<Product> getProducts() {
	return products;
}


public void setProducts(List<Product> products) {
	this.products = products;
}


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	@Override
	public String toString() {
		return "User [uid=" + uid + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", phone=" + phone + ", address=" + address + ", role=" + role + ", enabled=" + enabled + "]";
	}


	


	






	
    
	
	
}
