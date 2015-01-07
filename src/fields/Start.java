package fields;

import boundary.MatadorGUI;
import game.Player;

public class Start extends Fields {

	private String name;

	private MatadorGUI out = new MatadorGUI(); 

	public Start(String name) {
		this.name = name;
	}

	@Override
	public void landOnField(Player player) {
		out.startMessage(name);
	}
	@Override
	public String toString() {
		return "Type: Start --- Name: " + name + "\n";
	}
	
//	@Deprecated		//This variable was moved to Game.java instead
//	public int getStartPassMoney() {
//		return passStartMoney;
//	}

}
