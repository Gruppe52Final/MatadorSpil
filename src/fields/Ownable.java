package fields;

import boundary.MatadorGUI;
import game.Player;

public abstract class Ownable extends Fields {
	
	private Player owner;
	private int price;
	private String name;
	private MatadorGUI gui = new MatadorGUI();

	public Ownable(int price, String name) {
		owner = null;
		this.price = price;
		this.setName(name);
	}
	
	@Override
	public abstract String toString();
	
	public abstract void checkFieldOwnedByAnotherPlayer(Player player);
		
	public abstract void checkFieldNotOwnedByAnyone(Player player, Refuge refuge);
	
	public void setOwner (Player player) {
		owner = player;
	}
		
	public Player getOwner() {
		return owner;
	}
	
	public void checkFieldOwnedByPlayerHimSelf(Player player) {
		// if the owner is the player himself, nothing happens
		if (getOwner() == player) {
			gui.fieldOwnedByPlayer(name);
		}
	}


	public void landOnField(Player player, Refuge refuge) {
		checkFieldNotOwnedByAnyone(player, refuge);	
		checkFieldOwnedByPlayerHimSelf(player);
		checkFieldOwnedByAnotherPlayer(player);				
		// Updates the GUI balance for each player
		gui.updateBalance(player);
		
	}

	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
