package blockchain.transaction.items;

public abstract class TransactionItem {
	protected String address;
	protected double value;

	public TransactionItem(String address, double value) {
		this.address = address;
		this.value = value;
	}
}
