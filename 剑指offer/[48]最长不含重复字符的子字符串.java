// 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。

// 示例 1:
// 输入: "abcabcbb"
// 输出: 3 
// 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

// 示例 2:
// 输入: "bbbbb"
// 输出: 1
// 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

// 示例 3:
// 输入: "pwwkew"
// 输出: 3
// 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
// 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//  
// 提示：
// s.length <= 40000


//动态规划+哈希表 O(N),O(1)
//状态定义：dp[j] 以 s[j] 结尾的最长子串长
// 转移方程：	dp[j]=dp[j-1]+1, dp[j-1]<j-i;	(s[i]不在dp[j-1]中)
// 				dp[j]=j-i,       dp[j-1]>=j-i; 	(s[i]在dp[j-1]中)

class Solution{
	public int lengthOfLongestSubstring(String s){

		HashMap<Character,Integer> map = new HashMap<>();//字符最后一次出现位置
		int res =0,tmp=0;//tmp 变量存储dp[j],res更新最大值

		for(int j =0;j<s.length();j++){

			int i = map.getOrDefault(s.charAt(j),-1);//查找i
			map.put(s.charAt(j),j);//更新

			tmp = tmp < j-i ？ tmp+1 : j-i; //dp[j-1]>j-i
			res = Math.max(res, tmp);
		}
		return res;
	}
}