package juego;

public class Pair<L,R> {

	private L left;
	private R right;

	public Pair(L left, R right) {
		this.left = left;
		this.right = right;
	}

	public L getLeft() {
		return left;
	}
	
	public R getRight() {
		return right;
	}
	
	public void setLeft(L l) {
		left = l;
	}
	
	public void setRight(R r) {
		right = r;
	}
}