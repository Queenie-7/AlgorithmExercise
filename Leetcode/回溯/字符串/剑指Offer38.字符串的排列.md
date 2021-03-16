# 字符串的排列



输入一个字符串,按字典序打印出该字符串中字符的所有排列。

例如输入字符串“abc”,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。



## 1. 去重的全排列

类似于数字的全排列II，

~~~java
import java.util.*;
public class Solution {
    public ArrayList<String> Permutation(String str) {
       char[] chars = str.toCharArray();
       Arrays.sort(chars);
        int n = chars.length;
       ArrayList<String> res = new ArrayList<>();
        boolean[] used = new boolean[n];
        dfs(chars,res,n,0,new StringBuilder(),used);
        return res;
    }
    public void dfs(char[] chars,ArrayList<String> res,int n,int depth,StringBuilder path,boolean[] used){
        if(n==depth){
           res.add(path.toString());
            return ; 
        }
           
        for(int i =0;i<n;i++){
            // 选没用过的元素
            if(!used[i]){
                // 去重 剪枝
                if(i>0 && chars[i]==chars[i-1] && !used[i-1]){
                continue;
                }
                // 1. 加入路径
                path.append(chars[i]);
                used[i]=true;
                // 2. 向下递归
                dfs(chars,res,n,depth+1,path,used);
                // 3. 回溯
                // 注意!回退的是当下最后一个，不是i
                path.deleteCharAt(path.length()-1);
                used[i]=false;
            }
        }
    }
}
~~~

