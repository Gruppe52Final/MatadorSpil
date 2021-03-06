package testHouseAndHotel;

import static org.junit.Assert.assertEquals;
import fields.Territory;
import game.Dice;
import game.Game;
import game.GameBoard;
import game.Player;
import game.PlayerList;

import org.junit.Test;

import boundary.MatadorGUI;

public class testColorHousePurchase {
	
	Dice dice = new Dice();
	Game game = new Game();
	Player[] playerListe;
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
		playerListe = new Player[2];		
		playerListe[0] = new Player("TestPlayer1");
		playerListe[1] = new Player("TestPlayer2");		
		Player player1 = playerListe[0];		
		Player player2 = playerListe[1];
		gui.setCars(playerListe);
		PlayerList playerList = new PlayerList(playerListe);
		
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
		
		player2.setPosition(6);
		
		
		//Check if player now has option to buy houses - buy house on Roskilde
		game.playerTurnMessage(player1, gameBoard, playerList);
		
		
		int rent = territory1.getRent();
		int startingCash = player2.getScore();	
		
		
		game.playerTurnMessage(player2, gameBoard, playerList);


		
		gameBoard.landOnField(player2);
		
		//Has landingPlayer been deducted the amount?
		assertEquals(player2.getScore(), (startingCash - rent));
		
		//Has the owning player been deposited the amount?
		assertEquals(player1.getScore(), ((startingCash - territory1.getHousePrice()) + rent));
	}

}
