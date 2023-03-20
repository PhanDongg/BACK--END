package mock.project.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mock.project.backend.entities.ProductSize;

@Repository(value="productSizeRepo")
public interface ProductSizeRepository extends JpaRepository<ProductSize, Integer> {

}
