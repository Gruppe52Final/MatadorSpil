package testHouseAndHotel;

import static org.junit.Assert.*;
import fields.Territory;
import game.Dice;
import game.Game;
import game.GameBoard;
import game.Player;

import org.junit.Test;

import boundary.MatadorGUI;

public class TestHotelPurchase {

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
		game.setPlayers(playerList);		
		game.setCars();		
	
		
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
		

		
		game.nextPlayer(player);
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

