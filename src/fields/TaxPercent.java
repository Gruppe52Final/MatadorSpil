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
		if (taxPick.equals("200")) {
			if (player.getScore() >= pay) {	
			player.subtractPoints(pay);
			} else if (player.getScore() < pay) {
				out.fundsTooLowToPayTax();
				taxPick = "10%";
				}			
		}
		if (taxPick.equals("10%")) {
			player.subtractPoints((int) (player.getScore() * 0.1));
			out.updateBalance(player);
		}
	}
	

	@Override
	public String toString() {
		return "Type: TaxPercent --- Name: " + name + " --- Tax: " + pay + "\n";
	}

}
