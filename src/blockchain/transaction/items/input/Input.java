package blockchain.transaction.items.input;

import blockchain.transaction.items.TransactionItem;

public class Input extends TransactionItem {
	private boolean blockReward;
	private PreviousOutput previousOutput;

	public Input(InputProps inputProps) {
		super(inputProps.getAddress(), inputProps.getValue());
		this.blockReward = inputProps.getBlockReward();
		this.previousOutput = inputProps.getPreviousOutput();
	}

	public InputProps getProperties() {
		return new InputProps(this.address, this.value, this.blockReward, this.previousOutput);
	}
}
