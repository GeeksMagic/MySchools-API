package com.gmt.myschool.dao;

import java.sql.Blob;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gmt.myschool.responses.SuperResponse;

@Entity
@Table(name = "images")
public class ImagesDao  extends SuperResponse {
	
	public ImagesDao(Long id, String name, String desc, Blob content, Date createdOn, Date updatedOn, boolean isDeleted) {
		super();
		this.id = id;
		this.name = name;
		this.description = desc;
		this.content = content;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.isDeleted = isDeleted;
	}

	public ImagesDao() {
		// TODO Auto-generated constructor stub
	}
	
	public ImagesDao(Long id){
		this.id=id;
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
	@Column(name = "description")
	private String description;
	
	@JsonProperty
	@Column(name = "content")
	private Blob content;
	
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

	public String getDesc() {
		return description;
	}

	public void setDesc(String desc) {
		this.description = desc;
	}

	public Blob getContent() {
		return content;
	}

	public void setContent(Blob content) {
		this.content = content;
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
