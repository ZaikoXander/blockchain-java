package blockchain.tests.factories;

import blockchain.block.Block;
import blockchain.block.BlockProps;
import blockchain.transaction.Transaction;

public class BlockFactory {
	public static Block execute() {
		Transaction[] transactions = {
			TransactionFactory.execute(),
			TransactionFactory.execute(),
			TransactionFactory.execute(),
		};
		BlockProps blockProps = new BlockProps(4, transactions, "a43c8o833c5453");

		return new Block(blockProps);
	}
}
