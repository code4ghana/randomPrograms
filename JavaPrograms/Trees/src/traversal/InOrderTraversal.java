package traversal;

import java.util.Stack;

import trees.BinaryTreeNode;
import trees.Traverser;

//lnr
public class InOrderTraversal extends Traverser {

	@Override
	public void print_recursive(BinaryTreeNode root) {
		// TODO Auto-generated method stub
		if (root == null) {
			return;
		}
		print_recursive(root.left);
		System.out.println(root.item);
		print_recursive(root.right);
	}

	@Override
	public void print_iterative(BinaryTreeNode root) {
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		BinaryTreeNode current = root;
		if (current == null) {
			return;
		}
		boolean done = false;
		while (done == false) {
			if (current != null) {
				// go through left subtree
				if (current.left != null) {
					stack.push(current);
					current = current.left;
				}

			} else {
				if (!stack.isEmpty()) {
					current = stack.pop();
					System.out.println(current.item);
					current = current.right;
				} else {
					done = true;
				}
			}
		}

	}

}
