package kodlamanew.io.rentACar.business.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateModelsRequest {

	
	@NotNull
	@NotBlank
	@Size(min=3, max=10)
	private String name;
	
	@NotNull
	@NotBlank
	private int brandId;
	
}
