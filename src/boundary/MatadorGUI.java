package boundary;

import java.awt.Color;

import desktop_codebehind.Car;
import desktop_fields.Brewery;
import desktop_fields.Field;
import desktop_fields.Refuge;
import desktop_fields.Shipping;
import desktop_fields.Start;
import desktop_fields.Street;
import desktop_fields.Tax;
import desktop_resources.GUI;
import game.Player;

public class MatadorGUI {
	//Game methods
	public void createField() {
		// Array that holds the fields for the GUI
		Field[] field = new Field[40];
		field[0] = new Start.Builder().setTitle("Start")
				.setDescription("Start").setSubText("Start")
				.setBgColor(Color.RED).build();
		field[1] = new Street.Builder().setTitle("Rødovrevej")
				.setDescription("Tribe Encampment").setBgColor(Color.CYAN)
				.setSubText("Price: 1000").setRent("Rent: 100").build();
		field[2] = new Tax.Builder().setTitle("Prøv Lykken")
				.setDescription("Prøv Lykken").setBgColor(Color.ORANGE)
				.setSubText("Pay: 2000").build();
		field[3] = new Street.Builder().setTitle("Hvidovrevej")
				.setDescription("Hvidovrevej").setBgColor(Color.CYAN)
				.setSubText("Price: 1500").setRent("Rent: 300").build();
		field[4] = new Tax.Builder().setTitle("Indkomstskat")
				.setDescription("Pay: 4000 or 10%").setBgColor(Color.ORANGE)
				.setSubText("Pay: 4000 or 10%").build();
		field[5] = new Shipping.Builder().setTitle("Helsingør-Helsingborg")
				.setDescription("Helsingør-Helsingborg").setBgColor(Color.GRAY)
				.setSubText("Price: 4000").setRent("Rent: 500").build();
		field[6] = new Street.Builder().setTitle("Roskildevej")
				.setDescription("Roskildevej").setBgColor(Color.CYAN)
				.setSubText("Price: 1500").setRent("Rent: 300").build();
		field[7] = new Street.Builder().setTitle("Prøv Lykken")
				.setDescription("Prøv Lykken").setBgColor(Color.CYAN)
				.setSubText("Price: 3000").setRent("Rent: 700").build();
		field[8] = new Street.Builder().setTitle("Valby Langgade")
				.setDescription("Valby Langgade").setBgColor(Color.CYAN)
				.setSubText("Price: 3000").setRent("Rent: 700").build();
		field[9] = new Street.Builder().setTitle("Allégade")
				.setDescription("Allégade").setBgColor(Color.CYAN)
				.setSubText("Price: 4000").setRent("Rent: 1000").build();
		field[10] = new Refuge.Builder().setTitle("Fængsel")
				.setDescription("Fængsel").setBgColor(Color.MAGENTA)
				.setSubText("Recieve: 500").build();
		field[11] = new Street.Builder().setTitle("Fredriksberg Allé")
				.setDescription("Fredriksberg Allé").setBgColor(Color.CYAN)
				.setSubText("Price: 4300").setRent("Rent: 1300").build();
		field[12] = new Brewery.Builder().setTitle("Tuborg")
				.setDescription("Tuborg").setBgColor(Color.GREEN)
				.setSubText("Price: 2500").setRent("100 x dice").build();
		field[13] = new Street.Builder().setTitle("Bülowsvej")
				.setDescription("Bülowsvej").setBgColor(Color.CYAN)
				.setSubText("Price: 4750").setRent("Rent: 1600").build();
		field[14] = new Street.Builder().setTitle("Gl Kongevej")
				.setDescription("Gl Kongevej").setBgColor(Color.CYAN)
				.setSubText("Price: 4750").setRent("Rent: 1600").build();
		field[15] = new Shipping.Builder().setTitle("Mols-Linien")
				.setDescription("Mols-Linien").setBgColor(Color.GRAY)
				.setSubText("Price: 4000").setRent("Rent: 500").build();
		field[16] = new Street.Builder().setTitle("Bernstorffsvej")
				.setDescription("Bernstorffsvej").setBgColor(Color.CYAN)
				.setSubText("Price: 4750").setRent("Rent: 1600").build();
		field[17] = new Street.Builder().setTitle("Prøv Lykken")
				.setDescription("Prøv Lykken").setBgColor(Color.CYAN)
				.setSubText("Price: 5500").setRent("Rent: 2600").build();
		field[18] = new Street.Builder().setTitle("Hellerupvej")
				.setDescription("Hellerupvej").setBgColor(Color.CYAN)
				.setSubText("Price: 5500").setRent("Rent: 2600").build();
		field[19] = new Street.Builder().setTitle("Strandvejen")
				.setDescription("Strandvejen").setBgColor(Color.CYAN)
				.setSubText("Price: 6000").setRent("Rent: 3200").build();
		field[20] = new Refuge.Builder().setTitle("Parkering")
				.setDescription("Parkering").setBgColor(Color.MAGENTA)
				.setSubText("Recieve: 5000").build();
		field[21] = new Street.Builder().setTitle("Trianglen")
				.setDescription("Trianglen").setBgColor(Color.CYAN)
				.setSubText("Price: 8000").setRent("Rent: 4000").build();
		field[22] = new Street.Builder().setTitle("Prøv Lykken")
				.setDescription("Prøv Lykken").setBgColor(Color.CYAN)
				.setSubText("Price: 5500").setRent("Rent: 2600").build();
		field[23] = new Street.Builder().setTitle("Østerbrogade")
				.setDescription("Østerbrogade").setBgColor(Color.CYAN)
				.setSubText("Price: 8000").setRent("Rent: 4000").build();
		field[24] = new Street.Builder().setTitle("Grønningen")
				.setDescription("Grønningen").setBgColor(Color.CYAN)
				.setSubText("Price: 8000").setRent("Rent: 4000").build();
		field[25] = new Shipping.Builder().setTitle("Gedser-Rostock")
				.setDescription("Gedser-Rostock").setBgColor(Color.GRAY)
				.setSubText("Price: 4000").setRent("Rent: 500").build();
		field[26] = new Street.Builder().setTitle("Bredgade")
				.setDescription("Bredgade").setBgColor(Color.CYAN)
				.setSubText("Price: 8000").setRent("Rent: 4000").build();
		field[27] = new Street.Builder().setTitle("Kgs Nytorv")
				.setDescription("Kgs Nytorv").setBgColor(Color.CYAN)
				.setSubText("Price: 8000").setRent("Rent: 4000").build();
		field[28] = new Brewery.Builder().setTitle("Coca-Cola")
				.setDescription("Coca-Cola").setBgColor(Color.GREEN)
				.setSubText("Price: 2500").setRent("100 x dice").build();
		field[29] = new Street.Builder().setTitle("Østergade")
				.setDescription("Østergade").setBgColor(Color.CYAN)
				.setSubText("Price: 8000").setRent("Rent: 4000").build();
		field[30] = new Refuge.Builder().setTitle("De Fængsles")
				.setDescription("De Fængsles").setBgColor(Color.MAGENTA)
				.setSubText("Recieve: 500").build();
		field[31] = new Street.Builder().setTitle("Amagertorv")
				.setDescription("Amagertorv").setBgColor(Color.CYAN)
				.setSubText("Price: 8000").setRent("Rent: 4000").build();
		field[32] = new Street.Builder().setTitle("Vimmelskaftet")
				.setDescription("Vimmelskaftet").setBgColor(Color.CYAN)
				.setSubText("Price: 8000").setRent("Rent: 4000").build();
		field[33] = new Street.Builder().setTitle("Prøv Lykken")
				.setDescription("Prøv Lykken").setBgColor(Color.CYAN)
				.setSubText("Price: 5500").setRent("Rent: 2600").build();
		field[34] = new Street.Builder().setTitle("Nygade")
				.setDescription("Nygade").setBgColor(Color.CYAN)
				.setSubText("Price: 8000").setRent("Rent: 4000").build();
		field[35] = new Shipping.Builder().setTitle("Rødby-Puttgarden")
				.setDescription("Rødby-Puttgarden").setBgColor(Color.GRAY)
				.setSubText("Price: 4000").setRent("Rent: 500").build();
		field[36] = new Street.Builder().setTitle("Prøv Lykken")
				.setDescription("Prøv Lykken").setBgColor(Color.CYAN)
				.setSubText("Price: 5500").setRent("Rent: 2600").build();
		field[37] = new Street.Builder().setTitle("Frederiksberggade")
				.setDescription("Frederiksberggade").setBgColor(Color.CYAN)
				.setSubText("Price: 5500").setRent("Rent: 2600").build();
		field[38] = new Tax.Builder().setTitle("Statsskat")
				.setDescription("Pay: 2000").setBgColor(Color.ORANGE)
				.setSubText("Pay: 2000").build();
		field[39] = new Street.Builder().setTitle("Rådhuspladsen")
				.setDescription("Rådhuspladsen").setBgColor(Color.CYAN)
				.setSubText("Price: 5500").setRent("Rent: 2600").build();

		GUI.create(field);
	}
	
