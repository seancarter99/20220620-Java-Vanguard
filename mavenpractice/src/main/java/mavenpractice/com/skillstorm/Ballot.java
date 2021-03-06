package mavenpractice.com.skillstorm;

public class Ballot {

	private Candidate firstPick;
	private Candidate secondPick;
	private Candidate thirdPick;

	public Ballot(Candidate firstPick) {
		this(firstPick, null, null);
	}

	public Ballot(Candidate firstPick, Candidate secondPick) {
		this(firstPick, secondPick, null);
	}

	public Ballot(Candidate firstPick, Candidate secondPick, Candidate thirdPick) {
		setFirstPick(firstPick);
		setSecondPick(secondPick);
		setThirdPick(thirdPick);
	}

	public Candidate getFirstPick() {
		return firstPick;
	}

	public void setFirstPick(Candidate firstPick) {
		if (firstPick == null) {
			throw new IllegalArgumentException("First Pick cannot be null");
		}
		this.firstPick = firstPick;
	}

	public Candidate getSecondPick() {
		return secondPick;
	}

	public void setSecondPick(Candidate secondPick) {
		this.secondPick = secondPick;
	}

	public Candidate getThirdPick() {
		return thirdPick;
	}

	public void setThirdPick(Candidate thirdPick) {
		this.thirdPick = thirdPick;
	}
	
	
}
