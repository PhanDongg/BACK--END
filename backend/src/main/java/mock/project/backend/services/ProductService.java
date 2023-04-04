package mock.project.backend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mock.project.backend.entities.Categories;
import mock.project.backend.entities.Images;
import mock.project.backend.entities.ProductSize;
import mock.project.backend.entities.Products;
import mock.project.backend.entities.Sizes;
import mock.project.backend.repository.CategoryRepository;
import mock.project.backend.repository.ImageRepository;
import mock.project.backend.repository.ProductRepository;
import mock.project.backend.repository.ProductSizeRepository;
import mock.project.backend.request.ProductDTO;
import mock.project.backend.request.ProductRequest;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository productRepo;

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private ModelMapper modelMap;

	@Autowired
	private CategoryRepository catRepo;
	
	@Autowired
	private ProductSizeRepository productSizeRepo;
	
	@Autowired
	private ImageRepository imageRepo;

	public List<ProductDTO> findAllProduct(Pageable pageable) {
		Page<Products> products = productRepo.findAll(pageable);
		List<ProductDTO> productDTOs = new ArrayList<>();
		for (Products product : products) {
			ProductDTO producctDTO = modelMap.map(product, ProductDTO.class);
			productDTOs.add(producctDTO);
		}
		return productDTOs;
	}

	public List<ProductDTO> findAllProductNoPaging() {
		List<Products> products = productRepo.findAll();
		List<ProductDTO> productDTOs = new ArrayList<>();
		for (Products product : products) {
			ProductDTO producctDTO = modelMap.map(product, ProductDTO.class);
			productDTOs.add(producctDTO);
		}
		return productDTOs;
	}

	public List<ProductDTO> findPoductBySearch(String searchField) {
		List<Products> products = new ArrayList<>();
		products = productRepo.findByProductName(searchField);
		List<ProductDTO> productDTOs = new ArrayList<>();
		for (Products product : products) {
			ProductDTO producctDTO = modelMap.map(product, ProductDTO.class);
			productDTOs.add(producctDTO);
		}
		return productDTOs;
	}

	public List<ProductDTO> findPoductByCategory(Integer category) {
		List<Products> products = new ArrayList<>();
		products = productRepo.findByCategory(category);
		List<ProductDTO> productDTOs = new ArrayList<>();
		for (Products product : products) {
			ProductDTO producctDTO = modelMap.map(product, ProductDTO.class);
			productDTOs.add(producctDTO);
		}
		return productDTOs;
	}

	public ProductDTO findPoductById(Integer id) {
		Optional<Products> product = productRepo.findById(id);
		ProductDTO productDTO = modelMap.map(product.get(), ProductDTO.class);
		return productDTO;
	}

	public List<ProductDTO> searchProductByFilter(ProductRequest productRequest) {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Products> cq = cb.createQuery(Products.class);
		Root<Products> root = cq.from(Products.class);
		List<Predicate> searchCriterias = new ArrayList<>();

		String color = productRequest.getColor();
		double size = productRequest.getSize();
		String type = productRequest.getType();
		String categoryName = productRequest.getCategoryName();
		double startRangePrice = productRequest.getStartRangePrice();
		double endRangePrice = productRequest.getEndRangePrice();

		if ((color != "") && (color != null)) {
			searchCriterias.add(cb.equal(root.get("color"), color));
		}
		if ((size != 0) && (size < 50)) {
			Join<Products, ProductSize> productSizeJoin = root.join("productSizes");
			Join<ProductSize, Sizes> productSizeSizeJoin = productSizeJoin.join("size");
			searchCriterias.add(cb.equal(productSizeSizeJoin.get("size"), size));
		}
		if ((categoryName != "") && (categoryName != null)) {
			searchCriterias.add(cb.equal(root.get("brand"), categoryName));
		}
		if ((type != "") && (type != null)) {
			searchCriterias.add(cb.equal(root.get("type"), type));
		}
		if ((startRangePrice != 0) && (endRangePrice != 0) && (startRangePrice < endRangePrice)) {
			searchCriterias.add(cb.between(root.get("price"), startRangePrice, endRangePrice));
		}
		cq.select(root).where(cb.and(searchCriterias.toArray(new Predicate[searchCriterias.size()])));

		List<Products> products = entityManager.createQuery(cq).getResultList();
		List<ProductDTO> productDTOs = new ArrayList<>();

		for (Products product : products) {
			ProductDTO producctDTO = modelMap.map(product, ProductDTO.class);
			productDTOs.add(producctDTO);
		}
		return productDTOs;
	}

	public Products save(ProductDTO productDTO) {
		Products product = new Products();
		productDTO.getCategory().getCategoryName(); // 2
		String[] imageArr = productDTO.getImages().get(0).getLink().split(",");
		
		Optional<Categories> category = catRepo.findById(Integer.valueOf(productDTO.getCategory().getCategoryName())); // id
																													// =
		product.setCategory(category.get()); // get lay object ben trong
		product.setProductName(productDTO.getProductName());
		product.setBrand(productDTO.getBrand());
		product.setColor(productDTO.getColor());
		product.setDate(productDTO.getDate());
		product.setType(productDTO.getType());
		product.setBrand(productDTO.getBrand());
		product.setDescription(productDTO.getDescription());
		product.setPrice(productDTO.getPrice());
		product.setQuantity(productDTO.getQuantity());
		product.setProductCode(productDTO.getProductCode());
		
		for (String link : imageArr) {
			Images images = new Images();
			images.setProduct(product);
			images.setLink(link);
			imageRepo.save(images);
			
		}
		
		for (Sizes s : productDTO.getSizes()) {
			ProductSize ps = new ProductSize();
			ps.setProduct(product);
			ps.setSize(s);
			productSizeRepo.save(ps);
		}

		
		return productRepo.save(product);
	}

	/*
	 * public Products saveProduct(ProductDTO product) { Products newProduct = new
	 * Products(); product.getCategory().getCategoryName(); // 2
	 * Optional<Categories> category =
	 * catRepo.findById(Integer.valueOf(product.getCategory().getCategoryName()));
	 * // id // = // 2 newProduct.setCategory(category.get()); // get lay object ben
	 * trong newProduct = modelMap.map(product, Products.class);
	 * productRepo.save(newProduct); return newProduct; }
	 */

	public void delete(Integer productId) {
		productRepo.deleteById(productId);
	}

	public Products findById(final Integer id) {
		return productRepo.findById(id).get();
	}

	public ProductDTO findByCategory(final Integer id) {
		Optional<Products> product = productRepo.findById(id);
		Products pro = product.get();
		ProductDTO producctDTO = modelMap.map(pro, ProductDTO.class);
		return producctDTO;
	}

	public List<ProductDTO> findAllProductByDateDESC(Pageable pageable) {
		Page<Products> products = productRepo.findAll(pageable);
		List<ProductDTO> productDTOs = new ArrayList<>();
		for (Products product : products) {
			ProductDTO producctDTO = modelMap.map(product, ProductDTO.class);
			productDTOs.add(producctDTO);
		}
		return productDTOs;
//	 List<Products> passengers = repository.findAll(Sort.by(Sort.Direction.ASC, "Date"));
	}

//	public List<ProductDTO> findProductByType(String type) {
//		List<Products> products = new ArrayList<>();
//		products = productRepo.findByProductType(type);
//		List<ProductDTO> productDTOList = new ArrayList<>();
//		for (Products product : products) {
//			ProductDTO productDTO = modelMap.map(product, ProductDTO.class);
//			productDTOList.add(productDTO);
//		}
//		return productDTOList;
//	}

	public List<Products> findByProductType(String type) {

		List<Products> productList = new ArrayList<>();
		productList = productRepo.findByType(type);

		return productList;
	}

	public List<Products> findByTypeAndCategory(Integer id, String type) {
		List<Products> productList = new ArrayList<>();
		productList = productRepo.findByTypeAndCategory(id, type);
		return productList;
	}

}
