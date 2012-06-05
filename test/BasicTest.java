import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

<<<<<<< HEAD
    @Test
    public void aVeryImportantThingToTest() {
        assertEquals(2, 1 + 1);
    }
=======
	public void createAndRetrieveUser() {
	    // Create a new user and save it
	 //   new User("bob@gmail.com", "secret", "Bob").save();
	    
	    // Retrieve the user with e-mail address bob@gmail.com
	    User bob = User.find("byEmail", "bob@gmail.com").first();
	    
	    // Test 
	  //  assertNotNull(bob);
	  //  assertEquals("Bob", bob.name);
	}
>>>>>>> 940948ffd861546e7a0f7407eecadb091be2972a

}
