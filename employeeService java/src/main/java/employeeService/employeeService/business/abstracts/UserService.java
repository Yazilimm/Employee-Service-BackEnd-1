package employeeService.employeeService.business.abstracts;

import java.util.List;

import employeeService.employeeService.core.Entities.Role;
import employeeService.employeeService.core.Entities.User;

public interface UserService {
	User saveUser(User user);
	Role saveRole(Role role);
	void addRoleToUser(String username, String roleName);
	User getUser(String username);
	List<User> getUsers();
}
