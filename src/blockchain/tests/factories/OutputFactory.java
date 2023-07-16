package blockchain.tests.factories;

import blockchain.transaction.items.output.Output;
import blockchain.transaction.items.output.OutputProps;

public class OutputFactory {
	public static Output execute() {
		OutputProps outputProps = new OutputProps("8ac53475a43c598734c8f34", 30);

		return new Output(outputProps);
	}
}
