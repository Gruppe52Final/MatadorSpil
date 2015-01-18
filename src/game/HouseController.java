package game;

import boundary.MatadorGUI;

public class HouseController {
	
	private MatadorGUI gui;
	private int fieldNumber;
	private GameBoard gameboard;
	private Player currentPlayer;
	
	public HouseController(MatadorGUI gui) {
		this.gui = gui;
	}
	
	
	public void buyHousesOption(Player currentPlayer, GameBoard gameboard) {
		this.gameboard = gameboard;
		this.currentPlayer = currentPlayer;
		String propertyToHouse = gui.choosePropertyToHouse(currentPlayer,gameboard);
		fieldNumber = gameboard.getFieldNumberFromPropertyName(propertyToHouse);
		int numberOfHouses = Integer.valueOf(gui.chooseNumberOfHousesToBuy());
		if(checkIfPlayerCanAffordHouses(numberOfHouses)) {
			subtractHousePrice(numberOfHouses);			
			gui.setHouse(fieldNumber,numberOfHouses, gameboard);
			gui.updateBalance(currentPlayer);
		}
	}
	
	private boolean checkIfPlayerCanAffordHouses(int numberOfHouses) {
		boolean x = false;	
		int housePrice = gameboard.getTerritoryHousePrice(fieldNumber);
		if(currentPlayer.account.getScore() > numberOfHouses * housePrice) {
			x = true;
		}
		return x;
}
	
	private void subtractHousePrice(int numberOfHouses) {
		int housePrice = gameboard.getTerritoryHousePrice(fieldNumber);
		currentPlayer.account.subtractPoints(numberOfHouses * housePrice);	
	}

}
