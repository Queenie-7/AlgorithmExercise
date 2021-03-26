# 24.反转链表

//    定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。 
//        示例:
//        输入: 1->2->3->4->5->NULL
//        输出: 5->4->3->2->1->NULL
//         
//        限制：
//        0 <= 节点个数 <= 5000

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

####  关键

- 从第一个开始，一个个反转；

- 三指针

~~~java
public class Solution {
    public ListNode ReverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode next;
        while(cur!=null){
            // 先来记录cur.next
            next = cur.next;
            // 反转
            cur.next = pre;
            // 移动指针
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
~~~

