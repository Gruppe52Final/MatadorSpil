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

public class TestPawningOfProperty {

	Dice dice = new Dice();
	Game game = new Game();
	Player[] players;
	Player player;
	Territory territory1;
	Territory territory2;
	GameBoard gameBoard = new GameBoard(dice);
	MatadorGUI gui = new MatadorGUI();
	PropertyController propertyController = new PropertyController();
	
	
	
	@Test
	public void test() {
		/**
		 * Test if player has option to pledge his property to bank for a specified value in the ownable constructor
		 * 
		 */
		players = new Player[2];
					
		players[0] = new Player("TestPlayer1");
		players[1] = new Player("TestPlayer2");	
		
		PlayerList playerList = new PlayerList(players);
		
		int startingCash = players[0].getScore();
		
		//Create territory objects
		territory1 = (Territory) gameBoard.getField(3);	
		
		//Makes player owner of territory and add those properties to his ownership list
		territory1.setOwner(players[0]);
		territory1.addProperty(players[0]);
		
		int pledge = territory1.getPledge();
		
		//Visual test, is player now given option to pawn property?
		propertyController.pledgeProperty(players[0], gameBoard);
				
		//Test if player is deposited the pledge
		assertEquals(players[0].getScore(), (startingCash + pledge));
		
		
		
	}

}

