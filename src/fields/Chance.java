package fields;

import chanceCards.ChanceCards;
import chanceCards.ChanceSubtractPoints;
import game.Player;
import boundary.MatadorGUI;
import boundary.Texts;

public class Chance extends Fields {

	private ChanceCards[] chanceCards;
	private MatadorGUI gui;
	ChanceCards pickedChanceCard;
	
	/**
	 * Used for testing in JUnit testing, must set a language, or you will get a nullPointer error
	 * @param language
	 */
	public Chance(String language) {
		gui = new MatadorGUI(language);
		createCardList();
	}
	
	/**
	 * Constructor to be used in normal gameplay, setting language 
	 */
	public Chance() {
		gui = new MatadorGUI();
		createCardList();
	}
	
	
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
	
	public void createCardList() {
		chanceCards = new ChanceCards[6];		
		chanceCards[0] = new ChanceSubtractPoints(Texts.text[39], 15);
		chanceCards[1] = new ChanceSubtractPoints(Texts.text[40], 150);
		chanceCards[2] = new ChanceSubtractPoints(Texts.text[41], 125);
		chanceCards[3] = new ChanceSubtractPoints(Texts.text[42], 120);
		chanceCards[4] = new ChanceSubtractPoints(Texts.text[43], 60);
		chanceCards[5] = new ChanceSubtractPoints(Texts.text[44], 50);
		
	}
	
	
	@Deprecated
	public ChanceCards getRandomChanceCard() {		
		return chanceCards[genRandomInt()];
	}
	
	public int genRandomInt() {
		int randomInt = (int) (Math.random() * chanceCards.length);
		return randomInt;
	}
	
	public ChanceCards[] getChanceCards() {
		return chanceCards;
	}

}
