package fields;

import boundary.MatadorGUI;
import game.Player;

public class TaxPercent extends Fields {
	
	private String name;
	private int pay;
	private MatadorGUI out = new MatadorGUI();

	public TaxPercent(String name, int pay) {
		this.name = name;
		this.pay = pay;
	}

	@Override
	public void landOnField(Player player) {
		String taxPick = out.taxPick(name);
		if (taxPick == "200") {
			if (player.account.getScore() >= pay) {
			player.account.addPoints(-pay);
		} else {
			out.fundsTooLowToPayTax();
			player.account.addPoints(-player.account.getScore());
			player.setDeathStatus(true);
		}
	} else {
		player.account.addPoints((int) -player.account.getScore() / 10);
		}
	}

	@Override
	public String toString() {
		return "Type: TaxPercent --- Name: " + name + " --- Tax: " + pay + "\n";
	}

}
