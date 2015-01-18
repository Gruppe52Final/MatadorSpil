package testHouseAndHotel;

import static org.junit.Assert.*;
import fields.Territory;
import game.Dice;
import game.Game;
import game.GameBoard;
import game.Player;

import org.junit.Test;

import boundary.MatadorGUI;

public class TestHousePricing {

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
		game.setPlayerAmount(2);		
		playerList = new Player[2];		
		playerList[0] = new Player("TestPlayer1");
		playerList[1] = new Player("TestPlayer2");		
		player = playerList[0];		
		player.setPosition(3);
		gui.setCars(playerList);
		
		//Makes player owner of territory and add those properties to his ownership list
		territory1 = (Territory) gameBoard.getField(3);	
		territory2 = (Territory) gameBoard.getField(1);	
		territory1.setOwner(player);
		territory2.setOwner(player);
		territory1.addProperty(player);
		territory2.addProperty(player);	
		
		
		//Check if player now has option to buy houses 
		game.playerTurnMessage(player, gameBoard);
		
		int startingCash = player.account.getScore();
		
		//Buy one house and check if price is deducted from his score
//		game.buyHouse(player);
		
//		assertEquals(player.account.getScore(),(startingCash - territory1.getHousePrice()));
		
		game.playerTurnMessage(player, gameBoard);
		
	}

}
