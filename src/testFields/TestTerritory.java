package testFields;

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
	
	Game game = new Game();
	Player player = new Player("TestTerritoryPlayer");
	Territory territory = new Territory("Valby Langgade", 100, 6, 30, 90, 270, 400, 550, 200, "pink");
	Refuge refuge = new Refuge("Parkering");
	LaborCamp laborCamp = new LaborCamp("Tuborg", 150, 100, dice);
	Player playerLanding = new Player("LandingOnTerritoryField");
	int startingCash = player.getScore();
	GameBoard gameBoard = new GameBoard(dice);
	
	@Test
	public void test() {
		
	
		//Test if player is deducted territory price when buying
		territory.landOnField(player, refuge);
		
		//Is he deducted the price?
		assertEquals(player.getScore(),(startingCash - territory.getPrice()));
		
		//Resets owner cash for testing
		player.setPoints(startingCash);
		
		//Test if player landing on the field has to pay rent
		territory.landOnField(playerLanding, refuge);
		
		//Is his account deducted the rent ?
		assertEquals(playerLanding.getScore(),(startingCash - territory.getBaseRent()));
		
		//Is the rent transfered to the other player?
		assertEquals(player.getScore(),(startingCash + territory.getBaseRent()));
		
		//Make sure player has no fleet or laborcamps when just buying territory
		assertEquals(player.getLaborCamp(),0);
		assertEquals(player.getFleets(),0);		
		
	}

}
