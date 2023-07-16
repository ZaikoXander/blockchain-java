package blockchain.tests;

import blockchain.Blockchain;
import blockchain.tests.factories.TransactionFactory;
import blockchain.transaction.Transaction;

public class BlockchainTest {
	public static void main(String[] args) {
		Blockchain blockchain = new Blockchain();
		Transaction[] transactions = { TransactionFactory.execute() };
		blockchain.addBlock(transactions);
		blockchain.addBlock(transactions);

		System.out.println("Is chain valid? " + blockchain.isChainValid());
	}
}
