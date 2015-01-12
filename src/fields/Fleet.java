package fields;

import game.Player;
import boundary.MatadorGUI;

public class Fleet extends Ownable {
	private int price;
	private int[] rent = new int[4];
	private MatadorGUI out = new MatadorGUI();
	private int rent_1 = 25;
	private int rent_2 = 50;
	private int rent_3 = 100;
	private int rent_4 = 200;
	

	public Fleet(String name, int price) {
		super(price, name);
		this.price = price;
	}

	@Override
	public void landOnField(Player player, Refuge refuge) {
		// If the current field has no owner, the player can buy it
		if (getOwner() == null) {
			if (player.account.getScore() >= price) {
				boolean buyField = out.buyField(super.getName(), price);
				if (buyField) {
					player.account.addPoints(-price);
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
			// if the owner is the player himself, nothing happens
		} else if (getOwner() == player) {
			out.fieldOwnedByPlayer(super.getName());
		}
		// if the field is owned by another player, a rent have to be paid
		else {
			if (player.account.getScore() >= rent[getOwner().getFleets() - 1]) {
				out.fieldTax(super.getName(), getOwner().getName(), rent[getOwner()
						.getFleets() - 1]);
				player.account.addPoints(-rent[getOwner().getFleets() - 1]);
				getOwner().account.addPoints(rent[getOwner().getFleets() - 1]);
				out.updateBalance(player);
				// the player loses if the rent is higher than the players
				// balance
			} else {
				getOwner().account.addPoints(player.account.getScore());
				player.account.addPoints(-player.account.getScore());

				out.insufficiantFunds(super.getName(), getOwner().getName(),
						player.account.getScore());
				out.updateBalance(player);

				player.setDeathStatus(true);
			}
		}
		// Updates the GUI balance for each player
		out.updateBalance(player);
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
}
