package fields;

import boundary.MatadorGUI;
import game.Player;

public class Territory extends Ownable {

	private int rent;
	private MatadorGUI gui = new MatadorGUI();

	public Territory(String name, int price, int rent) {
		super(price, name);
		this.rent = rent;
	}

	
	@Override
	public String toString() {
		return "Type: Territory --- Name: " + super.getName() + " --- Price: " + super.getPrice() + " --- Rent: " + rent + "\n";
	}

	


	@Override
	public void checkFieldOwnedByAnotherPlayer(Player player) {
		if (getOwner() != player && getOwner() != null) {
			if (player.account.getScore() >= rent) {
				gui.fieldTax(super.getName(), getOwner().getName(), rent);		//Har givet nullPointerError	
				getOwner().account.addPoints(rent);
				player.account.subtractPoints(rent);
				gui.updateBalance(player);			// the player looses if the rent is higher than the players balance
				gui.updateBalance(getOwner());
			}
			// the player loses if the rent is higher than the players balance
			else {
				getOwner().account.addPoints(player.account.getScore());
				player.account.subtractPoints(player.account.getScore());
				
				gui.insufficiantFunds(super.getName(), getOwner().getName(), player.account.getScore());
				gui.updateBalance(player);
				
				player.setDeathStatus(true);
			}		
		}		
	}
	
	public int getRent() {
		return rent;
	}


	@Override
	public void landOnField(Player player) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addProperty(Player player) {
		setOwner(player);		
	}
	


	
}
