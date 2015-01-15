package test;

import static org.junit.Assert.*;
import fields.Territory;
import game.Dice;
import game.Game;
import game.GameBoard;
import game.Player;

import org.junit.Test;

import boundary.MatadorGUI;

public class TestHouseRent {

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
		Player landingPlayer; 
		landingPlayer = playerList[1];
		game.setPlayers(playerList);		
		game.setCars();		
	
		
		//Makes player own Hvidovrevej and Rødovrevej
		territory1 = (Territory) gameBoard.getField(3);		
//		territory1.setOwner(player);		
		territory1.landOnField(player);
		territory2 = (Territory) gameBoard.getField(1);		
//		territory2.setOwner(player);
		territory2.landOnField(player);
		
//		
//		//Check if player now has option to buy houses 
////		gui.OptionToBuyHouse();
//		game.nextPlayer(player);
//		
////		Buy property 1
//		dice.setDice1(1);
//		dice.setDice2(0);
//		
//		game.movePlayer(player, dice);	
//		gameBoard.landOnField(player);
//		
//		
////		Buy property 2
//		dice.setDice1(1);
//		dice.setDice2(1);
//		
//		game.movePlayer(player, dice);	
//		gameBoard.landOnField(player);
//		
//		//Does player have option to buy houses now ?
//		
//		dice.setDice1(1);
//		dice.setDice2(1);
//		
//		game.nextPlayer(player);
////		game.movePlayer(player, dice);	
////		gameBoard.landOnField(player);
		
		
		
		territory1.addProperty(player);
		territory2.addProperty(player);		


		gui.setHouse(2, 4);
		territory1.setHouses(4);
		gui.setHouse(4, 4);
		territory2.setHouses(4);
		
		dice.setDice1(2);
		dice.setDice2(1);
		
		int rent = territory1.getRent();
		int startingCash = landingPlayer.account.getScore();
		
		game.nextPlayer(landingPlayer);
		game.movePlayer(landingPlayer, dice);
		
		gameBoard.landOnField(landingPlayer);
		
		//Has landingPlayer been deducted the amount?
		assertEquals(landingPlayer.account.getScore(), (startingCash - rent));
		
		//Has the owning player been deposited the amount?
		assertEquals(player.account.getScore(), (startingCash + rent));
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

