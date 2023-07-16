package blockchain.transaction.block;

public class Mempool extends PseudoBlock {
	private long mempool;

	public Mempool(long mempool) {
		this.mempool = mempool;
	}

	public long getMempool() {
		return this.mempool;
	}
}
