package testProperty;

import static org.junit.Assert.assertEquals;
import fields.Refuge;
import fields.Territory;
import game.Dice;
import game.Game;
import game.GameBoard;
import game.Player;
import game.PlayerList;
import game.PropertyController;

import org.junit.Test;

import boundary.MatadorGUI;

public class TestPawnRent {

	Dice dice = new Dice();
	Game game = new Game();
	Player[] players;
	Player player;
	Territory territory1;
	Territory territory2;
	GameBoard gameBoard = new GameBoard(dice);
	MatadorGUI gui = new MatadorGUI();
	PropertyController propertyController = new PropertyController();
	Refuge refuge = new Refuge("Parking");

	
	
	@Test
	public void test() {
		/**
		 * Test if player has option to pledge his property to bank for a specified value in the ownable constructor
		 * 
		 */
		players = new Player[2];
					
		players[0] = new Player("TestOwningPlayer");
		players[1] = new Player("TestLandingPlayer");	
		
		PlayerList playerList = new PlayerList(players);
		
		int startingCash = players[0].getScore();
		
		//Create territory objects
		territory1 = (Territory) gameBoard.getField(3);	
		
		//Makes player owner of territory and add those properties to his ownership list
		territory1.setOwner(players[0]);
		territory1.addProperty(players[0]);
		
		
		//Visual test, is player now given option to pawn property?
		propertyController.pledgeProperty(players[0], gameBoard);
				
		//Make the non-owning player land on the field
		territory1.landOnField(players[1], refuge);
		
		//Test if player landing on the pledged property is NOT withdrawn the rent
		assertEquals(players[1].getScore(),1500);
		
		
		
		
	}

}

