package game;

import desktop_resources.GUI;
import fields.Territory;
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
			setHouse(fieldNumber,numberOfHouses, gameboard);
			gui.updateBalance(currentPlayer);
		}
	}
	
	private boolean checkIfPlayerCanAffordHouses() {
		boolean x = false;	
		int housePrice = gameboard.getTerritoryHousePrice(fieldNumber);
		if(currentPlayer.getScore() > numberOfHouses * housePrice) {
			x = true;
		}
		return x;
}
	
	private void subtractHousePrice() {
		int housePrice = gameboard.getTerritoryHousePrice(fieldNumber);
		currentPlayer.subtractPoints(numberOfHouses * housePrice);	
	}
	
	public void setHouse(int fieldNumber, int numberOfHouses, GameBoard gameBoard) {
		int houseCount = numberOfHouses;
		Territory territory = (Territory) gameBoard.getField(fieldNumber);
		int currentHouses = territory.getHouses();
		if (currentHouses >= 4) {
			gui.setHotel((fieldNumber + 1), true);
			territory.setHouses(houseCount + currentHouses);		//Boundary works as controller here - not good - needs fix!
		} else if (currentHouses <= 4) {
			gui.setHouses((fieldNumber + 1), (houseCount + currentHouses));		//This should ideally be the only line called in here!!
			territory.setHouses(houseCount + currentHouses);
		}
	}

}
