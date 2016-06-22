package com.gmt.myschool.apis;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gmt.myschool.dao.UserDao;
import com.gmt.myschool.repository.UserRepository;
import com.gmt.myschool.requests.LoginRequest;
import com.gmt.myschool.responses.MessageResponse;
import com.gmt.myschool.responses.SuperResponse;

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
		for (UserDao user : getAllUsers()) {
			if (user.getUsername().equalsIgnoreCase(req.getUsername())) {
				if (user.getPassword().equals(req.getPassword())) {
					return user;
				} else {
					return new MessageResponse("Invalid Password");
				}
			} else {
				return new MessageResponse("Invalid Username");
			}
		}

		return new MessageResponse("Error Finding User");
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
