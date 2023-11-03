package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.demo.entity.Cred1Entity;
import com.demo.service.Cred1Service;
import com.demo.entity.Cred2Entity;
import com.demo.repository.Cred1EntityCustomized;
import com.demo.service.Cred2Service;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan("com.demo")
@EntityScan(basePackages = {"com.demo.entity"})
@EnableJpaRepositories("com.demo.repository")

/**
*
*/
public class Crud1Application {
	static Logger log=Logger.getLogger(Crud1Application.class.getName());

	public static void main(String[] args) {
		ApplicationContext ctx =SpringApplication.run(Crud1Application.class, args);
		log.info("Crud1Application started successfully");
	        //task 1 insert credential_details(parent)
			/*Cred1Service service = ctx.getBean(Cred1Service.class);
			Cred1Entity cred1 = new Cred1Entity();
			cred1.setName("anveer");
			cred1.setId(1);
			cred1.setStreet("RN street");
			cred1.setContactNumber(9756456790l);
			
		   service.insertServiceCred1(cred1);*/
			
			//task 2 insert Cred2Entity(child)
			/*Cred2Service cred2service = ctx.getBean(Cred2Service.class);
			Cred2Entity cred2 = new Cred2Entity();
			cred2.setPersonalName("Janani");
			cred2.setPersonalNumber(93701498);
			 
			Cred1Entity credd1 = new Cred1Entity();
			
			credd1.setId(1);
			cred2.setCred1(credd1);
			cred2service.insertServiceCred2(cred2);*/
			
			//task 3 insert Cred2Entity(child)
		//correspond to 1 parent column(id), creating 2 id  of same value in child table
			/*Cred2Entity p1 = new Cred2Entity();
			p1.setPersonalName("vvv");
			p1.setPersonalNumber(89932439);
			
			Cred2Entity p2 = new Cred2Entity();
			p2.setPersonalName("sss");
			p2.setPersonalNumber(843459300);
			
			//insert Cred1Entity
			Cred1Entity cu1 = new Cred1Entity();
			cu1.setContactNumber(9856407865l);
			cu1.setName("meera");
			cu1.setStreet("SR street");
			
			//Associating Cred2 to Cred1
			p1.setCred1(cu1);
			p2.setCred1(cu1);
			
			//Associating Cred1 with Cred2
			List<Cred2Entity> cu2 = new ArrayList<Cred2Entity>();
			cu2.add(p1);
			cu2.add(p2);
			cu1.setCred2(cu2);
			
			System.out.println("Adding Cred1Entity.......");
			Cred1Service service3 = ctx.getBean(Cred1Service.class);
			service3.insertServiceCred1(cu1);*/
			
			//Transaction
			Cred1Service tsc  = ctx.getBean(Cred1Service.class);
			/*Cred2Entity clm1 = new Cred2Entity();
			//clm1.setId(9);
			clm1.setPersonalName("Harry");
			clm1.setPersonalNumber(787800085);
		
			Cred1Entity cust1 = new Cred1Entity();
			cust1.setId(3);
			clm1.setCred1(cust1);
			
			Cred1Entity cust2 = new Cred1Entity();
			cust2.setContactNumber(9043245907l);
			cust2.setName("buzan");
			cust2.setStreet("Slayers Street");
			
			tsc.transactionDemo(cust2, clm1);*/
			
			//fetch
			//System.out.println(service.findServiceCred1(1));
			
			//fetchAll
			//System.out.println(service.findAllServiceCred1());
			
			//update
			//cred1.setId(2);
			//cred1.setStreet("Judge street");
			//service.updateServiceCred1(cred1);
		
			//Custom Query
			/*List<Cred1Entity> list=tsc.filterById(1);
			System.out.println("Cred1Entity based on id"+list);*/
			
			/*List<Cred1Entity> list1=tsc.filterByName("i");
			System.out.println("Cred1Entity name with i"+list1);*/
			
			/*List<Cred1EntityCustomized> list2=tsc.filterByNameCustomized("meera");
			for(Cred1EntityCustomized a: list2)
			{
				System.out.println("Customized Details: "+a.getStreet());
			}*/
			
			//System.out.println("Cred1Entity details Order by name desc: "+tsc.findAllOrderByNameDescending());
			
			//Inner Join 
			/*List<Cred1Entity> list3 = tsc.findCredWithPers();
			System.out.println("Credentials with Personal_details Inner Join: " + list3);*/
			
			//Left Join 
			/*List<Cred1Entity> list4 = tsc.findCredWithPersLeft();
			System.out.println("Credentials with Personal_details Left Join: " + list4);*/
			
			//customized data by Join 
			//List<Cred1EntityCustomized> list5 = tsc.findCredWithPersCust();
			/*for(Cred1EntityCustomized cust: list5) {
				System.out.println("Credentials with Personal_details customized Join: " + cust.getName()+"-"+cust.getStreet());
			}*/
	}
}