package testHouseAndHotel;

import fields.Territory;
import game.Dice;
import game.Game;
import game.GameBoard;
import game.Player;

import org.junit.Test;

import boundary.MatadorGUI;

public class TestHousePurchase {
	
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
	
		
		//Makes objects Hvidovrevej and Rødovrevej
		territory1 = (Territory) gameBoard.getField(3);		
		territory1.landOnField(player);
		territory2 = (Territory) gameBoard.getField(1);		
		territory2.landOnField(player);
		
		
		//Check if player now has option to buy houses 
//		gui.OptionToBuyHouse();
		game.nextPlayer(player, gameBoard);
		
//		Buy property 1
		dice.setDice1(1);
		dice.setDice2(0);
		
		game.movePlayer(player, dice);	
		gameBoard.landOnField(player);
		
		
//		Buy property 2
		dice.setDice1(1);
		dice.setDice2(1);
		
		game.movePlayer(player, dice);	
		gameBoard.landOnField(player);
		
		//Does player have option to buy houses now ?
		
		dice.setDice1(1);
		dice.setDice2(1);
		
		game.nextPlayer(player, gameBoard);
//		game.movePlayer(player, dice);	
//		gameBoard.landOnField(player);
		
		game.nextPlayer(player, gameBoard);
		game.nextPlayer(player, gameBoard);
		
		System.out.println(gameBoard.canPlayerBuyHouses(player));

		
		
		
		
		
		
	}

}
