package ca.mcgill.ecse321.Parking_Lot.dao;
import org.springframework.data.repository.CrudRepository;
import ca.mcgill.ecse321.Parking_Lot.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, String>{

	Employee findEmployeeByName(String name);

}
