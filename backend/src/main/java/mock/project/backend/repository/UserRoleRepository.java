package mock.project.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mock.project.backend.entities.UserRole;
@Repository(value="userRoleRepo")
public interface UserRoleRepository  extends JpaRepository<UserRole, Integer>{

}
