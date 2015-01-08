package fields;

import boundary.MatadorGUI;
import game.Player;

public class VisitPrison extends Fields {

	private String name;
	private int bonus;
	private MatadorGUI out = new MatadorGUI();
		
		public VisitPrison(String name) {
			this.name = name;
		}
		@Override
		public void landOnField(Player player) {
				out.prisonMessage(name);
		}
		@Override
		public String toString() {
			return "Type: Refuge --- Name: " + name + " --- Bonus: " + bonus + "\n";
		}
	}
