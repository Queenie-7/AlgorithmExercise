# 连续子数组的最大和

## 1. 确保有正有负；

// 示例1:
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
// 输出: 6
// 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。



### 动态规划

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

## 2. 不一定有正，可能全为负

F（i）：以array[i]为末尾元素的子数组的和的最大值，子数组的元素的相对位置不变

F（i）=max（F（i-1）+array[i] ， array[i]）

~~~java
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length==0) return 0;
        int pre = array[0];
        int res = array[0];
        for(int i=1;i<array.length;i++){
            pre = Math.max(array[i],pre+array[i]);
            res = Math.max(pre,res);
        }
        return res;
    }
}
~~~



