package com.capg.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.springboot.Exceptions.AddressNotFoundException;
import com.capg.springboot.entity.Address;
import com.capg.springboot.service.AddressService;

@RestController
@RequestMapping("/addressController")
public class AddressController {

	@Autowired
	private AddressService add_ser;
	/* Method: addAddress
	 * Description: It allows to add the address.
	 * @RequestMapping: It is used to map HTTP requests to handler methods of MVC and REST controllers.
	 * @RestController: It is used to create RESTful web services using MVC.
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @Autowired: It enables to inject object dependency implicitly.
	 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type.
     * Created By- Jyothi Prakash
     * Created Date - 30-11-2021 
     */
	@PostMapping("/addAddress")
	public ResponseEntity<Address> addAddress(@RequestBody Address add){
		add_ser.addAddress(add);
		return new ResponseEntity(add,HttpStatus.OK);
	}
	
	/* Method: removeAddress
	 * Description: It allows to remove the address.
	 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type.
     * @DeleteMapping: It is used to handle the HTTP DELETE requests matched with given URI expression.
     * Created By- Jyothi Prakash
     * Created Date - 30-11-2021 
     */
	@DeleteMapping("/removeAddress")
	public ResponseEntity<Address> removeAddress(@RequestBody Address add){
		add_ser.removeAddress(add);
		return new ResponseEntity(add,HttpStatus.OK);
	}
	/* Method: updateAddress
	 * Description: It allows to update the address.
	 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type.
     * @PostMapping: It is used to handle the HTTP POST requests matched with given URI expression.
     * Created By- Jyothi Prakash
     * Created Date - 30-11-2021 
     */
	@PostMapping("/updateAddress")
	public ResponseEntity<Address> updateAddress(@RequestBody Address add){
		add_ser.updateAddress(add);
		return new ResponseEntity(add,HttpStatus.OK);
	}
	/* Method: viewAllAddress
	 * Description: It allows to view all the address by id.
	 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type.
     * @GetMapping:It is used to handle the HTTP GET requests matched with given URI Expression.	
     * Created By- Jyothi Prakash
     * Created Date - 30-11-2021 
     */
	@GetMapping("/viewAllAddress/{id}")
	public ResponseEntity<Address> viewAllAddress(@PathVariable String id )throws AddressNotFoundException{
		Address address=add_ser.viewAllAddress(id);
		return new ResponseEntity(address,HttpStatus.OK);
 	}
}
