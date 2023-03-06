package ca.mcgill.ecse321.Parking_Lot.dao;
import org.springframework.data.repository.CrudRepository;
import ca.mcgill.ecse321.Parking_Lot.model.Client;

public interface ClientRepository extends CrudRepository<Client, String>{

	Client findClientByName(String name);

}