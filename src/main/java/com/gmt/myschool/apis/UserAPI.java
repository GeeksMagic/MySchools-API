package com.gmt.myschool.apis;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gmt.myschool.dao.UserDao;
import com.gmt.myschool.repository.UserRepository;
import com.gmt.myschool.requests.LoginRequest;
import com.gmt.myschool.responses.LoginResponse;
import com.gmt.myschool.responses.MessageResponse;
import com.gmt.myschool.responses.SuperResponse;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserAPI {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(method = RequestMethod.GET, value = "/all")
	@Consumes(MediaType.APPLICATION_JSON)
	public @ResponseBody List<UserDao> getAllUsers() {
		return userRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	@Consumes(MediaType.APPLICATION_JSON)
	public @ResponseBody SuperResponse getOne(@RequestBody LoginRequest req) {
		try{
		UserDao foundUser = null;
		for (UserDao user : getAllUsers()) {
			if (user.getUsername().equalsIgnoreCase(req.getUsername())) {
				foundUser = user;
				break;
			}
		}
		if (foundUser == null)
			return new MessageResponse("Invalid Username");
		else {
			if (foundUser.getPassword().equals(req.getPassword())) {
				return new LoginResponse(foundUser);
			} else {
				return new MessageResponse("Invalid Password");
			}
		}
		}catch(Exception e){
			return new MessageResponse("Error Finding User:"+e.getMessage());
		}
		
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public @ResponseBody SuperResponse getOne(@PathVariable("id") long id) {
		try {
			if (userRepository.exists(id)) {
				return userRepository.findOne(id);
			} else {
				return new MessageResponse("User Not Found");
			}
		} catch (Exception ex) {
			return new MessageResponse("Error reading the user:" + ex.toString());
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addorupdate")
	@Consumes(MediaType.APPLICATION_JSON)
	public @ResponseBody UserDao createOrUpdate(@RequestBody UserDao users) {
		return userRepository.save(users);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@Consumes(MediaType.APPLICATION_JSON)
	public @ResponseBody SuperResponse delete(@PathVariable("id") long id) {
		try {
			if (userRepository.exists(id)) {
				userRepository.delete(id);
				return new MessageResponse("User Deleted");
			} else {
				return new MessageResponse("User Not Found");
			}
		} catch (Exception ex) {
			return new MessageResponse("Error deleting the user:" + ex.toString());
		}
	}
}
