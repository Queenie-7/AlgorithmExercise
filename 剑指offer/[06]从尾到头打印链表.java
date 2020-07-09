//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

//        示例 1：
//        输入：head = [1,3,2]
//        输出：[2,3,1]


import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
//思路:利用栈先入后出的特点，从尾到头打印链表。
class reversePrint{
    public int[] reversePrint(ListNode head) {
        //节点入栈
       Stack<ListNode> stack = new Stack<ListNode>();
       ListNode temp = head;
       while (temp!=null){
           stack.push(temp);
           temp=temp.next;
       }
       //节点出栈，取数到数组
       int size=stack.size();
       int[] print = new int[size];
       for(int i =0;i<size;i++)
           print[i] = stack.pop().val;
       //打印数组
       return print;
    }
}