package kodlamanew.io.rentACar.core.utilities.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
 
@Service              // ioc'ta tekrar üretilmesini istemiyorum
@AllArgsConstructor   // injection yapacağım
public class ModelMapperManager implements ModelMapperService {
	
	private ModelMapper  modelMapper;

	@Override
	public ModelMapper forkresponse() {
		
		this.modelMapper.getConfiguration()
		.setAmbiguityIgnored(true)
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		
		
		return this.modelMapper;
	}

	@Override
	public ModelMapper forkrequest() {
		this.modelMapper.getConfiguration()
		.setAmbiguityIgnored(true)
		.setMatchingStrategy(MatchingStrategies.STANDARD);
		
		
		return this.modelMapper;
	}

}
