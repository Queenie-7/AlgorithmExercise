// 输入一棵二叉树的根节点，求该树的深度。
// 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。

// 例如：
// 给定二叉树 [3,9,20,null,null,15,7]，

//     3
//    / \
//   9  20
//     /  \
//    15   7
// 返回它的最大深度 3 。
//  
// 提示：
// 节点总数 <= 10000

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


// DFS 后序遍历  效率更高
// 关键点：树的深度= max(左子树的深度,右子树的深度) +1
class Solution{
	public int maxDepth(TreeNode root){
		if(root == null) return 0;
		return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
	}
}


// BFS 层序遍历
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res=0;
        while(!queue.isEmpty()){
            res++;
            for(int i =queue.size();i>0;i--){
            TreeNode node = queue.poll();
            if(node.left!=null)
                queue.add(node.left);
            if(node.right!=null)
                queue.add(node.right);
            }
        }
        return res;
    }
}

