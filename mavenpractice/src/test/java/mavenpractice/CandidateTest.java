package mavenpractice;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import mavenpractice.com.skillstorm.Candidate;

public class CandidateTest {
	
	Candidate c1;
	
	@BeforeClass
	public static void beforeAll() {
		System.out.println("I run once, before ALL tests");
		// Connect to a test database here
	}
	
	@Before // Runs before each and every test
	public void refreshCandidates() {
		c1 = new Candidate("John", "Cheese", 0);
	}
	
	@After
	public void afterEach() {
		// Very good for inspecting the results. Could do logging here
		System.out.println("I run after each and every test");
	}
	
	@AfterClass
	public static void afterAll() {
		// Sever test database connection here
	}

	@Test // JUnit will run any function in the class annotated with @Test
	@Ignore // This test will now be ignored
	public void test() {
		// If there are ANY failed tests, the build will not pass the test phase
		fail("Not yet implemented");
	}
	
	@Test
	public void createNormalCandidate() {
		
	}
	
	@Test
	public void createCandidateWithNegativeVotes() {
		// Ensure that I cannot do this
//		try {
//			Candidate c = new Candidate("John", "Cheese", -1);
//			fail("Should fail");
//		} catch (IllegalArgumentException e) {
//			
//		}
		assertThrows(IllegalArgumentException.class, () -> {
			Candidate c = new Candidate("John", "Cheese", -1);
			// This block of code should throw an IllegalArgumentException
		});
	}
	
	@Test
	public void preventsVoteCountOverflow() {
		Candidate c = new Candidate("John", "Cheese", Integer.MAX_VALUE);
		c.addVote();
		assertEquals(c.getNumVotes(), Integer.MAX_VALUE); // Passes if equal
	}
	
	@Test
	public void addNegativeVotes() {
		Candidate c = new Candidate("John", "Cheese", Integer.MAX_VALUE);	
		assertThrows(IllegalArgumentException.class, () -> {
			c.addVote(-1);
		});
	}
	
	@Test
	public void preventsVoteCountOverflowWithMultipleVotes() {
		Candidate c = new Candidate("John", "Cheese", Integer.MAX_VALUE - 1);	
		c.addVote(5);
		assertEquals(c.getNumVotes(), Integer.MAX_VALUE); // Passes if equal
	}

}
