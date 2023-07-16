package blockchain.tests.factories;

import blockchain.transaction.items.input.Input;
import blockchain.transaction.items.input.InputProps;
import blockchain.transaction.items.input.PreviousOutput;

public class InputFactory {
	public static Input execute() {
		PreviousOutput previousOutput = new PreviousOutput("b2983aed4457f", 30);
		InputProps inputProps = new InputProps("7ec4a83dc4f7f45", 100.0, false, previousOutput);

		return new Input(inputProps);
	}
}
