//********************************************************************
//  Player.java       Authors: Group 57
//
//  A class to hold information and methods regarding the player in CDIO part 3
//********************************************************************

package game;

public class Player {
	private String name;
	private int position, fleets, laborCamp;
	private int prisonTurns;
	private boolean dead;
	public Account account = new Account();
	private int previousPosition;
	private boolean justOutOfPrison;
	private String[] propertiesOwned;
	private boolean[] fieldsOwned;
	String[] colorsOwned;

	// Object that stores the name and position of a player
	public Player(String name) {
		previousPosition = 0;
		position = 0;
		fleets = 0;
		laborCamp = 0;
		prisonTurns = 0;
		dead = false;
		this.name = name;
		propertiesOwned = new String[2];
		propertiesOwned[0] = "";
		propertiesOwned[1] = "";
	}

	// Method that returns the name of the player
	public String getName() {
		return name;
	}

	// Method that sets the position of the player
	public void addRollToPosition(int roll) {
		previousPosition = position;		
		if (position + roll > 39) {
			position = position + roll - 40;
		} else {
			position += roll;
		}
	}
	// Method that returns the position of the player
	public int getPosition() {
		return position;
	}
	// Adds a fleet to the players owned fleets
	public void addFleet() {
		fleets++;
	}
	// Returns the number of the players owned fleets
	public int getFleets() {
		return fleets;
	}
	
	public String[] getPropertiesOwned() {
		return propertiesOwned;
	}
	
	public void addLaborCamp(){
		laborCamp++;
	}
	public int getLaborCamp(){
		return laborCamp;
	}
	public void setPrisonTurns(int prisonTurns){
		this.prisonTurns = prisonTurns;
	}
	public int getPrisonTurns(){
		return prisonTurns;
	}
	public void setDeathStatus(boolean deathStatus) {
		dead = deathStatus;
	}
	public boolean getDeathStatus() {
		return dead;
	}

	public int getPreviousPosition() {
		return previousPosition;
		
	}

	public void setPosition(int i) {
		position = i;		
	}
@Deprecated
	public void setJustOutOfPrison(boolean b) {
		justOutOfPrison = b;
		
	}
@Deprecated
	public boolean getJustOutOfPrison() {
		return justOutOfPrison;
	}

	public boolean canBuyHouses() {
		boolean x = false;
		int group = 0;
	for (int i = 0; i < propertiesOwned.length; i++) {
		if(propertiesOwned[i].equals("Rødovrevej")) {
			group++;
		} 
			else if(propertiesOwned[i].equals("Hvidovrevej")){
				group++;
			}
		}
	if(group ==2) {
		x =true;
	}
		
		
//	int TwoProperties = 0;
//	int ThreeProperties = 0;
//	for (int i = 0; i < colorsOwned.length; i++) {
//		if(colorsOwned[i].equals("blue") || colorsOwned[i].equals("purple")) {
//			TwoProperties++;
//		} else if(colorsOwned)
//	}	
	
		
	return x;
	}

	public void addProperty(String nameOfProperty) {		
		for (int i = 0; i < propertiesOwned.length; i++) {
			if(propertiesOwned[i].equals("")) {
				propertiesOwned[i] = nameOfProperty;
				break;
			}
		}
	}

	public void addColor(String color) {
		for (int i = 0; i < colorsOwned.length; i++) {
			if(colorsOwned[i].equals("")) {
				colorsOwned[i] = color;
				break;
			}
		}
		
	}

	public void addFieldNumberOwned() {
		// TODO Auto-generated method stub
		
	}
	
}
