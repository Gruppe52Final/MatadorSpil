package game;

import boundary.MatadorGUI;

public class PassStartCheck {
	
	private int passStartMoney = 200;
	private MatadorGUI gui = new MatadorGUI();
	
	public void checkIfPlayerPassedStart(Player player, int diceSum) {
		if (!(diceSum + player.getPreviousPosition() == player.getPosition()) && (player.getPrisonTurns() == 0)) {
				player.account.addPoints(passStartMoney);
				gui.passedStart(player, passStartMoney);
				gui.updateBalance(player);	
			}			
		}
	
}
