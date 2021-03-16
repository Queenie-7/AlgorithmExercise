# 重建二叉树

输入某二叉树的**前序遍历和中序遍历**的结果，请重建该二叉树。

假设输入的前序遍历和中序遍历的结果中**都不含重复**的数字。

    例如，
    前序遍历 preorder = [3,9,20,15,7]
    中序遍历 inorder = [9,3,15,20,7]
    
    返回如下的二叉树
    
        3
       / \
      9  20
        /  \
       15   7


## 哈希表 + 递归

- 哈希表存放中序遍历，方便取前序根结点在中序的位置

- 递归

  buildTree(前序根索引，左边界，右边界){

  ​	构造当前根结点

  ​	左子树递归构建

  ​	右子树递归构建

  }

- 递归终止条件：

  - left>right 

~~~java
import java.util.*;
public class Solution {
    // 存放中序遍历，方便查找root位置
    Map<Integer,Integer> map = new HashMap<>();
    // 全局的前序
    int[] p;
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        // 准备工作：前序全局，中序哈希
        p = pre;
        for(int i =0;i<in.length;i++){
            map.put(in[i],i);
        }
        // 递归构建
       return  buildTree(0,0,in.length-1);
        
    }
    
    private TreeNode buildTree(int root,int left,int right){
        // 递归终止
        if(left>right) return null;
        // 构建当前根结点
        TreeNode node = new TreeNode(p[root]);
        // 找左右子树的根结点和范围
        int index = map.get(p[root]);
        node.left = buildTree(root+1,left,index-1);
        node.right = buildTree(root+index-left+1,index+1,right);
        return node;
    }
        
    
}
~~~

