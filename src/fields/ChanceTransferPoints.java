package fields;

import game.Player;

public class ChanceTransferPoints extends ChanceCards {
	int amount;
	String text;
	
	public ChanceTransferPoints(String text, int amount) {
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
