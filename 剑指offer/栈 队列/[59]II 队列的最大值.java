// 请定义一个队列并实现函数 max_value 得到队列里的最大值，
// 要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
// 若队列为空，pop_front 和 max_value 需要返回 -1

// 示例 1：
// 输入: 
// ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
// [[],[1],[2],[],[],[]]
// 输出: [null,null,null,2,1,2]

// 示例 2：
// 输入: 
// ["MaxQueue","pop_front","max_value"]
// [[],[],[]]
// 输出: [null,-1,-1]

// 限制：
// 1 <= push_back,pop_front,max_value的总操作数 <= 10000
// 1 <= value <= 10^5


// 另外维护一个单调递减队列
class MaxQueue {

	Queue<Integer> queue;
	Deque<Integer> deque;
    public MaxQueue() {
    	queue = new LinkedList<>();
    	deque = new LinkedList<>();
    }
    
    public int max_value() {
    	if(!deque.isEmpty())
    		return deque.peekFirst();
    	return -1;
    }
    
    public void push_back(int value) {
    	queue.add(value);
    	while(!deque.isEmpty() && value>deque.peekLast())
    		deque.removeLast();
    	deque.add(value);
    }
    
    public int pop_front() {
    	if(queue.isEmpty())
    		return -1;
    	if(queue.peek().equals(deque.peek()))
    		deque.pop();
    	return queue.poll();

    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */