package ca.mcgill.ecse321.Parking_Lot.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ca.mcgill.ecse321.Parking_Lot.model.Owner;


@SpringBootTest
public class OwnerRepositoryTests {

	@Autowired
	private OwnerRepository ownerRepository;

	@AfterEach
	public void clearDatabase() {
		ownerRepository.deleteAll();
	}

	@Test
	public void testPersistAndLoadOwner() {
		// Create object
		String name = "Anakin Skywalker";
		Owner anakin = new Owner("Alex1", "123", "alex", 12);
		anakin.setUsername(name);

		// Save object
		anakin = ownerRepository.save(anakin);
		String username = anakin.getUsername();

		// Read object from database
		anakin = ownerRepository.findOwnerByName(username);

		// Assert that object has correct attributes
		assertNotNull(anakin);
		assertEquals(name, anakin.getUsername());
	}
}
