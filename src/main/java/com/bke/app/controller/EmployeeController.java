package com.bke.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bke.app.model.Employee;
import com.bke.app.repository.EmployeeRepository;

@RestController
@RequestMapping("api/")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/employees")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Employee> getEmployees() {
		return this.employeeRepository.findAll();

	}

	// create Employee rest api
	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee u) {
		return this.employeeRepository.save(u);

	}

	// update Employee rest api
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee u) {
		Optional<Employee> EmployeeData = employeeRepository.findById(id);

		if (EmployeeData.isPresent()) {
			Employee _u = EmployeeData.get();
			_u.setFirstName(u.getFirstName());
			_u.setLastName(u.getLastName());
			_u.setTelephoneNumberr(u.getTelephoneNumberr());
			return new ResponseEntity<>(employeeRepository.save(_u), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// delete Employee rest api
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") long id) {
		try {
			employeeRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// get employee by id rest apii
	@GetMapping("/findEmployee/{id}")
	public ResponseEntity<Employee> getTutorialById(@PathVariable("id") long id) {
		Optional<Employee> tutorialData = employeeRepository.findById(id);

		if (tutorialData.isPresent()) {
			return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/***** tutos ******/
	/*
	 * @GetMapping("/tutorials") public ResponseEntity<List<Tutorial>>
	 * getAllTutorials(@RequestParam(required = false) String title) { try {
	 * List<Tutorial> tutorials = new ArrayList<Tutorial>();
	 * 
	 * if (title == null) tutorialRepository.findAll().forEach(tutorials::add); else
	 * tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);
	 * 
	 * if (tutorials.isEmpty()) { return new
	 * ResponseEntity<>(HttpStatus.NO_CONTENT); }
	 * 
	 * return new ResponseEntity<>(tutorials, HttpStatus.OK); } catch (Exception e)
	 * { return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); } }
	 * 
	 * @GetMapping("/tutorials/{id}") public ResponseEntity<Tutorial>
	 * getTutorialById(@PathVariable("id") long id) { Optional<Tutorial>
	 * tutorialData = tutorialRepository.findById(id);
	 * 
	 * if (tutorialData.isPresent()) { return new
	 * ResponseEntity<>(tutorialData.get(), HttpStatus.OK); } else { return new
	 * ResponseEntity<>(HttpStatus.NOT_FOUND); } }
	 * 
	 * @PostMapping("/tutorials") public ResponseEntity<Tutorial>
	 * createTutorial(@RequestBody Tutorial tutorial) { try { Tutorial _tutorial =
	 * tutorialRepository .save(new Tutorial(tutorial.getTitle(),
	 * tutorial.getDescription(), false)); return new ResponseEntity<>(_tutorial,
	 * HttpStatus.CREATED); } catch (Exception e) { return new
	 * ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); } }
	 * 
	 * @PutMapping("/tutorials/{id}") public ResponseEntity<Tutorial>
	 * updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
	 * Optional<Tutorial> tutorialData = tutorialRepository.findById(id);
	 * 
	 * if (tutorialData.isPresent()) { Tutorial _tutorial = tutorialData.get();
	 * _tutorial.setTitle(tutorial.getTitle());
	 * _tutorial.setDescription(tutorial.getDescription());
	 * _tutorial.setPublished(tutorial.isPublished()); return new
	 * ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK); } else {
	 * return new ResponseEntity<>(HttpStatus.NOT_FOUND); } }
	 * 
	 * @DeleteMapping("/tutorials/{id}") public ResponseEntity<HttpStatus>
	 * deleteTutorial(@PathVariable("id") long id) { try {
	 * tutorialRepository.deleteById(id); return new
	 * ResponseEntity<>(HttpStatus.NO_CONTENT); } catch (Exception e) { return new
	 * ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); } }
	 * 
	 * @DeleteMapping("/tutorials") public ResponseEntity<HttpStatus>
	 * deleteAllTutorials() { try { tutorialRepository.deleteAll(); return new
	 * ResponseEntity<>(HttpStatus.NO_CONTENT); } catch (Exception e) { return new
	 * ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); }
	 * 
	 * }
	 * 
	 * @GetMapping("/tutorials/published") public ResponseEntity<List<Tutorial>>
	 * findByPublished() { try { List<Tutorial> tutorials =
	 * tutorialRepository.findByPublished(true);
	 * 
	 * if (tutorials.isEmpty()) { return new
	 * ResponseEntity<>(HttpStatus.NO_CONTENT); } return new
	 * ResponseEntity<>(tutorials, HttpStatus.OK); } catch (Exception e) { return
	 * new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); } }
	 */

}
