package com.demo.service;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.bo.Cred1Bo;
import com.demo.bo.Cred2Bo;
import com.demo.entity.Cred1Entity;
import com.demo.entity.Cred2Entity;
import com.demo.repository.Cred1EntityCustomized;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component

public class Cred1Service {
	static Logger log=Logger.getLogger(Cred1Service.class.getName());
	@Autowired
	Cred1Bo serviceBO;
	
	public Cred1Entity insertServiceCred1(Cred1Entity addCred1) {
		log.info("insert Cred1Service started successfully");
		return serviceBO.insertCred1(addCred1);
	}
	
	public Cred1Entity findServiceCred1(Integer id) {
		log.info("fetchCred1Service started successfully");
		return  serviceBO.findCred1(id);
		
		}
	
	public List<Cred1Entity> findAllServiceCred1(){
		log.info("fetchAll Cred1Service started successfully");
		return serviceBO.findAllCred1();
	}
		
	public Cred1Entity updateServiceCred1(Cred1Entity upCred1) {
		log.info("update Cred1Service started successfully");
			return serviceBO.updateCred1(upCred1);	
	}
	
	@Autowired
	Cred1Bo serviceBo; 
	
	@Autowired
	Cred2Bo  bo2;
	
	@Autowired
	Cred1Bo bo1;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void transactionDemo(Cred1Entity c,Cred2Entity cl) {
		System.out.println("Cred1Entity Add-----Before");
		bo1.insertCred1(c);
		System.out.println("Cred1 Add-----After");
		System.out.println("Cred2 Add-----Before");
		bo2.insertCred2(cl);
		System.out.println("Cred2 Add-----After");
	}
	
	//Custom queries
	public List<Cred1Entity> filterById(int id)
	{
		return bo1.filterById(id);
	}
	
	/*public List<Cred1Entity> filterByName(String name)
	{
		return bo1.filterByName(name);
	}*/
	
	public List<Cred1EntityCustomized> filterByNameCustomized(String name)
	{
		return bo1.filterByNameCustomized(name);
	}
	
	public List<Cred1Entity> findAllOrderByNameDescending()
	{
		return bo1.findAllOrderByNameDescending();
	}
	
	//Inner Join
	public List <Cred1Entity> findCredWithPers()
	{
		return bo1.findCredWithPers();
	}
	
	//Left Join
	public List<Cred1Entity> findCredWithPersLeft()
	{
		return bo1.findCredWithPersLeft();
	}
	
	//customized data by join
	public List <Cred1EntityCustomized> findCredWithPersCust()
	{
		return bo1.findCredWithPersCust();
	}
}