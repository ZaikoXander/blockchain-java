package blockchain.tests;

import blockchain.tests.factories.TransactionFactory;
import blockchain.transaction.Transaction;

public class TransactionTest {
	public static void main(String[] args) {
		Transaction transaction = TransactionFactory.execute();

		System.out.println(transaction.getProperties().getHash());
	}
}