package kodlamanew.io.rentACar.business.Abstract;

import java.util.List;

import kodlamanew.io.rentACar.business.requests.CreateBrandRequest;
import kodlamanew.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlamanew.io.rentACar.entities.concretes.Brand;

public interface BrandService {

	List<GetAllBrandsResponse> getAll(); 
	void add(CreateBrandRequest createbrandrequest); // kısaca bana name ver
	
}
