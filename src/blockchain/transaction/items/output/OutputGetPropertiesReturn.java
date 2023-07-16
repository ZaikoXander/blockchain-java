package blockchain.transaction.items.output;

public class OutputGetPropertiesReturn {
	private String address;
	private double value;
	private boolean hasSpent;
	private NextInput nextInput;

	public OutputGetPropertiesReturn(String address, double value, boolean hasSpent, NextInput nextInput) {
		this.address = address;
		this.value = value;
		this.hasSpent = hasSpent;
		this.nextInput = nextInput;
	}

	public String getAddress() {
		return this.address;
	}

	public double getValue() {
		return this.value;
	}

	public boolean getHasSpent() {
		return this.hasSpent;
	}

	public NextInput getNextInput() {
		return this.nextInput;
	}
}
