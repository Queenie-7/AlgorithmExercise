// 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
// 调用 min、push 及 pop 的时间复杂度都是 O(1)。

// 示例:
// MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);
// minStack.min();   --> 返回 -3.
// minStack.pop();
// minStack.top();      --> 返回 0.
// minStack.min();   --> 返回 -2.
//  

// 提示：
// 各函数的调用总次数不超过 20000 次

class MinStack {

    Stack<Integer> A,B;
    /** initialize your data structure here. */
    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }
    
    public void push(int x) {
        A.add(x);
        if(B.empty() || B.peek() >= x)
            B.add(x);
    }
    
    public void pop() {
        if(A.pop().equals(B.peek()))  
            B.pop();
    }
    
    // 因为==在比较基本数据类型的时候才是比较内容大小，Integer不是基本数据类型，==比较的是引用的对象地址，
    // equals在没有重写的时候功能和==一样，重写之后就是比较内容大小，Integer对象已经重写了equals，所以是比较内容，
    // 所以要比较Integer内容不能用==，必须用重写之后的equals
    
    public int top() {
        return A.peek();

    }
    
    public int min() {
        return B.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */