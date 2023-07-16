package blockchain.transaction.items.output;

public class OutputProps {
	private String address;
	private long value;

	public OutputProps(String address, long value) {
		this.address = address;
		this.value = value;
	}

	public String getAddress() {
		return this.address;
	}

	public double getValue() {
		return this.value;
	}
}
