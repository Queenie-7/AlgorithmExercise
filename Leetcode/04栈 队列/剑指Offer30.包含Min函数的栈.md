# 设计getMin功能的栈

实现一个特殊功能的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。

调用 min、push 及 pop 的时间复杂度都是 O(1)。

```
输入：
[[1,3],[1,2],[1,1],[3],[2],[3]]
有三种操作种类，op1表示push，op2表示pop，op3表示getMin。你需要返回和op3出现次数一样多的数组，表示每次getMin的答案
输出：
[1,2]
```

## 两个栈实现最小栈

一个栈正常出入，另一个栈维护最小元素

~~~java
public class Solution {
    /**
     * return a array which include all ans for op3
     * @param op int整型二维数组 operator
     * @return int整型一维数组
     */
 
    public int[] getMinStack (int[][] op) {
        // write code here
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack= new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<op.length;i++){
            // push
            if(op[i][0]==1){
                stack.push(op[i][1]);
                // 如果最小栈为空或此时更小，入最小栈
                if(minStack.isEmpty()||op[i][1]<minStack.peek()){
                    minStack.push(op[i][1]);
                }
            }
            // pop
            else if(op[i][0]==2){
                int tmp=stack.pop();
                // 最小栈顶和pop元素相同，也要pop
                if(tmp==minStack.peek()){
                    minStack.pop();
                }
            }
            // getMin
            else{
                res.add(minStack.peek());
            }
        }
        int[] ans = new int[res.size()];
        for(int i=0;i<res.size();i++){
            ans[i]=res.get(i);
        }
        return ans;
    }
}
~~~

