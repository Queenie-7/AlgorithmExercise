// 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
// 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。

// 示例 1：
// 输入: n = 5, m = 3
// 输出: 3

// 示例 2：
// 输入: n = 10, m = 17
// 输出: 2
//  
// 限制：
// 1 <= n <= 10^5
// 1 <= m <= 10^6

// 链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof

//方法一：模拟链表O(n^2)，LinkedList超时，ArrayList勉强
class Solution{
	public int lastRemaining(int n,int m){
		ArrayList<Integer> list = new ArrayList<>(n);
		for(int i=0;i<n;i++){
			list.add(i);
		}
		int idx=0;
		while(n>1){
			//当前位置删除了，后面的数字会前移一位
			idx = (idx+m-1)%n;
			list.remove(idx);
			n--;
		}
		return list.get(0);
	}
}

// 约瑟夫环，数学解法
// 只关注最后所剩数字的下标，最后下标为0，倒推
// (当前index + m) % 上一轮剩余数字的个数。
class Solution{
	public int lastRemaining(int n,int m){
		int idx=0;
		// 最后一轮剩下2个人，从2开始反推
		for（int i=2,i<=n;i++）{
			idx = (idx+m)%i;
		}
		return idx;
	}
}
