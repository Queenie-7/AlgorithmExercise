// 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
// 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。

// 示例 1:
// 输入: [1,2,3,4,5]
// 输出: True

// 示例 2:
// 输入: [0,0,1,2,5]
// 输出: True
//  

// 限制：
// 数组长度为 5 
// 数组的数取值为 [0, 13] .

// 两个条件：1.不重复（除了0外） 2.max-min<5

class Solution {
    public boolean isStraight(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max=-1,min=14;

        for(int num:nums){
        	// 遇到大小王 直接先跳过
            if(num==0)
                continue;
            // 重复失败
            if(set.contains(num)) 
            	return false;

            set.add(num);
            max=Math.max(max,num);
            min=Math.min(min,num);
        }
        
        return max-min<5;
    }
}