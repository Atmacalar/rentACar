package kodlamanew.io.rentACar.business.Concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import kodlamanew.io.rentACar.business.Abstract.ModelService;
import kodlamanew.io.rentACar.business.requests.CreateModelsRequest;
import kodlamanew.io.rentACar.business.requests.UpdateModelsRequest;
import kodlamanew.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlamanew.io.rentACar.business.responses.GetAllModelsResponse;
import kodlamanew.io.rentACar.business.responses.GetByIdBrandResponse;
import kodlamanew.io.rentACar.business.responses.GetByIdModelResponse;
import kodlamanew.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlamanew.io.rentACar.dataAcces.Abstract.IModelRepository;
import kodlamanew.io.rentACar.entities.concretes.Brand;
import kodlamanew.io.rentACar.entities.concretes.Models;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

	private IModelRepository modelrepo;
	private ModelMapperService modelMaperService;
	
	@Override
	public List<GetAllModelsResponse> getAll() {

		List<Models> models =modelrepo.findAll(); 
		
		List<GetAllModelsResponse>modelsResponse = models.stream().
				map(model-> this.modelMaperService.forkresponse().
						map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
		
		
		
		return modelsResponse;
	}

	@Override
	public void add(CreateModelsRequest createbrandrequest) {
		Models model= this.modelMaperService.forkrequest().map(createbrandrequest, Models.class);		
		
		this.modelrepo.save(model);
		
	}

	@Override
	public void update(UpdateModelsRequest updateBrandRequest) {
Models model= this.modelMaperService.forkrequest().map(updateBrandRequest, Models.class);		
		
		this.modelrepo.save(model);;
		
		
	}

	@Override
	public void delete(int id) {
		this.modelrepo.deleteById(id);
		
	}

	@Override
	public GetByIdModelResponse getById(int id) {
	
		Models model= this.modelrepo.findById(id).orElseThrow();
		
	GetByIdModelResponse response =this.modelMaperService.forkresponse().map(model, GetByIdModelResponse.class);
	return response;
	}
 
}
