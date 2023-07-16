package blockchain.transaction;

import blockchain.transaction.block.PseudoBlock;
import blockchain.transaction.items.input.Input;
import blockchain.transaction.items.output.Output;

public class GetTransactionPropertiesReturn {
	private Input[] inputs;
	private Output[] outputs;
	private double fee;
	private long time;
	private boolean replaceByFee;
	private PseudoBlock block;
	private String hash;

	public GetTransactionPropertiesReturn(
		Input[] inputs,
		Output[] outputs,
		double fee,
		long time,
		boolean replaceByFee,
		PseudoBlock block,
		String hash
	) {
		this.inputs = inputs;
		this.outputs = outputs;
		this.fee = fee;
		this.time = time;
		this.replaceByFee = replaceByFee;
		this.block = block;
		this.hash = hash;
	}

	public Input[] getInputs() {
		return this.inputs;
	}

	public Output[] getOutputs() {
		return this.outputs;
	}

	public double getFee() {
		return this.fee;
	}

	public long getTime() {
		return this.time;
	}

	public boolean getReplaceByFee() {
		return this.replaceByFee;
	}

	public PseudoBlock getBlock() {
		return this.block;
	}

	public String getHash() {
		return this.hash;
	}
}
