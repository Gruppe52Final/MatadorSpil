package game;

import fields.Chance;
import fields.Fields;
import fields.Fleet;
import fields.GoToPrison;
import fields.LaborCamp;
import fields.Ownable;
import fields.Refuge;
import fields.Start;
import fields.TaxPercent;
import fields.TaxStatic;
import fields.Territory;
import fields.VisitPrison;

public class GameBoard {

	private Fields[] field;
	
	public GameBoard(Dice dice) {
		
		// Array that creates each field and the attributes
		field = new Fields[40];
		field[0] = new Start("Start");
		field[1] = new Territory("R�dovrevej", 60, 2, 10, 30, 90, 160, 250);
		field[2] = new Chance();
		field[3] = new Territory("Hvidovrevej", 60, 4, 20, 60, 180, 320, 540);
		field[4] = new TaxPercent("Indkomstskat", 200);
		field[5] = new Fleet("Helsing�r-Helsingborg", 200);
		field[6] = new Territory("Roskildevej", 100, 6, 30, 90, 270, 400, 550);
		field[7] = new Chance();
		field[8] = new Territory("Valby Langgade", 100, 6, 30, 90, 270, 400, 550);
		field[9] = new Territory("All�gade", 120, 8, 40, 100, 300, 450, 600);
		field[10] = new VisitPrison("Jail");
		field[11] = new Territory("Fredriksberg All�", 140, 10, 50, 150, 450, 625, 750);
		field[12] = new LaborCamp("Tuborg", 150, 10, dice);
		field[13] = new Territory("B�lowsvej", 140, 10, 50, 150, 450, 625, 750);
		field[14] = new Territory("Gl Kongevej", 160, 12, 60, 180, 500, 700, 900);
		field[15] = new Fleet("Mols-Linien",  200);
		field[16] = new Territory("Bernstorffsvej", 180, 14, 70, 200, 550, 750, 950);
		field[17] = new Chance();
		field[18] = new Territory("Hellerupvej", 180, 14, 70, 200, 550, 750, 950);
		field[19] = new Territory("Strandvej", 200, 16, 80, 220, 600, 800, 1000);
		field[20] = new Refuge("Parkering");
		field[21] = new Territory("Trianglen", 220, 18, 90, 250, 700, 875, 1050);
		field[22] = new Chance();
		field[23] = new Territory("�sterbrogade", 220, 18, 90, 250, 700, 875, 1050);
		field[24] = new Territory("Gr�nningen", 240, 20, 100, 300, 750, 925, 1100);
		field[25] = new Fleet("Gedser-Rostock",  200);
		field[26] = new Territory("Bredgade", 260, 22, 110, 330, 800, 975, 1150);
		field[27] = new Territory("Kgs Nytorv", 260, 22, 110, 330, 800, 975, 1150);
		field[28] = new LaborCamp("Carlsberg", 150, 10, dice);
		field[29] = new Territory("�stergade", 280, 22, 90, 250, 700, 875, 1050);
		field[30] = new GoToPrison("Arrested");
		field[31] = new Territory("Amagertorv", 300, 26, 130, 390, 900, 1100, 1275);
		field[32] = new Territory("Vimmelskaftet", 300, 26, 130, 390, 900, 1100, 1275);
		field[33] = new Chance();
		field[34] = new Territory("Nygade", 320, 28, 150, 450, 1000, 1200, 1400);
		field[35] = new Fleet("R�dby-Puttgarden",  200);
		field[36] = new Chance();
		field[37] = new Territory("Frederiksberggade", 350, 35, 175, 500, 1100, 1300, 1500);
		field[38] = new TaxStatic("Statsskat", 100);
		field[39] = new Territory("R�dhuspladsen", 400, 50, 200, 600, 1400, 1700, 2000);
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

	public boolean fieldOwnable(int position) {
		boolean x = false;
		if(field[position] instanceof Ownable) {
			x = true;
		}
		return x;
	}

	public void landOnField(Player player) {
		if(field[player.getPosition()] instanceof Ownable) {
			Refuge refuge;
			Ownable ownable;
			ownable =(Ownable) field[player.getPosition()];
			refuge = (Refuge) field[20];
			ownable.landOnField(player, refuge);
		} else {
			field[player.getPosition()].landOnField(player);
		}
		
		
	}
}
