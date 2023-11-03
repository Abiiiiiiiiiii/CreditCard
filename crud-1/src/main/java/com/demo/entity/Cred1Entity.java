package com.demo.entity;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

//parentClass
@Entity
@Table(name="credential_details")

@EntityListeners(AuditingEntityListener.class)
@NamedQueries({@NamedQuery (name = "Cred1Entity.findAllOrderByNameDescending" , query = "select c from Cred1Entity c ORDER BY c.name DESC")})
/**
*
*
* @author Jon Doe
*/
public class Cred1Entity {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      /**
      *
      *
      * @author Jon Doe
      */
      private int id;
      
      @Column(unique=true,name = "customer_name")
      /**
      *
      *
      * @author Jon Doe
      */
      private String name;
      
      @JsonManagedReference
      @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "cred1")
      /**
      *
      *
      * @author Jon Doe
      */
      private List<Cred2Entity> cred2;
      
      @Column(name="street")
      /**
      *
      *
      * @author Jon Doe
      */
      private String street;
      
     
      @Column(name="contact_number")
      /**
      *
      *
      * @author Jon Doe
      */
      private Long contactNumber;
      
      
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
	/**
	*
	*
	* @author Jon Doe
	*/
	public List<Cred2Entity> getProduct() {
		return cred2;
	}

	public void setCred2(List<Cred2Entity> cred2) {
		this.cred2 = cred2;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
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
		return "Cred1Entity [id=" + id + ", name=" + name + ", street=" + street + ", contactNumber=" + contactNumber
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}	
}