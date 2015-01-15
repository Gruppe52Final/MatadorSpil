package fields;

import boundary.MatadorGUI;
import game.Player;

public class Territory extends Ownable {

	private int rent;
	private int houses;
	private int hotelRent;
	private int[] houseRent = new int[4];
	private MatadorGUI gui = new MatadorGUI();

	public Territory(String name, int price, int rent, int houseRent1, int houseRent2, int houseRent3, int houseRent4, int hotelRent) {
		super(price, name);
		this.rent = rent;
		houseRent[0] = houseRent1;
		houseRent[1] = houseRent2;
		houseRent[2] = houseRent3;
		houseRent[3] = houseRent4;
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
				insufficientFunds(player);
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
		player.addProperty(super.getName());
	}
	
	public void setHouses(int houses) {
		this.houses = houses;
	}


	public int getHouses() {
		return houses;
	}
	


	
}
