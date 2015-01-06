package game;

import fields.Fields;
import fields.Fleet;
import fields.LaborCamp;
import fields.Ownable;
import fields.Refuge;
import fields.Start;
import fields.Tax;
import fields.Territory;

public class GameBoard {

	private Fields[] field;
	
	public GameBoard(Dice dice) {
		
		// Array that creates each field and the attributes
		field = new Fields[22];
		field[0] = new Start("Start");
		field[1] = new Territory("Tribe Encampment", 1000, 100);
		field[2] = new Tax("Goldmine", 2000);
		field[3] = new Territory("Crater", 1500, 300);
		field[4] = new Fleet("Second Sail", 4000, 500, 1000, 2000, 4000);
		field[5] = new Territory("Mountain", 2000, 500);
		field[6] = new LaborCamp("Huts in the mountain", 2500, 100, dice);
		field[7] = new Territory("Cold Desert", 3000, 700);
		field[8] = new Fleet("Sea Grover", 4000, 500, 1000, 2000, 4000);
		field[9] = new Territory("Black cave", 4000, 1000);
		field[10] = new Refuge("Monastery", 500);
		field[11] = new Territory("The werewall", 4300, 1300);
		field[12] = new Tax("Caravan", 4000);
		field[13] = new Territory("Mountain village", 4750, 1600);
		field[14] = new Fleet("The Buccaneers", 4000, 500, 1000, 2000, 4000);
		field[15] = new Territory("South Catidal", 5000, 2000);
		field[16] = new LaborCamp("The pit", 2500, 100, dice);
		field[17] = new Territory("Palace gates", 5500, 2600);
		field[18] = new Fleet("Privateer armade", 4000, 500, 1000, 2000, 4000);
		field[19] = new Territory("Tower", 6000, 3200);
		field[20] = new Refuge("Walled city", 5000);
		field[21] = new Territory("Castle", 8000, 4000);
	}
	
	public Fields getField(int i) {
		return field[i];
	}
	public void resetOwnedFields(Player player) {
		for (int i = 0; i<field.length; i++) {
			if (field[i] instanceof Ownable) {
				if (((Ownable) field[i]).getOwner() == player) {
					((Ownable) field[i]).setOwner(null);
				}
			}
		}
	}
	public String toString() {
		String s = "";
		for (int i = 0; i<field.length; i++) {
			s += "Felt " + (i+1)+ "		" + field[i].toString();
		}
		return s;		
	}
}
