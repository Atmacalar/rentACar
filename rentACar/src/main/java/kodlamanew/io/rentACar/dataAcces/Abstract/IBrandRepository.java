package kodlamanew.io.rentACar.dataAcces.Abstract;

import java.util.List;



import kodlamanew.io.rentACar.entities.concretes.Brand;


public interface IBrandRepository {

	List<Brand> getAll();

}
