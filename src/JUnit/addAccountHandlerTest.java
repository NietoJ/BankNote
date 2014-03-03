package JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.banknote.model.addAccountHandler;

public class addAccountHandlerTest {

	
	
	@Test
	public void testIsValidName() 
	{
		addAccountHandler.setup();
		assertFalse(addAccountHandler.isValidName(""));
	}

	@Test
	public void testNameAlreadyExists() {
		addAccountHandler.setup();
		assertFalse(addAccountHandler.nameAlreadyExists("",""));
		addAccountHandler.addAccount("peter", "pete", "1", "1");
		assertTrue(addAccountHandler.nameAlreadyExists("peter","pete"));
		
	}

	@Test
	public void testIsValidInterestRate() 
	{
		addAccountHandler.setup();
		assertTrue(addAccountHandler.isValidInterestRate("2.0"));
		assertFalse(addAccountHandler.isValidInterestRate("-2.1"));
		assertTrue(addAccountHandler.isValidInterestRate(""));
		

	}

	@Test
	public void testAddAccount() 
	{
		addAccountHandler.setup();
		addAccountHandler.addAccount("bob", "b", "1.1", "2.2");
		addAccountHandler.addAccount("bob", "b", "", "");
	}

}
