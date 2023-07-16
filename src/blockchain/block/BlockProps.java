package blockchain.block;

import blockchain.transaction.Transaction;

public class BlockProps {
	private long height;
	private Transaction[] transactions;
	private String previousBlockHash;

	public BlockProps(long height, Transaction[] transactions, String previousBlockHash) {
		this.height = height;
		this.transactions = transactions;
		this.previousBlockHash = previousBlockHash;
	}

	public long getHeight() {
		return this.height;
	}

	public Transaction[] getTransactions() {
		return this.transactions;
	}

	public String getPreviousBlockHash() {
		return this.previousBlockHash;
	}
}
