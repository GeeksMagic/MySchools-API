package com.gmt.myschool.dao;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gmt.myschool.responses.SuperResponse;

@Entity
@Table(name = "schools")
public class SchoolDao extends SuperResponse{

	public SchoolDao() {
		// TODO Auto-generated constructor stub
	}
	
	public SchoolDao(Long id){
		this.id=id;
	}
	

	public SchoolDao(Long id, String name, String address, String city, String state, String pincode, String phone,
			String about, Long image_id, Date createdOn, Date updatedOn, Boolean isDeleted) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.phone = phone;
		this.about = about;
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
	@Column(name = "name")
	private String name;
	
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
	private String pincode;
	
	@JsonProperty
	@Column(name = "phone")
	private String phone;
	
	@JsonProperty
	@Column(name = "about")
	private String about;
		
	@JsonProperty
	@Column(name = "image_id")
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
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

	
	
}
