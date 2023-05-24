package kodlamanew.io.rentACar.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="brands") // bu benim tablom ve adı brands
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Brand {
	
	@Id   // id değerisin
	@GeneratedValue(strategy = GenerationType.IDENTITY) //id otomatik arttırma
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	
	//burada veritabanınındaki tabloları tasarladım

}

//Brand(db)-->id,name,quantitiy
//GetAllBrandsResponse-->id,name  
//bunları birbiriyle eşleştireceğim kullanıcıya quantity'i göstermek istemiyorum
	
	


