package kodlamanew.io.rentACar.core.utilities.mappers;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {

	ModelMapper forkresponse();  //response'lar için mapper üreten 
	ModelMapper forkrequest();   //requestler için mapper üreten 
	                              // iki ayrı metot oluşturmak istiyorum
	
	
	
	// bu interface mapperlar için strateji yazılması amacıyla kullanılır.
}
