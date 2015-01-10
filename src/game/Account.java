package game;

public class Account {
	private int balance;

	// Object that stores the score of the two players
	public Account() {
		balance = 1500;
	}

	// Public get method to get the score of chosen player
	public int getScore() {
		return balance;
	}

	// Public set Points
	public void setPoints(int points) {
		this.balance = points;
	}	
	// Public method to add points to chosen player
	public boolean addPoints(double d) {

		if (balance + d >= 0) {
			balance += d;
			return true;
		} else {
			balance = 0;
			return false;
		}
	}
	public void subtractPoints(int d) {
		balance = balance - d;
	}
}
