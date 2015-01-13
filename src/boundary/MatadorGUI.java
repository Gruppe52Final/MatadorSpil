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
import desktop_fields.Jail;
import desktop_resources.GUI;
import game.Player;

public class MatadorGUI {
	
	private Texts text = new Texts();
	
	public MatadorGUI() {
		
	}
	
	public MatadorGUI(String language) {
		if(language.equals("Dansk")) {
			text = new Texts("Dansk");
		} else if(language.equals("English")) {
			text = new Texts("English");
		}
	}
	public void getLanguage() {
		System.out.println(Texts.text[0]);
	}
	
	//Game methods
	public void createField() {
		// Array that holds the fields for the GUI
		Field[] field = new Field[40];
		field[0] = new Start.Builder().setTitle("Start")
				.setDescription("Start").setSubText("Start")
				.setBgColor(Color.RED).build();
		field[1] = new Street.Builder().setTitle("R�dovrevej")
				.setDescription("R�dovrevej").setBgColor(Color.decode("#6495ED"))
				.setSubText("Price: 60").setRent("Rent: 2").build();
		field[2] = new Tax.Builder().setTitle("Pr�v Lykken")
				.setDescription("Pr�v Lykken").setBgColor(Color.LIGHT_GRAY)
				.setSubText("Pay: 2000").build();
		field[3] = new Street.Builder().setTitle("Hvidovrevej")
				.setDescription("Hvidovrevej").setBgColor(Color.decode("#6495ED"))
				.setSubText("Price: 60").setRent("Rent: 4").build();
		field[4] = new Tax.Builder().setTitle("Indkomstskat")
				.setDescription("Pay: 200 or 10%").setBgColor(Color.GRAY)
				.setSubText("Pay: 200 or 10%").build();
		field[5] = new Shipping.Builder().setTitle("�resund A/S")
				.setDescription("�resund A/S").setBgColor(Color.white)
				.setSubText("Price: 200").setRent("Rent: 25").build();
		field[6] = new Street.Builder().setTitle("Roskildevej")
				.setDescription("Roskildevej").setBgColor(Color.decode("#FF6347"))
				.setSubText("Price: 100").setRent("Rent: 6").build();
		field[7] = new Street.Builder().setTitle("Pr�v Lykken")
				.setDescription("Pr�v Lykken").setBgColor(Color.LIGHT_GRAY)
				.setSubText("Price: 3000").setRent("Rent: 700").build();
		field[8] = new Street.Builder().setTitle("Valby Langgade")
				.setDescription("Valby Langgade").setBgColor(Color.decode("#FF6347"))
				.setSubText("Price: 100").setRent("Rent: 6").build();
		field[9] = new Street.Builder().setTitle("All�gade")
				.setDescription("All�gade").setBgColor(Color.decode("#FF6347"))
				.setSubText("Price: 120").setRent("Rent: 8").build();
		field[10] = new Jail.Builder().setDescription("Jail")
				.setBgColor(Color.DARK_GRAY).setSubText("Jail").build();
		field[11] = new Street.Builder().setTitle("Fredriksberg All�")
				.setDescription("Fredriksberg All�").setBgColor(Color.green)
				.setSubText("Price: 140").setRent("Rent: 10").build();
		field[12] = new Brewery.Builder().setTitle("Tuborg")
				.setDescription("Tuborg")
				.setSubText("Price: 150").setRent("100 x dice").build();
		field[13] = new Street.Builder().setTitle("B�lowsvej")
				.setDescription("B�lowsvej").setBgColor(Color.green)
				.setSubText("Price: 140").setRent("Rent: 10").build();
		field[14] = new Street.Builder().setTitle("Gl Kongevej")
				.setDescription("Gl Kongevej").setBgColor(Color.green)
				.setSubText("Price: 160").setRent("Rent: 12").build();
		field[15] = new Shipping.Builder().setTitle("D.F.D.S")
				.setDescription("D.F.D.S").setBgColor(Color.white)
				.setSubText("Price: 200").setRent("Rent: 25").build();
		field[16] = new Street.Builder().setTitle("Bernstorffsvej")
				.setDescription("Bernstorffsvej").setBgColor(Color.GRAY)
				.setSubText("Price: 180").setRent("Rent: 14").build();
		field[17] = new Street.Builder().setTitle("Pr�v Lykken")
				.setDescription("Pr�v Lykken").setBgColor(Color.LIGHT_GRAY)
				.setSubText("Price: 5500").setRent("Rent: 2600").build();
		field[18] = new Street.Builder().setTitle("Hellerupvej")
				.setDescription("Hellerupvej").setBgColor(Color.GRAY)
				.setSubText("Price: 180").setRent("Rent: 14").build();
		field[19] = new Street.Builder().setTitle("Strandvejen")
				.setDescription("Strandvejen").setBgColor(Color.GRAY)
				.setSubText("Price: 200").setRent("Rent: 16").build();
		field[20] = new Refuge.Builder().setTitle("Parkering")
				.setDescription("Parkering").setBgColor(Color.white)
				.setSubText("Recieve: 5000").build();
		field[21] = new Street.Builder().setTitle("Trianglen")
				.setDescription("Trianglen").setBgColor(Color.red)
				.setSubText("Price: 220").setRent("Rent: 18").build();
		field[22] = new Street.Builder().setTitle("Pr�v Lykken")
				.setDescription("Pr�v Lykken").setBgColor(Color.LIGHT_GRAY)
				.setSubText("Price: 5500").setRent("Rent: 2600").build();
		field[23] = new Street.Builder().setTitle("�sterbrogade")
				.setDescription("�sterbrogade").setBgColor(Color.red)
				.setSubText("Price: 220").setRent("Rent: 18").build();
		field[24] = new Street.Builder().setTitle("Gr�nningen")
				.setDescription("Gr�nningen").setBgColor(Color.red)
				.setSubText("Price: 240").setRent("Rent: 20").build();
		field[25] = new Shipping.Builder().setTitle("�. K.")
				.setDescription("�. K.").setBgColor(Color.white)
				.setSubText("Price: 200").setRent("Rent: 25").build();
		field[26] = new Street.Builder().setTitle("Bredgade")
				.setDescription("Bredgade").setBgColor(Color.white)
				.setSubText("Price: 260").setRent("Rent: 22").build();
		field[27] = new Street.Builder().setTitle("Kgs Nytorv")
				.setDescription("Kgs Nytorv").setBgColor(Color.white)
				.setSubText("Price: 260").setRent("Rent: 22").build();
		field[28] = new Brewery.Builder().setTitle("Carlsberg")
				.setDescription("Carlsberg")
				.setSubText("Price: 150").setRent("100 x dice").build();
		field[29] = new Street.Builder().setTitle("�stergade")
				.setDescription("�stergade").setBgColor(Color.white)
				.setSubText("Price: 280").setRent("Rent: 22").build();
		field[30] = new Jail.Builder().setDescription("Arrested")
				.setBgColor(Color.GRAY).setSubText("Arrested").build();
		field[31] = new Street.Builder().setTitle("Amagertorv")
				.setDescription("Amagertorv").setBgColor(Color.yellow)
				.setSubText("Price: 300").setRent("Rent: 26").build();
		field[32] = new Street.Builder().setTitle("Vimmelskaftet")
				.setDescription("Vimmelskaftet").setBgColor(Color.yellow)
				.setSubText("Price: 300").setRent("Rent: 26").build();
		field[33] = new Street.Builder().setTitle("Pr�v Lykken")
				.setDescription("Pr�v Lykken").setBgColor(Color.LIGHT_GRAY)
				.setSubText("Price: 5500").setRent("Rent: 2600").build();
		field[34] = new Street.Builder().setTitle("Nygade")
				.setDescription("Nygade").setBgColor(Color.yellow)
				.setSubText("Price: 320").setRent("Rent: 28").build();
		field[35] = new Shipping.Builder().setTitle("D/S Bornholm 1866")
				.setDescription("D/S Bornholm 1866").setBgColor(Color.white)
				.setSubText("Price: 200").setRent("Rent: 25").build();
		field[36] = new Street.Builder().setTitle("Pr�v Lykken")
				.setDescription("Pr�v Lykken").setBgColor(Color.LIGHT_GRAY)
				.setSubText("Price: 5500").setRent("Rent: 2600").build();
		field[37] = new Street.Builder().setTitle("Frederiksberggade")
				.setDescription("Frederiksberggade").setBgColor(Color.decode("#800080"))
				.setSubText("Price: 350").setRent("Rent: 35").build();
		field[38] = new Tax.Builder().setTitle("Statsskat")
				.setDescription("Pay: 100").setBgColor(Color.DARK_GRAY)
				.setSubText("Pay: 100").build();
		field[39] = new Street.Builder().setTitle("R�dhuspladsen")
				.setDescription("R�dhuspladsen").setBgColor(Color.decode("#800080"))
				.setSubText("Price: 400").setRent("Rent: 50").build();
		GUI.create(field);
	}
	
