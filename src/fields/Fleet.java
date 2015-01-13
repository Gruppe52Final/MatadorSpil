package fields;

import game.Player;
import boundary.MatadorGUI;

public class Fleet extends Ownable {
	private int price;
	private int[] rent = new int[4];
	private MatadorGUI gui = new MatadorGUI();
	

	public Fleet(String name, int price) {
		super(price, name);
		this.price = price;
		rent[0] = 25;
		rent[1] = 50;
		rent[2] = 100;
		rent[3] = 200;
	}
	

	public void checkFieldOwnedByAnotherPlayer(Player player) {
		if (getOwner() != player && getOwner() != null) {
			if (player.account.getScore() >= rent[getOwner().getFleets() - 1]) {
				gui.fieldTax(super.getName(), getOwner().getName(), rent[getOwner().getFleets()  - 1]);
				player.account.subtractPoints(rent[getOwner().getFleets() - 1]);
				getOwner().account.addPoints(rent[getOwner().getFleets() - 1]);
				gui.updateBalance(player);
				// the player loses if the rent is higher than the players
				// balance
			} else {
				getOwner().account.addPoints(player.account.getScore());
				player.account.subtractPoints(player.account.getScore());

				gui.insufficiantFunds(super.getName(), getOwner().getName(),
						player.account.getScore());
				gui.updateBalance(player);
				gui.updateBalance(getOwner());

				player.setDeathStatus(true);
			}
		}
		
	}



	@Override
	public String toString() {
		return "Type: Fleet --- Name: " + super.getName() + " --- Price: " + price + " --- Rent 1: " + rent[0]
				+ " --- Rent 2: " + rent[1] + " --- Rent 3: " + rent[2] + " --- Rent 4: "
				+ rent[3] + "\n";
	}

	@Override
	public void landOnField(Player player) {
		// TODO Auto-generated method stub
		
	}

	public int[] getRent() {
		return rent;
	}

	public void setRent(int[] rent) {
		this.rent = rent;
	}

	@Override
	public void addProperty(Player player) {
		player.addFleet();
		setOwner(player);
		
	}
}
