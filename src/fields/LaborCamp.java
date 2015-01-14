package fields;

import game.Dice;
import game.Player;
import boundary.MatadorGUI;

public class LaborCamp extends Ownable {

	private int rent;
	private Dice dice;
	private MatadorGUI gui = new MatadorGUI();

	public LaborCamp(String name,int price, int rent, Dice dice) {
		super(price, name);
		this.rent = rent;
		this.dice = dice;
	}

	
	public void checkFieldOwnedByAnotherPlayer(Player player) {
		// if the field is owned by another player, a rent have to be paid
		if (getOwner() != player && getOwner() != null) {
			int fullRent = rent * dice.getSum() * getOwner().getLaborCamp();
			if (player.account.getScore() >= fullRent) {
				gui.fieldTax(super.getName(), getOwner().getName(), fullRent);				
				getOwner().account.addPoints(fullRent);
				player.account.subtractPoints(fullRent);
				gui.updateBalance(player);
			}
			// the player looses if the rent is higher than the players balance
			 else {
				 insufficientFunds(player);
			}
		}		
	}

	@Override
	public String toString() {
		return "Type: Labor Camp --- Name: " + super.getName() + " --- Price: " + super.getPrice() + " --- Rent: " + rent + "\n";
	}

	@Override
	public void landOnField(Player player) {
		// TODO Auto-generated method stub
		
	}
	
	public int getRent() {
		return rent;
	}

	@Override
	public void addProperty(Player player) {
		setOwner(player);
		player.addLaborCamp();
		
	}

}
