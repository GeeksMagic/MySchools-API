package com.gmt.myschool.dao;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gmt.myschool.enums.Gender;
import com.gmt.myschool.enums.UserTypes;
import com.gmt.myschool.responses.SuperResponse;

@Entity
@Table(name = "users")
public class UserDao extends SuperResponse {

	public UserDao() {
		// TODO Auto-generated constructor stub
	}

	public UserDao(Long id) {
		this.id = id;
	}

	public UserDao(Long id, String firstName, String lastName, String username, String password, String email,
			String phone, String address, String city, String state, Long pincode, String dob, Gender gender,
			UserTypes userType, Long school_id, Long image_id, Date createdOn, Date updatedOn, Boolean isDeleted) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.dob = dob;
		this.gender = gender;
		this.userType = userType;
		this.school_id = school_id;
		this.image_id = image_id;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.isDeleted = isDeleted;
	}

	@Id
	@GeneratedValue
	@JsonProperty
	@Column(name = "id")
	private Long id;

	@JsonProperty
	@Column(name = "first_name")
	private String firstName;

	@JsonProperty
	@Column(name = "last_name")
	private String lastName;

	@JsonProperty
	@Column(name = "username")
	private String username;

	@JsonProperty
	@Column(name = "password")
	private String password;

	@JsonProperty
	@Column(name = "email")
	private String email;

	@JsonProperty
	@Column(name = "phone")
	private String phone;

	@JsonProperty
	@Column(name = "address")
	private String address;

	@JsonProperty
	@Column(name = "city")
	private String city;

	@JsonProperty
	@Column(name = "state")
	private String state;

	@JsonProperty
	@Column(name = "pincode")
	private Long pincode;

	@JsonProperty
	@Column(name = "dob")
	private String dob;

	@JsonProperty
	@Column(name = "gender")
	private Gender gender;

	@JsonProperty
	@Column(name = "user_type")
	private UserTypes userType;

	@JoinColumn(name = "school_id")
	private Long school_id;

	@JoinColumn(name = "image_id")
	private Long image_id;
	
	@JsonProperty
	@Column(name = "created_on")
	private Date createdOn;

	@JsonProperty
	@Column(name = "updated_on")
	private Date updatedOn;

	@Column(name = "is_deleted")
	private Boolean isDeleted;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public UserTypes getUserType() {
		return userType;
	}

	public void setUserType(UserTypes userType) {
		this.userType = userType;
	}

	

	public Long getSchool_id() {
		return school_id;
	}

	public void setSchool_id(Long school_id) {
		this.school_id = school_id;
	}

	public Long getImage_id() {
		return image_id;
	}

	public void setImage_id(Long image_id) {
		this.image_id = image_id;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

}
