package kodlamanew.io.rentACar.webApi.contraller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamanew.io.rentACar.business.Abstract.BrandService;
import kodlamanew.io.rentACar.business.requests.CreateBrandRequest;
import kodlamanew.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlamanew.io.rentACar.entities.concretes.Brand;

@RestController
@RequestMapping("/api/brands") //kullanıcı conrollere ulaşması için yazması gereken adres
public class BrandsController {
	
	
	//dataacess business içinde kullanıldı, business da api içinde kullanılıcak(katmanlı mimari)
	
	private BrandService brandservice;

	
	@Autowired  //brandservice yi kim implements etmişse bana onu new le
	public BrandsController(BrandService brandservice) {
		super();
		this.brandservice = brandservice;
	}
	
	
	@GetMapping("/getAll") // controllerın çalıştıracağı metod 
	                       // (bu businessa, business dataccesse ordan db ye)
	public List<GetAllBrandsResponse> getAll(){
		return brandservice.getAll();
		
		
	}
	
	@PostMapping("/add")
	public void add(CreateBrandRequest createBrandRequest)
	{
		this.brandservice.add(createBrandRequest);
		
	}

}
