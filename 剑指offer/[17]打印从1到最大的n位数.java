//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
// 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
//
//        示例 1:
//        输入: n = 1
//        输出: [1,2,3,4,5,6,7,8,9]
//         
//        说明：
//        用返回一个整数列表来代替打印
//        n 为正整数
//思路：找边界打印
class printNumbers{
    public int[] printNumbers(int n) {
        int max=1;
        for(int i=0;i<n;i++)
            max *= 10;
        max =max-1;
        int[] s=new int[max];
        for(int i=0;i<max;i++)
            s[i]=i+1;
        return s;
    }
}