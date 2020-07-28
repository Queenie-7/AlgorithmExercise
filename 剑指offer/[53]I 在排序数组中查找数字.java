// 统计一个数字在排序数组中出现的次数。

// 示例 1:
// 输入: nums = [5,7,7,8,8,10], target = 8
// 输出: 2

// 示例 2:
// 输入: nums = [5,7,7,8,8,10], target = 6
// 输出: 0
//  
// 限制：
// 0 <= 数组长度 <= 50000

//因为有序，所以可以二分查找，降低时间复杂度
//分别二分查找 target和 target - 1的右边界，将两结果相减并返回即可。
//helper() 函数旨在查找数字 target在数组 nums中的 插入点 ，且若数组中存在值相同的元素，则插入到这些元素的右边。
class Solution{
	public int search(int[] nums,int target){
		return helper(nums,target)-helper(num,target-1);
	}
	int helper(int[] nums,int target){
		int i=0, j=nums.length-1;
		while(i<=j){
			int m=(i+j)/2;
			if(nums[m]<=target)
				i=m+1;
			else j=m-1;
		}
		return i;
	}
}