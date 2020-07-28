// 给定一棵二叉搜索树，请找出其中第k大的节点。

// 示例 1:
// 输入: root = [3,1,4,null,2], k = 1
//    3
//   / \
//  1   4
//   \
//    2
// 输出: 4

// 示例 2:
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//        5
//       / \
//      3   6
//     / \
//    2   4
//   /
//  1
// 输出: 4
//  
// 限制：
// 1 ≤ k ≤ 二叉搜索树元素个数

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// 二叉搜索树有序，倒中序遍历，右中左，从大到小


class Solution {
    int res,count;
    
    public int kthLargest(TreeNode root, int k) {
        count=k;
        dfs(root);
        return res;
    }

    void dfs(TreeNode root){
        if(root==null) return;
        dfs(root.right);

        count--;
        if(count==0){
            res=root.val;
            return;
        }

        dfs(root.left);
    }
 }

// 倒中序遍历
void dfs(TreeNode root){
	if(root==null) return;
	dfs(root.right);
	System.out.printlin(root.val);
	dfs(root.left);
}