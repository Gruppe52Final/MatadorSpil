package game;

import boundary.MatadorGUI;

public class PrisonController {
		private MatadorGUI gui;

		
	public PrisonController(MatadorGUI matadorGUI) {
		gui = matadorGUI;
//		this.currentPlayer = currentPlayer;
//		this.dice = dice;
	}
	
	
	public void prisonDialog(Player currentPlayer, Dice dice) {
		boolean payOutOfPrison = false;
		payOutOfPrison = gui.payOutOfPrison(currentPlayer);
		if(payOutOfPrison) {				
			//Check if player has enough money to actually pay himself out...	
			
			//If he has more than 100 points, let him out and subtract the points
			if (currentPlayer.getScore() >= 100) {
				currentPlayer.setPrisonTurns(0);
				//Subtract 100 points from players account
				currentPlayer.subtractPoints(100);	
				//Update GUI
				gui.updateBalance(currentPlayer);
				
				//If he doesn't have enough, tell him this in GUI.
				} else if (currentPlayer.getScore() < 100) {					
					gui.cantPayOutOfPrison(currentPlayer);
				}
			//If player chooses not to pay bail, or doesn't have enough money, we throw the dice.
			} else if(!payOutOfPrison || (currentPlayer.getScore() < 100)) {
				//Shows the dice on the GUI
				gui.showDice(dice.getDice1(), dice.getDice2());
				//If both dice are equal, he's out of prison
				if (dice.getDice1() == dice.getDice2()) {
					currentPlayer.setPrisonTurns(0);

				} else {
					currentPlayer.setPrisonTurns(currentPlayer.getPrisonTurns() - 1);
				}
			}
		}	
}
