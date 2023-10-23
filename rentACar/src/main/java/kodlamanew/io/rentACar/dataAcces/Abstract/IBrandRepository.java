package kodlamanew.io.rentACar.dataAcces.Abstract;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamanew.io.rentACar.entities.concretes.Brand;


public interface IBrandRepository extends JpaRepository<Brand,Integer> {

	boolean existsByName(String name);  //spring jpa keywords
	
	
	
	
	
	
	
	
	
	

}
