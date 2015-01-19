package game;

import java.util.ArrayList;
import java.util.Arrays;

import boundary.MatadorGUI;

public class PlayerList {
	private Player[] players;
	private MatadorGUI gui = new MatadorGUI();
	
	public PlayerList(Player[] players) {
		this.players = players;
	}
	
	public String[] getPlayerNames() {
		ArrayList<String> listNames = new ArrayList<String>();
		for (int i = 0; i < players.length; i++) {
			listNames.add(players[i].getName());
		}
		
		int listSize = listNames.size();
		String stringListNames[] = listNames.toArray(new String[listSize]);
		return stringListNames;
	}

	public String[] getBuyerNames(Player sellingPlayer) {
		String[] buyingPlayers = new String[0];
		for (int i = 0; i < players.length; i++) {
			if (players[i].getName() != sellingPlayer.getName()) {
				buyingPlayers = addElement(buyingPlayers, players[i].getName());
			}
		}
		return buyingPlayers;
	}
	
	public String[] addElement(String[] input, String input1) {
		String[] temp;
		temp = Arrays.copyOf(input, input.length + 1);
		temp[temp.length - 1] = input1;
		return temp;
	}

	public Player getPlayerObjectFromString(String playerName) {
		Player returnPlayer = new Player("");
		for (int i = 0; i < players.length; i++) {
			if(players[i].getName() == playerName) {
				returnPlayer = players[i];
			}
		}
		return returnPlayer;
	}
	
	public boolean checkIfPlayerWon(Player[] players) {
		boolean won = false;
		int lostCount = 0;
		for (int i = 0; i < players.length; i++) {
			if(players[i].getDeathStatus()) {
				lostCount++;
			}
		}
		// If only one player is left, won is set to true
		if (lostCount == (players.length - 1)) {
			won = true;
			gui.showWin(players, players.length);
		}
		return won;
	}
	
	

}
