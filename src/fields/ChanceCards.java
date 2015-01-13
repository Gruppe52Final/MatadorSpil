package fields;

import game.Player;

public abstract class ChanceCards {

	String text;
	
	public String getText() {
		return text;
	}
	
	public ChanceCards (String text) {
		this.text = text;
	}

	public abstract void activate(Player player);


}