	public int playerAmount() {
		return Integer.parseInt(GUI.getUserSelection(
				Texts.text[1], "2", "3", "4", "5", "6"));
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
			player[i] = new Player(GUI.getUserString(Texts.text[0]
					+ (i + 1) + ":"));
			GUI.addPlayer(player[i].getName(), player[i].account.getScore(),
					car[i]);
			GUI.setCar(player[i].getPosition() + 1, player[i].getName());
		}
	}
	
	public void nextPlayer(Player[] player, int currentPlayer) {
		GUI.showMessage(player[currentPlayer].getName()
				+ Texts.text[2]);
	}
	
	public void showDice(int dice1, int dice2) {
		GUI.setDice(dice1, dice2);
	}
	
	public void updatePosition(Player[] player, int currentPlayer) {
		// Remove car from old position on board
		GUI.removeCar(player[currentPlayer].getPosition() + 1,
				player[currentPlayer].getName());
		GUI.removeAllCars(player[currentPlayer].getName());
		// Sets car on new position on board
		GUI.setCar(player[currentPlayer].getPosition() + 1,
				player[currentPlayer].getName());
	}
	
	public void removePlayer(Player[] player, int currentPlayer) {
		GUI.removeCar(player[currentPlayer].getPosition() + 1, player[currentPlayer].getName());
		GUI.showMessage(Texts.text[3]);		
	}
	
	public void showWin(Player[] player, int playerAmount) {
		for (int i = 0; i < playerAmount; i++) {
			if (!player[i].getDeathStatus()) {
				GUI.showMessage(player[i].getName() + Texts.text[4]);
			}
		}
	}
	
	//Field methods
	public boolean buyField(String name, int price) {
		return GUI.getUserLeftButtonPressed(name + 
				Texts.text[5] + price + "?", Texts.text[6],
				Texts.text[7]);
	}
	
	public void fieldBought(String name) {
		GUI.showMessage(Texts.text[8] + name);
	}
	
	public void fieldRefused(String name) {
		GUI.showMessage(Texts.text[9] + name);
	}
	
	public void fieldRefusedPrice(String name) {
		GUI.showMessage(Texts.text[10] + name);
	}
	
	public void fieldOwnedByPlayer(String name) {
		GUI.showMessage(name
				+ Texts.text[11]);
	}
	
	public void fieldTax(String fieldName, String playerName, int price) {
		GUI.showMessage(fieldName + Texts.text[12] + playerName
				+ ", " + price
				+ Texts.text[13]
				+ playerName + Texts.text[14]);
	}
	
	public void updateBalance(Player player) {
		GUI.setBalance(player.getName(), player.account.getScore());
	}
	
	public void insufficiantFunds(String fieldName, String playerName, int balance) {
		GUI.showMessage(fieldName
				+ Texts.text[12]
				+ playerName
				+ Texts.text[15]
				+ balance
				+ Texts.text[13]
				+ playerName + ".");
	}
	
	public void bonusMessage(String name, int bonus) {
		GUI.showMessage(Texts.text[16] + name + Texts.text[17] + bonus + Texts.text[18]);
	}
	
	public void startMessage(String name) {
		GUI.showMessage(Texts.text[16] + name
				+ Texts.text[19]);
	}
	
	public void goldmineMessage(String name) {
		GUI.showMessage(Texts.text[16] + name
				+ Texts.text[20]);
	}
	
	public void insufficiantFundsTax() {
		GUI.showMessage(Texts.text[21]
				+ Texts.text[22]);
	}
	
	public String taxPick(String name) {
		return GUI.getUserSelection(
				Texts.text[21] + name + Texts.text[23]
						+ Texts.text[24],
					Texts.text[25], Texts.text[26]);
	}
	
	public void fundsTooLowToPayTax() {
		GUI.showMessage(Texts.text[27]);
	}

	public void passedStart(Player player, int passStartMoney) {
		GUI.showMessage(Texts.text[28] 
				+ passStartMoney + Texts.text[18]);
		
	}

	public void removePlayer(Player player) {
		GUI.removeCar(player.getPosition() + 1, player.getName());
		GUI.showMessage(Texts.text[29]);			
	}

	public void updatePosition(Player currentPlayer) {
		// Remove car from old position on board
		GUI.removeCar(currentPlayer.getPosition() + 1,
				currentPlayer.getName());
		GUI.removeAllCars(currentPlayer.getName());
		// Sets car on new position on board
		GUI.setCar(currentPlayer.getPosition() + 1,
				currentPlayer.getName());		
	}

	public void nextPlayer(Player currentPlayer) {
		GUI.showMessage(currentPlayer.getName()
				+ "'s turn to roll the dice.");
		
	}
	

	public void visitPrisonMessage() {
		GUI.showMessage("You have landed on prison You're only on a visit and can leave any time.");
	}
	
	
	public void inPrisonMessage() {
		GUI.showMessage("You are in prison, throw equal dice to get out");
	}
	
	public void goToPrisonMessage() {
		GUI.showMessage("You're being taken to the jail. "
				+ "You either have to pay yourself out "
				+ "or be set free because of good behavior (by rolling two equal dice)");
	}
	
	public boolean payOutOfPrison(Player currentPlayer) {
		return GUI.getUserLeftButtonPressed(currentPlayer.getName() 
				+" is in jail. Do you want to pay 100 points to get out?", "Yes",
				"No");
	}

	public void cantPayOutOfPrison(Player currentPlayer) {
		GUI.showMessage("You don't have enough points to pay bail... wait for your parole");
		
	}

	public String selectLanguage() {
		return GUI.getUserSelection(
				"V�lg sprog / Select language", "Dansk", "English");
	}

	public void createTexts(String language) {
		if(language.equals("Dansk")) {
			text = new Texts("Dansk");
		} else if(language.equals("English")) {
			text = new Texts("English");
		}		
	}
}
