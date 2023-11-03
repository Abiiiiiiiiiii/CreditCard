package com.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.bo.Cred2Bo;
import com.demo.entity.Cred2Entity;

@Component
/**
*
*
* @author Jon Doe
*/
public class Cred2Service {
	
		
		@Autowired
		/**
		*
		*
		* @author Jon Doe
		*/
		Cred2Bo servicesBO;
		/**
		*
		*
		* @author Jon Doe
		*/
		public Cred2Entity insertServiceCred2(Cred2Entity addCred2) {
			return servicesBO.insertCred2(addCred2);
		}
		/**
		*
		*
		* 
		*/
		public Cred2Entity findServiceCred2(Integer id) {
			return  servicesBO.findCred2(id);
			
			}
		/**
		*
		*
		* @author Jon Doe
		*/
		public List<Cred2Entity> findAllServiceCred2(){
			return servicesBO.findAllCred2();
		}
		/**
		*
		*
		* @author Jon Doe
		*/
		public Cred2Entity updateServiceProduct(Cred2Entity updateCred2) {
				return servicesBO.updateCred2(updateCred2);	
		}

	}