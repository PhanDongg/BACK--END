package mock.project.backend;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

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
	 

//		@Bean
//			public CommandLineRunner Demo(ProductSizeRepository productSizeRepo,BCryptPasswordEncoder bCryptPasswordEncoder,StatusRepository statusRepo,UserRepository userRepo,UserRoleRepository userRoleRepo, RoleRepository roleRepo,CategoryRepository catRepo ,ProductRepository productRepo, ImageRepository imageRepo,SizeRepository sizeRepo) {
//				return args ->{
//					
//					Roles role = new Roles("ROLE_ADMIN"); 
//					Roles role1 = new Roles("ROLE_USER"); 
//					roleRepo.save(role);
//					roleRepo.save(role1);
//					String password = bCryptPasswordEncoder.encode("123");
//					Users user = new Users("admin",password,"Admin","admin@gmail.com","123HCMC","012388888",LocalDate.of(1999, 7, 8),"https://i.bloganchoi.com/bloganchoi.com/wp-content/uploads/2020/10/meme-hai-huoc-moi-nhat-96.jpg?fit=564%2C20000&quality=95&ssl=1");
//					Users user1 = new Users("user",password,"User","user@gmail.com","123HCMC","012388888",LocalDate.of(1992, 7, 8),"https://i.bloganchoi.com/bloganchoi.com/wp-content/uploads/2020/10/meme-hai-huoc-moi-nhat-96.jpg?fit=564%2C20000&quality=95&ssl=1");
//					user.setEnabled(true);
//					user1.setEnabled(true);
//					userRepo.save(user);
//					userRepo.save(user1);
//					
//					userRoleRepo.save(new UserRole(user,role));
//					userRoleRepo.save(new UserRole(user,role1));
//					userRoleRepo.save(new UserRole(user1,role1));
//							
//					List<Sizes> sizes = new ArrayList<>();
//					sizes.add(new Sizes(37));
//					sizes.add(new Sizes(38));
//					sizes.add(new Sizes(39));
//					sizes.add(new Sizes(40));
//					sizes.add(new Sizes(41));
//					sizes.add(new Sizes(42));
//					sizes.add(new Sizes(43));
//					for(Sizes size: sizes) {
//						sizeRepo.save(size);
//					}
//					
//					
//					List<Status> status = new ArrayList<>();
//					status.add(new Status("Mới"));
//					status.add(new Status("Đang xử lí"));
//					status.add(new Status("Đang giao hàng"));
//					status.add(new Status("Đã giao"));
//					for(Status stt: status) {
//						statusRepo.save(stt);
//					}
//					
//					Categories adidas = new Categories("Giày Adidas"); 
//					Categories puma = new Categories("Giày Puma"); 
//					Categories nike = new Categories("Giày Nike"); 
//					Categories reebok = new Categories("Giày Reebok"); 
//					catRepo.save(adidas);
//					catRepo.save(puma);
//					catRepo.save(nike);
//					catRepo.save(reebok);
//					
//					List<Products> productadidas = new ArrayList<>();
//					productadidas.add(new Products("Giày Chạy Bộ Adidas Ultraboost Srdy Tyo FX0031",3000000,"Sneaker","Nam","Trắng",100,"Adidas",adidas));
//					productadidas.add(new Products("Giày Chạy Bộ Adidas Supernova M H04482",5890000,"Sneaker","Nam","Đen",100,"Adidas",adidas));
//					productadidas.add(new Products("Giày Chạy Bộ Adidas Supernova 2 M GW9092",6000000,"Sneaker","Nam","Trắng",100,"Adidas",adidas));
//					productadidas.add(new Products("Giày Chạy Bộ Adidas Sl20.3 M GY0559",1200000,"Sneaker","Nữ","Xám",100,"Adidas",adidas));
//					productadidas.add(new Products("Giày Chạy Bộ Adidas EQ21 Run GZ6869",8900000,"Sneaker","Nữ","Trắng",100,"Adidas",adidas));
//					productadidas.add(new Products("Giày Chạy Bộ Adidas Nebzed GX4284",1110000,"Sneaker","Nam","Đen",100,"Adidas",adidas));
//					productadidas.add(new Products("Giày Chạy Bộ Adidas Response GW6565",2000000,"Sneaker","Nam","Trắng",100,"Adidas",adidas));
//					productadidas.add(new Products("Giày Chạy Bộ Adidas Response GW6645",5500000,"Sneaker","Nữ","Đen",100,"Adidas",adidas));
//					productadidas.add(new Products("Giày Chạy Bộ Adidas Duramo SL GV7124",7400000,"Sneaker","Nam","Xám",100,"Adidas",adidas));
//					productadidas.add(new Products("Giày Chạy Bộ Adidas Pureboost Jet GW8591",8000000,"Sneaker","Nữ","Đen",100,"Adidas",adidas));
//					
//					List<Products> productPuma = new ArrayList<>();
//					productPuma.add(new Products("Giày Tập Luyện Puma Xetic Halflife 19",2300000,"Sneaker","Unisex","Đen",100,"Puma",puma));
//					productPuma.add(new Products("Giày Lifestyle Puma Intl 375149-01",5890000,"Sneaker","Nữ","Trắng",100,"Puma",puma));
//					productPuma.add(new Products("Giày Lifestyle Puma Rs Z 383589-01",6000000,"Sneaker","Nam","Xám",100,"Puma",puma));
//					productPuma.add(new Products("Giày Lifestyle Puma Trc 383104-01",6000000,"Sneaker","Nam","Đen",100,"Puma",puma));
//					productPuma.add(new Products("Giày Lifestyle Puma Rs X3 368845-03",1900000,"Sneaker","Unisex","Đen",100,"Puma",puma));
//					productPuma.add(new Products("Giày Bóng Rổ Puma Slipstream Mix 388635-03",2300000,"Sneaker","Unisex","Đen",100,"Puma",puma));
//					productPuma.add(new Products("Giày Bóng Rổ Puma Triple Mid 376451-01",3300000,"Sneaker","Nam","Đen",100,"Puma",puma));
//					productPuma.add(new Products("Giày Lifestyle Puma X Ray 373108-16",2300000,"Sneaker","Unisex","Đen",100,"Puma",puma));
//					productPuma.add(new Products("Giày Bóng Rổ Puma Rebound 374765-19",1000000,"Sneaker","Nữ","Trắng",100,"Puma",puma));
//					productPuma.add(new Products("Giày Chạy Bộ Puma X-Ray 384639-11",3300000,"Sneaker","Unisex","Trắng",100,"Puma",puma));
//					
//					List<Products> productnike = new ArrayList<>();
//					productnike.add(new Products("Giày Lifestyle Nike Court Legacy Cnvs CW6539-100",1900000,"Sneaker","Nam","Trắng",100,"Nike",nike));
//					productnike.add(new Products("Giày Bóng Rổ Nike Defyallday DJ1196-101",6000000,"Sneaker","Nam","Đen",100,"Nike",nike));
//					productnike.add(new Products("Giày Chạy Bộ Nike Downshifter 12 DD9293-101",2000000,"Sneaker","Nam","Xám",100,"Nike",nike));
//					productnike.add(new Products("Giày Lifestyle Nike Blazer Low 77 Se Nn DM0210-100",3300000,"Sneaker","Nữ","Trắng",100,"Nike",nike));
//					productnike.add(new Products("Giày Lifestyle Nike Air Max 97 DM0027-001",1110000,"Sneaker","Nữ","Trắng",100,"Nike",nike));
//					productnike.add(new Products("Giày Lifestyle Nike Blazer Mid Pro Club DQ7673-100",5000000,"Sneaker","Nam","Đen",100,"Nike",nike));
//					productnike.add(new Products("Giày Lifestyle Nike Blazer Mid Pro Club DQ7673-001",1000000,"Sneaker","Nam","Đen",100,"Nike",nike));
//					productnike.add(new Products("Giày Chạy Bộ Nike Air Zoom Pegasus 39 DH4071-102",1230000,"Sneaker","Nữ","Trắng",100,"Nike",nike));
//					productnike.add(new Products("Giày Bóng Rổ Nike M Metcon 8 Flyease DO9388-300",1500000,"Sneaker","Nam","Trắng",100,"Nike",nike));
//					productnike.add(new Products("Giày Lifestyle Nike Air Max 90 DQ4071-100",1110000,"Sneaker","Nữ","Đen",100,"Nike",nike));
//					
//					List<Products> productreebok= new ArrayList<>();
//					productreebok.add(new Products("Giày Tennis Reebok Club C Revenge Vintage FW4862",3300000,"Sneaker","Nam","Trắng",100,"Reebok",reebok));
//					productreebok.add(new Products("Giày Chạy Bộ Reebok Cl Legacy Az GY1552",5500000,"Sneaker","Nam","Đen",100,"Reebok",reebok));
//					productreebok.add(new Products("Giày Tập Luyện Reebok Hiit Training 2.0 GW8519",6100000,"Sneaker","Nam","Xám",100,"Reebok",reebok));
//					productreebok.add(new Products("Giày Tennis Reebok Club C 85 GZ3656",2000000,"Sneaker","Nữ","Đen",100,"Reebok",reebok));
//					productreebok.add(new Products("Giày Tennis Reebok Royal Techque T Ce GX3514",3700000,"Sneaker","Nữ","Đen",100,"Reebok",reebok));
//					productreebok.add(new Products("Giày Tennis Reebok Club C Revenge Mu EG9270",6100000,"Sneaker","Nam","Đen",100,"Reebok",reebok));
//					productreebok.add(new Products("Giày Chạy Bộ Reebok Turbo Restyle GW7830",6100000,"Sneaker","Nam","Trắng",100,"Reebok",reebok));
//					productreebok.add(new Products("Giày Tennis Reebok Club C Revenge GX1702",6100000,"Sneaker","Nữ","Đen",100,"Reebok",reebok));
//					productreebok.add(new Products("Giày Chạy Bộ Reebok Rider V GZ3109",9990000,"Sneaker","Nam","Đen",100,"Reebok",reebok));
//					productreebok.add(new Products("Giày Chạy Bộ Reebok Rider V GZ3110",1500000,"Sneaker","Nữ","Trắng",100,"Reebok",reebok));
//					
//					List<Images> imageAdidas= new ArrayList<>();
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/269219/adidas-ultraboost-srdy-tyo-fx0031-1.jpg"));
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/269219/adidas-ultraboost-srdy-tyo-fx0031-2.jpg"));
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/269219/adidas-ultraboost-srdy-tyo-fx0031-3.jpg"));
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/269219/adidas-ultraboost-srdy-tyo-fx0031-4.jpg"));
//					
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/282599/adidas-supernova-m-h04482-1.jpg"));
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/282599/adidas-supernova-m-h04482-2.jpg"));
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/282599/adidas-supernova-m-h04482-3.jpg"));
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/282599/adidas-supernova-m-h04482-4.jpg"));
//					
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/282558/giay-chay-bo-nam-adidas-supernova-2-m-gw9092-1.jpg"));
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/282558/giay-chay-bo-nam-adidas-supernova-2-m-gw9092-2.jpg"));
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/282558/giay-chay-bo-nam-adidas-supernova-2-m-gw9092-3.jpg"));
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/282558/giay-chay-bo-nam-adidas-supernova-2-m-gw9092-4.jpg"));
//					
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/276942/adidas-sl203-m-gy0559-1.jpg"));
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/276942/adidas-sl203-m-gy0559-2.jpg"));
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/276942/adidas-sl203-m-gy0559-3.jpg"));
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/276942/adidas-sl203-m-gy0559-4.jpg"));
//					
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/282508/adidas-eq21-run-gz6869-cam-1.jpg"));
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/282508/adidas-eq21-run-gz6869-cam-2.jpg"));
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/282508/adidas-eq21-run-gz6869-cam-4.jpg"));
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/282508/adidas-eq21-run-gz6869-cam-4.jpg"));
//					
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/282630/giay-chay-bo-nam-adidas-nebzed-gx4284-moi-1.jpg"));
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/282630/giay-chay-bo-nam-adidas-nebzed-gx4284-moi-2.jpg"));
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/282630/giay-chay-bo-nam-adidas-nebzed-gx4284-moi-3.jpg"));
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/282630/giay-chay-bo-nam-adidas-nebzed-gx4284-moi-4.jpg"));
//					
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/279824/giay-chay-bo-nam-adidas-response-gw6565-xam-1.jpg"));
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/279824/giay-chay-bo-nam-adidas-response-gw6565-xam-2.jpg"));
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/279824/giay-chay-bo-nam-adidas-response-gw6565-xam-3.jpg"));
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/279824/giay-chay-bo-nam-adidas-response-gw6565-xam-4.jpg"));
//					
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/282466/giay-chay-bo-nam-adidas-response-gw6645-1.jpg"));
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/282466/giay-chay-bo-nam-adidas-response-gw6645-2.jpg"));
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/282466/giay-chay-bo-nam-adidas-response-gw6645-3.jpg"));
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/282466/giay-chay-bo-nam-adidas-response-gw6645-4.jpg"));
//					
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/277666/giay-chay-bo-nam-adidas-duramo-sl-den-1.jpg"));
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/277666/giay-chay-bo-nam-adidas-duramo-sl-den-2.jpg"));
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/277666/giay-chay-bo-nam-adidas-duramo-sl-den-3.jpg"));
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/277666/giay-chay-bo-nam-adidas-duramo-sl-den-4.jpg"));
//					
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/282468/giay-chay-bo-unisex-adidas-pureboost-jet-gw8591-moi-1.jpg"));
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/282468/giay-chay-bo-unisex-adidas-pureboost-jet-gw8591-moi-2.jpg"));
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/282468/giay-chay-bo-unisex-adidas-pureboost-jet-gw8591-moi-3.jpg"));
//					imageAdidas.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/282468/giay-chay-bo-unisex-adidas-pureboost-jet-gw8591-moi-4.jpg"));
//					
//					//////
//					List<Images> imagePuma= new ArrayList<>();
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/285866/puma-xetic-halflife-195196-06-1.jpg"));
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/285866/puma-xetic-halflife-195196-06-2.jpg"));
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/285866/puma-xetic-halflife-195196-06-5.jpg"));
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/285866/puma-xetic-halflife-195196-06-4.jpg"));
//					
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/292470/giay-bong-ro-puma-nu-ki-retro-grade-386450-01-1.jpg"));
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/292470/giay-bong-ro-puma-nu-ki-retro-grade-386450-01-2.jpg"));
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/292470/giay-bong-ro-puma-nu-ki-retro-grade-386450-01-3.jpg"));
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/292470/giay-bong-ro-puma-nu-ki-retro-grade-386450-01-4.jpg"));
//					
//					
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/285860/giay-lifestyle-unisex-puma-rs-z-383589-01-trang-xanh-1.jpg"));
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/285860/giay-lifestyle-unisex-puma-rs-z-383589-01-trang-xanh-2.jpg"));
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/285860/giay-lifestyle-unisex-puma-rs-z-383589-01-trang-xanh-3.jpg"));
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/285860/giay-lifestyle-unisex-puma-rs-z-383589-01-trang-xanh-4.jpg"));
//					
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/285858/puma-trc-383104-01-1.jpg"));
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/285858/puma-trc-383104-01-2.jpg"));
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/285858/puma-trc-383104-01-3.jpg"));
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/285858/puma-trc-383104-01-4.jpg"));
//					
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/265637/giay-lifestyle-unisex-puma-rs-x3-368845-m-1.jpg"));
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/265637/giay-lifestyle-unisex-puma-rs-x3-368845-m-2.jpg"));
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/265637/giay-lifestyle-unisex-puma-rs-x3-368845-m-1.jpg"));
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/265637/giay-lifestyle-unisex-puma-rs-x3-368845-m-4.jpg"));
//					
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/280539/puma-muse-x5-383954-01-den-1.jpg"));
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/280539/puma-muse-x5-383954-01-den-2.jpg"));
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/280539/puma-muse-x5-383954-01-den-3.jpg"));
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/280539/puma-muse-x5-383954-01-den-4.jpg"));
//					
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/290499/puma-37645101-1.jpg"));
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/290499/puma-37645101-2.jpg"));
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/290499/puma-37645101-3.jpg"));
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/290499/puma-37645101-4.jpg"));
//					
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/285845/giay-lifestyle-nu-puma-cali-dream-384463-01-1.jpg"));
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/285845/giay-lifestyle-nu-puma-cali-dream-384463-01-2.jpg"));
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/285845/giay-lifestyle-nu-puma-cali-dream-384463-01-3.jpg"));
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/285845/giay-lifestyle-nu-puma-cali-dream-384463-01-4.jpg"));
//					
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/292464/giay-bong-ro-puma-unisex-puma-rebound-374765-19-1.jpg"));
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/292464/giay-bong-ro-puma-unisex-puma-rebound-374765-19-2.jpg"));
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/292464/giay-bong-ro-puma-unisex-puma-rebound-374765-19-3.jpg"));
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/292464/giay-bong-ro-puma-unisex-puma-rebound-374765-19-4.jpg"));
//					
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/292473/giay-chay-bo-puma-unisex-x-ray-384639-11-1.jpg"));
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/292473/giay-chay-bo-puma-unisex-x-ray-384639-11-2.jpg"));
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/292473/giay-chay-bo-puma-unisex-x-ray-384639-11-3.jpg"));
//					imagePuma.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/292473/giay-chay-bo-puma-unisex-x-ray-384639-11-5.jpg"));
//					
//					///////
//					List<Images> imageNike= new ArrayList<>();
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/276778/nike-court-legacy-cnvs-cw6539-100-trang-1.jpg"));
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/276778/nike-court-legacy-cnvs-cw6539-100-trang-2.jpg"));
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/276778/nike-court-legacy-cnvs-cw6539-100-trang-3.jpg"));
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/276778/nike-court-legacy-cnvs-cw6539-100-trang-4.jpg"));
//					
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/284964/nike-defyallday-dj1196-101-1.jpg"));
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/284964/nike-defyallday-dj1196-101-2.jpg"));
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/284964/nike-defyallday-dj1196-101-3.jpg"));
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/284964/nike-defyallday-dj1196-101-4.jpg"));
//					
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/299122/giay-chay-bo-nam-nike-downshifter-12-dd9293-101-1.jpg"));
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/299122/giay-chay-bo-nam-nike-downshifter-12-dd9293-101-2.jpg"));
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/299122/giay-chay-bo-nam-nike-downshifter-12-dd9293-101-3.jpg"));
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/299122/giay-chay-bo-nam-nike-downshifter-12-dd9293-101-4.jpg"));
//					
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/284975/giay-lifestyle-nam-nike-blazer-low-77-se-nn-dm0210-mau-be-1.jpg"));
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/284975/giay-lifestyle-nam-nike-blazer-low-77-se-nn-dm0210-mau-be-2.jpg"));
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/284975/giay-lifestyle-nam-nike-blazer-low-77-se-nn-dm0210-mau-be-3.jpg"));
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/284975/giay-lifestyle-nam-nike-blazer-low-77-se-nn-dm0210-mau-be-4.jpg"));
//					
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/295241/giay-lifestyle-nam-nike-air-max-97-dm0027-001-1.jpg"));
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/295241/giay-lifestyle-nam-nike-air-max-97-dm0027-001-2.jpg"));
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/295241/giay-lifestyle-nam-nike-air-max-97-dm0027-001-3.jpg"));
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/295241/giay-lifestyle-nam-nike-air-max-97-dm0027-001-4.jpg"));
//					
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/299137/giay-lifestyle-nam-nike-blazer-mid-pro-club-dq7673-100-1.jpg"));
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/299137/giay-lifestyle-nam-nike-blazer-mid-pro-club-dq7673-100-2.jpg"));
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/299137/giay-lifestyle-nam-nike-blazer-mid-pro-club-dq7673-100-3.jpg"));
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/299137/giay-lifestyle-nam-nike-blazer-mid-pro-club-dq7673-100-4.jpg"));
//					
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/299136/giay-lifestyle-nam-nike-blazer-mid-pro-club-dq7673-001-1.jpg"));
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/299136/giay-lifestyle-nam-nike-blazer-mid-pro-club-dq7673-001-2.jpg"));
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/299136/giay-lifestyle-nam-nike-blazer-mid-pro-club-dq7673-001-3.jpg"));
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/299136/giay-lifestyle-nam-nike-blazer-mid-pro-club-dq7673-001-4.jpg"));
//					
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/299125/giay-chay-bo-nam-nike-air-zoom-pegasus-39-dh4071-102-1.jpg"));
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/299125/giay-chay-bo-nam-nike-air-zoom-pegasus-39-dh4071-102-2.jpg"));
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/299125/giay-chay-bo-nam-nike-air-zoom-pegasus-39-dh4071-102-3.jpg"));
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/299125/giay-chay-bo-nam-nike-air-zoom-pegasus-39-dh4071-102-4.jpg"));
//					
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/295272/giay-bong-ro-nam-nike-m-metcon-8-flyease-do9388-300-1.jpg"));
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/295272/giay-bong-ro-nam-nike-m-metcon-8-flyease-do9388-300-2.jpg"));
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/295272/giay-bong-ro-nam-nike-m-metcon-8-flyease-do9388-300-3.jpg"));
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/295272/giay-bong-ro-nam-nike-m-metcon-8-flyease-do9388-300-4.jpg"));
//					
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/299133/giay-lifestyle-nam-nike-air-max-90-dq4071-100-1.jpg"));
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/299133/giay-lifestyle-nam-nike-air-max-90-dq4071-100-2.jpg"));
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/299133/giay-lifestyle-nam-nike-air-max-90-dq4071-100-3.jpg"));
//					imageNike.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/299133/giay-lifestyle-nam-nike-air-max-90-dq4071-100-4.jpg"));
//					
//					///////////
//					List<Images> imageReebok= new ArrayList<>();
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/288413/reebok-club-c-revenge-vintage-fw4862-1.jpg"));
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/288413/reebok-club-c-revenge-vintage-fw4862-2.jpg"));
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/288413/reebok-club-c-revenge-vintage-fw4862-3.jpg"));
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/288413/reebok-club-c-revenge-vintage-fw4862-4.jpg"));
//					
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/288415/reebok-cl-legacy-az-gy1552-1.jpg"));
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/288415/reebok-cl-legacy-az-gy1552-2.jpg"));
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/288415/reebok-cl-legacy-az-gy1552-3.jpg"));
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/288415/reebok-cl-legacy-az-gy1552-4.jpg"));
//					
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/276605/reebok-hiit-tr-20-gw8519-den-do-1.jpg"));
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/276605/reebok-hiit-tr-20-gw8519-den-do-2.jpg"));
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/276605/reebok-hiit-tr-20-gw8519-den-do-3.jpg"));
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/276605/reebok-hiit-tr-20-gw8519-den-do-3.jpg"));
//					
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/276646/giay-tennis-nam-reebok-club-c-85-gz3656-m-1.jpg"));
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/276646/giay-tennis-nam-reebok-club-c-85-gz3656-m-2.jpg"));
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/276646/giay-tennis-nam-reebok-club-c-85-gz3656-m-3.jpg"));
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/276646/giay-tennis-nam-reebok-club-c-85-gz3656-m-1.jpg"));
//					
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/276610/giay-tennis-nam-reebok-royal-techque-t-ce-gx3514-m-1.jpg"));
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/276610/giay-tennis-nam-reebok-royal-techque-t-ce-gx3514-m-2.jpg"));
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/276610/giay-tennis-nam-reebok-royal-techque-t-ce-gx3514-m-3.jpg"));
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/276610/giay-tennis-nam-reebok-royal-techque-t-ce-gx3514-m-4.jpg"));
//					
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/276594/reebok-club-c-revenge-mu-eg9270-trang-den-1.jpg"));
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/276594/reebok-club-c-revenge-mu-eg9270-trang-den-2.jpg"));
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/276594/reebok-club-c-revenge-mu-eg9270-trang-den-3.jpg"));
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/276594/reebok-club-c-revenge-mu-eg9270-trang-den-4.jpg"));
//					
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/276603/reebok-turbo-restyle-gw7830-trang-do-1.jpg"));
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/276603/reebok-turbo-restyle-gw7830-trang-do-2.jpg"));
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/276603/reebok-turbo-restyle-gw7830-trang-do-3.jpg"));
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/276603/reebok-turbo-restyle-gw7830-trang-do-4.jpg"));
//					
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/288429/giay-tennis-nam-reebok-club-c-revenge-gx1702-1.jpg"));
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/288429/giay-tennis-nam-reebok-club-c-revenge-gx1702-2.jpg"));
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/288429/giay-tennis-nam-reebok-club-c-revenge-gx1702-3.jpg"));
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/288429/giay-tennis-nam-reebok-club-c-revenge-gx1702-4.jpg"));
//					
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/288414/giay-chay-bo-unisex-reebok-cl-legacy-az-gx9346-1.jpg"));
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/288414/giay-chay-bo-unisex-reebok-cl-legacy-az-gx9346-2.jpg"));
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/288414/giay-chay-bo-unisex-reebok-cl-legacy-az-gx9346-3.jpg"));
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/288414/giay-chay-bo-unisex-reebok-cl-legacy-az-gx9346-4.jpg"));
//					
//					
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/276578/reebok-royal-techque-t-gv7412-trang-xanh-1.jpg"));
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/276578/reebok-royal-techque-t-gv7412-trang-xanh-2.jpg"));
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/276578/reebok-royal-techque-t-gv7412-trang-xanh-3.jpg"));
//					imageReebok.add(new Images("https://cdn.tgdd.vn/Products/Images/9980/276578/reebok-royal-techque-t-gv7412-trang-xanh-4.jpg"));	
//				
//					//set image to product and vice versa
//					int x =0;
//					for(Products product: productadidas) {
//						product.setDate(LocalDate.of(2012, 8, 2));
//						productRepo.save(product);
//						for(int i=x;i<imageAdidas.size();i++) {
//							imageAdidas.get(i).setProduct(product);
//							imageRepo.save(imageAdidas.get(i));
//							if(( i ==( imageAdidas.size()-1))){
//								x = 0;
//								break;
//							}
//							if(i == (x + 4)) {
//								x = x+ 4;
//								break;
//							}
//						}
//					}
//					for(Products product: productPuma) {
//						product.setDate(LocalDate.of(2013, 8, 2));
//						productRepo.save(product);
//						for(int i=x;i<imagePuma.size();i++) {
//							imagePuma.get(i).setProduct(product);
//							imageRepo.save(imagePuma.get(i));
//							if( i==(imagePuma.size()-1)){
//								x = 0;
//								break;
//							}
//							if(i == (x + 4)) {
//								x = x+ 4;
//								break;
//							}
//						}
//					}
//					for(Products product: productnike) {
//						product.setDate(LocalDate.of(2019, 8, 2));
//						productRepo.save(product);
//						for(int i=x;i<imageNike.size();i++) {
//							imageNike.get(i).setProduct(product);
//							imageRepo.save(imageNike.get(i));
//							if( i== (imageNike.size()-1)){
//								x = 0;
//								break;
//							}
//							if(i == (x + 4)) {
//								x = x+ 4;
//								break;
//							}
//						}
//					}
//					
//					for(Products product: productreebok) {
//						product.setDate(LocalDate.of(2022, 8, 2));
//						productRepo.save(product);
//						for(int i=x;i<imageReebok.size();i++) {
//							imageReebok.get(i).setProduct(product);
//							imageRepo.save(imageReebok.get(i));
//							if( i== (imageReebok.size()-1)){
//								x = 0;
//								break;
//							}
//							if(i == (x + 4)) {
//								x = x+ 4;
//								break;
//							}
//						}
//					}
//					
//					//set productsize
//					for(Products product: productadidas) {
//						for(int i=0;i<sizes.size();i++) {
//							ProductSize productsize=new ProductSize();
//							productsize.setProduct(product);
//							productsize.setSize(sizes.get(i));
//							productSizeRepo.save(productsize);
//						}
//					}
//					
//					for(Products product: productnike) {
//						for(int i=0;i<sizes.size();i++) {
//						ProductSize productsize=new ProductSize();
//						productsize.setProduct(product);
//						productsize.setSize(sizes.get(i));
//						productSizeRepo.save(productsize);
//					}
//					}
//					
//					for(Products product: productPuma) {
//						for(int i=0;i<sizes.size();i++) {
//						ProductSize productsize=new ProductSize();
//						productsize.setProduct(product);
//						productsize.setSize(sizes.get(i));
//						productSizeRepo.save(productsize);
//						}
//					}
//					
//					for(Products product: productreebok) {
//						for(int i=0;i<sizes.size();i++) {
//						ProductSize productsize=new ProductSize();
//						productsize.setProduct(product);
//							productsize.setSize(sizes.get(i));
//						productSizeRepo.save(productsize);
//						}
//					}
//			};
//		}
}