//        输入一个链表，输出该链表中倒数第k个节点。
//        为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
//        例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。
//        这个链表的倒数第3个节点是值为4的节点。

//        示例：
//        给定一个链表: 1->2->3->4->5, 和 k = 2.
//        返回链表 4->5.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class getKthFromEnd{
    //遍历统计个数
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p=head;
        int n=1;
        while(p.next!=null){
            p=p.next;
            n++;
        }
        p=head;
        int i=1;
        while(i!=n-k+1){
            p=p.next;
            i++;
        }
        return p;
    }
    // 快慢指针。快指针p比慢指针q先走k步，再同时出发，当p走出链表，q正好在倒数第K节点。
    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode p=head,q=head;
        for(int i=0;i<k;i++)
            p=p.next;
        while(p!=null){
            p=p.next;
            q=q.next;
        }
        return q;
    }
}