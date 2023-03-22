package mock.project.backend.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mock.project.backend.entities.Categories;
import mock.project.backend.entities.Sizes;
import mock.project.backend.repository.CategoryRepository;
import mock.project.backend.repository.SizeRepository;
import mock.project.backend.request.CategoryDTO;
import mock.project.backend.request.SizeDTO;
@Service
@Transactional
public class SizeService {
	
	@Autowired
	private SizeRepository sizeRepo;

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private ModelMapper modelMap;
	
	public List<SizeDTO> findAllSizes() {
		List<SizeDTO> sizeDTOs = new ArrayList<>();
		List<Sizes> sizes = sizeRepo.findAll();
		for (Sizes size : sizes) {
			SizeDTO categoryDTO = modelMap.map(size, SizeDTO.class);
			sizeDTOs.add(categoryDTO);
		}
		return sizeDTOs;
	}
	
	
}