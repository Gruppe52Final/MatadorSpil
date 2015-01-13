package fields;

import game.Player;
import boundary.MatadorGUI;

public class Chance extends Fields {

	private ChanceCards[] chanceCards;
	private MatadorGUI gui = new MatadorGUI();
	private final int numberOfChanceCards = 2;
	ChanceCards pickedChanceCard;
	
	
	
	@Override
	public void landOnField(Player player) {
		pickedChanceCard = chanceCards[genRandomInt()];
		gui.chanceCard(pickedChanceCard.getText());
		pickedChanceCard.activate(player);
		gui.updateBalance(player);
	}

	@Override
	public String toString() {
		return "Type: Chance";
	}
	
	public Chance() {
		chanceCards = new ChanceCards[2];
		
		chanceCards[0] = new ChanceTransferPoints("Betal for vognvask og smøring kr. 15,00.", 15);
		chanceCards[1] = new ChanceTransferPoints("De har kørt frem for \"Fuld stop\". Betal 150 point.", 150);
	}
	
	@Deprecated
	public ChanceCards getRandomChanceCard() {		
		return chanceCards[genRandomInt()];
	}
	
	public int genRandomInt() {
		int randomInt = (int) (Math.random() * numberOfChanceCards);
		return randomInt;
	}
	
	public ChanceCards[] getChanceCards() {
		return chanceCards;
	}

}
