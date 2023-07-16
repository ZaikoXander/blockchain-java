package blockchain.transaction.items.output;

import blockchain.transaction.items.TransactionItem;

public class Output extends TransactionItem {
	private boolean hasSpent;
	private NextInput nextInput;

	public Output(OutputProps outputProps) {
		super(outputProps.getAddress(), outputProps.getValue());
		this.hasSpent = false;
		this.nextInput = null;
	}

	public void setNextInput(NextInput nextInput) {
		this.nextInput = nextInput;
		this.hasSpent = true;
	}

	public OutputGetPropertiesReturn getProperties() {
		return new OutputGetPropertiesReturn(this.address, this.value, this.hasSpent, this.nextInput);
	}
}
