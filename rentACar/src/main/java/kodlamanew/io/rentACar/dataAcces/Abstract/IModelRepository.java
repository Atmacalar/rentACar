package kodlamanew.io.rentACar.dataAcces.Abstract;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamanew.io.rentACar.entities.concretes.Models;

public interface IModelRepository extends JpaRepository<Models, Integer> {

}
