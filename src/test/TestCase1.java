package test;

import game.Player;
public class TestCase1 {

	public TestCase1() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		
		//Preconditions
		Player player = new Player("Test");
		player.addRollToPosition(18);
		
		
		//Test
		player.addRollToPosition(10);
		
		//Postconditions
		System.out.println("player.getPosition(): " + player.getPosition());
		if (player.getPosition() == 28)
			System.out.println("Postcondition 1: OK");
		else
			System.out.println("Postcondition 1: Fejl");
	}

}
