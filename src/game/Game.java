//********************************************************************
//  Main.java       Authors: Group 57
//
//  The main class in CDIO part 2 to start and end the game
//********************************************************************

package game;


import desktop_resources.GUI;
import boundary.MatadorGUI;
import boundary.Texts;
import fields.Fields;
import fields.Territory;



public class Game {

	private int playerAmount = 0;
	private int passStartMoney = 200;
	private MatadorGUI gui = new MatadorGUI(); 
	private int lostCount = 0;
	private Dice dice = new Dice();
	private GameBoard gameboard;
	private boolean won = false;
	private Player currentPlayer;
	private PrisonController prisonController = new PrisonController(gui);
	private HouseController houseController;
	private Player[] players;	
	private PlayerList playerList;

	
	public Game() {
	gui.createField();	//Must be one of the first methods to call in GUI.jar

	String language = gui.selectLanguage();
 	if(language.equals("Dansk")) {
 		gui = new MatadorGUI("Dansk");
 		} else if(language.equals("English")) {
 			gui = new MatadorGUI("English");
		}
	 	gameboard = new GameBoard(dice); //If this is set earlier in class, Chance() will invoke an nullpointerError

	}

		
	public void init() {

	//Gets input from player actor outside system boundary
	playerAmount = gui.playerAmount();
	
	
	players = new Player[playerAmount];
	
	createPlayers();	
	
	playerList = new PlayerList(players);
	
	}
	
	public void createPlayers() {
		for (int i = 0; i < playerAmount; i++) {
			players[i] = new Player(GUI.getUserString(Texts.text[0]		//This GUI call should be in MatadorGUI, but not the creation of player object.
					+ (i + 1) + ":"));
		}
		gui.createPlayers(playerAmount, players);	

	}
	
	public void run() {
		

		// The game continues as long as won equals false
		while (!won) {
			//Goes through the player[]
			for (int i = 0; i < players.length; i++) {
				//If the player is not dead, he can have a turn!
				if (!players[i].getDeathStatus()) {
					
					//Sets currentPlayer object
					currentPlayer = players[i];
					
					//Shows message for the player having current turn, might have option to buy houses, or option to throw dice
					playerTurnMessage(currentPlayer, gameboard);
					
					//Throws dice in Dice class, meaning generating random numbers stored in Dice.
					dice.throwDice();							
					
					if(currentPlayer.getPrisonTurns() == 0) {
						movePlayer(currentPlayer, dice);
					}
					
					//Check if player passed start field, gives him passStartMoney in case
					checkIfPlayerPassedStart(currentPlayer, dice.getSum());
					
					if(currentPlayer.getPrisonTurns() > 0) {
						prisonController.prisonDialog(currentPlayer, dice);
					}				
			

					gameboard.landOnField(currentPlayer);

					// If a player has lost, adds one to lostCount and reset the players owned fields
					checkIfPlayerLost(currentPlayer);
			
					//Checks if one player has won in the player array
					checkIfPlayerWon(players);					

				}
			}
		}	
	}	
		
	public void playerTurnMessage(Player currentPlayer, GameBoard gameboard) {
			if(gameboard.canPlayerBuyHouses(currentPlayer)) {
				if(gui.optionToBuyHouse().equals("Køb hus")) {
					houseController = new HouseController(gui, gameboard, currentPlayer); //Sets variables for housecontroller to use
					houseController.buyHousesOption();	//Player is given option to buy houses if he has a group in same color
				}				
			} else if(gameboard.playerHasOwnable(currentPlayer)) { //If player has ownable, he gets option to sell it to another player
				String userOption = gui.sellPropertyOrThrowDice(currentPlayer);
					if(userOption.equals("Kast")) {
						//Does nothing, just continue back to game.run(), which will dice.Throw() next.
					} else if(userOption.equals("Sælg grund")) {
						sellProperty(currentPlayer, gameboard);
					}
			} else if(!gameboard.playerHasOwnable(currentPlayer)) {	//If player doesn't have ownable, he only has option to throw dice
				//Shows message for what player has turn
				gui.throwDiceOptionOnly(currentPlayer);
			}
	}
	
	private void sellProperty(Player currentPlayer, GameBoard gameboard) {
		//Lots of variables needed to sell
		String[] buyingPlayers = playerList.getBuyerNames(currentPlayer);
		String[] playerOwnedProperty = gameboard.getPlayerOwnableNames(currentPlayer);	
		String propertyToSell = gui.choosePropertyToSell(playerOwnedProperty);
		String buyingPlayerName = gui.choosePlayerToSellPropertyTo(buyingPlayers);
		Player buyingPlayer = playerList.getPlayerObjectFromString(buyingPlayerName);
		int price = gui.getSellingPropertySellingPrice();
		boolean confirmation = gui.askForPlayerConfirmation(buyingPlayer.getName(), propertyToSell, currentPlayer.getName(), price);
//		If the buying player has money and wants to buy, the transfer will be completed below
		if(confirmation && buyingPlayer.account.getScore() > price) {
			buyingPlayer.account.subtractPoints(price);
			currentPlayer.account.addPoints(price);
			gameboard.setOwner(buyingPlayer, propertyToSell);
			gui.sellConfirmation(currentPlayer.getName(), buyingPlayer.getName(), propertyToSell);
			gui.updateBalance(buyingPlayer);
			gui.updateBalance(currentPlayer);
		}
	}

	
	public void movePlayer(Player player, Dice dice) {
		//Shows the dice on the GUI
		gui.showDice(dice.getDice1(), dice.getDice2());

		//Updates the position variable inside player object
		player.addRollToPosition(dice.getSum());
		
		//Updates the position of the cars on GUI
		gui.updatePosition(player);		
		
	}

	
	public void checkIfPlayerLost( Player currentPlayer) {
		if (currentPlayer.getDeathStatus()) {
			//If the player is dead, remove them from the board and reset the fields owned
			gui.removePlayer(currentPlayer);			
			gameboard.resetOwnedFields(currentPlayer);
			lostCount++;
		}		
	}
	
	private void checkIfPlayerWon(Player[] players) {
		// If only one player is left, won is set to true
		if (lostCount == playerAmount - 1) {
			won = true;
			gui.showWin(players, playerAmount);
		}	
	}

	public void checkIfPlayerPassedStart(Player player, int diceSum) {
		if (!(diceSum + player.getPreviousPosition() == player.getPosition()) && (player.getPrisonTurns() == 0)) {
				player.account.addPoints(passStartMoney);
				gui.passedStart(player, passStartMoney);
				gui.updateBalance(player);	
			}
			
		}


	public void setPlayerList(PlayerList playerList2) {
		this.playerList = playerList2;
		
	}
}
