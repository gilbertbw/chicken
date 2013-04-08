package chicken.server;

import javax.jws.WebService;

@WebService(endpointInterface = "chicken.server.IMafiaChickenServer")

public class MafiaChickenServer implements IMafiaChickenServer {

	private int maxClients = 1;
	private Client connectedClients[];
	private boolean maxClientsSet = false;
	
	@Override
	public void clientConnect(String usrnm) {
		
	}

	@Override
	public void clientDisconnect(String usrnm) {
		
	}

	@Override
	public Client[] clientList() {
		return null;
	}

	@Override
	public int clientAmount() {
		return 0;
	}

	@Override
	public int maxClientAmount() {
		return maxClients;
	}

	@Override
	public void setMaxClientAmount(int amount) {
		if(!maxClientsSet) {
			maxClients = amount;
			connectedClients = new Client[maxClients];
			maxClientsSet = true;
		}
	}

	@Override
	public void clientRequestChat(String usrnm, String message) {
		
	}

	@Override
	public void clientRequestBuyRed(String usrnm) {
		
	}

	@Override
	public void clientRequestBuyYellow(String usrnm) {
		
	}

	@Override
	public void clientRequestBuyBlue(String usrnm) {
		
	}

	@Override
	public void clientRequestAttack(String usrnm, String targetUsrnm) {
		
	}

	@Override
	public int clientInfoRedAmount(String usrnm) {
		return 0;
	}

	@Override
	public int clientInfoYellowAmount(String usrnm) {
		return 0;
	}

	@Override
	public int clientInfoBlueAmount(String usrnm) {
		return 0;
	}

	@Override
	public int clientInfoCoinAmount(String usrnm) {
		return 0;
	}

	@Override
	public int clientInfoTerritoryAmount(String usrnm) {
		return 0;
	}

	@Override
	public int serverInfoRedCost() {
		return 0;
	}

	@Override
	public int serverInfoYellowCost() {
		return 0;
	}

	@Override
	public int serverInfoBlueCost() {
		return 0;
	}

	@Override
	public int serverInfoCoinAmount() {
		return 0;
	}

	@Override
	public int serverInfoTerritoryAmount() {
		return 0;
	}

	@Override
	public void serverStart() {
		
	}

	@Override
	public void serverStop() {
		
	}
	
}