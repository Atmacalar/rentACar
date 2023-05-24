package kodlamanew.io.rentACar.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateBrandRequest {

	private String name;
	
}


//Kullanıcıdan birşey alıyorsam request, kullanıcıya birşey veriyorsam response
// mesela kullanıcıya veri eklemesi için id yi vermiyorum sadece name'i veriyorum'