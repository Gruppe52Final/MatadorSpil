package boundary;

import fields.Territory;
import game.GameBoard;
import game.Player;

import java.awt.Color;

import desktop_codebehind.Car;
import desktop_fields.Brewery;
import desktop_fields.Field;
import desktop_fields.Jail;
import desktop_fields.Refuge;
import desktop_fields.Shipping;
import desktop_fields.Start;
import desktop_fields.Street;
import desktop_fields.Tax;
import desktop_resources.GUI;

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
		field[1] = new Street.Builder().setTitle("Rødovrevej")
				.setDescription("Rødovrevej").setBgColor(Color.decode("#6495ED"))
				.setSubText("Price: 60").setRent("Rent: 2").build();
		field[2] = new Tax.Builder().setTitle("Prøv Lykken")
				.setDescription("Prøv Lykken").setBgColor(Color.LIGHT_GRAY)
				.setSubText("Pay: 2000").build();
		field[3] = new Street.Builder().setTitle("Hvidovrevej")
				.setDescription("Hvidovrevej").setBgColor(Color.decode("#6495ED"))
				.setSubText("Price: 60").setRent("Rent: 4").build();
		field[4] = new Tax.Builder().setTitle("Indkomstskat")
				.setDescription("Pay: 200 or 10%").setBgColor(Color.GRAY)
				.setSubText("Pay: 200 or 10%").build();
		field[5] = new Shipping.Builder().setTitle("Øresund A/S")
				.setDescription("Øresund A/S").setBgColor(Color.white)
				.setSubText("Price: 200").setRent("Rent: 25").build();
		field[6] = new Street.Builder().setTitle("Roskildevej")
				.setDescription("Roskildevej").setBgColor(Color.decode("#FF6347"))
				.setSubText("Price: 100").setRent("Rent: 6").build();
		field[7] = new Street.Builder().setTitle("Prøv Lykken")
				.setDescription("Prøv Lykken").setBgColor(Color.LIGHT_GRAY)
				.setSubText("Price: 3000").setRent("Rent: 700").build();
		field[8] = new Street.Builder().setTitle("Valby Langgade")
				.setDescription("Valby Langgade").setBgColor(Color.decode("#FF6347"))
				.setSubText("Price: 100").setRent("Rent: 6").build();
		field[9] = new Street.Builder().setTitle("Allégade")
				.setDescription("Allégade").setBgColor(Color.decode("#FF6347"))
				.setSubText("Price: 120").setRent("Rent: 8").build();
		field[10] = new Jail.Builder().setDescription("Jail")
				.setBgColor(Color.DARK_GRAY).setSubText("Jail").build();
		field[11] = new Street.Builder().setTitle("Fredriksberg Allé")
				.setDescription("Fredriksberg Allé").setBgColor(Color.green)
				.setSubText("Price: 140").setRent("Rent: 10").build();
		field[12] = new Brewery.Builder().setTitle("Tuborg")
				.setDescription("Tuborg")
				.setSubText("Price: 150").setRent("100 x dice").build();
		field[13] = new Street.Builder().setTitle("Bülowsvej")
				.setDescription("Bülowsvej").setBgColor(Color.green)
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
		field[17] = new Street.Builder().setTitle("Prøv Lykken")
				.setDescription("Prøv Lykken").setBgColor(Color.LIGHT_GRAY)
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
		field[22] = new Street.Builder().setTitle("Prøv Lykken")
				.setDescription("Prøv Lykken").setBgColor(Color.LIGHT_GRAY)
				.setSubText("Price: 5500").setRent("Rent: 2600").build();
		field[23] = new Street.Builder().setTitle("Østerbrogade")
				.setDescription("Østerbrogade").setBgColor(Color.red)
				.setSubText("Price: 220").setRent("Rent: 18").build();
		field[24] = new Street.Builder().setTitle("Grønningen")
				.setDescription("Grønningen").setBgColor(Color.red)
				.setSubText("Price: 240").setRent("Rent: 20").build();
		field[25] = new Shipping.Builder().setTitle("Ø. K.")
				.setDescription("Ø. K.").setBgColor(Color.white)
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
		field[29] = new Street.Builder().setTitle("Østergade")
				.setDescription("Østergade").setBgColor(Color.white)
				.setSubText("Price: 280").setRent("Rent: 22").build();
		field[30] = new Jail.Builder().setDescription("Arrested")
				.setBgColor(Color.GRAY).setSubText("Arrested").build();
		field[31] = new Street.Builder().setTitle("Amagertorv")
				.setDescription("Amagertorv").setBgColor(Color.yellow)
				.setSubText("Price: 300").setRent("Rent: 26").build();
		field[32] = new Street.Builder().setTitle("Vimmelskaftet")
				.setDescription("Vimmelskaftet").setBgColor(Color.yellow)
				.setSubText("Price: 300").setRent("Rent: 26").build();
		field[33] = new Street.Builder().setTitle("Prøv Lykken")
				.setDescription("Prøv Lykken").setBgColor(Color.LIGHT_GRAY)
				.setSubText("Price: 5500").setRent("Rent: 2600").build();
		field[34] = new Street.Builder().setTitle("Nygade")
				.setDescription("Nygade").setBgColor(Color.yellow)
				.setSubText("Price: 320").setRent("Rent: 28").build();
		field[35] = new Shipping.Builder().setTitle("D/S Bornholm 1866")
				.setDescription("D/S Bornholm 1866").setBgColor(Color.white)
				.setSubText("Price: 200").setRent("Rent: 25").build();
		field[36] = new Street.Builder().setTitle("Prøv Lykken")
				.setDescription("Prøv Lykken").setBgColor(Color.LIGHT_GRAY)
				.setSubText("Price: 5500").setRent("Rent: 2600").build();
		field[37] = new Street.Builder().setTitle("Frederiksberggade")
				.setDescription("Frederiksberggade").setBgColor(Color.decode("#800080"))
				.setSubText("Price: 350").setRent("Rent: 35").build();
		field[38] = new Tax.Builder().setTitle("Statsskat")
				.setDescription("Pay: 100").setBgColor(Color.DARK_GRAY)
				.setSubText("Pay: 100").build();
		field[39] = new Street.Builder().setTitle("Rådhuspladsen")
				.setDescription("Rådhuspladsen").setBgColor(Color.decode("#800080"))
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
	
	//This method is used for houses testing purposes
	public void setCars(Player[] player) {
		// Array that holds the cars for the GUI
		Car[] car = new Car[6];
		car[0] = new Car.Builder().primaryColor(Color.blue).build();
		car[1] = new Car.Builder().primaryColor(Color.red).build();
		car[2] = new Car.Builder().primaryColor(Color.yellow).build();
		car[3] = new Car.Builder().primaryColor(Color.green).build();
		car[4] = new Car.Builder().primaryColor(Color.white).build();
		car[5] = new Car.Builder().primaryColor(Color.black).build();
		
		for (int i = 0; i < player.length; i++) {
			GUI.addPlayer(player[i].getName(), player[i].account.getScore(),
					car[i]);
			GUI.setCar(player[i].getPosition() + 1, player[i].getName());
		}
	}
	
	@Deprecated
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
				+ text.text[2]);
		
	}
	

	public void visitPrisonMessage() {
		GUI.showMessage(text.text[16] + text.text[30]);
	}
	
	
	public void inPrisonMessage() {
		GUI.showMessage(text.text[31]);
	}
	
	public void goToPrisonMessage() {
		GUI.showMessage(text.text[32]
				+ text.text[33]
				+ text.text[34]);
	}
	
	public boolean payOutOfPrison(Player currentPlayer) {
		return GUI.getUserLeftButtonPressed(currentPlayer.getName() 
				+ text.text[35] + text.text[37] + currentPlayer.getPrisonTurns() + text.text[38], text.text[6],
				text.text[7]);
		
	}
	

	public void cantPayOutOfPrison(Player currentPlayer) {
		GUI.showMessage(text.text[36]);
	
		
	}

	public String selectLanguage() {
		return GUI.getUserSelection(
				"Vælg sprog / Select language", "Dansk", "English");
	}

	public void createTexts(String language) {
		if(language.equals("Dansk")) {
			text = new Texts("Dansk");
		} else if(language.equals("English")) {
			text = new Texts("English");
		}		
	}

	public void chanceCard(String chanceCardText) {
		GUI.showMessage(chanceCardText);
		GUI.displayChanceCard(chanceCardText);
	}
	
	public void debugStopGUIForChanceCard() {
		GUI.getUserSelection("Debugging purpose only", "Yes");
	}

	public String optionToBuyHouse() {
		return GUI.getUserButtonPressed("Vælg", "Kast", "Køb hus");
		
	}

	public String choosePropertyToHouse(Player currentPlayer) {		
		return GUI.getUserSelection("Which property do you want a house on?", currentPlayer.getPropertiesOwned());
	}
	
	public String chooseNumberOfHousesToBuy() {
		return GUI.getUserSelection("How many houses do you want to buy?", "1","2","3","4");
	}
	
	//Not working correctly in test
	public void updateHouses(GameBoard gameBoard) {
		for (int i = 0; i < 39; i++) {
			if(gameBoard.getField(i) instanceof Territory) {
				Territory territory;
				territory = (Territory) gameBoard.getField(i);
				GUI.setHouses((i), ((Territory) gameBoard.getField(i)).getHouses());
				System.out.println(territory.getHouses() + "field " + i);
				GUI.setHouses(3, 1);
				}
			}
	}

//	public void setHouse(String choosePropertyToHouse, String numberOfHouses, GameBoard gameBoard) {
//		int fieldNumber = 0;
//		int houseCount = Integer.parseInt(numberOfHouses);
//		if(choosePropertyToHouse.equals("Rødovrevej")) {
//			fieldNumber = 2;
//		} else if (choosePropertyToHouse.equals("Hvidovrevej")) {
//			fieldNumber = 4;
//		}
//		Territory territory = (Territory) gameBoard.getField(fieldNumber - 1);
//		int currentHouses = territory.getHouses();
//		GUI.setHouses(fieldNumber, (houseCount + currentHouses));
//		territory.setHouses(houseCount + currentHouses);
//	}
	
	public void setHouse(int fieldNumber, int numberOfHouses) {
		GUI.setHouses(fieldNumber, numberOfHouses);
	}



}
