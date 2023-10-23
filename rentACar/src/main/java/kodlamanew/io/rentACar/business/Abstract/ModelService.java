package kodlamanew.io.rentACar.business.Abstract;

import java.util.List;

import kodlamanew.io.rentACar.business.requests.CreateBrandRequest;
import kodlamanew.io.rentACar.business.requests.CreateModelsRequest;
import kodlamanew.io.rentACar.business.requests.UpdateBrandRequest;
import kodlamanew.io.rentACar.business.requests.UpdateModelsRequest;
import kodlamanew.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlamanew.io.rentACar.business.responses.GetAllModelsResponse;
import kodlamanew.io.rentACar.business.responses.GetByIdBrandResponse;
import kodlamanew.io.rentACar.business.responses.GetByIdModelResponse;

public interface ModelService {

	
	List<GetAllModelsResponse> getAll(); 
	void add(CreateModelsRequest createbrandrequest); // kısaca bana name ver
	void update(UpdateModelsRequest updateBrandRequest);
	void delete(int id);
	GetByIdModelResponse getById(int id);
}
