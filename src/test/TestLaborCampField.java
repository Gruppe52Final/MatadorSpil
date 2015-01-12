package test;

import static org.junit.Assert.*;

import org.junit.Test;

import boundary.MatadorGUI;
import game.*;
import fields.*;
public class TestLaborCampField {

	@Test
	public void test() {
		
		Player playerBuy = new Player("TestLaborCampPlayer");
		Player playerLand = new Player("TestLaborCampLandingPlayer");
		Dice dice = new Dice();
		MatadorGUI gui = new MatadorGUI();
		int pay = 200;
		int rent = 100;
		LaborCamp laborCamp = new LaborCamp("LaborCamp", pay, rent, dice);
		int startingCash = playerBuy.account.getScore();

		Game game = new Game();
		
		gui.createField();
		
		//Test if player can buy LaborCamp
		laborCamp.landOnField(playerBuy);
		
		//Becomes owner ?
		assertEquals(laborCamp.getOwner(), playerBuy);
		
		//Subtracted price from his account ?		
		assertEquals(playerBuy.account.getScore(), (startingCash - pay));
		
		//Make another player land on LaborCamp
		laborCamp.landOnField(playerLand);
		
		dice.setDice1(6);
		dice.setDice2(6);
		
		game.movePlayer(playerLand, dice);
		
//		//Test if other players will pay correct rent
//		dice.setDice1(1);
//		dice.setDice2(1);
//		
		
	}

}
