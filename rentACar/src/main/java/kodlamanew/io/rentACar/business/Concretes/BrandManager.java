package kodlamanew.io.rentACar.business.Concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamanew.io.rentACar.business.Abstract.BrandService;
import kodlamanew.io.rentACar.business.requests.CreateBrandRequest;
import kodlamanew.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlamanew.io.rentACar.dataAcces.Abstract.IBrandRepository;
import kodlamanew.io.rentACar.entities.concretes.Brand;

@Service // bu sınıf business nesnesidir diyoruz springe
public class BrandManager implements BrandService {
	
	// business dataaccesisi kulllanır
	
	private IBrandRepository  brandrepository;
	
	
	
	
  @Autowired
	public BrandManager(IBrandRepository brandrepository) {
		super();
		this.brandrepository = brandrepository;
	}





	@Override
	public List<GetAllBrandsResponse> getAll(){
		
		List<Brand> brands = brandrepository.findAll(); //db nesnesi yarattım
		List<GetAllBrandsResponse> brandsResponse = new ArrayList<GetAllBrandsResponse>(); //response türünden liste oluşturdum
		
		for(Brand  brand : brands ) { //db deki verilerimi tek tek geziyorum
			
			GetAllBrandsResponse responseItem = new GetAllBrandsResponse(); //response türünden nesne oluşturdum
			responseItem.setId(brand.getId());                          // göstermek istediğim verileri
			responseItem.setName(brand.getName());                      // eşleştiriyorum    
			
			
			
			brandsResponse.add(responseItem);  //response türünden oluşturduğum listeye response nesnesini atıyorum
			
		}
		
		
		return brandsResponse;
		
	}

 //artık etkileşim yaparken brand'ı(db) değil  request ve response kullanıyorum



	@Override
	public void add(CreateBrandRequest createbrandrequest) {
	Brand brand = new Brand();
	brand.setName(createbrandrequest.getName());
	
	this.brandrepository.save(brand);
		
	}

}
 