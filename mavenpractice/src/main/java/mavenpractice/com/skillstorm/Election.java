package mavenpractice.com.skillstorm;

import java.util.LinkedList;

public class Election {

	/*
	 * Technical Requirements:
	 * - I should be able to calculate the winner of an election
	 * - An election with one candidate should always win regardless of votes
	 * 
	 * Edge Cases:
	 * - If there's a tie, we have a list of winners (two presidents)
	 * - What if two candidates have the same name? (Need equality comparisons)
	 * - No ballots? (Throw an exception)
	 * - No candidates? (Throw an exception)
	 * - Ballots for candidates not in election? (Flag the ballot, put in a flaggedBallot list)
	 */
	
	private LinkedList<Candidate> candidates;
	private LinkedList<Ballot> ballots;
	private LinkedList<Ballot> flaggedBallots = new LinkedList<>();
	private LinkedList<Candidate> winners;
	
	public Election(LinkedList<Candidate> candidates, LinkedList<Ballot> ballots) {
		if (candidates == null || ballots == null) {
			throw new IllegalArgumentException("Candidates/Ballots may be null");
		}
		this.candidates = new LinkedList<>(candidates); // Ensures it's a different object reference
		this.ballots = new LinkedList<>(ballots);
	}
	
	public void tallyVotes() {
		for (Ballot ballot : ballots) {
			// If the candidate put in did not exist
			if (!candidates.contains(ballot.getFirstPick())) {
				flaggedBallots.add(ballot); // flag ballot
			} else {
				ballot.getFirstPick().addVote(3);
			}
		}
	}
	
	public LinkedList<Candidate> getWinners() {
		return this.winners;
	}
}
