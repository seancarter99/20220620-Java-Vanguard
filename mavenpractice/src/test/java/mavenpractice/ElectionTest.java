package mavenpractice;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import mavenpractice.com.skillstorm.Ballot;
import mavenpractice.com.skillstorm.Candidate;
import mavenpractice.com.skillstorm.Election;

public class ElectionTest {
	
	Candidate c1;
	Candidate c2;
	Candidate c3;
	
	@Before
	public void beforeEach() {
		c1 = new Candidate("John", "Democratic");
		c2 = new Candidate("Sally", "Republican");
		c3 = new Candidate("Craig", "Independent");
	}

	@Test
	public void createElectionWithNullCandidates() {
		assertThrows(IllegalArgumentException.class, () -> {
			Election e = new Election(null, new LinkedList<>());
		});
	}
	
	@Test
	public void createElectionWithNullBallots() {
		assertThrows(IllegalArgumentException.class, () -> {
			Election e = new Election(new LinkedList<>(), null);
		});
	}

	@Test
	public void runStandardElection() {
		LinkedList<Candidate> candidates = new LinkedList<>(Arrays.asList(c1, c2, c3));
		LinkedList<Ballot> ballots = new LinkedList<>(Arrays.asList(
				new Ballot(c1),
				new Ballot(c2),
				new Ballot(c1)
			));
		Election e = new Election(candidates, ballots);
		e.tallyVotes();
		assertEquals(c1.getNumVotes(), 6);
		assertEquals(c2.getNumVotes(), 3);
	}
}
