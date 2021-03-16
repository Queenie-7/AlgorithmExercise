// 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
// 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
// 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
//
//        示例 1：
//        输入：[3,4,5,1,2]
//        输出：1

//        示例 2：
//        输入：[2,2,2,0,1]
//        输出：0

//思路1：遍历查找寻找点
class minArray{
    public int minArray(int[] numbers){
        for(int i=0;i<numbers.length-1;i++){
            if(numbers[i+1]>numbers[i])
                return  numbers[i+1];
        }
        return numbers[0];
    }
}

//思路2：二分查找，将时间复杂度由线性级别，降至对数级别。
//        算法流程 循环二分：
//        设置 i, j 指针分别指向 numbers 数组左右两端，m = (i + j) // 2,为每次二分的中点（ "//" 代表向下取整除法），可分为以下三种情况：
//        1.当 numbers[m] > numbers[j]时： 旋转点 x 一定在 [m+1,j] 闭区间内，因此执行 i = m + 1；
//        2.当 numbers[m] < numbers[j] 时： 旋转点 x 一定在[i, m]闭区间内，因此执行 j = m；
//        3.当 numbers[m] == numbers[j] 时： 无法判断旋转点 x 在哪个区间中。
//          解决方案： 执行 j = j-1 缩小判断范围。
//        返回值： 当 i = j 时跳出二分循环，并返回 numbers[i] 即可

class minArray2{
    public int minArray2(int[] numbers){
        int i=0,j=numbers.length-1;
        while(i<j){
            int m=(i+j)/2;
            if(numbers[m]>numbers[j])
                i=m+1;
            else if(numbers[m]<numbers[j])
                j=m;
            else j--;
        }
        return numbers[i];
    }


}