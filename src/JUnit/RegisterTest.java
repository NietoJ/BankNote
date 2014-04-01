package JUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.example.banknote.model.LoginHandler;
import com.example.banknote.model.RegisterHandler;

public class RegisterTest {

	@Test
	public void loginAdmin() {
		String user = "admin";
		String pass = "pass123";
		assertTrue(LoginHandler.attemptLogin(user, pass));
	}

	@Test
	public void registerNew1() {
		System.out.println(RegisterHandler.store("bob", "waters"));
		assertTrue(LoginHandler.attemptLogin("admin", "pass123"));
		assertTrue(LoginHandler.attemptLogin("bob", "waters"));
		assertFalse(RegisterHandler.store("bob", "waters"));
		System.out.println(RegisterHandler.store("bob", "waters"));
	}
	
	@Test
	public void registerNull() {
		System.out.println(RegisterHandler.store(null, null));
		assertTrue(LoginHandler.attemptLogin("admin", "pass123"));
		assertFalse(LoginHandler.attemptLogin("bob", "waters"));
		assertTrue(RegisterHandler.store("bob", "waters"));
		assertFalse(RegisterHandler.store("bob", "waters"));
	}
}
