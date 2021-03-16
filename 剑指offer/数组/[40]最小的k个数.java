// 输入整数数组 arr ，找出其中最小的 k 个数。
// 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。

// 示例 1：
// 输入：arr = [3,2,1], k = 2
// 输出：[1,2] 或者 [2,1]

// 示例 2：
// 输入：arr = [0,1,2,1], k = 1
// 输出：[0]
//  
// 限制：
// 0 <= k <= arr.length <= 10000
// 0 <= arr[i] <= 10000


//快速排序
// 每次调用 partition 遍历的元素数目都是上一次遍历的 1/2，因此时间复杂度是 N + N/2 + N/4 + ... + N/N = 2N, 因此时间复杂度是 O(N)。
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr.length==0||k==0) 
            return new int[0];
        quickSort(arr, 0, arr.length-1, k-1); // 找到第K小的数，即归位k-1
        return Arrays.copyOf(arr,k);
    }
    void quickSort(int[] nums, int low, int high, int k){ //快排，使索引为k的数字归位,前面的比它小，后面的比它大
        int j = partitions(nums,low,high);
        if(k==j) 
            return;
        if(k<j) 
            quickSort(nums,low,j-1,k);
        else 
            quickSort(nums,j+1,high,k);
    }
    int partitions(int[] nums,int low, int high){ //划分，定位至j
        int v=nums[low], i = low ,j = high +1; //定位数v
        while(true){
            while(++i <= high && nums[i]<v);	//先移动找到比v大的i
            while(--j >= low && nums[j]>v);	//先移动找到比v小的j
            if(i>=j) 
                break;
            int t = nums[i]; //交换i j
            nums[i]=nums[j];
            nums[j]=t;
        }
        nums[low]=nums[j]; //把v换到j位置
        nums[j]=v;
        return j; //返回定位j
    }
}


// 大根堆（前k小)/小根堆（前k大)，利用java中现成的PriorityQueue,O(NlogK)

class Solution{
	public int[] getLeastNumbers(int[] arr,int k){
		if(k==0 || arr.length==0) 
            return new int[0];

		//构建大根堆，大小为K
		Queue<Integer> heap = new PriorityQueue<>((v1,v2)->v2-v1);//默认是小根堆，实现大根堆需要重写比较器
		for(int num:arr){
			if(heap.size()<k) 
                heap.offer(num);//数量小于k，直接入堆
			else if(num < heap.peek())｛  //数比堆顶小,堆顶出来，数进去
				heap.poll();
				heap.offer(num);

			｝ 
		}

		//返回堆元素
		int[] res = new int[k];
		int i=0;
		for(int num:heap) 
			res[i++]=num;
		return res;		
	}
}

// 两种方法的优劣性比较
// 看起来分治法的快速选择算法的时间、空间复杂度都优于使用堆的方法.
// 但是要注意到快速选择算法的几点局限性：
// 第一，算法需要修改原数组，如果原数组不能修改的话，还需要拷贝一份数组，空间复杂度就上去了。
// 第二，算法需要保存所有的数据。如果把数据看成输入流的话。
//      使用堆的方法是来一个处理一个，不需要保存数据，只需要保存 k 个元素的最大堆。
//      而快速选择的方法需要先保存下来所有的数据，再运行算法。
//      所以当数据量大的时候还是用基于堆的方法比较好。
