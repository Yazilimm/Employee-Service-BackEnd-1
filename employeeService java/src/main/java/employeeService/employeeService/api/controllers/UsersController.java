package employeeService.employeeService.api.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import employeeService.employeeService.business.abstracts.UserService;
import employeeService.employeeService.core.Entities.Role;
import employeeService.employeeService.core.Entities.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UsersController {
	private final UserService userService;
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getUsers(){
		final List<User> users = userService.getUsers();
		return ResponseEntity.ok(users);
	}
	
	@GetMapping("/saveUser")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/saveUser").toUriString());
		return ResponseEntity.created(uri).body(userService.saveUser(user));
	}
	
	@GetMapping("/saveRole")
	public ResponseEntity<Role> saveRole(@RequestBody Role role){
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/saveRole").toUriString());
		return ResponseEntity.created(uri).body(userService.saveRole(role));
	}
	
	@GetMapping("/roleAddToUser")
	public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form){
		userService.addRoleToUser(form.getUsername(),form.getRoleName());
		return ResponseEntity.ok().build();
	}
	
	
}
@Data
class RoleToUserForm{
	private String username;
	private String roleName;
}
