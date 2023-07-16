package blockchain.block;

import blockchain.transaction.Transaction;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;

public class Block {
	public String hash;
	public String previousBlockHash;
	public long time;
	public double fee;
	public long nonce;
	public long transactionCount;
	public long height;
	public Transaction[] transactions;

	public Block(BlockProps blockProps) {
		this.height = blockProps.getHeight();
		this.time = System.currentTimeMillis();
		this.transactions = blockProps.getTransactions();
		this.previousBlockHash = blockProps.getPreviousBlockHash();
		this.nonce = 0;
		this.hash = this.calculateHash();
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
						this.height +
						this.previousBlockHash +
						this.time +
						Arrays.toString(this.transactions) +
						this.nonce;
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] encodedhash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));

			calculatedHash = Block.bytesToHex(encodedhash);
		}
		catch (Exception exception) {
			calculatedHash = this.calculateHash();
		}

		return calculatedHash;
	}

	private boolean validateHash(String hash, int difficulty) {
		return hash.startsWith("0".repeat(difficulty));
	}

	public void mineBlock(int difficulty) {
		while (!this.validateHash(this.hash, difficulty)) {
			this.nonce++;
			this.time = System.currentTimeMillis();
			this.hash = this.calculateHash();
		}

		System.out.println("Block mined: " + this.hash);
	}

	@Override
	public String toString() {
		return "Block{" +
			"hash='" + hash + '\'' +
			", previousBlockHash='" + previousBlockHash + '\'' +
			", time=" + time +
			", fee=" + fee +
			", nonce=" + nonce +
			", transactionCount=" + transactionCount +
			", height=" + height +
			", transactions=" + Arrays.toString(transactions) +
		'}';
	}
}
