# 数组中你的逆序对

输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007

`(a+b+c)%k = (a%k+b%k+c%k) %k`

[7,5,6,4] 

逆序对（7，5）（6，4）（5，4）（7，4）（7，6）

## 归并排序合并中计数

合并中怎么比较计数？

当arr2[j]<arr1[i]时，arr1后面的元素都大于arr2[j],那么就可以计数了 right1-i+1;

![img](https://pic.leetcode-cn.com/1614274007-nIGXwT-Picture5.png)



~~~java
public class Solution {
    public int InversePairs(int [] array) {
        int[] tmp = new int[array.length];
        int res = mergeSort(array,0,array.length-1,tmp);
        return res%1000000007;
    }
    public int mergeSort(int[] arr,int left,int right,int[] tmp){
        if(left>=right) return 0;
        int mid = left+right>>1;
        int l=mergeSort(arr,left,mid,tmp);
        int r=mergeSort(arr,mid+1,right,tmp);
        return l + r + merge(arr,left,mid,mid+1,right,tmp);
    }
    public int merge(int[] arr,int l1,int r1,int l2,int r2,int[] tmp){
        int i=l1;
        int j=l2;
        int p =l1;
        int count=0;
        while(i<=r1 && j<=r2){
            if(arr[j]<arr[i]){
                // 计数
                tmp[p++]=arr[j++];
                count+=r1-i+1;
            }else{
                tmp[p++]=arr[i++];
            }
        }
        while(i<=r1)tmp[p++]=arr[i++];  
        while(j<=r2)tmp[p++] =arr[j++];
        // 别忘了放到arr里排序
        for(int k =l1;k<p;k++){
            arr[k]=tmp[k];
        }
        return count%1000000007;
    }
}
~~~

