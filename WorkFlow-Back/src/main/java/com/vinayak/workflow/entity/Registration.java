package com.vinayak.workflow.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Registration {
   
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	    private String firstName;
	    private String lastName;
	    @Column(unique=true)
	    private String gender;
	    private String emailId;
	    private String password;
	    private String mobileNo;
	    private String addressCity;

	    public Registration() {}

	    public Registration(String firstName, String lastName, String gender, String emailId, String password, String mobileNo, String addressCity) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.gender = gender;
	        this.emailId = emailId;
	        this.password = password;
	        this.mobileNo = mobileNo;
	        this.addressCity = addressCity;
	    }

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
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

	    public String getGender() {
	        return gender;
	    }

	    public void setGender(String gender) {
	        this.gender = gender;
	    }

	    public String getEmailId() {
	        return emailId;
	    }

	    public void setEmailId(String emailId) {
	        this.emailId = emailId;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getMobileNo() {
	        return mobileNo;
	    }

	    public void setMobileNo(String mobileNo) {
	        this.mobileNo = mobileNo;
	    }

	    public String getAddressCity() {
	        return addressCity;
	    }

	    public void setAddressCity(String addressCity) {
	        this.addressCity = addressCity;
	    }

	    @Override
	    public String toString() {
	        return "Registration [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender +
	               ", emailId=" + emailId + ", mobileNo=" + mobileNo + ", addressCity=" + addressCity + "]";
	    }
	}
