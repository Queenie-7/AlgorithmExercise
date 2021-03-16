//用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
//
//        示例 1：
//
//        输入：
//        ["CQueue","appendTail","deleteHead","deleteHead"]
//        [[],[3],[],[]]
//        输出：[null,null,3,-1]
// 栈底-栈顶；队头-队尾。
//思路：两个栈，第一个栈 栈顶入队；第二个栈将第一个栈中元素逆序，栈顶出队。

import java.util.LinkedList;

class CQueue {
    LinkedList<Integer> stack1,stack2;
    public CQueue() {
        stack1 = new LinkedList<Integer>();
        stack2 = new LinkedList<Integer>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if(!stack2.isEmpty())
            return  stack2.pop();
        if(stack1.isEmpty())
            return -1;
        while(!stack1.isEmpty())
            stack2.push(stack1.pop());
        return stack2.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */