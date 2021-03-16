// 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。

// 示例 1:
// 输入: [7,5,6,4]
// 输出: 5
 
// 限制：
// 0 <= 数组长度 <= 50000


//归并排序：归并两个有序数组的过程中，进行逆序对的计算。
//归并排序是利用分治思想，一分为二，在方法栈弹出时进行合并，排序。

class Solution{
	public int reversePairs(int[] nums){
		int len =nums.length;

		if(len<2)
			return 0;

		int[] copy = new int[len]; //不更改原数组
		for(int i = 0; i < len ;i++)
			copy[i] = nums[i];

		int[] tmp = new int[len];
		return reversePairs(copy,0,len-1,tmp);
	}

	private int reversePairs(int[] nums,int left,int right,int[] tmp){
		if(left==right)
			return 0;
		int mid = left +(right-left)/2;	// 防止大数越界
		int leftPairs = reversePairs(nums,left,mid,tmp);
		int rightPairs = reversePairs(nums,mid+1,right,tmp);

		//整个数组已经有序，则无需合并
		if(nums[mid]<=nums[mid+1])
			return leftPairs + rightPairs;

		int crossPais = mergeAndCount(nums,left,mid,right,tmp);
		
		return leftPairs+rightPairs+crossPais;
	}

	private int mergeAndCount(int[] nums,int left,int mid,int right,int[] tmp){
		for(int i=left;i<=right;i++){
			tmp[i] = nums[i];
		}

		int i =left;
		int j = mid+1;
		int count = 0;

		for(int k =left; k<=right;k++){
			//有下标访问，先判断是否越界
			if(i==mid+1){
				nums[k]=tmp[j];
				j++;
			}else if(j==right + 1){
				nums[k]=tmp[i];
				i++;
			}else if(tmp[i]<=tmp[j]){
				//注意 是<=，等于时 优先将第一个数组中的合并
				nums[k]=tmp[i];
				i++;
			}else{
				nums[k]=tmp[j];
				j++;
				// 第二个数组中的数合并时，计算逆序对
				count +=(mid -i+1);
			}
		}
		return count;
	}
}