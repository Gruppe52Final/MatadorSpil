package fields;

import boundary.MatadorGUI;
import game.Player;


public class Refuge extends Fields {
	
private String name;
private int bonus;
private MatadorGUI out = new MatadorGUI();
	
	public Refuge(String name, int bonus) {
		this.name = name;
		this.bonus = bonus;
	}
	@Override
	public void landOnField(Player player) {
			out.bonusMessage(name, bonus);
			player.account.addPoints(bonus);
			out.updateBalance(player.getName(), player.account.getScore());
	}
	@Override
	public String toString() {
		return "Type: Refuge --- Name: " + name + " --- Bonus: " + bonus + "\n";
	}

}
