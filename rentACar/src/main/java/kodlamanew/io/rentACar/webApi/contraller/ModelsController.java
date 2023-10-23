package kodlamanew.io.rentACar.webApi.contraller;

import java.util.List;

import javax.validation.Valid;

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

import kodlamanew.io.rentACar.business.Abstract.ModelService;
import kodlamanew.io.rentACar.business.requests.CreateBrandRequest;
import kodlamanew.io.rentACar.business.requests.CreateModelsRequest;
import kodlamanew.io.rentACar.business.requests.UpdateBrandRequest;
import kodlamanew.io.rentACar.business.requests.UpdateModelsRequest;
import kodlamanew.io.rentACar.business.responses.GetAllModelsResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/models") 
@AllArgsConstructor
public class ModelsController {
	
	private ModelService modelService;
	
	
	@GetMapping
	public List<GetAllModelsResponse> getAll(){
		
		return modelService.getAll();
	}

	@PostMapping()
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add (@RequestBody() @Valid CreateModelsRequest createModelsRequest)
	{
		this.modelService.add(createModelsRequest);
		
	}
	
	@PutMapping
	public void update(@RequestBody UpdateModelsRequest updateModelsRequest){
		
		this.modelService.update(updateModelsRequest);
	}
	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		
		this.modelService.delete(id);
		
	}

	
	
	
}
