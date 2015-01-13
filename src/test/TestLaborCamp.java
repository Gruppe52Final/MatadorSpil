package test;

import static org.junit.Assert.*;

import org.junit.Test;

import fields.Fleet;
import fields.LaborCamp;
import fields.Refuge;
import fields.Territory;
import game.Dice;
import game.Game;
import game.GameBoard;
import game.Player;

public class TestLaborCamp {
	
	Dice dice = new Dice();
	GameBoard gameBoard = new GameBoard(dice);
	Game game = new Game();
	Player player = new Player("TestParkingPlayer");
	Territory territory;
	Refuge refuge = new Refuge("Parkering");
	LaborCamp laborCamp = new LaborCamp("Tuborg", 150, 100, dice);
	Player playerLanding = new Player("LandingOnFleetField");
	int startingCash = player.account.getScore();
	

	@Test
	public void test() {
		
		laborCamp.landOnField(player,refuge);
		
		
		//Check player has been deducted laborCamp cost
		assertEquals(player.account.getScore(), startingCash - laborCamp.getPrice());
		
		
	}

}
