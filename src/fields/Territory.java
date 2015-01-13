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

	
	public void checkFieldNotOwnedByAnyone(Player player, Refuge refuge) {
		if (getOwner() == null) {
			if (player.account.getScore() >= super.getPrice()) {
				boolean buyField = gui.buyField(super.getName(), super.getPrice());
				if (buyField) {
					player.account.subtractPoints(super.getPrice());
					setOwner(player);
					refuge.account.addPoints(0.1 * super.getPrice());
					gui.fieldBought(super.getName());
				} else {
					gui.fieldRefused(super.getName());
				}
			} else {
				gui.fieldRefusedPrice(super.getName());
			}	
		}
	}


	@Override
	public void checkFieldOwnedByAnotherPlayer(Player player) {
		if (player.account.getScore() >= rent) {
			System.out.println(super.getName());
			System.out.println(getOwner().getName());
			System.out.println(rent);
			gui.fieldTax(super.getName(), getOwner().getName(), rent);
			
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
	
	public int getRent() {
		return rent;
	}


	@Override
	public void landOnField(Player player) {
		// TODO Auto-generated method stub
		
	}
	


	
}
