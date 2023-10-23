package kodlamanew.io.rentACar.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cars {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="plate" , unique = true)
	private String plate;
	
	
	@Column(name="dailyprice")
	private double dailyprice;
	
	
	@Column(name="year")
	private int year;
	
	@Column(name="state")
	private int state;
	
	@ManyToOne
	@JoinColumn(name="model_id")
	private Models model;
	
}
