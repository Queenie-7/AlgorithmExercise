
// 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。


// 例如:
// 给定二叉树: [3,9,20,null,null,15,7],

//     3
//    / \
//   9  20
//     /  \
//    15   7

// 返回其层次遍历结果：

// [
//   [3],
//   [9,20],
//   [15,7]
// ]

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// BFS 队列实现 + 临时列表存储当前层
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
    	Queue<TreeNode> queue = new LinkedList<>();
    	List<List<Integer>> res = new ArrayList<>();
    	if(root != null) queue.add(root);

    	while(!queue.isEmpty()){

    		List<Integer> tmp = new ArrayList<>();

    		for(int i = queue.size(); i > 0; i--){ 
    		   //用 i++ 的话，每轮都要获取 queue.size() 的值，而队列的长度是在变化的。
    			TreeNode node = queue.poll();
    			tmp.add(node.val);
    			if(node.left != null) queue.add(node.left);
    			if(node.right != null) queue.add(node.right);
    		}
    		
    		res.add(tmp);
    	}

    return res;
    }
}