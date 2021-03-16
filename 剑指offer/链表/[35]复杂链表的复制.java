// 请实现 copyRandomList 函数，复制一个复杂链表。
// 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null

// 示例 1：
// 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
// 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]

// 示例 2：
// 输入：head = [[1,1],[2,1]]
// 输出：[[1,1],[2,1]]

// 示例 3：
// 输入：head = [[3,null],[3,0],[3,null]]
// 输出：[[3,null],[3,0],[3,null]]

// 示例 4：
// 输入：head = []
// 输出：[]
// 解释：给定的链表为空（空指针），因此返回 null。


/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

// hashmap 
// 先把链表遍历一遍，将旧节点作为key，新初始化一个跟当前节点值相等的节点作为值存到HashMap中，
// 然后再从头遍历，每次遍历，用map中的值找到下一个节点和随机节点
class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map = new HashMap<>(); //<旧节点，新节点>
        
        Node cur=head;
        while(cur!=null){
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }
       
        cur = head;
        while(cur!=null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        
        return map.get(head);
    }
}