package test;

import static org.junit.Assert.*;

import org.junit.Test;

import fields.LaborCamp;
import fields.Refuge;
import fields.Territory;
import game.Dice;
import game.Game;
import game.GameBoard;
import game.Player;

public class TestTerritory {

	
	Dice dice = new Dice();
	GameBoard gameBoard = new GameBoard(dice);
	Game game = new Game();
	Player player = new Player("TestTerritoryPlayer");
	Territory territory = new Territory("Valby Langgade", 100, 6);
	Refuge refuge = new Refuge("Parkering");
	LaborCamp laborCamp = new LaborCamp("Tuborg", 150, 100, dice);
	Player playerLanding = new Player("LandingOnTerritoryField");
	int startingCash = player.account.getScore();
	
	@Test
	public void test() {
		
//		territory.setOwner(player);
		
		//Test if player is deducted territory price when buying
		territory.landOnField(player, refuge);
		
		//Is he deducted the price?
		assertEquals(player.account.getScore(),(startingCash - territory.getPrice()));
		
		//Resets owner cash for testing
		player.account.setPoints(startingCash);
		
		//Test if player landing on the field has to pay rent
		territory.landOnField(playerLanding, refuge);
		
		//Is his account deducted the rent ?
		assertEquals(playerLanding.account.getScore(),(startingCash - territory.getRent()));
		
		//Is the rent transfered to the other player?
		assertEquals(player.account.getScore(),(startingCash + territory.getRent()));
		
		
	}

}
