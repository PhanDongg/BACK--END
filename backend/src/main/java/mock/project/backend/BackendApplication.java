package mock.project.backend;

<<<<<<< HEAD
=======
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

>>>>>>> 06603f08a7d3bf016bd69dcec4f47e1fe5ea05a6
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

<<<<<<< HEAD
=======
import mock.project.backend.entities.Categories;
import mock.project.backend.entities.Images;
import mock.project.backend.entities.ProductSize;
import mock.project.backend.entities.Products;
import mock.project.backend.entities.Roles;
import mock.project.backend.entities.Sizes;
import mock.project.backend.entities.Status;
import mock.project.backend.entities.UserRole;
import mock.project.backend.entities.Users;
import mock.project.backend.repository.CategoryRepository;
import mock.project.backend.repository.ImageRepository;
import mock.project.backend.repository.ProductRepository;
import mock.project.backend.repository.ProductSizeRepository;
import mock.project.backend.repository.RoleRepository;
import mock.project.backend.repository.SizeRepository;
import mock.project.backend.repository.StatusRepository;
import mock.project.backend.repository.UserRepository;
import mock.project.backend.repository.UserRoleRepository;

>>>>>>> 06603f08a7d3bf016bd69dcec4f47e1fe5ea05a6
@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	 @Bean
	    public ModelMapper modelMapper() {
	        return new ModelMapper();
	    }
			 
	 
}