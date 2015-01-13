package fields;

import boundary.MatadorGUI;
import game.Player;

public class Territory extends Ownable {

	private int rent;
	private MatadorGUI out = new MatadorGUI();

	public Territory(String name, int price, int rent) {
		super(price, name);
		this.rent = rent;
	}

	@Override
	public void landOnField(Player player, Refuge refuge) {
		// If the current field has no owner, the player can buy it
		if (getOwner() == null) {
			if (player.account.getScore() >= super.getPrice()) {
				boolean buyField = out.buyField(super.getName(), super.getPrice());
				if (buyField) {
					//Add money to refuge field
					refuge.account.addPoints(super.getPrice() * 0.1);
					//Subtract money from player for buying field
					player.account.subtractPoints(super.getPrice());
					setOwner(player);
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
		// if the field is owned by another player, a rent have to be paid
		} else {
			if (player.account.getScore() >= rent) {
				out.fieldTax(super.getName(), getOwner().getName(), rent);
				
				getOwner().account.addPoints(rent);
				player.account.subtractPoints(rent);

				out.updateBalance(player);			// the player looses if the rent is higher than the players balance
			}
			// the player loses if the rent is higher than the players balance
			else {
				getOwner().account.addPoints(player.account.getScore());
				player.account.subtractPoints(player.account.getScore());
				
				out.insufficiantFunds(super.getName(), getOwner().getName(), player.account.getScore());
				out.updateBalance(player);
				
				player.setDeathStatus(true);
			}
		}
		// Updates the GUI balance for each player
		out.updateBalance(player);
	}
	
	@Override
	public String toString() {
		return "Type: Territory --- Name: " + super.getName() + " --- Price: " + super.getPrice() + " --- Rent: " + rent + "\n";
	}

	@Override
	public void landOnField(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkFieldOwnedByAnotherPlayer(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkFieldOwnedByPlayerHimSelf(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkFieldNotOwnedByAnyone(Player player, Refuge refuge) {
		// TODO Auto-generated method stub
		
	}
	


	
}
