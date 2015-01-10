//********************************************************************
//  Dice.java       Authors: Group 57
//
//  A class to hold information and methods regarding the dice in CDIO part 2
//********************************************************************

package game;

public class Dice {
	private static final int SIDES_ON_DICE = 6;

	private int dice1;
	private int dice2;

	// Object that stores the value of the two dice
	public Dice() {
		dice1 = 0;
		dice2 = 0;
	}

	// Public set method that generates two random integers between 1 and 6
	public void throwDice() {
		dice1 = (int) (Math.random() * SIDES_ON_DICE + 1);
		dice2 = (int) (Math.random() * SIDES_ON_DICE + 1);
	}

	// Returns the sum of the two dice
	public int getSum() {
		return dice1 + dice2;
//		return 2; //Used for prison testing.. not the best way
	}

	// Method that returns dice1
	public int getDice1() {
		return dice1;
//		return 1; //Stupid prison testing ^^
	}

	// Method that return dice2
	public int getDice2() {
		return dice2;
//		return 1; //Lame prison testing
	}
	
	public void setDice1(int dice1) {
		this.dice1 = dice1;
	}
	
	public void setDice2(int dice2) {
		this.dice2 = dice2;
	}
	
}
