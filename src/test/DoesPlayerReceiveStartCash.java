package test;

import static org.junit.Assert.*;
import fields.Start;
import game.Dice;
import game.Game;
import game.GameBoard;

import org.junit.Test;

import game.Player;

public class DoesPlayerReceiveStartCash {
	
	Player player = new Player("TestStartCash");
	Dice dice = new Dice();
	int startCash = player.getScore();
	int passStartMoney = 4000;
	int diceSum = 0;
	
	@Test
	public void test() {
		
		//Make sure player starts at field 0 (start), with starting cash,
		//Make sure player hasn't received the start field pass money yet!
		
		player.addRollToPosition(0);
		assertEquals(player.getPosition(),0);
		assertEquals(player.getScore(), startCash);
		
		//Now lets make the player pass the start field
		
		//First we set player very close to the start field 
		player.addRollToPosition(38);
		
		dice.throwDice();
		
		diceSum = dice.getSum();
		
		checkIfPlayerPassedStart(player, diceSum); //This should transfer money to player

		assertEquals(player.getScore(), startCash + passStartMoney);
	}

	private void checkIfPlayerPassedStart(Player player, int diceSum) {
		player.getPreviousPosition();
		if (!(diceSum + player.getPreviousPosition() == player.getPosition())) {
			player.addPoints(passStartMoney);
		}		
	}
}
