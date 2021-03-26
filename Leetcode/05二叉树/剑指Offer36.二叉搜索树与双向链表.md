# 二叉搜索树->双向链表

输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。

要求不能创建任何新的结点，只能调整树中结点指针的指向。

## 递归 中序遍历

~~~java
public class Solution {
    TreeNode pre,head;
    public TreeNode Convert(TreeNode pRootOfTree) {
       if(pRootOfTree== null) return null;
        buildList(pRootOfTree);
        return head;
    }
    
    void buildList(TreeNode cur){
        // 递归结束
        if(cur==null) return;
        
        // 构建左子树
        buildList(cur.left);
        
        // 构建当前节点
        // 是否为头节点
        if(head==null){
            head = cur;
        }else{
            cur.left = pre;
            pre.right = cur; 
        }
        pre = cur;
        
        // 构建右子树
        buildList(cur.right);
        
    }
}
~~~



## 非递归

