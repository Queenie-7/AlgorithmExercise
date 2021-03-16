
// 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
// 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。


// 例如:
// 给定二叉树: [3,9,20,null,null,15,7],

//     3
//    / \
//   9  20
//     /  \
//    15   7
// 返回其层次遍历结果：

// [
//   [3],
//   [20,9],
//   [15,7]
// ]

// BFS层遍历+双端队列

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()){
            LinkedList<Integer> tmp = new LinkedList<>(); //双端队列
            for(int i = queue.size();i>0;i--){
                TreeNode node = queue.poll();
                if(res.size() % 2 == 0) tmp.addLast(node.val); // 奇数层 -> 队列尾部
                else tmp.addFirst(node.val); // 偶数层 -> 队列头部
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}