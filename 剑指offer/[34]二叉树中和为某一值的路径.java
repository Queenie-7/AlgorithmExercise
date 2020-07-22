
// 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
// 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。

 
// 示例:
// 给定如下二叉树，以及目标和 sum = 22，

//               5
//              / \
//             4   8
//            /   / \
//           11  13  4
//          /  \    / \
//         7    2  5   1

// 返回:
// [
//    [5,4,11,2],
//    [5,8,4,5]
// ]

class Solution{
	List<List<Integer>> res = new ArrayList<>();
	LinkedList<Integer> path = new LinkedList<>();
	public List<List<Integer>> pathSum(TreeNode root,int sum){
		recur(root, sum);
		return res;
	}
	void recur(TreeNode root,int target){
		if(root == null) return;
		path.add(root.val);
		target -= root.val;
		if(target==0 && root.left==null && root.right==null){
			res.add(new LinkedList(path)); //注意要新new 一个path 才可以，不然对象path加入res，后续会变化。
		}
		recur(root.left,target);
		recur(root.right,target);
		path.removeLast();
	}
}