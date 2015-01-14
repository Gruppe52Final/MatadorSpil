package fields;

import game.Player;

public class ChanceSubtractPoints extends ChanceCards {
	int amount;
	String text;
	
	public ChanceSubtractPoints(String text, int amount) {
		super(text);
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}

	@Override
	public void activate(Player player) {
		player.account.subtractPoints(amount);		
	}	
}
