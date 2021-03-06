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
		if (player.getScore() >= pay) {
			out.taxPay(name);
			player.addPoints(-pay);
		} else {
			out.fundsTooLowToPayTax();
			player.addPoints(-player.getScore());
			player.setDeathStatus(true);
		}
		out.updateBalance(player);
	}

	@Override
	public String toString() {
		return "Type: TaxStatic --- Name: " + name + " --- Tax: " + pay + "\n";
	}
	
}
