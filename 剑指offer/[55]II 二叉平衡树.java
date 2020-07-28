// 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
// 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。

// 示例 1:
// 给定二叉树 [3,9,20,null,null,15,7]
//     3
//    / \
//   9  20
//     /  \
//    15   7
// 返回 true 。

// 示例 2:
// 给定二叉树 [1,2,2,3,3,null,null,4,4]

//        1
//       / \
//      2   2
//     / \
//    3   3
//   / \
//  4   4
// 返回 false 。

// 限制：
// 1 <= 树的结点个数 <= 10000


// 方法一：后序遍历 + 剪枝 （从底至顶）
class Solution{
  public boolean isBalanced(TreeNode root){
    return dfs(root)!=-1;
  }
//后序遍历，自底向上,定义-1表示子树不平衡
  int dfs(TreeNode root){
    if(root==null) return 0;

    int left = dfs(root.left);
    if(left==-1) return -1;

    int right = dfs(root.right);
    if(right==-1) return -1;

    return Math.abs(left-right)<2 ? Math.max(left,right)+1 : -1;
  }
}

// 方法二：先序遍历 + 判断深度 （从顶至底）
// 不光计算根节点的左右子树高度差，还要保证左右子树都是平衡数
class Solution{
  public boolean isBalanced(TreeNode root){
    if(root == null) return true;
    return Math.abs(depth(root.left)-depth(root.right))<=1 && isBalanced(root.left) &&isBalanced(root.right);
  }

  int depth(TreeNode root){
    if(root == null ) return 0;
    return Math.max(depth(root.left),depth(root.right))+1;
  }
}