package fields;

import boundary.MatadorGUI;
import game.Player;

public class VisitPrison extends Fields {

	private String name;
	private MatadorGUI out = new MatadorGUI();
		
		public VisitPrison(String name) {
			this.name = name;
		}
		@Override
		public void landOnField(Player player) {
			if(player.getPrisonTurns() == 0) {
				out.visitPrisonMessage();
			} else if(player.getPrisonTurns() > 0) {
				out.inPrisonMessage();
			}
		}
		@Override
		public String toString() {
			return "Type: Jail --- Name: " + name + "\n";
		}
	}
