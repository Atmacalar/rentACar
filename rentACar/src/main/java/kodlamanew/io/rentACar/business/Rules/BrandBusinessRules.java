package kodlamanew.io.rentACar.business.Rules;

import org.springframework.stereotype.Service;

import kodlamanew.io.rentACar.core.utilities.exception.BusinessException;
import kodlamanew.io.rentACar.dataAcces.Abstract.IBrandRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
	
		private IBrandRepository brandRepository;
	
	public void checkIfBrandNameExist(String name) {
	
		if(this.brandRepository.existsByName(name)) {
			
			throw new BusinessException("Brand already exists");
		}
		
	}

}
