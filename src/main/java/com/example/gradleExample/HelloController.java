package com.example.gradleExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "demo")
@CrossOrigin(origins="http://localhost:4200")
public class HelloController {

	/*
	 * private static final String template = "Hello, %s!"; private final AtomicLong
	 * counter = new AtomicLong();
	 * 
	 * @RequestMapping("/hello") public Hello hello(@RequestParam(value="name",
	 * defaultValue="World") String name) { return new
	 * Hello(counter.incrementAndGet(), String.format(template, name)); }
	 */

	@Autowired
	private UserRepository userRepository;

	@PostMapping(path = "/add")
	public @ResponseBody String addNewUser(@RequestBody Employee emp) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Employee n = new Employee();
		n.setId(emp.getId());
		n.setName(emp.getName());
		n.setSalary(emp.getSalary());
		userRepository.save(n);
		return "Saved";
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Employee> getAllUsers() {
		
		System.out.println("barkha"+userRepository.findAll());
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
}
