// 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。
// 请找出那个只出现一次的数字。

// 示例 1：
// 输入：nums = [3,4,3,3]
// 输出：4

// 示例 2：
// 输入：nums = [9,1,7,9,7,9,7]
// 输出：1
//  
// 限制：
// 1 <= nums.length <= 10000
// 1 <= nums[i] < 2^31


// 位运算
// 每一位所有数加起来（排除那个数字）都能被3整除。
// 每一位所有数加起来，如果当前位能被3整除，则这个数该位为0，不能，则该位为1。
class Solution{
	public int singleNumber(int[] nums){
		if(nums.length==0) return -1;
		//java int类型有32位，其中首位为符号位
		int[] bitSum = new int[32];
		int res=0;
		//计算bitSum
		for(int num:nums){
			int bitMask = 1;
			for(int i =31;i>=0;i--){
				if((num&bitMask)!=0)
					bitSum[i]++;
				bitMask <<=1;
			}
		}
		// 判断当前位能够被3除，得结果
		// 这两步顺序不能变，否则最后一步会多左移一次
		for(int i =0;i<32;i++){
			res <<=1;
			res +=bitSum[i]%3;
		}
		return res;
	}
}