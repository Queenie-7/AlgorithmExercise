# 连续子数组的最大和

// 示例1:
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
// 输出: 6
// 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。



## 动态规划

要求：时间复杂度为O(n），空间复杂度为O(1)

- 维护前一个状态pre

- 前一个状态加上当前数字：
  - 大于0，加上
  - 小于等于0，不加上，重新为0



~~~java
public class Solution {
    /**
     * max sum of the subarray
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxsumofSubarray (int[] arr) {
        // write code here
        int res =0;
        int pre =0;
        for(int num:arr){
            pre = pre+num;
            if(pre>0){
                res = Math.max(res,pre);
            }else{
                pre =0;
            }
        }
        return res;
    }
}
~~~

