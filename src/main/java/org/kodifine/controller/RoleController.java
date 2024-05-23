package org.kodifine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoleController {
	
	
	@GetMapping("/employee")
	public String handleEmployee()
	{
		return "EmployeeHome";
	}
	@GetMapping("/hr/home")
	public String handleHr()
	{
		return "HrHome";
	}


}
