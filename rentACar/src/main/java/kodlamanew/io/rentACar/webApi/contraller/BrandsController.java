package kodlamanew.io.rentACar.webApi.contraller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamanew.io.rentACar.business.Abstract.BrandService;
import kodlamanew.io.rentACar.business.requests.CreateBrandRequest;
import kodlamanew.io.rentACar.business.requests.UpdateBrandRequest;
import kodlamanew.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlamanew.io.rentACar.business.responses.GetByIdBrandResponse;
import kodlamanew.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/brands") //kullanıcı conrollere ulaşması için yazması gereken adres
@AllArgsConstructor
public class BrandsController {
	
	
	//dataacess business içinde kullanıldı, business da api içinde kullanılıcak(katmanlı mimari)
	
	private BrandService brandservice;

	
	@Autowired  //brandservice yi kim implements etmişse bana onu new le
	public BrandsController(BrandService brandservice) {
		
		this.brandservice = brandservice;
	}
	
	
	@GetMapping() // controllerın çalıştıracağı metod 
	public List<GetAllBrandsResponse> getAll(){
		return brandservice.getAll();
		
		
	}

	
	@GetMapping("/{id}")
	public GetByIdBrandResponse getById(@PathVariable id){ //git adres çubuğundaki path'ten oku
		return brandservice.getAll();
		
		
	}
	
	@PostMapping()
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(CreateBrandRequest createBrandRequest)
	{
		this.brandservice.add(createBrandRequest);
		
	}
	
	@PutMapping
	public void update(@RequestBody UpdateBrandRequest updateBrandRequest){
		
		this.brandservice.update(updateBrandRequest);
	}
	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		
		this.brandservice.delete(id);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
