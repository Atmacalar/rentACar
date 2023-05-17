package kodlamanew.io.rentACar.dataAcces.Concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlamanew.io.rentACar.dataAcces.Abstract.IBrandRepository;
import kodlamanew.io.rentACar.entities.concretes.Brand;


@Repository  //  bu sınıf dataacces nesnesidir diyoruz springe
public class inMemoryBrandRepository implements IBrandRepository{

	List<Brand> brands;
	
	public inMemoryBrandRepository() {
		brands = new ArrayList<Brand>();
	    brands.add(new Brand(1,"BMW"));
	    brands.add(new Brand(2,"MERCEDES"));
	    brands.add(new Brand(3,"AUDİ"));
	    brands.add(new Brand(4,"OPEL"));
	    
	
		
	}
	
	
	@Override
	public List<Brand> getAll() {
		// TODO Auto-generated method stub
		return brands;
	}

}