	public int playerAmount() {
		return Integer.parseInt(GUI.getUserSelection(
				"Welcome, choose amount of players:", "2", "3", "4", "5", "6"));
	}
	
	public void createPlayers(int playerAmount, Player[] player) {
		// Array that holds the cars for the GUI
		Car[] car = new Car[6];
		car[0] = new Car.Builder().primaryColor(Color.blue).build();
		car[1] = new Car.Builder().primaryColor(Color.red).build();
		car[2] = new Car.Builder().primaryColor(Color.yellow).build();
		car[3] = new Car.Builder().primaryColor(Color.green).build();
		car[4] = new Car.Builder().primaryColor(Color.white).build();
		car[5] = new Car.Builder().primaryColor(Color.black).build();
		
		for (int i = 0; i < playerAmount; i++) {
			player[i] = new Player(GUI.getUserString("Enter name of player "
					+ (i + 1) + ":"));
			GUI.addPlayer(player[i].getName(), player[i].account.getScore(),
					car[i]);
			GUI.setCar(player[i].getPosition() + 1, player[i].getName());
		}
	}
	
	public void nextPlayer(Player[] player, int currentPlayer) {
		GUI.showMessage(player[currentPlayer].getName()
				+ "'s turn to roll the dice.");
	}
	
	public void showDice(int dice1, int dice2) {
		GUI.setDice(dice1, dice2);
	}
	
