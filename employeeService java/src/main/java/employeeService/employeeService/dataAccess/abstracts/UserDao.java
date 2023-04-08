package employeeService.employeeService.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import employeeService.employeeService.core.Entities.User;

public interface UserDao extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
