package ca.mcgill.ecse321.Parking_Lot.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ca.mcgill.ecse321.Parking_Lot.model.Client;


@SpringBootTest
public class ClientRepositoryTests {

	@Autowired
	private ClientRepository clientRepository;

	@AfterEach
	public void clearDatabase() {
		clientRepository.deleteAll();
	}

	@Test
	public void testPersistAndLoadClient() {
		// Create object
		String name = "Anakin Skywalker";
		Client anakin = new Client("Alex1", "123", "alex", 12,true);
		anakin.setUsername(name);

		// Save object
		anakin = clientRepository.save(anakin);
		String username = anakin.getUsername();

		// Read object from database
		anakin = clientRepository.findClientByName(username);

		// Assert that object has correct attributes
		assertNotNull(anakin);
		assertEquals(name, anakin.getUsername());
	}
}
