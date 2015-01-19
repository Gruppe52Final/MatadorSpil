package testProperty;

import fields.Territory;
import game.Dice;
import game.Game;
import game.GameBoard;
import game.Player;
import game.PlayerList;
import game.PropertyController;

import org.junit.Test;

import boundary.MatadorGUI;

public class TestSellPropertyVisual {

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
		 * Test if player has option to sell property if he owns just one territory
		 * Also testing if he is excluded from list of possible buyers...
		 */
		players = new Player[2];
					
		players[0] = new Player("TestPlayer1");
		players[1] = new Player("TestPlayer2");	
		
		PlayerList playerList = new PlayerList(players);
		

		
		//Create territory objects
		territory1 = (Territory) gameBoard.getField(3);	
//		territory2 = (Territory) gameBoard.getField(1);	
		
		//Makes player owner of territory and add those properties to his ownership list
		territory1.setOwner(players[0]);
//		territory2.setOwner(player);
		territory1.addProperty(players[0]);
//		territory2.addProperty(player);	
		
		//Visual test, is player now given option to sell property?
		propertyController.sellProperty(players[0], gameBoard, playerList);

		
		
	}

}

