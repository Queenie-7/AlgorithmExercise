//        输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
//        B是A的子结构， 即 A中有出现和B相同的结构和节点值。
//
//        例如:
//        给定的树 A:
//
//             3
//            / \
//           4   5
//          / \
//         1   2
//        给定的树 B：
//
//           4 
//          /
//         1
//        返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
//
//        示例 1：
//        输入：A = [1,2,3], B = [3,1]
//        输出：false
//
//        示例 2：
//        输入：A = [3,4,5,1,2], B = [4,1]
//        输出：true
//
//        限制：
//        0 <= 节点个数 <= 10000
//思路：
//1.先序遍历A中每个节点 isSubStructure(A,B);
//2.判断树A中是否包含B recur(A,B);


class SubStructure{
    public boolean isSubStructure(TreeNode A,TreeNode B){
        return (A!=null && B!=null) && (recur(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B));
    }
    boolean recur(TreeNode A,TreeNode B){
        if(B==null) return  true; //必须先判断B是否为空，此时A可能为空
        if(A==null || A.val != B.val) return  false;
        return recur(A.left,B.left) && recur(A.right,B.right);
    }
}