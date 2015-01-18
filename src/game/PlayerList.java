package game;

import java.util.ArrayList;

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

}
