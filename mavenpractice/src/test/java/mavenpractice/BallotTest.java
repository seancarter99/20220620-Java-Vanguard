package mavenpractice;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import mavenpractice.com.skillstorm.Ballot;
import mavenpractice.com.skillstorm.Candidate;

public class BallotTest {
	
	Candidate c1;
	Candidate c2;
	Candidate c3;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		c1 = new Candidate("John", "Democratic");
		c2 = new Candidate("Sally", "Republican");
		c3 = new Candidate("Craig", "Independent");
	}

	@After
	public void tearDown() throws Exception {
	}

	// Ballot is going have a candidate attached
	// If the first pick candidate is null, throw an exception
	// If the first pick is present, but the other two are empty, that's fine
	
	// 1 John - 3 votes
	// 2 Sally - 2 votes
	// 3 Drew - 1 vote
	
	@Test
	public void createBallotWithNoFirstPick() {
		assertThrows(IllegalArgumentException.class, () -> {
			Ballot b = new Ballot(null);
		});
	}
	
	@Test
	public void createBallotWithOnlyFirstPick() {
		try {
			Ballot b1 = new Ballot(c3, null);
			Ballot b2 = new Ballot(c3, null, null);
		} catch (IllegalArgumentException e) {
			fail("Should be allowed to create ballot with no second/third pick");
		}
	}

}
