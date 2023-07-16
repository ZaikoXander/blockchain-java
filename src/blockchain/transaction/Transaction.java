package blockchain.transaction;

import blockchain.transaction.block.TransactionBlock;
import blockchain.transaction.block.Mempool;
import blockchain.transaction.block.PseudoBlock;
import blockchain.transaction.items.input.Input;
import blockchain.transaction.items.output.Output;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;

public class Transaction {
	private Input[] inputs;
	private Output[] outputs;
	private double fee;
	private long time;
	private boolean replaceByFee;
	private PseudoBlock block;
	private String hash;

	public Transaction(TransactionProps transactionProps) {
		this.inputs = transactionProps.getInputs();
		this.outputs = transactionProps.getOutputs();
		this.replaceByFee = transactionProps.getReplaceByFee();

		boolean isBlockReward = this.inputs[0].getProperties().getBlockReward();
		if (isBlockReward) {
			this.fee = 0;
		} else {
			this.fee = this.calculateFee();
		}

		this.time = System.currentTimeMillis();
		this.block = new Mempool(this.time);
		this.hash = this.calculateHash();
	}
	
	public double calculateFee() {
		double totalInputValue = 0;
		double totalOutputValue = 0;

		for (Input i : this.inputs) {
			if (i.getProperties().getValue() == null) continue;
			totalInputValue += i.getProperties().getValue();
		}

		for (Output o : this.outputs) {
			totalOutputValue += o.getProperties().getValue();
		}

		double fee = totalInputValue - totalOutputValue;

		return fee;
	}

	private static String bytesToHex(byte[] hash) {
		StringBuilder hexString = new StringBuilder(2 * hash.length);
		for (int i = 0; i < hash.length; i++) {
			String hex = Integer.toHexString(0xff & hash[i]);
			if(hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}

		return hexString.toString();
	}

	public String calculateHash() {
		String calculatedHash;
		String originalString =
			Arrays.toString(this.inputs) +
			Arrays.toString(this.outputs) +
			this.fee +
			this.time +
			this.replaceByFee;
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] encodedhash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));

			calculatedHash = Transaction.bytesToHex(encodedhash);
		}
		catch (Exception exception) {
			calculatedHash = this.calculateHash();
		}

		return calculatedHash;
	}

	public void setBlock(TransactionBlock transactionBlock) {
		this.block = transactionBlock;
	}

	public GetTransactionPropertiesReturn getProperties() {
		return new GetTransactionPropertiesReturn(
			this.inputs,
			this.outputs,
			this.fee,
			this.time,
			this.replaceByFee,
			this.block,
			this.hash
		);
	}
}
