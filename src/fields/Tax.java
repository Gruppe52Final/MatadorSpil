package fields;

import boundary.MatadorGUI;
import game.Player;

public class Tax extends Fields {

	private String name;
	private int pay;
	private MatadorGUI out = new MatadorGUI();

	public Tax(String name, int pay) {
		this.name = name;
		this.pay = pay;
	}

	@Override
	public void landOnField(Player player) {
		if (name == "Statsskat") {
			if (player.account.getScore() >= pay) {
				player.account.addPoints(-pay);
			} else {
				out.fundsTooLowToPayTax();
				player.account.addPoints(-player.account.getScore());
				player.setDeathStatus();
			} 
		}
		
		if (name == "Indkomstskat") {
			String taxPick = out.taxPick(name);
			if (taxPick == "200") {
				if (player.account.getScore() >= pay) {
				player.account.addPoints(-pay);
			} else {
				out.fundsTooLowToPayTax();
				player.account.addPoints(-player.account.getScore());
				player.setDeathStatus();
			}
		} else {
			player.account.addPoints((int) -player.account.getScore() / 10);
		}
	}
		out.updateBalance(player.getName(), player.account.getScore());

	}
	@Override
	public String toString() {
		return "Type: Tax --- Name: " + name + " --- Tax: " + pay + "\n";
	}

}
