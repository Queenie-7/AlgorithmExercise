// 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
// 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
// 参考以下这颗二叉搜索树：

//      5
//     / \
//    2   6
//   / \
//  1   3

// 示例 1：
// 输入: [1,6,3,2,5]
// 输出: false

// 示例 2：
// 输入: [1,3,2,6,5]
// 输出: true

// 后序遍历定义： [ 左子树 | 右子树 | 根节点 ] ，即遍历顺序为 “左、右、根” 。
// 二叉搜索树定义： 左子树中所有节点的值 < 根节点的值；右子树中所有节点的值 > 根节点的值；其左、右子树也分别为二叉搜索树。

// 递归：
// 终止条件： 当 i>= j ，说明节点数<=1，不需要判断直接返回 true;
// 递推工作： 找到第一个大于根节点 j 的数 索引记为 m ，作为右子树的开始节点，将序列划分为[i,m-1] [m,j-1]
//           判断右子树是否都满足大于根节点

class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder,0,postorder.length-1);
    }
    boolean recur(int[] postorder,int i ,int j){
        if(i >= j) return true;
        int p = i;
        while(postorder[p] < postorder[j]) p++;
        int m = p;
        while(postorder[p] > postorder[j]) p++;
        return p == j && recur(postorder,i,m-1) && recur(postorder,m,j-1);
    }
}