package assign07;

public class Node<E> {
	E value;
	Node<E> leftNode;
	Node<E> rightNode;
	Node<E> parentNode;
	
	public Node(E value) {
		this.value = value;
		this.leftNode = null;
		this.rightNode = null;
		this.parentNode = null;
	}
}
