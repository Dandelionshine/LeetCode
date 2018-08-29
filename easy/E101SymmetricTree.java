package easy;

import java.util.Stack;

//判断一棵树是不是平衡树

public class E101SymmetricTree {

	
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		E101SymmetricTree  e = new E101SymmetricTree();
		E101SymmetricTree.TreeNode root = e.new TreeNode(1);
		root.left = e.new TreeNode(2);
		root.right = e.new TreeNode(2);
		root.left.left = e.new TreeNode(3);
		root.right.left = e.new TreeNode(3);
		root.left.right = e.new TreeNode(4);
		root.right.right = e.new TreeNode(3);
		System.out.println(e.isSymmetric2(root));
		
	}
	
	//递归方式
	public boolean isSymmetric(TreeNode root) {
		return root == null || isSymmetricHelp(root.left,root.right);
    }
	private boolean isSymmetricHelp(TreeNode left,TreeNode right) {
		if(left == null || right == null) return left == right;
		if(left.val != right.val) return false;
		return isSymmetricHelp(left.left,right.right) && isSymmetricHelp(left.right,right.left);
		
    }
	
	
	//迭代方式，使用栈
	public boolean isSymmetric2(TreeNode root) {
		if(root == null) return true;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root.left);
		stack.push(root.right);
		
		while(!stack.isEmpty()) {
			E101SymmetricTree.TreeNode right = stack.pop();
			E101SymmetricTree.TreeNode left = stack.pop();
			if(right == null && left == null) continue;
			if(right == null || left == null) return false;
			if(right.val != left.val) return false;
			stack.push(right.left);
			stack.push(left.right);
			stack.push(right.right);
			stack.push(left.left);
		}
		return true;
		
    }
	
}


//Definition for a binary tree node.


