package ca.mcgill.ecse321.Parking_Lot.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ca.mcgill.ecse321.Parking_Lot.model.Employee;
import ca.mcgill.ecse321.Parking_Lot.model.Owner;


@SpringBootTest
public class EmployeeRepositoryTests {

	@Autowired
	private EmployeeRepository employeeRepository;

	@AfterEach
	public void clearDatabase() {
		employeeRepository.deleteAll();
	}

	@Test
	public void testPersistAndLoadEmployee() {
		// Create object
		String name = "Anakin Skywalker";
        Owner alex = new Owner("Alex1", "123", "alex", 12);
		Employee anakin = new Employee("Alex1", "123", "alex", 890, "cashier", 15, alex);
		anakin.setUsername(name);

		// Save object
		anakin = employeeRepository.save(anakin);
		String username = anakin.getUsername();

		// Read object from database
		anakin = employeeRepository.findEmployeeByName(username);

		// Assert that object has correct attributes
		assertNotNull(anakin);
		assertEquals(name, anakin.getUsername());
	}

    @Test
    public void testPersistAndLoadEmployeeViaOwner(){
        // Create object
		String name = "Anakin Skywalker";
        Owner alex = new Owner("Alex1", "123", "alex", 12);
		Employee anakin = new Employee("Alex1", "123", "alex", 890, "cashier", 15, alex);
		anakin.setUsername(name);

    }
}

