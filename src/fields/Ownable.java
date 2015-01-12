package fields;

import game.Player;

public abstract class Ownable extends Fields {
	
	private Player owner;

	public Ownable() {
		owner = null;
	}	
	
	

	
	@Override
	public abstract String toString();
	
	public void setOwner (Player player) {
		owner = player;
	}
		
	public Player getOwner() {
		return owner;
	}


	public void landOnField(Player player, Refuge refugeField) {
		// TODO Auto-generated method stub
		
	}
}
