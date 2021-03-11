# K个一组反转链表

将给出的链表中的节点每 *k* 个一组翻转，返回翻转后的链表
如果链表中的节点数不是 *k* 的倍数，将最后剩下的节点保持原样
你不能更改节点中的值，只能更改节点本身。
要求空间复杂度 *O*(1)

例如：

给定的链表是1→2→3→4→5

对于  *k*=2, 你应该返回2→1→4→3→5

对于  *k*=3, 你应该返回 3→2→1→4→5

## 分段头插法

- 分段反转，不足K的组不用反转

  循环一次计算长度，循环 `len/k`

- 每段用头插法循环 `k-1` 次

  - `pre` 作为每段的头
  - 每段反转完成，移动`pre` ， `cur` 指针

- 头插法

  - **插入cur 后的tmp结点到pre后面**
  - 首先记录tmp
  - tmp断连，cur.next 连上 tmp.next
  - 插入到pre后面

~~~java
public class Solution{
	public ListNode reverseKGroup(ListNode head,int k){
		if(head==null || head.next==null ||k==1) 
            return head;
        // 哑结点
        ListNode res = new ListNode(0);
        res.next = head;
        
        ListNode pre = res;
        ListNode cur = head;
        ListNode tmp;
            
        // 计算长度
        int len=0;
        while(head!=null){
            len++;
            head = head.next;
        }
        
        // 分段处理
        for(int i=0;i<len/k;i++){
            // 头插法，pre作为段的头，反转插入k-1次
            //  0->1->2->3
			for(int j=1;j<k;j++){
                tmp = cur.next; // 头插法：插入2
                cur.next = tmp.next; // 1->3
                // 2 ->1 ,0->2
                tmp.next = pre.next;// （tmp需要连接的不是前一个点，而是pre后的点），tmp.next = cur是错误的
                pre.next = tmp;
            }
            // 0->3->2->1->4,一段处理完，移动pre,cur指针
            pre = cur; //  pre->1
            cur = cur.next; // cur->4
        }
		return res.next;        
	}
}
~~~



## 栈实现

## 递归



