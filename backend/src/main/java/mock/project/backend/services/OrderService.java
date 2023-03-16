package mock.project.backend.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mock.project.backend.entities.Orders;
import mock.project.backend.repository.OrderRepository;
import mock.project.backend.request.OrderDTO;

public class OrderService {

	@Autowired
	private OrderRepository orderRepo;

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private ModelMapper modelMap;
	
	public List<OrderDTO> findByBrand(Pageable pageable) {
		List<OrderDTO> orderDTOs = new ArrayList<>();
		Page<Orders> orders= orderRepo.findAll(pageable);
		for (Orders order : orders) {
			OrderDTO orderDTO = modelMap.map(order, OrderDTO.class);
			orderDTOs.add(orderDTO);
		}
		return orderDTOs;
	}
}
