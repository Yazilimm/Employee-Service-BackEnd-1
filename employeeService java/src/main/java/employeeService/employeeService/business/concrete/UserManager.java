package employeeService.employeeService.business.concrete;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;


import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import employeeService.employeeService.business.abstracts.UserService;
import employeeService.employeeService.core.Entities.Role;
import employeeService.employeeService.core.Entities.User;
import employeeService.employeeService.dataAccess.abstracts.UserDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import employeeService.employeeService.dataAccess.abstracts.RoleDao;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserManager implements UserService, UserDetailsService {

	private final UserDao userDao;
	private final RoleDao roleDao;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		if(user== null){
			log.error("User not found in the database");
			throw new UsernameNotFoundException("User not found in the database");
		}
		else{
			log.info("User  found in the database: {}", username);
		}
		
		return  User(user.getUsername(),user.getPassword());
	}

	private UserDetails User(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User saveUser(User user) {
		log.info("Saving new user {} to the database", user.getName());
		return userDao.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		log.info("Saving new role {} to the database",role.getName());
		return roleDao.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		log.info("Adding role {} to user",roleName,username);
		User user = userDao.findByUsername(username);
		Role role = roleDao.findByName(roleName);
		//user.getRoles().add(role);
		
	}

	@Override
	public User getUser(String username) {
		log.info("Fetching user {} ",username);
		return userDao.findByUsername(username);
	}

	@Override
	public List<User> getUsers() {
		log.info("Fetching all users ");
		return userDao.findAll();
	}


}
