package kodlamanew.io.rentACar.business.Concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamanew.io.rentACar.business.Abstract.BrandService;
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
	public List<Brand> getAll() {
		// iş kuralları 
		return brandrepository.getAll();
	}

}
 