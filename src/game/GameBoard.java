package game;

import fields.Chance;
import fields.Fields;
import fields.Fleet;
import fields.GoToPrison;
import fields.LaborCamp;
import fields.Ownable;
import fields.Refuge;
import fields.Start;
import fields.Tax;
import fields.Territory;
import fields.VisitPrison;

public class GameBoard {

	private Fields[] field;
	
	public GameBoard(Dice dice) {
		
		// Array that creates each field and the attributes
		field = new Fields[40];
		field[0] = new Start("Start");
		field[1] = new Territory("Rødovrevej", 60, 2);
		field[2] = new Chance();
		field[3] = new Territory("Hvidovrevej", 60, 4);
		field[4] = new Tax("Indkomstskat", 4000);
		field[5] = new Fleet("Helsingør-Helsingborg", 200, 25, 50, 100, 200);
		field[6] = new Territory("Roskildevej", 100, 6);
		field[7] = new Chance();
		field[8] = new Territory("Valby Langgade", 100, 6);
		field[9] = new Territory("Allégade", 120, 8);
		field[10] = new VisitPrison("Prison");
		field[11] = new Territory("Fredriksberg Allé", 140, 10);
		field[12] = new LaborCamp("Tuborg", 150, 100, dice);
		field[13] = new Territory("Bülowsvej", 140, 10);
		field[14] = new Territory("Gl Kongevej", 160, 12);
		field[15] = new Fleet("Mols-Linien",  200, 25, 50, 100, 200);
		field[16] = new Territory("Bernstorffsvej", 180, 14);
		field[17] = new Chance();
		field[18] = new Territory("Hellerupvej", 180, 14);
		field[19] = new Territory("Strandvejen", 200, 16);
		field[20] = new Refuge("Parkering", 5000);
		field[21] = new Territory("Trianglen", 220, 18);
		field[22] = new Chance();
		field[23] = new Territory("Østerbrogade", 220, 18);
		field[24] = new Territory("Grønningen", 240, 20);
		field[25] = new Fleet("Gedser-Rostock",  200, 25, 50, 100, 200);
		field[26] = new Territory("Bredgade", 260, 22);
		field[27] = new Territory("Kgs Nytorv", 260, 22);
		field[28] = new LaborCamp("Coca-Cola", 150, 100, dice);
		field[29] = new Territory("Østergade", 280, 22);
		field[30] = new GoToPrison();
		field[31] = new Territory("Amagertorv", 300, 26);
		field[32] = new Territory("Vimmelskaftet", 300, 26);
		field[33] = new Chance();
		field[34] = new Territory("Nygade", 320, 28);
		field[35] = new Fleet("Rødby-Puttgarden",  200, 25, 50, 100, 200);
		field[36] = new Chance();
		field[37] = new Territory("Frederiksberggade", 350, 35);
		field[38] = new Tax("Statsskat", 2000);
		field[39] = new Territory("Rådhuspladsen", 400, 50);
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
