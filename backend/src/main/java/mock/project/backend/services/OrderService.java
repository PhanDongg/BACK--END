package mock.project.backend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mock.project.backend.entities.Orders;
import mock.project.backend.repository.OrderRepository;
import mock.project.backend.request.OrderDTO;

@Service
@Transactional
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
	
	public OrderDTO findOrderById(Integer id) {
		Optional<Orders> order = orderRepo.findById(id);
		OrderDTO orderDTO = modelMap.map(order.get(), OrderDTO.class);
		return orderDTO;
	}
	
	public List<OrderDTO> findListOrdersByUserId(Integer userId) {
		List<OrderDTO> orderDTOs = new ArrayList<>();
		List<Orders> orders= orderRepo.findByUser(userId);
		for (Orders order : orders) {
			OrderDTO orderDTO = modelMap.map(order, OrderDTO.class);
			orderDTOs.add(orderDTO);
		}
		return orderDTOs;
	}
}
