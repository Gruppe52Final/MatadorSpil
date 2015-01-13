package fields;

import game.Dice;
import game.Player;
import boundary.MatadorGUI;

public class LaborCamp extends Ownable {

	private int rent;
	private Dice dice;
	private MatadorGUI out = new MatadorGUI();

	public LaborCamp(String name,int price, int rent, Dice dice) {
		super(price, name);
		this.rent = rent;
		this.dice = dice;
	}

	@Override
	public void landOnField(Player player, Refuge refuge) {
			checkFieldOwnedByPlayerHimSelf(player);
			checkFieldOwnedByAnotherPlayer(player);	
			checkFieldNotOwnedByAnyone(player, refuge);
			
			
		// Updates the GUI balance for each player
		out.updateBalance(player);
	}
	
	
	
	public void checkFieldOwnedByAnotherPlayer(Player player) {
		// if the field is owned by another player, a rent have to be paid
		if (getOwner() != player && getOwner() != null) {
			int fullRent = rent * dice.getSum() * getOwner().getLaborCamp();
			if (player.account.getScore() >= fullRent) {
				out.fieldTax(super.getName(), getOwner().getName(), fullRent);
				
				getOwner().account.addPoints(fullRent);
				player.account.addPoints(-fullRent);

				out.updateBalance(player);			
			}	
			// the player looses if the rent is higher than the players balance
			 else {
				getOwner().account.addPoints(player.account.getScore());
				player.account.addPoints(-player.account.getScore());
				
				out.insufficiantFunds(super.getName(), getOwner().getName(), player.account.getScore());
				out.updateBalance(player);
				
				player.setDeathStatus(true);
			}
		}
		
	}

	public void checkFieldOwnedByPlayerHimSelf(Player player) {
	// if the owner is the player himself, nothing happens
	if (getOwner() == player) {
		out.fieldOwnedByPlayer(super.getName());
		}
	}

	public void checkFieldNotOwnedByAnyone(Player player, Refuge refuge) {
		// If the current field has no owner, the player can buy it
		if (getOwner() == null) {
			if (player.account.getScore() >= super.getPrice()) {
				boolean buyField = out.buyField(super.getName(), super.getPrice());
				if (buyField) {
					player.account.subtractPoints(super.getPrice());
					setOwner(player);
					player.addLaborCamp();
					refuge.account.addPoints(0.1* super.getPrice());
					out.fieldBought(super.getName());
					} else if(!buyField) {
						out.fieldRefused(super.getName());
					}
			} else if(player.account.getScore() < super.getPrice()) {
				out.fieldRefusedPrice(super.getName());
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

}
