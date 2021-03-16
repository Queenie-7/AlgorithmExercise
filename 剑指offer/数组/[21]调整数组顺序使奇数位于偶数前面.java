//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。

//        示例：
//        输入：nums = [1,2,3,4]
//        输出：[1,3,2,4]
//        注：[3,1,2,4] 也是正确的答案之一。
//         
//        提示：
//        1 <= nums.length <= 50000
//        1 <= nums[i] <= 10000

//双指针。
class exchange{
    //    首尾指针
    //    i从左到右搜索偶数，j从右往左搜索奇数，奇偶交换。可始终保证： 指针 i 左边都是奇数，指针 j 右边都是偶数 。
    public int[] exchange(int[] nums){
        int i = 0,j=nums.length-1,tmp;
        while(i<j){
            while(i<j && (nums[i]&1)==1) i++;
            while(i<j && (nums[i]&1)==0) j--;
            tmp=nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
        }
        return nums;
    }
    // 快慢指针，i快指针，j慢指针。
    public int[] exchange2(int[] nums) {
        int j=0,t;
        for(int i=0;i<nums.length;i++){
            if((nums[i]&1)==1){
                t=nums[i];
                nums[i]=nums[j];
                nums[j]=t;
                j++;
            }
        }
        return nums;
    }

}