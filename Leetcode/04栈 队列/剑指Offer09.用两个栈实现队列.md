# [用两个栈实现队列](https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof)

用两个栈实现一个队列。

队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead 。(若队列中没有元素，deleteHead 操作返回 -1 )

~~~
输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]
~~~



## 两个栈： 一个正序入， 一个逆序出

- 加入队尾：
  -  将数字 val 加入栈 A 即可。
- 删除队首： 有以下三种情况。
  - 当栈 B 不为空： **B中仍有已完成倒序的元素**，因此直接返回 B 的栈顶元素。
  - 否则，当 A 为空： 即两个栈都为空，无元素，因此返回 -1。
  - 否则： 将栈 A 元素全部转移至栈 B 中，实现元素倒序，并返回栈 B 的栈顶元素。

~~~java
import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
        if(!stack2.isEmpty()){
            return stack2.pop();
        }else{
            if(stack1.isEmpty()){
               return -1;
            }
           while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
           }
            return stack2.pop();
        }
    }
}
~~~

