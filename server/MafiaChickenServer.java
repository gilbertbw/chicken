package chicken.server;

import javax.jws.WebService;

@WebService(endpointInterface = "chicken.server.IMafiaChickenServer")

public class MafiaChickenServer implements IMafiaChickenServer {

	private int maxPlayers = 1, currentPlayers = 0;
	private Client players[];
	private boolean serverStarted = false;
	private String chat = "";
	
	private int redCost, yellowCost, blueCost;
	private int totalTerritory;
	private int startCoinAmount;
	
	@Override
	public void playerConnect(String usrnm) {
		for(int i = 0; i < players.length; i++) {
			if(usrnm.equals(players[i].username)) {
				return;
			}
			if(players[i] == null) {
				players[i] = new Client(usrnm, startCoinAmount);
				return;
			}
		}
	}

	@Override
	public Client[] playerList() {
		return players;
	}

	@Override
	public int playerAmount() {
		return currentPlayers;
	}

	@Override
	public int maxPlayerAmount() {
		return maxPlayers;
	}

	@Override
	public void clientRequestChat(String usrnm, String message) {
		//\n wont work in text box, this is temporary
		chat += "\n" + usrnm + ": " + message;
	}

	@Override
	public void clientRequestBuyRed(String usrnm) {
		for(int i = 0; i < players.length; i++) {
			if(players[i] == null) return;
			else {
				if(usrnm.equals(players[i].username)) {
					players[i].coinAmount -= redCost;
					players[i].redAmount++;
					return;
				}
			}
		}
	}

	@Override
	public void clientRequestBuyYellow(String usrnm) {
		for(int i = 0; i < players.length; i++) {
			if(players[i] == null) return;
			else {
				if(usrnm.equals(players[i].username)) {
					players[i].coinAmount -= yellowCost;
					players[i].yellowAmount++;
					return;
				}
			}
		}
	}

	@Override
	public void clientRequestBuyBlue(String usrnm) {
		for(int i = 0; i < players.length; i++) {
			if(players[i] == null) return;
			else {
				if(usrnm.equals(players[i].username)) {
					players[i].coinAmount -= blueCost;
					players[i].blueAmount++;
					return;
				}
			}
		}
	}

	@Override
	public void clientRequestAttack(String usrnm, String targetUsrnm) {
		int index = 0;
		int targetIndex = players.length + 1;
		clientRequestAttackLoop:
		for(int i = 0; i < players.length; i++) {
			if(players[i] == null) break clientRequestAttackLoop;
			if(usrnm.equals(players[i].username)) index = i;
			if(targetUsrnm.equals(players[i].username)) targetIndex = i;
		}
		if(targetIndex != players.length + 1) {
			//makes variables containing the target's chickens before the attack
			int targetRed = players[targetIndex].redAmount;
			int targetYellow = players[targetIndex].yellowAmount;
			int targetBlue = players[targetIndex].blueAmount;
			//the attack
			players[targetIndex].redAmount -= players[index].redAmount;
			players[index].redAmount -= targetRed;
			players[targetIndex].yellowAmount -= players[index].yellowAmount;
			players[index].yellowAmount -= targetYellow;
			players[targetIndex].blueAmount -= players[index].blueAmount;
			players[index].blueAmount -= targetBlue;
		}
	}

	@Override
	public int clientInfoRedAmount(String usrnm) {
		for(int i = 0; i < players.length; i++) {
			if(players[i] == null) return 0;
			if(usrnm.equals(players[i].username)) {
				return players[i].redAmount;
			}
		}
		return 0;
	}

	@Override
	public int clientInfoYellowAmount(String usrnm) {
		for(int i = 0; i < players.length; i++) {
			if(players[i] == null) return 0;
			if(usrnm.equals(players[i].username)) {
				return players[i].yellowAmount;
			}
		}
		return 0;
	}

	@Override
	public int clientInfoBlueAmount(String usrnm) {
		for(int i = 0; i < players.length; i++) {
			if(players[i] == null) return 0;
			if(usrnm.equals(players[i].username)) {
				return players[i].blueAmount;
			}
		}
		return 0;
	}

	@Override
	public int clientInfoCoinAmount(String usrnm) {
		for(int i = 0; i < players.length; i++) {
			if(players[i] == null) return 0;
			if(usrnm.equals(players[i].username)) {
				return players[i].coinAmount;
			}
		}
		return 0;
	}

	@Override
	public int clientInfoTerritoryAmount(String usrnm) {
		for(int i = 0; i < players.length; i++) {
			if(players[i] == null) return 0;
			if(usrnm.equals(players[i].username)) {
				return players[i].territoryAmount;
			}
		}
		return 0;
	}

	@Override
	public void serverStart(String xmlName) {
		if(!serverStarted) {
			serverStarted = true;
		}
	}

	@Override
	public void serverStart(int maxPlayers, int redCost, int yellowCost, int blueCost, int totalTerritory, int startCoinAmount) {
		if(!serverStarted) {
			this.maxPlayers = maxPlayers;
			this.players = new Client[this.maxPlayers];
			this.redCost = redCost;
			this.yellowCost = yellowCost;
			this.blueCost = blueCost;
			this.totalTerritory = totalTerritory;
			this.startCoinAmount = startCoinAmount;
			serverStarted = true;
		}
	}

	@Override
	public void serverStop(String xmlName) {
		
	}

	@Override
	public int serverInfoRedCost() {
		return redCost;
	}

	@Override
	public int serverInfoYellowCost() {
		return yellowCost;
	}

	@Override
	public int serverInfoBlueCost() {
		return blueCost;
	}

	@Override
	public int serverInfoCoinAmount() {
		int totalCoins = 0;
		serverInfoCoinAmountLoop:
		for(int i = 0; i < players.length; i++) {
			if(players[i] != null) {
				totalCoins += players[i].coinAmount;
			} else {
				break serverInfoCoinAmountLoop;
			}
		}
		return totalCoins;
	}

	@Override
	public int serverInfoTerritoryAmount() {
		return totalTerritory;
	}

	@Override
	public String serverInfoChat() {
		return chat;
	}
	
}