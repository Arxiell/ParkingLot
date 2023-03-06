package ca.mcgill.ecse321.Parking_Lot.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.Parking_Lot.model.User;

public interface UserRepository extends CrudRepository<User, String>{

	User findUserByName(String name);

}

