package blockchain.tests;

import blockchain.block.Block;
import blockchain.tests.factories.BlockFactory;

public class BlockTest {
	public static void main(String[] args) {
		Block block = BlockFactory.execute();

		block.mineBlock(4);
	}
}
