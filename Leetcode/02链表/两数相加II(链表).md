# 454.两个链表生成相加链表II

假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。

给定两个这种链表，请生成代表两个整数相加值的结果链表。

例如：链表 1 为 9->3->7，链表 2 为 6->3，最后生成新的结果链表为 1->0->0->0。

**本题链表是从高位开始**



## 反转再相加

- 链表相加要从**个位开始**加，因此先反转

- 哑结点
- 当一个为null时，按节点为0处理
- flag进位
- 最后一位是否存在 9+99=108

~~~java
public class Solution {
    /**
     * 
     * @param head1 ListNode类 
     * @param head2 ListNode类 
     * @return ListNode类
     */
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        ListNode h1 = reverse(head1);
        ListNode h2 = reverse(head2);
        ListNode res = new ListNode(0);
        ListNode p = res;
        int flag=0;
        while(h1!=null || h2!=null){
            if(h1==null){
                h1 = new ListNode(0);
            }
            if(h2==null){
                h2 = new ListNode(0);    
            }
            int sum = h1.val+h2.val+flag;
            if(sum>=10){
                flag=1;
            }else{
                flag=0;
            }
            ListNode node = new ListNode(sum%10);
            p.next = node;
            p = p.next;
            h1 =h1.next;
            h2=h2.next;
        }
        if(flag==1){
            ListNode node = new ListNode(1);
            p.next = node;
        }
        return reverse(res.next);
    }
    
    // 先反转，从个位开始相加
    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp ;
        while(cur!=null){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
~~~

