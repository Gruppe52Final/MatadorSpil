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
	Territory territory5;
	Territory territory6;
	
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
		Player player1 = playerList[0];		
		Player player2 = playerList[1];
		
		game.setPlayers(playerList);		
		game.setCars();	
		
//		Makes player owner of territory and add those properties to his ownership list
		territory1 = (Territory) gameBoard.getField(6);	
		territory2 = (Territory) gameBoard.getField(8);	
		territory3 = (Territory) gameBoard.getField(9);	
		territory4 = (Territory) gameBoard.getField(9);
		territory5 = (Territory) gameBoard.getField(1);	
		territory6 = (Territory) gameBoard.getField(3);

		territory1.setOwner(player1);
		territory2.setOwner(player1);
		territory3.setOwner(player1);
		territory5.setOwner(player1);
		territory6.setOwner(player1);
		territory1.addProperty(player1);
		territory2.addProperty(player1);
		territory3.addProperty(player1);		
		territory5.addProperty(player1);		
		territory6.addProperty(player1);
		
		


		/**
		 * Test if player landing on fields is deducted the correct rent
		 */
		
		player2.setPosition(9);
		
		System.out.println(player2.getPosition() + "player.getPosition 1st ");
		System.out.println(player2.getName());
		
		
		//Check if player now has option to buy houses - buy house on Roskilde
		game.nextPlayer(player2, gameBoard);
		
		System.out.println(player2.getPosition() + "player.getPosition 2nd ");
		System.out.println(player2.getName());

		
		int rent = territory1.getRent();
		int startingCash = player2.account.getScore();	
		
		
		game.nextPlayer(player2, gameBoard);


		
		gameBoard.landOnField(player2);
		
		//Has landingPlayer been deducted the amount?
		assertEquals(player2.account.getScore(), (startingCash - rent));
		
		//Has the owning player been deposited the amount?
		assertEquals(player1.account.getScore(), (startingCash + rent));
	}

}
