package fields;

import boundary.MatadorGUI;
import game.Player;

public class TaxStatic extends Fields {
	
	private String name;
	private int pay;
	private MatadorGUI out = new MatadorGUI();

	public TaxStatic(String name, int pay) {
		this.name = name;
		this.pay = pay;
	}

	@Override
	public void landOnField(Player player) {
		if (player.account.getScore() >= pay) {
			player.account.addPoints(-pay);
		} else {
			out.fundsTooLowToPayTax();
			player.account.addPoints(-player.account.getScore());
			player.setDeathStatus(true);
		}
		out.updateBalance(player.getName(), player.account.getScore());
	}

	@Override
	public String toString() {
		return "Type: TaxStatic --- Name: " + name + " --- Tax: " + pay + "\n";
	}
	
}
