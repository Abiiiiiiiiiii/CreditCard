package com.demo.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.demo.bo.Cred1Bo;
import com.demo.bo.Cred2Bo;
import com.demo.dto.CredentialDetailsDto;
import com.demo.dto.LoginRequest;
import com.demo.entity.Cred1Entity;
import com.demo.entity.Cred2Entity;
import com.demo.entity.User;
import com.demo.exception.CredException;
import com.demo.repository.Cred1EntityCustomized;
import com.demo.repository.UserRepository;
import com.demo.response.ResponseObj;

@CrossOrigin
@RestController
public class CredDemo {
	static Logger log=Logger.getLogger(CredDemo.class.getName());
	@Autowired
	Cred1Bo service1;
	
	@Autowired
	Cred2Bo service2;
	
	@Autowired
    private UserRepository userRepository;

	//insert(parent)
	@RequestMapping(value="/createCred1Entity",method=RequestMethod.POST)
	public ResponseObj<CredentialDetailsDto> insertCred1(@RequestBody CredentialDetailsDto msg) {
		log.info("insertion(parent) CredDemo(RestLayer) executed successfully");


		System.out.println("Name:"+msg.getName());
		System.out.println("Street:"+msg.getStreet());
		System.out.println("ContactNumber:"+msg.getContactNumber());

        Cred1Entity c = new Cred1Entity();
        c.setName(msg.getName());
        c.setStreet(msg.getStreet());
        c.setContactNumber(msg.getContactNumber());
        
        Cred1Entity c1=service1.insertCred1(c);
        msg.setId(c1.getId());
        msg.setCreatedAt(c1.getCreatedAt());
        msg.setCreatedAt(c1.getUpdatedAt());
        return new ResponseObj<>(true, "Credentials created successfully", msg);
	}
	
	//FindById(parent)
	@RequestMapping(value="/findCred1ById",method=RequestMethod.GET)
	public ResponseObj<CredentialDetailsDto> findCred1(@RequestParam int id) {
		log.info("FindById(parent) CredDemo(RestLayer) executed successfully");

	//public CredentialDetailsDto findCred(@RequestParam int id){
	
		System.out.println("ID: "+id);
		Cred1Entity c2=service1.findCred1(id);
		CredentialDetailsDto dto=new CredentialDetailsDto();
		dto.setId(c2.getId());
		dto.setName(c2.getName());
		dto.setStreet(c2.getStreet());
		dto.setContactNumber(c2.getContactNumber());
		dto.setCreatedAt(c2.getCreatedAt());
		dto.setUpdatedAt(c2.getUpdatedAt());
		return new ResponseObj<>(true, "Credential found successfully", dto);
    
		//return dto;
	}
	
	//FindAll(parent)
	@RequestMapping(value="/findAllCred1",method=RequestMethod.GET)
	public ResponseObj<List<Cred1Entity>> findAllCred() {
		log.info("FindAll(parent) CredDemo(RestLayer) executed successfully");
        List<Cred1Entity> fetchAll = service1.findAllCred1();
    
	//public List<CredentialDetailsDto> findAllCred(){
		//List<Cred1Entity> credentials=service1.findAllCred1();
		List<CredentialDetailsDto> dtos=new ArrayList<>();
		for(Cred1Entity c2:fetchAll) {
			CredentialDetailsDto dto=new CredentialDetailsDto();
			dto.setId(c2.getId());
			dto.setName(c2.getName());
			dto.setStreet(c2.getStreet());
			dto.setContactNumber(c2.getContactNumber());
			dto.setCreatedAt(c2.getCreatedAt());
			dto.setUpdatedAt(c2.getUpdatedAt());
			
			dtos.add(dto);
		}
		return new ResponseObj<>(true, "Credentials fetched successfully", fetchAll);
		//return dtos;
	}
	
	//fetchById(child)
	@RequestMapping(value="/fetchPersById",method=RequestMethod.GET)
	public ResponseObj<Cred2Entity> fetchPers(@RequestParam int Id) {
		log.info("fetchById(child) CredDemo(RestLayer) executed successfully");
	//public Cred2Entity fetchPers(@RequestParam int Id) {
		System.out.println("Id: "+Id);
		Cred2Entity p=service2.findCred2(Id);
		p.getCreatedAt();
		p.getUpdatedAt();
		p.getId();
		p.getPersonalName();
		p.getPersonalNumber();
		
		//System.out.println("Personal details fetched successfully...");
		//return p;
		return new ResponseObj<>(true, "Personal details fetched successfully", p);
	}
	
	//fetchAll(child)
	@RequestMapping(value="/fetchAllPers",method=RequestMethod.GET)
	public ResponseObj<List<Cred2Entity>> fetchAllPers() {
		log.info("fetchAll(child) CredDemo(RestLayer) executed successfully");
	//public List<Cred2Entity> fetchAllPers(){
		List<Cred2Entity>fetchAll=service2.findAllCred2();
		//return fetchAll;
		return new ResponseObj<>(true, "Personal details fetched successfully", fetchAll);

	}
	
	//insert PersonalDetails(child)
	@RequestMapping(value="/createPers",method=RequestMethod.POST)
	public ResponseObj<Cred2Entity> addCred2(@RequestBody Cred2Entity msg) {
		log.info("insertion(child) CredDemo(RestLayer) executed successfully");

		System.out.println("ID:"+msg.getCred1().getId());
		System.out.println("Personal Name:"+msg.getPersonalName());
		System.out.println("Personal Number:"+msg.getPersonalNumber());
		Cred1Entity c1=service1.findCred1(msg.getCred1().getId());

		System.out.println("Credential Details response--->"+c1);
		Cred2Entity p=new Cred2Entity();
		
		p.setPersonalName(msg.getPersonalName());
		p.setPersonalNumber(msg.getPersonalNumber());
		Cred2Entity response=service2.insertCred2(msg);
		System.out.println("Personal Details(Cred2Entity) added successfully");
		return new ResponseObj<>(true, "Personal details inserted successfully", response);

		//return response;
	}
	
