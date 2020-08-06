// 求 1+2+...+n 。
// 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

// 改写递归
// 递归
class Solution{
	public int sumNums(int n){
		if(n==1) return 1;
		n +=sumNums(n-1);
		return n;
	}
}

// 用短路代替判断
n > 1 && sumNums(n - 1) // 当 n = 1 时 n > 1 不成立 ，此时 “短路” ，终止后续递归


//java中构成语句 要添加辅助布尔量x 前后都为布尔输出
class Solution{
	public int sumNums(int n){
		boolean x = n>1 &&(n +=sumNums(n-1))>0
		return n;
	}
}