// 输入一个字符串，打印出该字符串中字符的所有排列。
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 

// 示例:
// 输入：s = "abc"
// 输出：["abc","acb","bac","bca","cab","cba"]
//  
// 限制：
// 1 <= s 的长度 <= 8

//回溯

class Solution {
    LinkedList<String> res = new LinkedList<>();
    char[] ans;

    public String[] permutation(String s) {
        ans=s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    void dfs(int x){  //固定至第x位
        if(x == ans.length-1){
            res.add(String.valueOf(ans));
            return;
        } 

        HashSet<Character> set = new HashSet<>();
        for(int i = x; i<ans.length;i++){  // 循环，使没固定的都可以依次在x位

            if(set.contains(ans[i])) continue;//避免重复字符，剪枝
            set.add(ans[i]);

            swap(x,i); //通过交换，使第i个字符固定到第x位
            dfs(x+1);  //固定下一位
            swap(x,i); //恢复
        }

    }

    void swap(int a ,int b){
        char tmp = ans[a];
        ans[a] = ans[b];
        ans[b] = tmp;
    }
}