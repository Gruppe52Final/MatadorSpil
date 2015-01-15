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

public class TestLaborCamp {
	
	Dice dice = new Dice();
	Game game = new Game();
	Player player1 = new Player("TestParkingPlayer");
	Player player2 = new Player("TestRent");
	Territory territory;
	Refuge refuge = new Refuge("Parkering");
	LaborCamp laborCamp1 = new LaborCamp("Tuborg", 150, 100, dice);
	LaborCamp laborCamp2 = new LaborCamp("Carlsberg", 150, 100, dice);
	GameBoard gameBoard = new GameBoard(dice);
	
	@Test
	public void test() {
		
		player2.account.setPoints(5000);
		int startingCash = player1.account.getScore();
		int startingCashAgain = player2.account.getScore();
		dice.throwDice();
		
		laborCamp1.landOnField(player1,refuge);
		int fullRent1 = laborCamp1.getRent()  * dice.getSum() * player1.getLaborCamp();
		
		assertNotEquals(fullRent1,0);
		
		//Check player has been deducted laborCamp cost
		assertEquals(player1.account.getScore(), startingCash - laborCamp1.getPrice());
		
		laborCamp1.landOnField(player2,refuge);
		
		//Test om playeren bliver fratrukket det korrekte rent
		assertEquals(player2.account.getScore(), startingCashAgain - fullRent1);
		assertEquals(player1.account.getScore(), startingCash - laborCamp1.getPrice() + fullRent1);
		
		laborCamp2.landOnField(player1,refuge);
		laborCamp2.landOnField(player2,refuge);
		
		int fullRent2 = laborCamp1.getRent()  * dice.getSum() * player1.getLaborCamp();
		int newCash1 = startingCash - laborCamp1.getPrice() + fullRent1 - laborCamp2.getPrice();
		int newCash2 = startingCashAgain - fullRent1;
		
		assertEquals(player2.account.getScore(), newCash2 - fullRent2);
		assertEquals(player1.account.getScore(), newCash1 + fullRent2);
		
	}

}
