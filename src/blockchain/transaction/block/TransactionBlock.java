package blockchain.transaction.block;

public class TransactionBlock extends PseudoBlock {
	private long height;
	private long position;

	public TransactionBlock(long height, long position) {
		this.height = height;
		this.position = position;
	}
}
