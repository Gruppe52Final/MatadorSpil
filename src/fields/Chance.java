package fields;

import chanceCards.ChanceCards;
import chanceCards.ChanceSubtractPoints;
import chanceCards.ChanceAddPoints;
import game.Player;
import boundary.MatadorGUI;
import boundary.Texts;

public class Chance extends Fields {

	private ChanceCards[] chanceCards;
	private MatadorGUI gui;
	private ChanceCards pickedChanceCard;
	
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
		chanceCards = new ChanceCards[16];
		//Substract cards
		chanceCards[0] = new ChanceSubtractPoints(Texts.text[39], 15);
		chanceCards[1] = new ChanceSubtractPoints(Texts.text[40], 150);
		chanceCards[2] = new ChanceSubtractPoints(Texts.text[41], 125);
		chanceCards[3] = new ChanceSubtractPoints(Texts.text[42], 120);
		chanceCards[4] = new ChanceSubtractPoints(Texts.text[43], 60);
		chanceCards[5] = new ChanceSubtractPoints(Texts.text[44], 50);
		//Add cards
		chanceCards[6] = new ChanceAddPoints(Texts.text[45], 25*(gui.playerAmount()-1));
		chanceCards[7] = new ChanceAddPoints(Texts.text[46], 200);
		chanceCards[8] = new ChanceAddPoints(Texts.text[47], 200);
		chanceCards[9] = new ChanceAddPoints(Texts.text[48], 20);
		chanceCards[10] = new ChanceAddPoints(Texts.text[49], 50);
		chanceCards[11] = new ChanceAddPoints(Texts.text[50], 5);
		chanceCards[12] = new ChanceAddPoints(Texts.text[51], 50);
		chanceCards[13] = new ChanceAddPoints(Texts.text[52], 100);
		chanceCards[14] = new ChanceAddPoints(Texts.text[53], 108);
		chanceCards[15] = new ChanceAddPoints(Texts.text[54], 100);
		
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
