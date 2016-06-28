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

import com.gmt.myschool.dao.SchoolDao;
import com.gmt.myschool.repository.SchoolsRepository;
import com.gmt.myschool.responses.MessageResponse;
import com.gmt.myschool.responses.SuperResponse;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/schools")
@Produces(MediaType.APPLICATION_JSON)
public class SchoolsAPI {

	@Autowired
	private SchoolsRepository schoolsRepository;

	@ApiOperation(value = "Get All Schools")
	@RequestMapping(method = RequestMethod.GET, value = "/all")
	@Consumes(MediaType.APPLICATION_JSON)
	public @ResponseBody List<SchoolDao> getAllUsers() {
		return schoolsRepository.findAll();
	}

	@ApiOperation(value = "Get One School")
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public @ResponseBody SuperResponse getOne(@PathVariable("id") long id) {
		try {
			if (schoolsRepository.exists(id)) {
				return schoolsRepository.findOne(id);
			} else {
				return new MessageResponse("School Not Found");
			}
		} catch (Exception ex) {
			return new MessageResponse("Error reading the user:" + ex.toString());
		}
	}

	@ApiOperation(value = "Add New School OR Update Existing School")
	@RequestMapping(method = RequestMethod.POST, value = "/addorupdate")
	@Consumes(MediaType.APPLICATION_JSON)
	public @ResponseBody SchoolDao createOrUpdate(@RequestBody SchoolDao school) {
		return schoolsRepository.save(school);
	}

	@ApiOperation(value = "Delete One School")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@Consumes(MediaType.APPLICATION_JSON)
	public @ResponseBody SuperResponse delete(@PathVariable("id") long id) {
		try {
			if (schoolsRepository.exists(id)) {
				schoolsRepository.delete(id);
				return new MessageResponse("School Deleted");
			} else {
				return new MessageResponse("School Not Found");
			}
		} catch (Exception ex) {
			return new MessageResponse("Error deleting the school:" + ex.toString());
		}
	}
}
