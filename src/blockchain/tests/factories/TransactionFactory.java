package blockchain.tests.factories;

import blockchain.transaction.Transaction;
import blockchain.transaction.TransactionProps;
import blockchain.transaction.items.input.Input;
import blockchain.transaction.items.output.Output;

public class TransactionFactory {
	public static Transaction execute() {
		Input[] inputs = {
			InputFactory.execute(),
			InputFactory.execute(),
			InputFactory.execute(),
		};

		Output[] outputs = {
			OutputFactory.execute(),
			OutputFactory.execute(),
			OutputFactory.execute(),
		};
		TransactionProps transactionProps = new TransactionProps(inputs, outputs, false);
		Transaction transaction = new Transaction(transactionProps);

		return transaction;
	}
}
