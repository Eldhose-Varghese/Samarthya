package org.kodifine.Service;

import java.util.Optional;

import org.kodifine.Entity.MyUser;
import org.kodifine.Repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private MyUserRepository myrepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 Optional<MyUser> user = myrepo.findByUsername(username);
		 if(user.isPresent())
		 {
			 var userobj = user.get();
			return User.builder()
				.username(userobj.getUsername())
				.password(userobj.getPassword())
				.roles(getRoles(userobj))
				.build();
		 }
		 else
		 {
			 throw new UsernameNotFoundException(username);
		 }
	}

	private String[] getRoles(MyUser userobj) {
		// TODO Auto-generated method stub
		if(userobj.getRole()==null)
		{
			return new String[]{"EMPLOYEE"};
		}
		return userobj.getRole().split(",");
	}

}
