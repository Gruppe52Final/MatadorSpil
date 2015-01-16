package game;

import java.util.ArrayList;

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
		field[1] = new Territory("Rødovrevej", 60, 2, 10, 30, 90, 160, 250, 50, "blue");
		field[2] = new Chance();
		field[3] = new Territory("Hvidovrevej", 60, 4, 20, 60, 180, 320, 540, 50, "blue");
		field[4] = new TaxPercent("Indkomstskat", 200);
		field[5] = new Fleet("Helsingør-Helsingborg", 200);
		field[6] = new Territory("Roskildevej", 100, 6, 30, 90, 270, 400, 550, 50, "pink");
		field[7] = new Chance();
		field[8] = new Territory("Valby Langgade", 100, 6, 30, 90, 270, 400, 550, 50, "pink");
		field[9] = new Territory("Allégade", 120, 8, 40, 100, 300, 450, 600, 50, "pink");
		field[10] = new VisitPrison("Jail");
		field[11] = new Territory("Fredriksberg Allé", 140, 10, 50, 150, 450, 625, 750, 100, "green");
		field[12] = new LaborCamp("Tuborg", 150, 4, dice);
		field[13] = new Territory("Bülowsvej", 140, 10, 50, 150, 450, 625, 750, 100, "green");
		field[14] = new Territory("Gl Kongevej", 160, 12, 60, 180, 500, 700, 900, 100, "green");
		field[15] = new Fleet("Mols-Linien",  200);
		field[16] = new Territory("Bernstorffsvej", 180, 14, 70, 200, 550, 750, 950, 100, "gray");
		field[17] = new Chance();
		field[18] = new Territory("Hellerupvej", 180, 14, 70, 200, 550, 750, 950, 100, "gray");
		field[19] = new Territory("Strandvej", 200, 16, 80, 220, 600, 800, 1000, 100, "gray");
		field[20] = new Refuge("Parkering");
		field[21] = new Territory("Trianglen", 220, 18, 90, 250, 700, 875, 1050, 150, "red");
		field[22] = new Chance();
		field[23] = new Territory("Østerbrogade", 220, 18, 90, 250, 700, 875, 1050, 150, "red");
		field[24] = new Territory("Grønningen", 240, 20, 100, 300, 750, 925, 1100, 150, "red");
		field[25] = new Fleet("Gedser-Rostock",  200);
		field[26] = new Territory("Bredgade", 260, 22, 110, 330, 800, 975, 1150, 150, "white");
		field[27] = new Territory("Kgs Nytorv", 260, 22, 110, 330, 800, 975, 1150, 150, "white");
		field[28] = new LaborCamp("Carlsberg", 150, 4, dice);
		field[29] = new Territory("Østergade", 280, 22, 90, 250, 700, 875, 1050, 150, "white");
		field[30] = new GoToPrison("Arrested");
		field[31] = new Territory("Amagertorv", 300, 26, 130, 390, 900, 1100, 1275, 200, "yellow");
		field[32] = new Territory("Vimmelskaftet", 300, 26, 130, 390, 900, 1100, 1275, 200, "yellow");
		field[33] = new Chance();
		field[34] = new Territory("Nygade", 320, 28, 150, 450, 1000, 1200, 1400, 200, "yellow");
		field[35] = new Fleet("Rødby-Puttgarden",  200);
		field[36] = new Chance();
		field[37] = new Territory("Frederiksberggade", 350, 35, 175, 500, 1100, 1300, 1500, 200, "purple");
		field[38] = new TaxStatic("Statsskat", 100);
		field[39] = new Territory("Rådhuspladsen", 400, 50, 200, 600, 1400, 1700, 2000, 200, "purple");
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
	public Fields[] getFields() {
		return field;
	}
	
	public boolean canPlayerBuyHouses(Player player) {
		Territory[] territory = new Territory[40];
		boolean x = false;
		for (int i = 0; i < field.length; i++) {
			if(field[i] instanceof Territory) {
				territory[i] = (Territory) field[i];
			}
		}
		if(territory[6].getOwner() == player && territory[8].getOwner() == player && territory[9].getOwner() == player) {
			x = true;
		}
		if(territory[1].getOwner() == player && territory[3].getOwner() == player) {
			x = true;
		}
		if(territory[11].getOwner() == player && territory[13].getOwner() == player && territory[14].getOwner() == player) {
			x = true;
		}
		if(territory[16].getOwner() == player && territory[18].getOwner() == player && territory[19].getOwner() == player) {
			x = true;
		}
		if(territory[21].getOwner() == player && territory[23].getOwner() == player && territory[24].getOwner() == player) {
			x = true;
		}
		if(territory[26].getOwner() == player && territory[27].getOwner() == player && territory[29].getOwner() == player) {
			x = true;
		}
		if(territory[31].getOwner() == player && territory[32].getOwner() == player && territory[34].getOwner() == player) {
			x = true;
		}
		if(territory[37].getOwner() == player && territory[39].getOwner() == player) {
			x = true;
		}

		return x;
		}
	
	public int getFieldNumberFromPropertyName(String propertyToHouse) {
		int fieldNumber = 0;
		for (int i = 0; i < field.length; i++) {
			if(field[i] instanceof Territory) {
				Territory territory;
				territory = (Territory) field[i];
				if (territory.getName().equals(propertyToHouse)) {
					fieldNumber = i;
				}
			}
		}		
		return fieldNumber;
	}
	
	
	public ArrayList<String> ReturnPropertiesHouseable(Player player) {
		ArrayList<String> houseable = new ArrayList<String>();
		Territory[] territory = new Territory[40];
		boolean x = false;
		for (int i = 0; i < field.length; i++) {
			if(field[i] instanceof Territory) {
				territory[i] = (Territory) field[i];
			}
		}
		if(territory[6].getOwner() == player && territory[8].getOwner() == player && territory[9].getOwner() == player) {
			houseable.add(territory[6].getName());
			houseable.add(territory[8].getName());
			houseable.add(territory[9].getName());
		}
		if(territory[1].getOwner() == player && territory[3].getOwner() == player) {
			houseable.add(territory[1].getName());
			houseable.add(territory[3].getName());
		}
		if(territory[11].getOwner() == player && territory[13].getOwner() == player && territory[14].getOwner() == player) {
			houseable.add(territory[11].getName());
			houseable.add(territory[13].getName());
			houseable.add(territory[14].getName());
		}
		if(territory[16].getOwner() == player && territory[18].getOwner() == player && territory[19].getOwner() == player) {
			houseable.add(territory[16].getName());
			houseable.add(territory[18].getName());
			houseable.add(territory[19].getName());
		}
		if(territory[21].getOwner() == player && territory[23].getOwner() == player && territory[24].getOwner() == player) {
			houseable.add(territory[21].getName());
			houseable.add(territory[23].getName());
			houseable.add(territory[24].getName());
		}
		if(territory[26].getOwner() == player && territory[27].getOwner() == player && territory[29].getOwner() == player) {
			houseable.add(territory[26].getName());
			houseable.add(territory[27].getName());
			houseable.add(territory[29].getName());
		}
		if(territory[31].getOwner() == player && territory[32].getOwner() == player && territory[34].getOwner() == player) {
			houseable.add(territory[31].getName());
			houseable.add(territory[32].getName());
			houseable.add(territory[34].getName());
		}
		if(territory[37].getOwner() == player && territory[39].getOwner() == player) {
			houseable.add(territory[37].getName());
			houseable.add(territory[39].getName());
		}

		return houseable;
	}
		
	
	public Player getOwnerOfTerritory(int fieldNumber) {
		Territory territory;
		territory = (Territory) getField(fieldNumber);
		Player owner = territory.getOwner();
		return owner;
	}

	public int getTerritoryHousePrice(int position) {
		Territory territory;
		territory = (Territory) getField(position);
		return territory.getHousePrice();		
	}
}
