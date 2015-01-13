package fields;

import game.Player;

public abstract class Ownable extends Fields {
	
	private Player owner;
	private int price;
	private String name;

	public Ownable(int price, String name) {
		owner = null;
		this.price = price;
		this.setName(name);
	}
	
	@Override
	public abstract String toString();
	
	public abstract void checkFieldOwnedByAnotherPlayer(Player player);
	
	public abstract void checkFieldOwnedByPlayerHimSelf(Player player);
	
	public abstract void checkFieldNotOwnedByAnyone(Player player, Refuge refuge);
	
	public void setOwner (Player player) {
		owner = player;
	}
		
	public Player getOwner() {
		return owner;
	}


	public void landOnField(Player player, Refuge refugeField) {
		// TODO Auto-generated method stub
		
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
