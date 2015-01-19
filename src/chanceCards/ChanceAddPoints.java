package chanceCards;

import game.Player;

public class ChanceAddPoints extends ChanceCards {
	int amount;
	String text;
	
	public ChanceAddPoints(String text, int amount) {
		super(text);
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}

	@Override
	public void activate(Player player) {
		player.addPoints(amount);		
	}	
}
