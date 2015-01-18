package testSellProperty;

import static org.junit.Assert.*;
import fields.Territory;
import game.Dice;
import game.Game;
import game.GameBoard;
import game.Player;

import org.junit.Test;

import boundary.MatadorGUI;

public class TestPlayerHasOwnable {

	Dice dice = new Dice();
	Game game = new Game();
	Player[] playerList;
	Player player;
	Territory territory1;
	Territory territory2;
	GameBoard gameBoard = new GameBoard(dice);
	MatadorGUI gui = new MatadorGUI();
	
	
	@Test
	public void test() {
	
		/**
		 * Test if player can buy a house on Rødovrevej and Hvidovrevej
		 */		
		//Sets variables needed for Game.java
		playerList = new Player[2];		
		playerList[0] = new Player("TestPlayer1");
		playerList[1] = new Player("TestPlayer2");		
		player = playerList[0];		
		Player landingPlayer; 
		landingPlayer = playerList[1];
		gui.setCars(playerList);	
		
		//Create territory objects
		territory1 = (Territory) gameBoard.getField(3);	
		territory2 = (Territory) gameBoard.getField(1);	
		
		//Makes player owner of territory and add those properties to his ownership list
		territory1.setOwner(player);
		territory2.setOwner(player);
		territory1.addProperty(player);
		territory2.addProperty(player);	
		
		//Does gameboard see player has an ownable?
		assertEquals(gameBoard.playerHasOwnable(player),true);

		
		
		
		
		
	}

}

