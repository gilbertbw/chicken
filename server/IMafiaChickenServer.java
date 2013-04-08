package chicken.server;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)

public interface IMafiaChickenServer {
	
	//player connect method
	@WebMethod public void playerConnect(String usrnm);
	
	//player list methods
	@WebMethod public Client[] playerList();
	@WebMethod public int playerAmount();
	@WebMethod public int maxPlayerAmount();
	
	//client request methods
	@WebMethod public void clientRequestChat(String usrnm, String message);
	@WebMethod public void clientRequestBuyRed(String usrnm);
	@WebMethod public void clientRequestBuyYellow(String usrnm);
	@WebMethod public void clientRequestBuyBlue(String usrnm);
	@WebMethod public void clientRequestAttack(String usrnm, String targetUsrnm);
	
	//client info methods
	@WebMethod public int clientInfoRedAmount(String usrnm);
	@WebMethod public int clientInfoYellowAmount(String usrnm);
	@WebMethod public int clientInfoBlueAmount(String usrnm);
	
	@WebMethod public int clientInfoCoinAmount(String usrnm);
	@WebMethod public int clientInfoTerritoryAmount(String usrnm);
	
	//server info methods
	@WebMethod public int serverInfoRedCost();
	@WebMethod public int serverInfoYellowCost();
	@WebMethod public int serverInfoBlueCost();
	
	@WebMethod public int serverInfoCoinAmount();
	@WebMethod public int serverInfoTerritoryAmount();
	
	@WebMethod public String serverInfoChat();

}
