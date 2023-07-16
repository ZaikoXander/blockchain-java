package blockchain.transaction.items.input;

public class PreviousOutput {
	private String transactionHash;
	private int index;

	public PreviousOutput(String transactionHash, int index) {
		this.transactionHash = transactionHash;
		this.index = index;
	}
}
