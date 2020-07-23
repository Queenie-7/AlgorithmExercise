// 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。

// 示例 1:
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
// 输出: 2
//  

// 限制：
// 1 <= 数组长度 <= 50000


//哈希表统计 时空复杂度均为O(N)
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int s=nums.length/2;
        for(int num:nums){
            if(!map.containsKey(num)) map.put(num,1);
            else {
                int k=map.get(num);
                map.put(num,++k);
                if(k>s){
                    return num;
                } 
            }
        }
        return nums[0];
    }
}

//摩尔投票法：“正负抵消”，时空复杂度分别为O(N),O(1) 
class Solution {
    public int majorityElement(int[] nums) {
        int votes=0,x=nums[0];  //x为众数，votes对众数，非众数进行投票
        for(int num:nums){
            if(votes==0) x=num; //当votes为0，前面的正负抵消，从当前重新统计
            if(x==num) votes++;
            else votes--;
        }
        return x;
    }
}