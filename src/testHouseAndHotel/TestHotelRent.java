package testHouseAndHotel;

import static org.junit.Assert.*;
import fields.Territory;
import game.Dice;
import game.Game;
import game.GameBoard;
import game.Player;
import game.PlayerList;

import org.junit.Test;

import boundary.MatadorGUI;

public class TestHotelRent {

	Dice dice = new Dice();
	Game game = new Game();
	Player[] playerListe;
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
		playerListe = new Player[2];		
		playerListe[0] = new Player("TestPlayer1");
		playerListe[1] = new Player("TestPlayer2");	
		PlayerList playerList = new PlayerList(playerListe);
		/**
		 * Test if player can buy a house on Rødovrevej and Hvidovrevej
		 */		
		//Sets variables needed for Game.java
			
		player = playerListe[0];	
		gui.setCars(playerListe);
		Player landingPlayer; 
		landingPlayer = playerListe[1];
		gui.setCars(playerListe);
		
		//Makes player own Hvidovrevej and Rødovrevej
		territory1 = (Territory) gameBoard.getField(3);		
//		territory1.setOwner(player);		
		territory1.landOnField(player);
		territory2 = (Territory) gameBoard.getField(1);		
//		territory2.setOwner(player);
		territory2.landOnField(player);
		
		
		territory1.addProperty(player);
		territory2.addProperty(player);		


		gui.setHotel(2, true);
		territory1.setHouses(5);
		gui.setHotel(4, true);
		territory2.setHouses(5);
		
		dice.setDice1(2);
		dice.setDice2(1);
		
		int rent = territory1.getRent();
		int startingCash = landingPlayer.getScore();
		
		game.playerTurnMessage(landingPlayer, gameBoard, playerList);
		game.movePlayer(landingPlayer, dice);
		
		gameBoard.landOnField(landingPlayer);
		
		//Has landingPlayer been deducted the amount?
		assertEquals(landingPlayer.getScore(), (startingCash - rent));
		
		//Has the owning player been deposited the amount?
		assertEquals(player.getScore(), (startingCash + rent));
		
		game.playerTurnMessage(landingPlayer, gameBoard, playerList);
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