	public void updatePosition(Player[] player, int currentPlayer, int diceSum) {
		// Remove car from old position on board
		GUI.removeCar(player[currentPlayer].getPosition() + 1,
				player[currentPlayer].getName());
		player[currentPlayer].setPosition(diceSum);
		// Sets car on new position on board
		GUI.setCar(player[currentPlayer].getPosition() + 1,
				player[currentPlayer].getName());

	}
	
	public void removePlayer(Player[] player, int currentPlayer) {
		GUI.removeCar(player[currentPlayer].getPosition() + 1, player[currentPlayer].getName());
		GUI.showMessage("You have gone bankrupt.");		
	}
	
	public void showWin(Player[] player, int playerAmount) {
		for (int i = 0; i < playerAmount; i++) {
			if (!player[i].getStatus()) {
				GUI.showMessage(player[i].getName() + " have won!");
			}
		}
	}
	
	//Field methods
	public boolean buyField(String name, int price) {
		return GUI.getUserLeftButtonPressed(name + 
				" has no owner, would you like to buy it for " + price + "?", "Yes",
				"No");
	}
	
	public void fieldBought(String name) {
		GUI.showMessage("You have successfully bought " + name);
	}
	
	public void fieldRefused(String name) {
		GUI.showMessage("You refused to buy " + name);
	}
	
	public void fieldRefusedPrice(String name) {
		GUI.showMessage("You dont have enough points to buy " + name);
	}
	
	public void fieldOwnedByPlayer(String name) {
		GUI.showMessage(name
				+ " is owned by yourself and therefore nothing happens.");
	}
	
	public void fieldTax(String fieldName, String playerName, int price) {
		GUI.showMessage(fieldName + " is owned by " + playerName
				+ ", " + price
				+ " points will be transfered to "
				+ playerName + "'s balance");
	}
	
	public void updateBalance(String playerName, int amount) {
		GUI.setBalance(playerName, amount);
	}
	
	public void insufficiantFunds(String fieldName, String playerName, int balance) {
		GUI.showMessage(fieldName
				+ " is owned by "
				+ playerName
				+ ", but the rent is higher than your balance. Your remaining "
				+ balance
				+ "points will be transfered to "
				+ playerName + ".");
	}
	
	public void bonusMessage(String name, int bonus) {
		GUI.showMessage("You have landed on " + name + " and recieve " + bonus + " points.");
	}
	
	public void startMessage(String name) {
		GUI.showMessage("You have landed on " + name
				+ ". Rest here until next turn.");
	}
	
	public void goldmineMessage(String name) {
		GUI.showMessage("You have landed on " + name
				+ " and must pay a tax of 2000 points");
	}
	
	public void insufficiantFundsTax() {
		GUI.showMessage("The tax is higher than your balance. "
				+ "Instead you pay the rest of you balance.");
	}
	
	public String taxPick(String name) {
		return GUI.getUserSelection(
				"You have landed on "+ name + " and have to pay tax. "
						+ "Would you like to pay 4000 points or 10% of your total socre?",
				"4000", "10%");
	}
	
	public void taxFunds() {
		GUI.showMessage("The tax is higher than your balance. Instead you pay the rest of you balance.");
	}
}
