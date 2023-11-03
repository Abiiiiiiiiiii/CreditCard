package com.demo.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.demo.entity.Cred1Entity;
import com.demo.exception.CredException;
import com.demo.response.ResponseObj;

@Repository
/**
*
*
* @author Jon Doe
*/
public interface Cred1Repository extends JpaRepository<Cred1Entity,Integer> {
	//Fetching all columns
	@Query(value="select c from Cred1Entity c where c.id> :id")
	/**
	*
	*
	* @author Jon Doe
	*/
	List<Cred1Entity> filterById(@Param("id") int id);
	
	/*@Query("select c from Cred1Entity c where c.name Like%:name%")
	List<Cred1Entity>filterByName(@Param("name")String name);*/
	
	//Fetching only few columns
	@Query("select c.street as street from Cred1Entity c where c.name=:name")
	/**
	*
	*
	* @author Jon Doe
	*/
	List<Cred1EntityCustomized>filterByNameCustomized(@Param("name")String name);

	//NamedQuery
	/**
	*
	*
	* @author Jon Doe
	*/
	List<Cred1Entity> findAllOrderByNameDescending();
		
	//Inner Join
	@Query("select c from Cred1Entity c JOIN c.cred2")
	/**
	*
	*
	* @author Jon Doe
	*/
	List<Cred1Entity> findCredWithPers();
	
	//Left Outer Join
	@Query("select c from Cred1Entity c left JOIN c.cred2")
	/**
	*
	*
	* @author Jon Doe
	*/
    List<Cred1Entity> findCredWithPersLeft();
	
	//customized data by join
	@Query("select c.name as name,c.street as street from Cred1Entity c JOIN c.cred2")
	/**
	*
	*
	* @author Jon Doe
	*/
	List<Cred1EntityCustomized> findCredWithPersCust();
	
	//exception
	/**
	*
	*
	* @author Jon Doe
	*/
	@RestControllerAdvice
	public class GlobalExceptionHandler {
	    @ExceptionHandler(CredException.class)
	    /**
	    *
	    *
	    * @author Jon Doe
	    */
	    public ResponseEntity<String> handleCredException(CredException ex) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	    }
	    // Add other exception handling methods for different custom exceptions if needed
	}

}