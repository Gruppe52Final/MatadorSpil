package fields;

import boundary.MatadorGUI;
import game.Player;

public class Territory extends Ownable {

	private int baseRent;
	private int houses;
	private int hotelRent;
	private String color;
	private int housePrice;
	private int[] houseRent = new int[4];
	private MatadorGUI gui = new MatadorGUI();

	public Territory(String name, int price, int rent, int houseRent1, int houseRent2,
			int houseRent3, int houseRent4, int hotelRent, int housePrice, String color) {
		super(price, name);
		this.baseRent = rent;
		houseRent[0] = houseRent1;
		houseRent[1] = houseRent2;
		houseRent[2] = houseRent3;
		houseRent[3] = houseRent4;
		this.hotelRent = hotelRent;
		this.housePrice = housePrice;
		this.color = color;
	}

	
	@Override
	public String toString() {
		return "Type: Territory --- Name: " + super.getName() + " --- Price: " + super.getPrice() + " --- BaseRent: " + baseRent + "\n";
	}

	
	public int getRent() {
		int currentRent = 0;
		if(houses == 5) {
			currentRent = hotelRent;
		} else if (houses > 0) {
			currentRent = houseRent[houses-1];
		} else {
			currentRent = baseRent;
		}
		return currentRent;
	}

	@Override
	public void checkFieldOwnedByAnotherPlayer(Player player) {
		if (getOwner() != player && getOwner() != null) {
			int currentRent = getRent();
			if (player.account.getScore() >= currentRent) {
				gui.fieldTax(super.getName(), getOwner().getName(), currentRent);		//Har givet nullPointerError	
				getOwner().account.addPoints(currentRent);
				player.account.subtractPoints(currentRent);
				gui.updateBalance(player);			// the player looses if the rent is higher than the players balance
				gui.updateBalance(getOwner());
			}
			// the player loses if the rent is higher than the players balance
			else {
				insufficientFunds(player);
			}			
		}
	}		
	
	public int getBaseRent() {
		return baseRent;
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
