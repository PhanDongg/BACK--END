package mock.project.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mock.project.backend.entities.Sizes;
@Repository(value="sizeRepo")
public interface SizeRepository  extends JpaRepository<Sizes, Integer>{

}
