package testHouseAndHotel;

import fields.Territory;
import game.Dice;
import game.Game;
import game.GameBoard;
import game.Player;
import game.PlayerList;

import org.junit.Test;

import boundary.MatadorGUI;

public class TestHotelPurchase {

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
	
		
		//Makes player own Hvidovrevej and Rødovrevej
		territory1 = (Territory) gameBoard.getField(3);		
//		territory1.setOwner(player);		
		territory1.landOnField(player);
		territory2 = (Territory) gameBoard.getField(1);		
//		territory2.setOwner(player);
		territory2.landOnField(player);		
		territory1.addProperty(player);
		territory2.addProperty(player);		


		gui.setHouse(2, 4);
		territory1.setHouses(4);
		gui.setHouse(4, 4);
		territory2.setHouses(4);
		
		dice.setDice1(2);
		dice.setDice2(1);
		

		
		game.playerTurnMessage(player, gameBoard, playerList);
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

