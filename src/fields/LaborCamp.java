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
	
	public void checkFieldNotOwnedByAnyone(Player player, Refuge refuge) {
		if (getOwner() == null) {
			if (player.account.getScore() >= super.getPrice()) {
				boolean buyField = gui.buyField(super.getName(), super.getPrice());
				if (buyField) {
					player.account.subtractPoints(super.getPrice());
					setOwner(player);
					player.addLaborCamp();
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

	
	public void checkFieldOwnedByAnotherPlayer(Player player) {
		// if the field is owned by another player, a rent have to be paid
		if (getOwner() != player && getOwner() != null) {
			int fullRent = rent * dice.getSum() * getOwner().getLaborCamp();
			if (player.account.getScore() >= fullRent) {
				System.out.println(super.getName() + getOwner().getName() + fullRent);
				System.out.println(dice.getSum());
				System.out.println(rent + " rent");
				System.out.println(getOwner().getLaborCamp() + "laborcamps owned");
				gui.fieldTax(super.getName(), getOwner().getName(), fullRent);
				
				getOwner().account.addPoints(fullRent);
				player.account.subtractPoints(fullRent);

				gui.updateBalance(player);			// the player looses if the rent is higher than the players balance
			} else {

				getOwner().account.addPoints(player.account.getScore());
				player.account.subtractPoints(player.account.getScore());
				
				gui.insufficiantFunds(super.getName(), getOwner().getName(), player.account.getScore());
				gui.updateBalance(player);
				
				player.setDeathStatus(true);
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
