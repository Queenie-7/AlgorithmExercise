// 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。

// 示例:
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
// 输出: [3,3,5,5,6,7] 
// 解释: 

//   滑动窗口的位置                最大值
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7
//  
// 提示：
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小


//单调递减队列，双指针移动，有点类似最小栈
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];

        for(int j = 0, i = 1 - k; j < nums.length; i++, j++) {
        	// 左边滑出的是否在队首
            if(i > 0 && deque.peekFirst() == nums[i - 1])
                deque.removeFirst(); 
            // 保持 deque 递减
            while(!deque.isEmpty() && deque.peekLast() < nums[j])
                deque.removeLast(); 
            deque.addLast(nums[j]);

            // 记录窗口最大值
            if(i >= 0)
                res[i] = deque.peekFirst();  
        }
        return res;
    }
}

