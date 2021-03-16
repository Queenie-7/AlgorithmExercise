// 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
// 要求不能创建任何新的节点，只能调整树中节点指针的指向。

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

// 本质：二叉搜索树的 中序遍历 为递增序列 。
// 在中序遍历过程中构建排序的双链表，遍历结束再构建循环。
class Solution {
    Node pre,head;
    public Node treeToDoublyList(Node root) {
        if(root==null) return null;
        recur(root); //构建双链表

        head.left=pre; //构建循环
        pre.right=head;
       
        return head;

    }
    void recur(Node cur){  //中序遍历
        if(cur==null) return;

        recur(cur.left);

        if(pre==null) head=cur; //对遍历节点的处理
        else{
        pre.right=cur;
        cur.left=pre;
        }
        pre=cur;

        recur(cur.right);
    }
}


// 打印中序遍历
void dfs(TreeNode root) {
    if(root == null) return;
    dfs(root.left); // 左
    System.out.println(root.val); // 根
    dfs(root.right); // 右
}