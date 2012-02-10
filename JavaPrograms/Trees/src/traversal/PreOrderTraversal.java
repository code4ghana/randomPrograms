package traversal;

import java.util.Stack;

import trees.BinaryTreeNode;
import trees.Traverser;
//nlr
public class PreOrderTraversal extends Traverser {

	@Override
	public void print_recursive(BinaryTreeNode node) {
		// TODO Auto-generated method stub
	if(node==null){
		return;
	}	
	System.out.println(node.item);
	print_recursive(node.left);
	print_recursive(node.right);
	}

	@Override
	public void print_iterative(BinaryTreeNode node) {
		// TODO Auto-generated method stub
		Stack<BinaryTreeNode> stack=new Stack<BinaryTreeNode>();
		BinaryTreeNode current=node;
		boolean done=false;
		while(done=false){
			if(current!=null){
				System.out.println(current.item);
				stack.push(current);
				current=current.left;
			}
			else{
				if(!stack.isEmpty()){
				current=stack.pop();
				current=current.right;}
				else{
					done=true;
				}
				
			}
		}
	}

}
