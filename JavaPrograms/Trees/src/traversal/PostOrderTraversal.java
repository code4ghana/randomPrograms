package traversal;

import java.util.Stack;

import trees.BinaryTreeNode;
import trees.Traverser;

//lrn
public class PostOrderTraversal extends Traverser {

	@Override
	public void print_recursive(BinaryTreeNode node) {
		// TODO Auto-generated method stub
		if (node == null) {
			return;
		}
		print_recursive(node.right);
		print_recursive(node.left);
		System.out.println(node.item);
	}

	@Override
	public void print_iterative(BinaryTreeNode node) {
		// TODO Auto-generated method stub
		if (node == null) {
			return;
		}
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		BinaryTreeNode lastPoped = null;
		stack.push(node);
		while (stack.isEmpty() == false) {
			BinaryTreeNode current = stack.pop();
			if (current != lastPoped) {
				lastPoped = current;
				if (current != null) {
					stack.push(current.left);
				}
				else{
					if(stack.isEmpty()==false){
					stack.push(current.right);}
				}
			}

			else {
				if (current != null) {
					System.out.println(current.item);
				}
			}
		}
	}

}
