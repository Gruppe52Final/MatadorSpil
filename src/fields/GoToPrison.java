package fields;

import boundary.MatadorGUI;
import game.Player;

public class GoToPrison extends Fields {
	
	private String name;
	private MatadorGUI out = new MatadorGUI();
		
		public GoToPrison(String name) {
			this.name = name;
		}
	@Override
	public void landOnField(Player player) {
		out.goToPrisonMessage(name);
		player.setPosition(11);
		out.updatePosition(player);
		player.setPrisonTurns(3);
	}

	@Override
	public String toString() {
		return "Type: Jail --- Name: " + name + "\n";
	}

}
