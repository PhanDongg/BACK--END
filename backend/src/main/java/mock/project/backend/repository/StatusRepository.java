package mock.project.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mock.project.backend.entities.Status;

public interface StatusRepository extends JpaRepository<Status, Integer> {

}
