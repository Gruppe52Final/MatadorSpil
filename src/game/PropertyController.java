package game;

import boundary.MatadorGUI;

public class PropertyController {
	
	private MatadorGUI gui = new MatadorGUI();

	public void sellProperty(Player currentPlayer, GameBoard gameboard, PlayerList playerList) {
		//Lots of variables needed to sell
		String[] buyingPlayers = playerList.getBuyerNames(currentPlayer);
		String[] playerOwnedProperty = gameboard.getPlayerOwnableNames(currentPlayer);	
		String propertyToSell = gui.choosePropertyToSell(playerOwnedProperty);
		String buyingPlayerName = gui.choosePlayerToSellPropertyTo(buyingPlayers);
		Player buyingPlayer = playerList.getPlayerObjectFromString(buyingPlayerName);
		int price = gui.getSellingPropertySellingPrice();
		boolean confirmation = gui.askForPlayerConfirmation(buyingPlayer.getName(), propertyToSell, currentPlayer.getName(), price);
//		If the buying player has money and wants to buy, the transfer will be completed below
		if(confirmation && buyingPlayer.account.getScore() > price) {
			buyingPlayer.account.subtractPoints(price);
			currentPlayer.account.addPoints(price);
			gameboard.setOwner(buyingPlayer, propertyToSell);
			gui.sellConfirmation(currentPlayer.getName(), buyingPlayer.getName(), propertyToSell);
			gui.updateBalance(buyingPlayer);
			gui.updateBalance(currentPlayer);
		}
	}
}
