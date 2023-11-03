package com.demo.dto;
import java.util.Date;

/**
*
*
* 
*/
public class CredentialDetailsDto {
	/**
	*
	*
	* 
	*/
	private int id;
	/**
	*
	*
	* 
	*/
	private String name;
	/**
	*
	*
	* 
	*/
	private String street;
	/**
	*
	*
	* 
	*/
	private long contactNumber;
	/**
	*
	*
	* 
	*/
	private Date createdAt;
	/**
	*
	*
	* @author Jon Doe
	*/
	private Date updatedAt;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	@Override
	public String toString() {
		return "CredentialDetailsDto [id=" + id + ", name=" + name + ", street=" + street + ", contactNumber="
				+ contactNumber + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
}
