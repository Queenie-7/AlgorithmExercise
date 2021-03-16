// 如何得到一个数据流中的中位数？
// 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
// 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。

// 例如，
// [2,3,4] 的中位数是 3
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5

// 设计一个支持以下两种操作的数据结构：
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。
// double findMedian() - 返回目前所有元素的中位数。

// 示例 1：
// 输入：
// ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
// [[],[1],[2],[],[3],[]]
// 输出：[null,null,null,1.50000,null,2.00000]

// 示例 2：
// 输入：
// ["MedianFinder","addNum","findMedian","addNum","findMedian"]
// [[],[2],[],[3],[]]
// 输出：[null,null,2.00000,null,2.50000]

class MedianFinder{
	Queue<Integer> A,B; 
	public MedianFinder(){
		A = new PriorityQueue<>(); //存放较大一部分，小根堆
		B = new PriorityQueue<>((v1,v2)-> v2-v1); // 存放较小一部分，大根堆
	}

	public void addNum(int num){ //假设A中元素等于B中元素，或者多一个
		if(A.size()!=B.size()){ //加入B
			A.add(num);           //得先加入A，再把A的堆顶加入B，保证整体的排序
			B.add(A.poll());
		}else{                  //加入A
			B.add(num);
			A.add(B.poll());
		}
	}

	public double findMedian(){
		return A.size()!=B.size()? A.peek():(A.peek()+B.peek()) / 2.0；
	}
}