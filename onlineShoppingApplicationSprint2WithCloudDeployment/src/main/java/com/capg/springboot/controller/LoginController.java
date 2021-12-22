package com.capg.springboot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.springboot.Exceptions.UserNotFoundException;
import com.capg.springboot.entity.User;
import com.capg.springboot.service.UserService;

/*Author:Singireddy Pranay

 * Date:30/11/2021
 * Description: This is User Login  Controller
 */
@RequestMapping(value={"/loginController"})
@RestController
public class LoginController {
	private static final HttpStatus HttpStatus = null;

	@Autowired
	HttpSession session;

	@Autowired
	private UserService loginservice;
	/* Method: addUser
	 * Description: It allows to add the user.
	 * @RequestMapping: It is used to map HTTP requests to handler methods of MVC and REST controllers.
	 * @RestController: It is used to create RESTful web services using MVC.
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @Autowired: It enables to inject object dependency implicitly.
	 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type.
     * Created By-Singireddy Pranay
     * Created Date - 30-11-2021 
     */
	
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody User user){
		if(user.getUserId()==null)
			return new ResponseEntity("Invalid",HttpStatus.NOT_FOUND);
		User userImpl=loginservice.addUser(user);
		return new ResponseEntity(userImpl,HttpStatus.OK);
	}
	/* Method: removeUser
	 * Description: It allows to remove the user.
	 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched with given URI expression.
	 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type.
     * Created By-Singireddy Pranay
     * Created Date - 30-11-2021 
     */
	@DeleteMapping("/removingUser")
	public ResponseEntity<User> removeUser(@RequestBody User user){
		if(user.getUserId()==null)
			return new ResponseEntity("Invalid",HttpStatus.NOT_FOUND);
		User userImpl=loginservice.removeUser(user);
		return new ResponseEntity(userImpl,HttpStatus.OK);
		
	}
	/* Method: getUser
	 * Description: It allows to get  the user by respective id.
	 * @PathVariable: It is used to handle template variables in the request URI
	 * @GetMapping:It is used to handle the HTTP GET requests matched with given URI Expression
     * Created By-Singireddy Pranay
     * Created Date - 30-11-2021 
     */
	@GetMapping("/getUser/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") String id)throws UserNotFoundException{
		User userImpl=loginservice.validateUser(id);
		return new ResponseEntity("User is Valid",HttpStatus.OK);
	}
	/* Method: signOut
	 * Description: It allows to signout
	 * Created By-Singireddy Pranay
     * Created Date - 30-11-2021 
     */
	@GetMapping("/signOut")
	public ResponseEntity<User> signOut(){
		session.invalidate();
		return new ResponseEntity("LoggedOut",HttpStatus.OK);
	}
	
}

