// 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。

// 示例:
// 输入: a = 1, b = 1
// 输出: 2 

// 提示：
// a, b 均可能是负数或 0
// 结果不会溢出 32 位整数

// 链接：https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof


// 位运算
// 无进位和 = 异或运算，进位 = 与运算 + 左移一位
// 将 s = a + b -> 无进位和 + 进位
// 当进位为0 时，无进位和即为所求，停止

// 递归 直观转化
class Solution{
	public int add(int a ,int b){
		if(b==0)
			return a;
		return add(a^b, (a&b)<<1); //与运算加括号
	}
}

// 循环
class Solution{
	public int add(int a ,int b){
		while(b!=0){
			int n = a^b ; //n 无进位和
			int c = (a&b)<<1; //c 进位
			a = n; // a 无进位和
			b = c; // b 进位
			
		}
		return a;
	}
}

class Solution{
	public int add(int a ,int b){
		while(b!=0){
			int c = (a&b)<<1; //c 进位
			a ^=b; // a 无进位和
			b = c; // b 进位	
		}
		return a;
	}
}