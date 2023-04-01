package mock.project.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mock.project.backend.entities.Products;

@Repository(value="productRepo")
public interface ProductRepository extends JpaRepository<Products, Integer> {
	@Query("SELECT p FROM Products p WHERE p.productName like %:productName%")
	List<Products> findByProductName(String productName);
	
	@Query("SELECT p FROM Products p WHERE category.categoryId= ?1")
	List<Products> findByCategory(Integer category);
	
	void deleteById(Integer productId);
	
//	@Query("SELECT p FROM Products p WHERE p.type LIKE %:type%")
//	List<Products> findByProductType(String type);
	
	List<Products> findByType(String type);
	
	@Query("Select p from Products p where category.categoryId=?1 and p.type = ?2")
	List<Products> findByTypeAndCategory(Integer id, String type);
	
	
}
