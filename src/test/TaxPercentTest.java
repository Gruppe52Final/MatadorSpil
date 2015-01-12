package test;

import static org.junit.Assert.*;

import org.junit.Test;
import game.*;
import fields.*;
public class TaxPercentTest {

	@Test
	public void test() {
	
	int pay = 200;
	Player player = new Player("TestTaxPercent");
	TaxPercent taxPercent = new TaxPercent("TaxPercent", pay);
	int playerStartMoney = player.account.getScore();
	Game game = new Game();
	
	
	//Test if player is deducted 200 points by taxfield
	assertEquals(player.account.getScore(),playerStartMoney);

	//Initialize GUI

	
	//Choose 200 points
	taxPercent.landOnField(player);
	
	assertEquals(player.account.getScore(), playerStartMoney - pay);
	
//	Test if player pays 10% if he can't pay taxes for 200 points	
	player.account.setPoints(199);
	
	//Choose 200 points
	taxPercent.landOnField(player);

	
	//Are we actually deducting 10% of his score... ?
	
	player.account.setPoints(100);
	
	//Choose 10%
	taxPercent.landOnField(player);
	
	assertEquals(player.account.getScore(),90);
	
	
	
		
	}

}
