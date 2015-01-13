package fields;

import game.Player;
import boundary.MatadorGUI;

public class Fleet extends Ownable {
	private int price;
	private int[] rent = new int[4];
	private MatadorGUI out = new MatadorGUI();
	

	public Fleet(String name, int price) {
		super(price, name);
		this.price = price;
		rent[0] = 25;
		rent[1] = 50;
		rent[2] = 100;
		rent[3] = 200;
	}
	
	


	@Override
	public void landOnField(Player player, Refuge refuge) {
		// If the current field has no owner, the player can buy it
		checkFieldNotOwnedByAnyone(player, refuge);
		
		checkFieldOwnedByPlayerHimSelf(player);
		
		checkFieldOwnedByAnotherPlayer(player);
		
		// Updates the GUI balance for each player
		out.updateBalance(player);
		
	}	
	
	public void checkFieldOwnedByPlayerHimSelf(Player player) {
		// if the owner is the player himself, nothing happens
		if (getOwner() == player) {
			out.fieldOwnedByPlayer(super.getName());
		}
	}

	public void checkFieldOwnedByAnotherPlayer(Player player) {
		if (getOwner() != player || getOwner() != null) {
			if (player.account.getScore() >= rent[getOwner().getFleets() - 1]) {
				out.fieldTax(super.getName(), getOwner().getName(), rent[getOwner().getFleets()  - 1]);
				player.account.subtractPoints(rent[getOwner().getFleets() - 1]);
				getOwner().account.addPoints(rent[getOwner().getFleets() - 1]);
				out.updateBalance(player);
				// the player loses if the rent is higher than the players
				// balance
			} else {
				getOwner().account.addPoints(player.account.getScore());
				player.account.subtractPoints(player.account.getScore());

				out.insufficiantFunds(super.getName(), getOwner().getName(),
						player.account.getScore());
				out.updateBalance(player);

				player.setDeathStatus(true);
			}
		}
		
	}


	public void checkFieldNotOwnedByAnyone(Player player, Refuge refuge) {
		if (getOwner() == null) {
			if (player.account.getScore() >= price) {
				boolean buyField = out.buyField(super.getName(), price);
				if (buyField) {
					player.account.subtractPoints(price);
					setOwner(player);
					player.addFleet();
					refuge.account.addPoints(0.1 * super.getPrice());
					out.fieldBought(super.getName());
				} else {
					out.fieldRefused(super.getName());
				}
			} else {
				out.fieldRefusedPrice(super.getName());
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
}
