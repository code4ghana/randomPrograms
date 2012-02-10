import java.util.Iterator;
import java.util.Stack;

public class Set<Key extends Comparable<Key>> implements Iterable<Key> {
	public Node root;

	public Key get(Key key) {
	
		
		return get(root, key);
		
	}

	private Key get(Node x, Key key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return get(x.left, key);
		else if (cmp > 0)
			return get(x.right, key);
		else
			return x.key;
	}

	public boolean contains(Key key) {
		return (get(key) != null);
	}

	public void put(Key key) {
		root = put(root, key);
	}

	private Node put(Node x, Key key) {
		if (x == null) {
			Node n = new Node(key);
			return n;
		}

		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			x.left = put(x.left, key);
		if (cmp > 0)
			x.right = put(x.right, key);

		return x;
	}

	public class Node {
		Key key;

		Node left, right;

		public Node(Key key) {
			this.key = key;
		}
	}

	public Set<Key> intersection(Set<Key> t) {
		Set<Key> answer = new Set<Key>();
		Iterator<Key> sItr = iterator();
		while (sItr.hasNext()) {
			Key currentkey = sItr.next();
			if (!answer.contains(currentkey) && t.contains(currentkey)) {
				answer.put(currentkey);
			}
		}
		return answer;

	}

	public Set<Key> union(Set<Key> t) {
		Set<Key> answer = new Set<Key>();
		Iterator<Key> itrthis = iterator();
		Iterator<Key> tItr = t.iterator();
		while (itrthis.hasNext()) {
			Key currentkey = itrthis.next();
			if (!answer.contains(currentkey)) {
				answer.put(currentkey);
			}
		}
		while (tItr.hasNext()) {
			Key currentkey = tItr.next();
			if (!answer.contains(currentkey)) {
				answer.put(currentkey);
			}
		}
		return answer;
	}

	public Set<Key> minus(Set<Key> t) {
		Iterator<Key> sItr = iterator();
		Iterator<Key> tItr = t.iterator();
		Set<Key> answer = new Set<Key>();
		while (sItr.hasNext()) {
			Key current = sItr.next();
			if (!t.contains(current)) {
				answer.put(current);
			}
		}
		return answer;

	}

	public Iterator<Key> iterator() {
		return new BSTIterator();
	}

	public class BSTIterator implements Iterator<Key> {
		Stack<Node> stack = new Stack<Node>();

		private void pushLeft(Node x) {
			while (x != null) {
				stack.push(x);
				x = x.left;
			}
		}

		BSTIterator() {
			pushLeft(root);
		}

		public boolean hasNext() {
			return !stack.isEmpty();
		}

		public Key next() {
			Node x = stack.pop();
			pushLeft(x.right);
			return x.key;
		}

		// public void remove(Key key) {
		// if (contains(key)){
		//				
		// }
		//				
		// }

		@Override
		public void remove() {

			// TODO Auto-generated method stub

		}

	}
	public static void main(String args[]){
		System.out.print("enter the values for the first set (S): ");
		
	}
}
