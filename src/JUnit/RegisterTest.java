package JUnit;

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
		RegisterHandler.store("bob", "waters");
		assertTrue(LoginHandler.attemptLogin("admin", "pass123"));
		assertTrue(LoginHandler.attemptLogin("bob", "waters"));
	}
}
