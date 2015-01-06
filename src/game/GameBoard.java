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
		field[1] = new Territory("R�dovrevej", 1000, 100);
		field[2] = new Tax("Pr�v Lykken", 2000);
		field[3] = new Territory("Hvidovrevej", 1500, 300);
		field[4] = new Tax("Indkomstskat", 4000);
		field[5] = new Fleet("Helsing�r-Helsingborg", 4000, 500, 1000, 2000, 4000);
		field[6] = new Territory("Roskildevej", 1500, 300);
		field[7] = new Territory("Pr�v Lykken", 3000, 700);
		field[8] = new Territory("Valby Langgade", 3000, 700);
		field[9] = new Territory("All�gade", 4000, 1000);
		field[10] = new Refuge("F�ngse", 500);
		field[11] = new Territory("Fredriksberg All�", 4300, 1300);
		field[12] = new LaborCamp("Tuborg", 2500, 100, dice);
		field[13] = new Territory("B�lowsvej", 4750, 1600);
		field[14] = new Territory("Gl Kongevej", 4000, 500);
		field[15] = new Fleet("Mols-Linien",  4000, 500, 1000, 2000, 4000);
		field[16] = new Territory("Bernstorffsvej", 4750, 1600);
		field[17] = new Territory("Pr�v Lykken", 5500, 2600);
		field[18] = new Territory("Hellerupvej", 5500, 2600);
		field[19] = new Territory("Strandvejen", 6000, 3200);
		field[20] = new Refuge("Parkering", 5000);
		field[21] = new Territory("Trianglen", 8000, 4000);
		field[22] = new Territory("Pr�v Lykken", 5500, 2600);
		field[23] = new Territory("�sterbrogade", 8000, 4000);
		field[24] = new Territory("Gr�nningen", 8000, 4000);
		field[25] = new Fleet("Gedser-Rostock",  4000, 500, 1000, 2000, 4000);
		field[26] = new Territory("Bredgade", 8000, 4000);
		field[27] = new Territory("Kgs Nytorv", 8000, 4000);
		field[28] = new LaborCamp("Coca-Cola", 2500, 100, dice);
		field[30] = new Territory("�stergade", 8000, 4000);
		field[31] = new Refuge("De F�ngsles", 500);
		field[32] = new Territory("Amagertorv", 8000, 4000);
		field[33] = new Territory("Pr�v Lykken", 8000, 4000);
		field[34] = new Territory("Nygade", 8000, 4000);
		field[35] = new Fleet("R�dby-Puttgarden",  4000, 500, 1000, 2000, 4000);
		field[36] = new Territory("Pr�v Lykken", 8000, 4000);
		field[37] = new Territory("Frederiksberggade", 8000, 4000);
		field[38] = new Tax("Statsskat", 2000);
		field[39] = new Territory("R�dhuspladsen", 5500, 2600);
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
