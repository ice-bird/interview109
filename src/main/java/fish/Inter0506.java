package fish;
// 面试题 05.06. 整数转换

// 整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。

// 求两个数有几位不同
// 求不同，异或 不同则1
public class Inter0506 {
    public int convertInteger(int A, int B) {
        int mask = A ^ B;
        // 求mask有多少位1  
        // 最低位1-1,高位保持不变
        int count=0;
        while (mask != 0) {
            if ((mask & 1) == 1) {
                count++;
            }
            // 不论是否满足均要右移
            // 注意maks >>> 1 只是一个操作，必须要赋值为mask，否则编译报错
            mask >>>= 1;
        }
        return count;
    }
}
