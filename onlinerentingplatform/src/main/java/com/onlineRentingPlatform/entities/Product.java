package com.onlineRentingPlatform.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="PRODUCT")
public class Product {
	
	





	@Id	
	@GeneratedValue(strategy= GenerationType.AUTO )
	public int pid;
	
	@Column(unique=true) 
	public String type;
	public String expectedprice;
	public String rentduration;
	public int df;
	public int customerid;
	
    public int getCustomerid() {
		return customerid;
	}





	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}





	public int getDf() {
		return df;
	}





	public void setDf(int df) {
		this.df = df;
	}





	public String details;
   
    @ManyToOne
	public User user;


	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}





	public int getPid() {
		return pid;
	}





	public void setPid(int pid) {
		this.pid = pid;
	}





	public String getType() {
		return type;
	}





	public void setType(String type) {
		this.type = type;
	}





	public String getExpectedprice() {
		return expectedprice;
	}





	public void setExpectedprice(String expectedprice) {
		this.expectedprice = expectedprice;
	}





	public String getRentduration() {
		return rentduration;
	}





	public void setRentduration(String rentduration) {
		this.rentduration = rentduration;
	}





	public String getDetails() {
		return details;
	}





	public void setDetails(String details) {
		this.details = details;
	}
	
	
	





	





	public User getUser() {
		return user;
	}





	public void setUser(User user) {
		this.user = user;
	}
    
//	@Override
//	public String toString() {
//		return "Product [pid=" + pid + ", type=" + type + ", expectedprice=" + expectedprice + ", rentduration="
//				+ rentduration + ", details=" + details + ", user=" + user + "]";
//	}
	

}
