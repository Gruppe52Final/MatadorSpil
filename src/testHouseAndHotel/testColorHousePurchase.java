package testHouseAndHotel;

import static org.junit.Assert.*;
import fields.Territory;
import game.Dice;
import game.Game;
import game.GameBoard;
import game.Player;

import org.junit.Test;

import boundary.MatadorGUI;

public class testColorHousePurchase {
	
	Dice dice = new Dice();
	Game game = new Game();
	Player[] playerList;
	Player player;
	Territory territory1;
	Territory territory2;
	Territory territory3;
	Territory territory4;
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
		game.setPlayers(playerList);		
		game.setCars();	
		player.setPosition(3);
		
//		Makes player owner of territory and add those properties to his ownership list
		territory1 = (Territory) gameBoard.getField(6);	
		territory2 = (Territory) gameBoard.getField(8);	
		territory3 = (Territory) gameBoard.getField(9);	
		territory4 = (Territory) gameBoard.getField(9);

		territory1.setOwner(player);
		territory2.setOwner(player);
		territory3.setOwner(player);
		territory1.addProperty(player);
		territory2.addProperty(player);
		territory3.addProperty(player);		
		territory1.landOnField(player);
		territory2.landOnField(player);
		territory3.landOnField(player);
		
		
		
		//Check if player now has option to buy houses 
		game.nextPlayer(player, gameBoard);
		
		int startingCash = player.account.getScore();
		
		game.nextPlayer(player, gameBoard);
		game.nextPlayer(player, gameBoard);

		game.nextPlayer(player, gameBoard);

		
		//Buy one house and check if price is deducted from his score
//		game.buyHouse(player);
		
//		assertEquals(player.account.getScore(),(startingCash - territory1.getHousePrice()));
//		
//		game.nextPlayer(player);
	}

}
