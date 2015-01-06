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
		field = new Fields[40];
		field[0] = new Start("Start");
		field[1] = new Territory("Rødovrevej", 1000, 100);
		field[2] = new Tax("Prøv Lykken", 2000);
		field[3] = new Territory("Hvidovrevej", 1500, 300);
		field[4] = new Tax("Indkomstskat", 4000);
		field[5] = new Fleet("Helsingør-Helsingborg", 4000, 500, 1000, 2000, 4000);
		field[6] = new Territory("Roskildevej", 1500, 300);
		field[7] = new Territory("Prøv Lykken", 3000, 700);
		field[8] = new Territory("Valby Langgade", 3000, 700);
		field[9] = new Territory("Allégade", 4000, 1000);
		field[10] = new Refuge("Fængse", 500);
		field[11] = new Territory("Fredriksberg Allé", 4300, 1300);
		field[12] = new LaborCamp("Tuborg", 2500, 100, dice);
		field[13] = new Territory("Bülowsvej", 4750, 1600);
		field[14] = new Territory("Gl Kongevej", 4000, 500);
		field[15] = new Fleet("Mols-Linien",  4000, 500, 1000, 2000, 4000);
		field[16] = new Territory("Bernstorffsvej", 4750, 1600);
		field[17] = new Territory("Prøv Lykken", 5500, 2600);
		field[18] = new Territory("Hellerupvej", 5500, 2600);
		field[19] = new Territory("Strandvejen", 6000, 3200);
		field[20] = new Refuge("Parkering", 5000);
		field[21] = new Territory("Trianglen", 8000, 4000);
		field[22] = new Territory("Prøv Lykken", 5500, 2600);
		field[23] = new Territory("Østerbrogade", 8000, 4000);
		field[24] = new Territory("Grønningen", 8000, 4000);
		field[25] = new Fleet("Gedser-Rostock",  4000, 500, 1000, 2000, 4000);
		field[26] = new Territory("Bredgade", 8000, 4000);
		field[27] = new Territory("Kgs Nytorv", 8000, 4000);
		field[28] = new LaborCamp("Coca-Cola", 2500, 100, dice);
		field[30] = new Territory("Østergade", 8000, 4000);
		field[31] = new Refuge("De Fængsles", 500);
		field[32] = new Territory("Amagertorv", 8000, 4000);
		field[33] = new Territory("Prøv Lykken", 8000, 4000);
		field[34] = new Territory("Nygade", 8000, 4000);
		field[35] = new Fleet("Rødby-Puttgarden",  4000, 500, 1000, 2000, 4000);
		field[36] = new Territory("Prøv Lykken", 8000, 4000);
		field[37] = new Territory("Frederiksberggade", 8000, 4000);
		field[38] = new Tax("Statsskat", 2000);
		field[39] = new Territory("Rådhuspladsen", 5500, 2600);
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
