package fields;

import boundary.MatadorGUI;
import game.Player;

public abstract class Ownable extends Fields {
	
	private Player owner;
	private int price;
	private String name;
	private MatadorGUI gui = new MatadorGUI();
	private int pledgeMoney;
	private boolean pledgeStatus = false;

	public Ownable(int price, String name, int pledgeMoney) {
		owner = null;
		this.price = price;
		this.setName(name);
		this.pledgeMoney = pledgeMoney;
	}
	
	@Override
	public abstract String toString();
	
	public abstract void checkFieldOwnedByAnotherPlayer(Player player);
	
	public abstract void addProperty(Player player);
	
	public void setOwner (Player player) {
		owner = player;
	}
		
	public Player getOwner() {
		return owner;
	}
	
	public int getPledge() {
		return pledgeMoney;
	}
	
	
	public void checkFieldNotOwnedByAnyone(Player player, Refuge refuge) {
		if (getOwner() == null) {
			if (player.getScore() >= price) {
				boolean buyField = gui.buyField(name, price);
				if (buyField) {
					player.subtractPoints(price);
					addProperty(player);
					refuge.addPoints(0.1 * price);
					gui.fieldBought(name);
				} else {
					gui.fieldRefused(name);
				}
			} else {
				gui.fieldRefusedPrice(name);
			}	
		}
	}
	
	public void checkFieldOwnedByPlayerHimSelf(Player player) {
		// if the owner is the player himself, nothing happens
		if (getOwner() == player) {
			gui.fieldOwnedByPlayer(name);
		}
	}
	
	public void insufficientFunds(Player player) {
		getOwner().addPoints(player.getScore());
		player.subtractPoints(player.getScore());				
		gui.insufficiantFunds(getName(), owner.getName(), player.getScore());
		gui.updateBalance(player);
		gui.updateBalance(getOwner());				
		player.setDeathStatus(true);
	}


	public void landOnField(Player player, Refuge refuge) {
		checkFieldOwnedByPlayerHimSelf(player);
		checkFieldNotOwnedByAnyone(player, refuge);			
		if(!pledgeStatus) {
			checkFieldOwnedByAnotherPlayer(player);				
		} else if(pledgeStatus) {
			gui.PropertyIsPledged(name);
		}
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

	public void setPledge(boolean pledgeStatus) {
		this.pledgeStatus = pledgeStatus;
		
	}

	public boolean getPledgeStatus() {
		return pledgeStatus;
	}
	
	
}
