// 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

// 示例:
// s = "abaccdeff"
// 返回 "b"

// s = "" 
// 返回 " "
//  
// 限制：
// 0 <= s 的长度 <= 50000

// 哈希表
class Solution{
	public char firstUniqChar(String s){
		HashMap<Characrer,Boolean> map = new HashMap<>(); //值存boolean型简单
		char[] chars = s.toCharArray();
		for(char c:chars)
			map.put(c,!map.containsKey(c)); //不包含即为第一次出现，为true
		for(char c:chars)
			if(map.get(c))
				return c;
		return ' ';
	}
}


//数组
public class firstUniqChar {
    public char firstUniqChar(String s) {
        int[] count = new int[256];
        char[] chars = s.toCharArray();
        for(char c : chars)
            count[c]++;        //c隐形转换成int,索引代表此char的ASCII代码
        for(char c : chars){
            if(count[c] == 1)
                return c;
        }
        return ' ';
    }
}

