package ca.mcgill.ecse321.Parking_Lot.dao;
import org.springframework.data.repository.CrudRepository;
import ca.mcgill.ecse321.Parking_Lot.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, String>{

	Owner findOwnerByName(String name);

}

