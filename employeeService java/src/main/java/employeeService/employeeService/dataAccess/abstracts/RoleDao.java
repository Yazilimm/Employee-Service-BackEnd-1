package employeeService.employeeService.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import employeeService.employeeService.core.Entities.Role;

public interface RoleDao extends JpaRepository<Role, Long> {
	Role findByName(String name);
}
