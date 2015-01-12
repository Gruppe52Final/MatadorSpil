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
		// If the current field has no owner, the player can buy it
		if (getOwner() == null) {
			if (player.account.getScore() >= price) {
				boolean buyField = out.buyField(name, price);
				if (buyField) {
					player.account.addPoints(-price);
					setOwner(player);
					player.addLaborCamp();
					out.fieldBought(name);
				} else {
					out.fieldRefused(name);
				}
			} else {
				out.fieldRefusedPrice(name);
			}
			// if the owner is the player himself, nothing happens
		} else if (getOwner() == player) {
			out.fieldOwnedByPlayer(name);
		}
		// if the field is owned by another player, a rent have to be paid
		else {
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
		// Updates the GUI balance for each player
		out.updateBalance(player);
	}

	@Override
	public String toString() {
		return "Type: Labor Camp --- Name: " + name + " --- Price: " + price + " --- Rent: " + rent + "\n";
	}
}
