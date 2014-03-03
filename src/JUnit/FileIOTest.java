package JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.banknote.model.FileIO;

public class FileIOTest {

	@Test
	public void test() {
		FileIO.addCred("admin");
		assertEquals("admin", FileIO.getCred().trim());
	}

	String getSearchName()
	{
		return "";
	}

}
