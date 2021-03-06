//
//        请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。
//        例如，把 9 表示成二进制是 1001，有 2 位是 1。
//        因此，如果输入 9，则该函数输出 2。
//
//        示例 1：
//        输入：00000000000000000000000000001011
//        输出：3
//        解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
//
//        示例 2：
//        输入：00000000000000000000000010000000
//        输出：1
//        解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
//
//        示例 3：
//        输入：11111111111111111111111111111101
//        输出：31
//        解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。

// you need to treat n as an unsigned value
// 位运算！
class hammingWeight{
    //思路1：逐位与运算，判断该位0还是1，右移。n&1=1：最右为1; n&1:最右为0。
    public int hammingWeight1(int n){
        int res=0;
        while(n!=0){
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    //思路2：巧用n&(n-1),与运算一次，消除一个最右的1，最终消除至0的次数，即为1的个数。
    public int hammingWeight2(int n){
        int res=0;
        while(n!=0){
            n = n & (n-1);
            res++;
        }
        return res;
    }
}