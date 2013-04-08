package chicken.server;

public class Client {
	
	public String username;
	public int redAmount, yellowAmount, blueAmount;
	public int coinAmount, territoryAmount;
	
	public Client() {}
	
	public Client(String username, int coinAmount) {
		this.username = username;
		this.coinAmount = coinAmount;
	}

}
