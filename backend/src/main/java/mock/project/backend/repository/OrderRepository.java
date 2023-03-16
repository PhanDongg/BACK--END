package mock.project.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mock.project.backend.entities.Orders;
@Repository(value="orderRepo")
public interface OrderRepository extends JpaRepository<Orders, Integer>{

}
