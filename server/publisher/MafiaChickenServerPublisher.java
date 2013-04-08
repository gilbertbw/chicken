package chicken.server.publisher;

import javax.xml.ws.Endpoint;
import chicken.server.MafiaChickenServer;

public class MafiaChickenServerPublisher {
	
	public MafiaChickenServer server;
	
	public void publishServer(String port) {
		server = new MafiaChickenServer();
		Endpoint.publish("http://127.0.0.1:" + port + "/MafiaChickenServer", server);
	}

}
