package fields;

import boundary.MatadorGUI;
import game.Account;
import game.Player;


public class Refuge extends Fields {
	
private String Parking;
private int startBonus = 50;
public Account account = new Account();
private MatadorGUI out = new MatadorGUI();
	
	//Object that stores the name and start bonus 
	public Refuge(String Parking) {
		this.Parking = Parking;
		this.account.setPoints(startBonus);
	}
	@Override
	//Gives a bonus to the player 
	public void landOnField(Player player) {
			//Prints the bonus for the player to see
			out.bonusMessage(Parking, account.getScore());
			//Add points to player
			player.account.addPoints(account.getScore());
			//updates balance of player
			out.updateBalance(player);
	}
	@Override
	public String toString() {
		return "Type: Refuge --- Name: " + Parking + " --- Bonus: " + account.getScore() + "\n";
	}
	
	public int getStartBonus() {
		return startBonus;
	}

}
