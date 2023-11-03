package com.demo.bo;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.entity.Cred1Entity;
import com.demo.exception.CredException;
import com.demo.repository.Cred1EntityCustomized;
import com.demo.repository.Cred1Repository;


@Component
/**
*
*
* @author Jon Doe
*/
public class Cred1Bo {
	@Autowired
	/**
	*
	*
	* @author Jon Doe
	*/
	Cred1Repository cred1;
	Cred1Entity cred=new Cred1Entity();
	
	/**
	*
	*
	* @author Jon Doe
	*/
	public Cred1Entity insertCred1(Cred1Entity addCred1) {
		
		if (addCred1.getName() == null || addCred1.getName().isEmpty()) {
	        throw new CredException("Credential---> name cannot be empty.");
	    }
		return cred1.save(addCred1);
		
	}
	/**
	*
	*
	* @author Jon Doe
	*/
	public Cred1Entity findCred1(Integer id) {
		Optional<Cred1Entity> clm = cred1.findById(id);
		if(clm.isPresent()) {
			Cred1Entity c=clm.get();
			return c;
		}
		else {
			throw new CredException("Inappropriate Id");
		}
	}
	/**
	*
	*
	* @author Jon Doe
	*/
	public List<Cred1Entity> findAllCred1(){
		if(cred==null) {
			throw new CredException("Null value not allowed");
		}
		return cred1.findAll();
	}
		
	/**
	*
	*
	* @author Jon Doe
	*/
	public Cred1Entity updateCred1(Cred1Entity updateCred1) {
		if(updateCred1.getId()>=10) {
			throw new CredException("Inappropriate Id");
		}
			return cred1.save(updateCred1);	
	}
	
	//Custom Queries
	/**
	*
	*
	* @author Jon Doe
	*/
	public List<Cred1Entity> filterById(int id){
		return cred1.filterById(id);
	}
	
	/*public List<Cred1Entity> filterByName(String name)
	{
		return cred1.filterByName(name);
	}*/
	/**
	*
	*
	* @author Jon Doe
	*/
	public List<Cred1EntityCustomized> filterByNameCustomized(String name)
	{
		return cred1.filterByNameCustomized(name);
	}
	
	//NamedQuery
	/**
	*
	*
	* @author Jon Doe
	*/
	public List<Cred1Entity> findAllOrderByNameDescending()
	{
		return cred1.findAllOrderByNameDescending();
	}
	
	//Inner Join
	/**
	*
	*
	* @author Jon Doe
	*/
	public List <Cred1Entity> findCredWithPers()
	{
		return cred1.findCredWithPers();
	}
	
	//Left Join
	/**
	*
	*
	* @author Jon Doe
	*/
	public List<Cred1Entity> findCredWithPersLeft()
	{
		return cred1.findCredWithPersLeft();
	}
	
	//customized data by join
	/**
	*
	*
	* @author Jon Doe
	*/
	public List<Cred1EntityCustomized> findCredWithPersCust()
	{
		return cred1.findCredWithPersCust();
	}
	
	
}