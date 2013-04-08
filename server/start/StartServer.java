package chicken.server.start;

import chicken.server.publisher.MafiaChickenServerPublisher;

public class StartServer {
	
	public static void main(String[] args) {
		MafiaChickenServerPublisher publisher = new MafiaChickenServerPublisher();
		publisher.publishServer("7264");
	}

}