	//update PersonalDetails(child)
	@RequestMapping(value="/updatePers/{id}",method=RequestMethod.POST)
	
	public ResponseObj<Cred2Entity> updatePers(@PathVariable("id") int id,@RequestBody Cred2Entity updatePers) {
		log.info("updation(child) CredDemo(RestLayer) executed successfully");

		System.out.println("PersonalNumber:" + updatePers.getPersonalNumber());
		Cred2Entity p=service2.findCred2(id);
	
		p.setPersonalNumber(updatePers.getPersonalNumber());
		
		Cred2Entity result=service2.updateCred2(p);
		System.out.println("PersonalDetails(Cred2Entity)updated successfully...");
		return new ResponseObj<>(true, "Personal details updated successfully", result);
		//return result;
	}
	
	//update(parent)
	@RequestMapping(value="/updateCred/{id}",method=RequestMethod.POST)
	public ResponseObj<CredentialDetailsDto> updateCred(@PathVariable("id") int id,@RequestBody CredentialDetailsDto msg) {
		log.info("updation(parent) CredDemo(RestLayer) executed successfully");

		//System.out.println("name:"+ msg.getName());
		System.out.println("contact number:" + msg.getContactNumber());
		System.out.println("street:" + msg.getStreet());
		
		Cred1Entity c=service1.findCred1(id);
		c.setContactNumber(msg.getContactNumber());
		c.setStreet(msg.getStreet());
		//c.setName(msg.getName());)
		
		Cred1Entity c1=service1.updateCred1(c);
		CredentialDetailsDto c2= new CredentialDetailsDto();
		c2.setId(c1.getId());
		c2.setContactNumber(c1.getContactNumber());
		c2.setStreet(c1.getStreet());
		c2.setCreatedAt(c1.getCreatedAt());
		c2.setUpdatedAt(c1.getUpdatedAt());
		return new ResponseObj<>(true, "Credential details updated successfully", c2);

		//return c2;
	}
	
	// Queries Methods
	//GreaterThanId
	@RequestMapping(value="/greaterThanId",method=RequestMethod.GET)
	public ResponseObj<List<Cred1Entity>> getPatientById(@RequestParam int id){
	List<Cred1Entity> g =service1.filterById(id);
	return new ResponseObj<>(true, "GreaterThanId details fetched successfully FROM credential details", g);
	//return g;
	}
		
		//FilterByNameCustomized
		@RequestMapping(value = "/findByNameCustomized", method = RequestMethod.GET)
		public ResponseObj<List<Cred1EntityCustomized>> findApplicantByNameCustomized(@RequestParam String name) 
		{
		    List<Cred1EntityCustomized> list = service1.filterByNameCustomized(name);
			return new ResponseObj<>(true, "FilterByNameCust details fetched successfully", list);

		    //return list;
		}
		
		//FindAllOrderByNameDesc
		@RequestMapping(value = "/findAllOrderByNameDescending", method = RequestMethod.GET)
		public ResponseObj<List<Cred1Entity>> findAllOrderByNameDescending() 
		{
		    List<Cred1Entity> list = service1.findAllOrderByNameDescending();
			return new ResponseObj<>(true, "FindAllOrderByNameDesc details fetched successfully", list);

		    //return list;
		}
		
		//Inner Join
		 @RequestMapping(value = "/credWithPers", method = RequestMethod.GET)
		    public ResponseObj<List<Cred1Entity>> findCredWithPers()
		 {
		        List<Cred1Entity> list = service1.findCredWithPers();
		    	return new ResponseObj<>(true, "InnerJoin details fetched successfully", list);
		        //return list;
		 }
		 
		 //Left Outer Join
		 @RequestMapping(value = "/cresWithPersLeft", method = RequestMethod.GET)
		    public ResponseObj<List<Cred1Entity>> findCredWithPersLeft() 
		 {
		        List<Cred1Entity> list = service1.findCredWithPersLeft();
		    	return new ResponseObj<>(true, "LeftOuterJoin details fetched successfully", list);
		        //return list;
		 }
		 
		//Customized join
		 @RequestMapping(value = "/credWithPersCustomized", method = RequestMethod.GET)
		    public  ResponseObj<List <Cred1EntityCustomized>> findCredWithPersCustomized() 
		 {
			 List <Cred1EntityCustomized> list = service1.findCredWithPersCust();
		    	return new ResponseObj<>(true, "CustomizedJoin details fetched successfully", list);
		        //return list;
		 }
		 
		 @RequestMapping(value = "/login", method = RequestMethod.POST)
		    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest request) {
		        Map<String, Object> response = new HashMap<>();

		        User user = userRepository.findByUsername(request.getUsername());

		        if (user != null && user.getPassword().equals(request.getPassword())) {
		            response.put("success", true);
		            response.put("message", "Login successful");
		            return ResponseEntity.ok(response);
		        } else {
		            response.put("success", false);
		            response.put("message", "Invalid credentials");
		            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
		        }
		}

		 @RestControllerAdvice
		 public class GlobalExceptionHandler {
		     @ExceptionHandler(CredException.class)
		     public ResponseEntity<String> handleCredException(CredException ex) {
		         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		     }
		     // Add other exception handling methods for different custom exceptions if needed
		 }

		 
}
