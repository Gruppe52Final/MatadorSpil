package game;

import java.util.ArrayList;
import java.util.Arrays;

public class PlayerList {
	private Player[] players;
	
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
	
	

}
