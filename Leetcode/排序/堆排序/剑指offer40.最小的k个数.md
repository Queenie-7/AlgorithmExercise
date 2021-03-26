# 剑指offer40.最小的K个数

设计一个算法，找出数组中最小的k个数。以**任意顺序**返回这k个数均可。

**示例：**

```
输入： arr = [1,3,5,7,2,4,6,8], k = 4
输出： [1,2,3,4]
```



### 堆排序和快排比较

- 看起来分治法的快速选择算法的时间、空间复杂度都优于使用堆的方法.

- 快速选择算法的几点局限性：
  - 第一，算法需要修改原数组，如果原数组不能修改的话，还需要拷贝一份数组，空间复杂度就上去了。
  - 第二，算法需要保存所有的数据。如果把数据看成输入流的话。
    - 使用堆的方法是来一个处理一个，不需要保存数据，只需要保存 k 个元素的最大堆。
    - 而快速选择的方法需要先保存下来所有的数据，再运行算法。所以当数据量大的时候还是用基于堆的方法比较好。



## 堆排序

- 堆用java中现成的优先队列`PriorityQueue` ，`O(NlogK)`
  - 优先队列，默认是小根堆
  - 实现大根堆重写比较器 `PriorityQueue<>((v1,v2)-> v2-v1)`
- 维护一个数量为`K`的堆，
- 选出前K个小数组成的堆，那么要使**堆的根**为堆的数中最大的，
- 每来一个数
  - 堆中数量不足，直接加入堆
  - 堆中数量满了，和堆顶比较，比堆顶小，堆顶出去，加入



~~~java
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
~~~





## 快排

基准数分割两部分，当基准数的`pos==k-1` 时，就分好了前k个数最小。



~~~java
class Solution {
    public int[] smallestK(int[] arr, int k) {
        quickSort(arr,0,arr.length-1,k);
        int [] res = new int[k];
        System.arraycopy(arr,0,res,0,k);
        return res;
    }

    private void quickSort(int[] nums,int l,int r,int k){
        if(l<r){
            int pos = partition(nums,l,r);
            // 正好分割好
            if(pos== k-1)  return；
                
            else if(pos < k-1){
                // 继续排序pos后面的
                quickSort(nums,pos+1,r,k);
            } else{
                // 继续排序pos前面的
                quickSort(nums,l,pos-1,k);
            }

        }
    }

    private  int partition(int[] nums,int l,int r){
        int p = nums[l];
        int i =l;
        int j= r;
        while(i<j){
            while(i<j && nums[j]>p) j--;
            while(i<j && nums[i]<=p) i++;
            swap(nums,i,j);
        }
        swap(nums,l,i);
        return i;
    }

    private void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
~~~

#### 复杂度分析

- 时间复杂度：期望为 O(n)，由于证明过程很繁琐，所以不再这里展开讲。

- 空间复杂度：期望为 O(logn)，递归调用的期望深度为 O(logn)，每层需要的空间为 O(1)，只有常数个变量。

最坏情况下的空间复杂度为O(n)。最坏情况下需要划分 n 次,数递归调用最深 n - 1层，而每层由于需要 O(1) 的空间，所以一共需要 O(n)的空间复杂度。

