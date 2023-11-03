package com.demo.bo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.repository.Cred2Repository;
import com.demo.entity.Cred1Entity;
import com.demo.entity.Cred2Entity;
@Component
/**
*
*
* @author Jon Doe
*/
public class Cred2Bo {
	@Autowired
	/**
	*
	*
	* @author Jon Doe
	*/
	Cred2Repository cred2;
	/**
	*
	*
	* @author Jon Doe
	*/
	public Cred2Entity insertCred2(Cred2Entity addCred2) {
		return cred2.save(addCred2);
		
	}
	/**
	*
	*
	* @author Jon Doe
	*/
	public Cred2Entity findCred2(Integer id) {
		Optional<Cred2Entity> clm = cred2.findById(id);
		return clm.get();
		}
	/**
	*
	*
	* @author Jon Doe
	*/
	public List<Cred2Entity> findAllCred2(){
		return cred2.findAll();
	}
	/**
	*
	*
	* @author Jon Doe
	*/
	public Cred2Entity updateCred2(Cred2Entity updateCred2) {
			return cred2.save(updateCred2);	
	}
	
}