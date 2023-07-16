package blockchain.transaction;

import blockchain.transaction.items.input.Input;
import blockchain.transaction.items.output.Output;

public class TransactionProps {
	private Input[] inputs;
	private Output[] outputs;
	private boolean replaceByFee;

	public TransactionProps(
		Input[] inputs,
		Output[] outputs,
		boolean replaceByFee
	) {
		this.inputs = inputs;
		this.outputs = outputs;
		this.replaceByFee = replaceByFee;
	}

	public Input[] getInputs() {
		return this.inputs;
	}

	public Output[] getOutputs() {
		return this.outputs;
	}

	public boolean getReplaceByFee() {
		return this.replaceByFee;
	}
}
