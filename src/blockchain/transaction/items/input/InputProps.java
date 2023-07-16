package blockchain.transaction.items.input;

import java.util.Optional;

public class InputProps {
	private String address;
	private Double value;
	private boolean blockReward;
	private PreviousOutput previousOutput;

	public InputProps(String address, double value, boolean blockReward, PreviousOutput previousOutput) {
		this.address = address;
		this.value = value;
		this.blockReward = blockReward;
		this.previousOutput = previousOutput;
	}

	public String getAddress() {
		return this.address;
	}

	public Double getValue() {
		return this.value;
	}

	public boolean getBlockReward() {
		return this.blockReward;
	}

	public PreviousOutput getPreviousOutput() {
		return this.previousOutput;
	}
}
