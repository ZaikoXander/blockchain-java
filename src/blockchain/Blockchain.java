package blockchain;

import blockchain.block.Block;
import blockchain.block.BlockProps;
import blockchain.transaction.Transaction;
import blockchain.transaction.TransactionProps;
import blockchain.transaction.block.TransactionBlock;
import blockchain.transaction.items.input.Input;
import blockchain.transaction.items.input.InputProps;
import blockchain.transaction.items.input.PreviousOutput;
import blockchain.transaction.items.output.Output;
import blockchain.transaction.items.output.OutputProps;

import java.util.Arrays;
import java.util.Objects;

public class Blockchain {
	private int difficulty;
	private Block[] chain;

	public Blockchain() {
		this.difficulty = 5;
		this.chain = new blockchain.block.Block[]{ this.createInitialBlock() };
	}

	private Block createInitialBlock() {
		PreviousOutput previousOutput = new PreviousOutput("0".repeat(64), 13);
		InputProps inputProps = new InputProps("a".repeat(32), 0.0, true, previousOutput);
		Input[] inputs = { new Input(inputProps) };

		OutputProps outputProps = new OutputProps("b".repeat(32), 542);
		Output[] outputs = { new Output(outputProps) };

		boolean replaceByFee = false;
		TransactionProps transactionProps = new TransactionProps(inputs, outputs, replaceByFee);
		Transaction transaction = new Transaction(transactionProps);


		TransactionBlock transactionBlock = new TransactionBlock(0, 0);
		transaction.setBlock(transactionBlock);

		Transaction[] transactions = { transaction };

		BlockProps blockProps = new BlockProps(0, transactions, "0".repeat(64));
		Block initialBlock = new Block(blockProps);

		initialBlock.mineBlock(this.difficulty);

		return initialBlock;
	}

	public Block[] getChain() {
		return this.chain;
	}

	public Block getLatestBlock() {
		return this.chain[this.chain.length - 1];
	}

	public void addBlock(Transaction[] transactions) {
		long newBlockIndex = this.getLatestBlock().height + 1;
		Block newBlock = new Block(new BlockProps(newBlockIndex, transactions, this.getLatestBlock().hash));
		newBlock.mineBlock(this.difficulty);

		Block[] copyChain = this.chain;
		this.chain = new Block[copyChain.length + 1];
		System.arraycopy(copyChain, 0, this.chain, 0, copyChain.length);
		this.chain[this.chain.length - 1] = newBlock;
		System.out.println(this.chain.length);
	}

	public boolean isChainValid() {
		for (int i = 1; i < this.chain.length; i++) {
			Block currentBlock = this.chain[i];
			Block previousBlock = this.chain[i - 1];

			System.out.println(previousBlock.toString());
			System.out.println(currentBlock.toString());

			if (!Objects.equals(currentBlock.hash, currentBlock.calculateHash())) {
				return false;
			}

			if (!Objects.equals(currentBlock.previousBlockHash, previousBlock.hash)) {
				return false;
			}
		}

		return true;
	}
}
