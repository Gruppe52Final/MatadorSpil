package fields;

import game.Dice;
import game.Player;
import boundary.MatadorGUI;

public class LaborCamp extends Ownable {

	private String name;
	private int price, rent;
	private Dice dice;
	private MatadorGUI out = new MatadorGUI();

	public LaborCamp(String name, int price, int rent, Dice dice) {
		this.name = name;
		this.price = price;
		this.rent = rent;
		this.dice = dice;
	}

	@Override
	public void landOnField(Player player) {
		checkFieldNotOwnedByAnyone(player);
		checkFieldOwnedByPlayerHimSelf(player);
		checkFieldOwnedByAnotherPlayer(player);
		// Updates the GUI balance for each player
		out.updateBalance(player);
	}
	
	
	
	private void checkFieldOwnedByAnotherPlayer(Player player) {
		// if the field is owned by another player, a rent have to be paid
		if (getOwner() != player || getOwner() != null) {
			int fullRent = rent * dice.getSum() * getOwner().getLaborCamp();
			if (player.account.getScore() >= fullRent) {
				out.fieldTax(name, getOwner().getName(), fullRent);
				
				getOwner().account.addPoints(fullRent);
				player.account.addPoints(-fullRent);

				out.updateBalance(player);			// the player looses if the rent is higher than the players balance
			} else {
				getOwner().account.addPoints(player.account.getScore());
				player.account.addPoints(-player.account.getScore());
				
				out.insufficiantFunds(name, getOwner().getName(), player.account.getScore());
				out.updateBalance(player);
				
				player.setDeathStatus(true);
			}
		}
		
	}

	private void checkFieldOwnedByPlayerHimSelf(Player player) {
	// if the owner is the player himself, nothing happens
	if (getOwner() == player) {
		out.fieldOwnedByPlayer(name);
		}
	}

	private void checkFieldNotOwnedByAnyone(Player player) {
		// If the current field has no owner, the player can buy it
		if (getOwner() == null) {
			if (player.account.getScore() >= price) {
				boolean buyField = out.buyField(name, price);
				if (buyField) {
					player.account.subtractPoints(price);
					setOwner(player);
					player.addLaborCamp();
					out.fieldBought(name);
					} else if(!buyField) {
						out.fieldRefused(name);
					}
			} else if(player.account.getScore() < price) {
				out.fieldRefusedPrice(name);
			}
		}
	}

	@Override
	public String toString() {
		return "Type: Labor Camp --- Name: " + name + " --- Price: " + price + " --- Rent: " + rent + "\n";
	}
}
