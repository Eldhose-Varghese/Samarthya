package org.kodifine.controller;

import org.kodifine.Entity.MyUser;
import org.kodifine.Repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
	
	@Autowired
	MyUserRepository myrepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostMapping("/register/user")
	public MyUser register(@RequestBody MyUser user)
	{
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return myrepo.save(user);
	}
	
}
