// 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。

// 示例 1:
// 输入: [10,2]
// 输出: "102"

// 示例 2:
// 输入: [3,30,34,5,9]
// 输出: "3033459"
//  

// 提示:
// 0 < nums.length <= 100

// 说明:
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0


//快速排序
class Solution{
	public String minNumber(int[] nums){
		String[] strs = new String[nums.length]; //转字符
		for(int i = 0; i<nums.length;i++)
			strs[i]=String.valueOf(nums[i]);

		quickSort(strs,0,strs.length-1); //快速排序  Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x)); 内置排序

		StringBuilder res = new StringBuilder(); //拼接
		for(String s:strs)
			res.append(s);

		return res.toString();
	}

	void quickSort(String[] strs,int low,int high){
		if(low >= high) //大于等于
			return;
		int i=low,j=high;
		String v=strs[low];
		while(i<j){
			while(i<j && (strs[j]+v).compareTo(v+strs[j])>=0) //j从high开始，先j移动
				j--;
			while(i<j && (strs[i]+v).compareTo(v+strs[i])<=0)
				i++;

			String tmp = strs[i];
			strs[i]=strs[j];
			strs[j]=tmp;
		}
		strs[low]=strs[i];//定位到i
		strs[i]=v;
		quickSort(strs,low,i-1);
		quickSort(strs,i+1,high);
	}
}

class Solution{
	public String minNumber(int[] nums){
		String[] strs = new String[nums.length];
        for(int i=0;i<nums.length;i++)
            strs[i]=String.valueOf(nums[i]);
        
        quickSort(strs,0,strs.length-1);

        StringBuilder res = new StringBuilder();
        for(String s:strs)
            res.append(s);
        
        return res.toString();
	}

    void quickSort(String[] strs,int low,int high){
        if(low>=high)
            return;
        int i=low,j=high;
        String v= strs[low];
        while(i<j){
            while(i<j && (strs[j]+v).compareTo(v+strs[j])>=0)
                j--;
            while(i<j && (strs[i]+v).compareTo(v+strs[i])<=0);
                i++;
            String tmp = strs[i];
            strs[i]=strs[j];
            strs[j]=tmp;
        }
        strs[low]=strs[i];
        strs[i]=v;
        quickSort(strs,low,i-1);
        quickSort(strs,i+1,high);
    }
  }