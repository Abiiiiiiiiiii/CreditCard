package com.demo.entity;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

//childClass
@Entity
@Table(name="personal_details")
@EntityListeners(AuditingEntityListener.class)

/**
*
*
* @author Jon Doe
*/
public class Cred2Entity {

	 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 /**
	 *
	 *
	 * @author Jon Doe
	 */
    private int Id;
    
    @Column(name="personal_name")
    /**
    *
    *
    * @author Jon Doe
    */
    private String personalName;
    
   
    @Column(name="personal_number")
    /**
    *
    *
    * @author Jon Doe
    */
    private int personalNumber;
    
    
    @Column(nullable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    /**
    *
    *
    * @author Jon Doe
    */
    private Date createdAt;
    
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    /**
    *
    *
    * @author Jon Doe
    */
    private Date updatedAt;
    
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerid",nullable = false,referencedColumnName = "id")
    /**
    *
    *
    * @author Jon Doe
    */
    Cred1Entity cred1;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		id = id;
	}

	public String getPersonalName() {
		return personalName;
	}

	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}

	public int getPersonalNumber() {
		return personalNumber;
	}

	public void setPersonalNumber(int personalNumber) {
		this.personalNumber = personalNumber;
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

	public Cred1Entity getCred1() {
		return cred1;
	}

	public void setCred1(Cred1Entity cred1) {
		this.cred1 = cred1;
	}

	@Override
	public String toString() {
		return "Cred2Entity [Id=" + Id + ", personalName=" + personalName + ", personalNumber=" + personalNumber
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

}