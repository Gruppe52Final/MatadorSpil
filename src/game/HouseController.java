package game;

import boundary.MatadorGUI;

public class HouseController {
	
	private MatadorGUI gui;
	private int fieldNumber;
	private GameBoard gameboard;
	private Player currentPlayer;
	private int numberOfHouses;
	
	public HouseController(MatadorGUI gui, GameBoard gameboard, Player currentPlayer) {
		this.gui = gui;
		this.gameboard = gameboard;
		this.currentPlayer = currentPlayer;
		String propertyToHouse = gui.choosePropertyToHouse(currentPlayer,gameboard);
		fieldNumber = gameboard.getFieldNumberFromPropertyName(propertyToHouse);
		numberOfHouses = Integer.valueOf(gui.chooseNumberOfHousesToBuy());
	}
	
	public void buyHousesOption() {		
		if(checkIfPlayerCanAffordHouses()) {
			subtractHousePrice();			
			gui.setHouse(fieldNumber,numberOfHouses, gameboard);
			gui.updateBalance(currentPlayer);
		}
	}
	
	private boolean checkIfPlayerCanAffordHouses() {
		boolean x = false;	
		int housePrice = gameboard.getTerritoryHousePrice(fieldNumber);
		if(currentPlayer.account.getScore() > numberOfHouses * housePrice) {
			x = true;
		}
		return x;
}
	
	private void subtractHousePrice() {
		int housePrice = gameboard.getTerritoryHousePrice(fieldNumber);
		currentPlayer.account.subtractPoints(numberOfHouses * housePrice);	
	}

}
