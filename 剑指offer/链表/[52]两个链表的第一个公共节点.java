/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

//个链表长度分别为L1+C、L2+C， C为公共部分的长度： 
// 第一个人走了L1+C步后，回到第二个人起点走L2步；第2个人走了L2+C步后，回到第一个人起点走L1步。 
// 当两个人走的步数都为L1+L2+C时就两个家伙就相爱了
// 注意：如果没有共同的，则最后都指向null时两节点相同，输出null。不用另外考虑。
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1=headA;
        ListNode node2=headB;
        while(node1!=node2){
        	node1 = node1!=null ? node1.next : headB;
        	node2 = node2!=null ? node2.next : headA;
        }
        return node1;
    }
}