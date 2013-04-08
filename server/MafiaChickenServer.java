package chicken.server;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)

public interface MafiaChickenServer {
	
	//client connect and disconnect methods
	@WebMethod public void clientConnect(String usrnm);
	@WebMethod public void clientDisconnect(String usrnm);
	
	//client requests
	@WebMethod public void clientRequestChat(String usrnm, String message);
	@WebMethod public void clientRequestBuyRed(String usrnm);
	@WebMethod public void clientRequestBuyYellow(String usrnm);
	@WebMethod public void clientRequestBuyBlue(String usrnm);

}
