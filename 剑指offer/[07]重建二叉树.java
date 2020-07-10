//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

//   例如，给出
//
//        前序遍历 preorder = [3,9,20,15,7]
//        中序遍历 inorder = [9,3,15,20,7]
//    返回如下的二叉树：
//
//         3
//        / \
//        9  20
//          /  \
//         15   7
//思路：递归构建二叉树。前序遍历找根，中序遍历找左右子树。
import java.util.HashMap;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class buildTree{
    //存放中序序列，便于查找根节点
    HashMap<Integer,Integer> dic = new HashMap<>();
    //全局变量：前序序列
    int[] po;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        po = preorder;
        for(int i=0; i<inorder.length;i++)
            dic.put(inorder[i],i);
        //传入变量：前序根节点位置，中序序列左边界，中序序列右边界
        return  recur(0,0,inorder.length -1);
    }

    //recur()自定义的递归函数，用于创建当前根节点，并向下分别递归左右子树。
    TreeNode recur(int pre_root,int in_left,int in_right){
        //终止条件：
        if(in_left > in_right) return null;
        //当前 前序序列中根节点
        TreeNode root = new TreeNode(po[pre_root]);
        //当前根节点在中序序列中位置
        int i = dic.get(po[pre_root]);
        //左子树：根节点为前序序列左子树的第一个（根+1），中序左右边界
        root.left = recur(pre_root+1,in_left,i-1);
        //右子树：根节点为前序序列右子树的第一个（根+左子树长度+1），中序左右边界
        root.right = recur(pre_root + i -in_left+1,i+1,in_right);
        return  root;
    }
}