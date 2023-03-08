package mock.project.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mock.project.backend.entities.Roles;

@Repository(value="roleRepo")
public interface RoleRepository extends JpaRepository<Roles, Integer> {

}
