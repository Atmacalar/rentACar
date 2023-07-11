package kodlamanew.io.rentACar.business.Concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamanew.io.rentACar.business.Abstract.BrandService;
import kodlamanew.io.rentACar.business.requests.CreateBrandRequest;
import kodlamanew.io.rentACar.business.requests.UpdateBrandRequest;
import kodlamanew.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlamanew.io.rentACar.business.responses.GetByIdBrandResponse;
import kodlamanew.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlamanew.io.rentACar.dataAcces.Abstract.IBrandRepository;
import kodlamanew.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;

@Service // bu sınıf business nesnesidir diyoruz springe
@AllArgsConstructor
public class BrandManager implements BrandService {
	
	
	
	private IBrandRepository  brandrepository;
	private ModelMapperService modelMapperService;
	


	@Override
	public List<GetAllBrandsResponse> getAll(){
		
		List<Brand> brands = brandrepository.findAll(); 
		
		List<GetAllBrandsResponse> brandsResponse = brands.stream().
				map(brand-> this.modelMapperService.forkresponse().
						map(brands, GetAllBrandsResponse.class)).collect(Collectors.toList());
		
		
		
		return brandsResponse;
		
		// brands.stream()                                     LİSTE TÜRLERİNDE KULLANIRIZ
		// map(brand-> this.modelMapperService.forkresponse()  GEZDİĞİN HER BİR BRAND LİSTESİ İÇİN MAP'LEME YAP
		//map(brands, GetAllBrandsResponse.class))             BRAND NESNELERİNİ  RESPONSE ÇEVİR
		//collect(Collectors.toList())                         BUNLARI TOPLA VE LİST TİPİNE ÇEVİR
		
	}

 



	@Override
	public void add(CreateBrandRequest createbrandrequest) {
	
		Brand brand= this.modelMapperService.forkrequest().map(createbrandrequest, Brand.class);		
	
	this.brandrepository.save(brand);
		
	}





	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		
		Brand brand= this.modelMapperService.forkrequest().map(updateBrandRequest, Brand.class);		
		
		this.brandrepository.save(brand);
		
	}





	@Override
	public void delete(int id) {
		
		this.brandrepository.deleteById(id);
		
	}





	@Override
	public GetByIdBrandResponse getById(int id) {
	  
		Brand brand = this.brandrepository.findById(id).orElseThrow();
		
		GetByIdBrandResponse response  = this.modelMapperService.forkresponse().map(brand, GetByIdBrandResponse.class);
		
		return response;
		
		
	}

}
 