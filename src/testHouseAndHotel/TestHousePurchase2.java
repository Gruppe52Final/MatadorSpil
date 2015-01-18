package testHouseAndHotel;

import static org.junit.Assert.*;
import fields.Territory;
import game.Dice;
import game.Game;
import game.GameBoard;
import game.Player;

import org.junit.Test;

import boundary.MatadorGUI;

public class TestHousePurchase2 {
	
	Dice dice = new Dice();
	Game game = new Game();
	Player[] playerList;
	Player player;
	Territory territory1;
	Territory territory2;
	Territory territory3;
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
		gui.setCars(playerList);
		
		//Makes objects Hvidovrevej and Rødovrevej
		territory1 = (Territory) gameBoard.getField(21);		
		territory1.landOnField(player);
		territory2 = (Territory) gameBoard.getField(23);		
		territory2.landOnField(player);
		territory3 = (Territory) gameBoard.getField(24);		
		territory3.landOnField(player);
		
		//Check if player now has option to buy houses 
		game.playerTurnMessage(player, gameBoard);
		
//		Buy property 1
		dice.setDice1(20);
		dice.setDice2(1);
		
		game.movePlayer(player, dice);	
		gameBoard.landOnField(player);
		
		
//		Buy property 2
		dice.setDice1(1);
		dice.setDice2(1);
		
		game.movePlayer(player, dice);	
		gameBoard.landOnField(player);
		
		
//		Buy property 3
		dice.setDice1(1);
		dice.setDice2(0);
		
		game.movePlayer(player, dice);	
		gameBoard.landOnField(player);
		
		//Does player have option to buy houses now ?
		
		dice.setDice1(1);
		dice.setDice2(0);
		
		game.playerTurnMessage(player, gameBoard);
//		game.movePlayer(player, dice);	
//		gameBoard.landOnField(player);
		
		game.playerTurnMessage(player, gameBoard);
		game.playerTurnMessage(player, gameBoard);
		
		System.out.println(gameBoard.canPlayerBuyHouses(player));

		
		
		
		
		
		
	}

}
