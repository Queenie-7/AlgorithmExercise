# [链表内指定区间反转](https://leetcode-cn.com/problems/reverse-linked-list-ii)

给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。

示例 1：

<img src="https://assets.leetcode.com/uploads/2021/02/19/rev2ex2.jpg" alt="img" style="zoom:50%;" />

输入：head = [1,2,3,4,5], left = 2, right = 4
输出：[1,4,3,2,5]

## 头插法

解题思路：
1、我们定义两个指针，分别称之为 g(guard 守卫) 和 p(point)。
我们首先根据方法的参数 m 确定 g 和 p 的位置。将 g 移动到第一个要反转的节点的前面，将 p 移动到第一个要反转的节点的位置上。我们以 m=2，n=4为例。
2、**将 p 后面的元素删除，然后添加到 g 的后面。也即头插法**。
3、根据 m 和 n 重复步骤（2）
4、返回dummyHead.next

![img1.png](https://pic.leetcode-cn.com/1616250561-sZiIjN-img1.png)

![img2.png](https://pic.leetcode-cn.com/1616250596-ApUPKJ-img2.png)



~~~java
public class Solution {
    /**
     * 
     * @param head ListNode类 
     * @param m int整型 
     * @param n int整型 
     * @return ListNode类
     */
    public ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        // 初始化从dummyHead开始
        ListNode pre = dummyHead;
        
        // pre走到m-1
        int step =0;
        while(step<m-1){
            pre =pre.next;
            step++;
        }
        // pre 和 p 指针是不变的
        // p为开始反转点,反转n-m次
        ListNode p = pre.next;
        for(int i=0;i<n-m;i++){
            // 将p后的tmp，插入pre后
            // 1.删除
            ListNode tmp = p.next; // 记录tmp
            p.next = tmp.next; // 删除tmp
            // 2.插入
            tmp.next = pre.next;
            pre.next = tmp; // 插入pre后
    
        }
        
        return dummyHead.next;
    }
}
~~~

