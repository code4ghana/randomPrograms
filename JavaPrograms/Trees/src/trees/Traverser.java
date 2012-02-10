package trees;

public abstract class Traverser {
public BinaryTreeNode find(BinaryTreeNode node,int item){	// TODO Auto-generated method stub
	if(node==null)
		return null;
	//found it
	if(node.item==item){
		return node;
	}
	//go to left subtree
	if(node.item>item){
		return find(node.left,item);
	}
	//go to right subtree
	if(node.item<item)
		return find(node.right,item);
	
	return null;
};
public abstract void print_recursive(BinaryTreeNode node);
public abstract void print_iterative(BinaryTreeNode node);
}
